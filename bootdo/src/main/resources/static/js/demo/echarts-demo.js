var loadEnterpriseProportionJson;
$(function () {
    // //折线图(各类企业增长分析)
    enterpriseHigh();
    administrativeDivision();//加载乡镇
    //饼图1，加载各村街企业占比
    loadEnterpriseProportion();
    //饼图2，加载企业性质占比
    loadEnterpriseNatureCode();
    //饼图3，加载污染类别占比
    loadPollutionCode();

    //折线图(各类企业消防设备分析)
    fireEquipHigh();
    //仪表盘（环保信息办理）
    envprotectionChart();
    //加载灭火器过期的企业
    getEffectFireEquip();
    // 防治设备过期的企业
    getEecoequipment();

    getDangerData();




});
//加载行政区划
//一级
function administrativeDivision(){
    $.ajax({
        type: "get",
        url: "/ecosys/code/list",
        dataType: "json",
        data: {
            parentId: 113
        },
        success: function (data) {
            var code_list = data.rows;
            var opts = "<option value='00'>" +"全部 "+"</option>";
            var optSon = "<option value='000'>" +"全部 "+"</option>";
            for (var i = 0; i < code_list.length; i++) {
                var code = code_list[i];
                opts += "<option value='" + code.codeId + "' id='" + code.id + "'>" + code.name + "</option>";
            }
            $("#administrativeDivision").append(opts);
            $("#country").append(optSon);
        }
    })
}

//行政区划，监听一级乡镇，联动村子
$("#administrativeDivision").bind("change", function(){
    enterpriseHigh();
    //饼图1，加载各村街企业占比
    loadEnterpriseProportion();
    //饼图2，加载企业性质占比
    loadEnterpriseNatureCode();
    //饼图3，加载污染类别占比
    loadPollutionCode();

    //折线图(各类企业消防设备分析)
    fireEquipHigh();
    //仪表盘（环保信息办理）
    envprotectionChart();
    //加载灭火器过期的企业
    getEffectFireEquip();
    // 防治设备过期的企业
    getEecoequipment();

    getDangerData();
    //获取
    // $("#administrativeDivision").find("option").remove();//清空option
    var option = $("#administrativeDivision option:selected").val();
    var parentId = $("#administrativeDivision option:selected").attr("id");
    $("#country").find("option").remove();//清空option
    //根据乡镇获取村
    if("" == administrativeDivision){

    }else {
        $.ajax({
            type: "get",
            url: "/ecosys/code/list",
            dataType: "json",
            data: {
                parentId: parentId
            },
            success: function (data) {
                var code_list = data.rows;
                var opts = "<option value='000'>" +"全部 "+"</option>";
                for (var i = 0; i < code_list.length; i++) {
                    var code = code_list[i];
                    opts += "<option value='" + code.orderNum + "'>" + code.name + "</option>";
                }
                $("#country").append(opts);
            }
        })
    }

})

//监听村子
$("#country").bind("change", function(){
    enterpriseHigh();
    //饼图1，加载各村街企业占比
    loadEnterpriseProportion();
    //饼图2，加载企业性质占比
    loadEnterpriseNatureCode();
    //饼图3，加载污染类别占比
    loadPollutionCode();

    //折线图(各类企业消防设备分析)
    fireEquipHigh();
    //仪表盘（环保信息办理）
    envprotectionChart();
    //加载灭火器过期的企业
    getEffectFireEquip();
    // 防治设备过期的企业
    getEecoequipment();

    getDangerData();

})

//1、加载各村街企业占比
function loadEnterpriseProportion(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/loadEnterpriseProportion",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            //饼图1
            var pieChart = echarts.init(document.getElementById("echarts-pie-chart1"), 'customed');
            var pieoption = {
                title : {
                    text: '各村街企业占比分析',
                    x:'left'
                },
                tooltip : {
                    trigger: 'item',
                    position:'right',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                calculable : true,
                series : [
                    {
                        name:'企业数量',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data.data,

                    }
                ]
            };
            pieChart.setOption(pieoption);
            $(window).resize(pieChart.resize);
        }
    })
}
//饼图2，加载企业性质占比
function loadEnterpriseNatureCode(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/loadEnterpriseNatureCode",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            //饼图1
            var pieChart = echarts.init(document.getElementById("echarts-pie-chart2"), 'customed');
            var pieoption = {
                title : {
                    text: '企业类型占比分析',
                    x:'left'
                },
                tooltip : {
                    trigger: 'item',
                    position:'right',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                calculable : true,
                series : [
                    {
                        name:'企业数量',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data.data,
                    }
                ]
            };
            pieChart.setOption(pieoption);
            $(window).resize(pieChart.resize);
        }
    })
}

//饼图3，加载污染类别占比
function loadPollutionCode(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/loadPollutionCode",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            //饼图1
            var pieChart = echarts.init(document.getElementById("echarts-pie-chart3"), 'customed');
            var pieoption = {
                title : {
                    text: '污染类别占比分析',
                    x:'left'
                },
                tooltip : {
                    trigger: 'item',
                    position:'right',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                calculable : true,
                series : [
                    {
                        name:'企业数量',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data.data,
                    }
                ]
            };
            pieChart.setOption(pieoption);
            $(window).resize(pieChart.resize);
        }
    })
}
//各类企业增长分析
function enterpriseHigh(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/enterpriseHigh",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            var pieChart = echarts.init(document.getElementById("enterpriseHigh"), 'customed');
            option = {
                title: {
                    text: '各类企业增长分析'
                },
                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                    x:40,
                    y:45,
                    x2:10,
                    y2:20,
                    containLabel: true
                },

                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: data.data.yearList
                },
                yAxis: {
                    type: 'value'
                },
                series:data.data.lineList,
            };
            pieChart.setOption(option);
            $(window).resize(pieChart.resize);
        }
    })
}
//各类企业消防设备分析
function fireEquipHigh(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/fireEquipHigh",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            var pieChart = echarts.init(document.getElementById("fireEquipHigh"), 'customed');
            option = {
                title: {
                    text: '各类企业消防设备分析'
                },
                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                    x:40,
                    y:45,
                    x2:10,
                    y2:20,
                    containLabel: true
                },

                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: data.data.yearList
                },
                yAxis: {
                    type: 'value'
                },
                series:data.data.lineList,

            };
            pieChart.setOption(option);
            $(window).resize(pieChart.resize);
        }
    })
}
//仪表盘（环保信息办理）
function envprotectionChart(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/envprotectionChart",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            var pieChart = echarts.init(document.getElementById("envprotectionChart"), 'customed');
            option = {
                title: {
                    text: '环保信息办理'
                },
                tooltip: {
                    formatter: '{a} <br/>{b} : {c}%'
                },

                series: [
                    {
                        name: '环保信息处理',
                        type: 'gauge',
                        center: ["50%", "60%"], // 仪表位置
                        radius: "100%", //仪表大小
                        /*startAngle: 200, //开始角度
                        endAngle: -20, //结束角度*/
                        axisLine:{
                            lineStyle:{
                                width:30,
                                color:[[0.2,'#40e0d0'],[0.4,'#008080'],[0.6,'#87CECB'],[0.8,'#C1DA39'],[1,'#72da39'],]
                            }
                        },
                        detail: {formatter: '{value}%'},
                        data: [{value: data.data.toFixed(2) - 0, name: '完成率'}]
                    }
                ]
            };
            /*setInterval(function () {
                option.series[0].data[0].value = data.data.toFixed(2) - 0;
            },2000);*/
            pieChart.setOption(option);
            $(window).resize(pieChart.resize);
        }
    })
}

//滚动特效
(function($){
    $.fn.newsScroll = function(options){
        var defaults = {
            spacetime:2000,
            hoverstop:false
        }
        var myData = $.extend({},defaults,options);
        var $this=$(this);
        var height=$this.find("li").height();
        function autoScroll(){
            $this.find("ul").animate({"marginTop":-height},500,function(){
                $this.find("ul").css({marginTop:"0px"}).find("li:first").appendTo(this);
            })
        }
        var timer=null;
        timer = setInterval(autoScroll,myData.spacetime);
        //鼠标经过停止
        if(myData.hoverstop){
            $this.hover(function(){
                clearInterval(timer);
            },function(){
                timer = setInterval(autoScroll,myData.spacetime);
            }).mouseout();
        }
    }

})(jQuery);
//  综合大数据  灭火器过期的企业 详情 showdangerInfo
function showFiredeviceInfo() {
    var mainhtml = "/ecosys/firedevice";
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    var data =admin+countryCode;
    openPageJump(mainhtml, mainhtml+'/showFiredeviceInfo/'+data,"消防设备过期的企业");
}
//  综合大数据  危险源的企业 详情
function showdangerInfo() {
    var mainhtml = "/ecosys/dangersource";
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    var data =admin+countryCode;

    openPageJump(mainhtml, mainhtml+'/showdangerInfo/'+data,"有危险源的企业");
}
// 综合大数据  防治设备过期  详情
function showEcoequipmentInfo() {
    var mainhtml = "/ecosys/ecoequipment";
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    var data =admin+countryCode;

    openPageJump(mainhtml, mainhtml+'/showecoequipmentInfo/'+data,"防治设备过期企业");
}

//加载灭火器过期的企业
function getEffectFireEquip(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/getEffectFireEquip",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            var dataStr = "";
            if(data.data.length == 0){
                dataStr = "<li><a href=\"#\" class=\"btn\" style=\"pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:16px\">" +
                    "暂无" + "</a></li>"
                $("#fireData").html(dataStr);
            }else{
                var strStrat = "<ul>";
                var strEnd = "</ul>";
                for(var i = 0;i<data.data.length;i++) {
                    dataStr = "<li ><a  href=\"#\" class=\"btn\" style=\" font-size: 5px;pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:12px\">" +
                        data.data[i].enterpriseName + "&nbsp;&nbsp;&nbsp;"
                        + data.data[i].equipmentName + "&nbsp;&nbsp;&nbsp;" + "</a></li>" + dataStr;
                }
                var dataStrNew = strStrat + dataStr + strEnd;
                $("#fireData").html(dataStrNew);
            }
            $("#s1").newsScroll({
                line: 1,
                speed: 500,
                timer: 4000,
            });
        }
    })
}
//加载消防设备过期企业
function getEecoequipment(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/getEecoequipment",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            var dataStr = "";
            if(data.data.length == 0){
                dataStr = "<li><a href=\"#\" class=\"btn\" style=\"pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:16px\">" +
                    "暂无" + "</a></li>"
                $("#eoequipment").html(dataStr);
            }else{
                var strStrat = "<ul>";
                var strEnd = "</ul>";
                for(var i = 0;i<data.data.length;i++) {
                    dataStr = "<li ><a  href=\"#\" class=\"btn\" style=\" font-size: 5px;pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:12px\">" +
                        data.data[i].enterpriseName + "&nbsp;&nbsp;&nbsp;"+
                    "</a></li>" + dataStr;
                }
                var dataStrNew = strStrat + dataStr + strEnd;
                $("#eoequipment").html(dataStrNew);
            }
            $("#s3").newsScroll({
                line: 1,
                speed: 500,
                timer: 4000,
            });
        }
    })
}

function getDangerData(){
    var admin = $("#administrativeDivision option:selected").val();//行政区划
    var parentId = $("#administrativeDivision option:selected").attr("id");//行政区划id
    var countryCode = $("#country option:selected").val();//村子的编码
    $.ajax({
        type: "get",
        url: "/ecosys/chart/getDangerData",
        dataType: "json",
        data: {
            administrativeDivision:admin,
            country:countryCode
        },
        success: function (data) {
            var dataStr = "";
            if(data.data.length == 0){
                dataStr = "<li><a href=\"#\" class=\"btn\" style=\"pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:16px\">" +
                    "暂无" + "</a></li>"
                $("#dangerData").html(dataStr);
            }else{
                var strStrat = "<ul>";
                var strEnd = "</ul>";
                for(var i = 0;i<data.data.length;i++) {
                    dataStr = "<li><a href=\"#\" class=\"btn\" style=\"pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:12px\">" +
                        data.data[i].enterpriseName + "&nbsp;&nbsp;&nbsp;"
                        + data.data[i].dangerSourceName + "</a></li>" + dataStr;
                }
                var dataStrNew = strStrat + dataStr + strEnd;
                $("#dangerData").html(dataStrNew);
            }
            $("#s2").newsScroll({
                line: 1,
                speed: 500,
                timer: 4000,
            });
        }
    })
}








