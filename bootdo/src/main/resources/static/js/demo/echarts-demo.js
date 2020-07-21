var loadEnterpriseProportionJson;
$(function () {
    administrativeDivision();//加载乡镇
    //饼图1，加载各村街企业占比
    loadEnterpriseProportion();
    //饼图2，加载企业性质占比
    loadEnterpriseNatureCode();
    //饼图3，加载污染类别占比
    loadPollutionCode();
    //折线图(各类企业增长分析)
    enterpriseHigh();
    //折线图(各类企业消防设备分析)
    fireEquipHigh();
    //仪表盘（环保信息办理）
    envprotectionChart();
    //加载灭火器过期的企业
    getEffectFireEquip();

    getDangerData();







    var mapChart = echarts.init(document.getElementById("echarts-map-chart"));
    var mapoption = {
        title : {
            text: 'iphone销量',
            subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            x:'left',
            data:['iphone3','iphone4','iphone5']
        },
        dataRange: {
            min: 0,
            max: 2500,
            x: 'left',
            y: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            x: 'right',
            y: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        roamController: {
            show: true,
            x: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series : [
            {
                name: 'iphone3',
                type: 'map',
                mapType: 'china',
                roam: false,
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '重庆',value: Math.round(Math.random()*1000)},
                    {name: '河北',value: Math.round(Math.random()*1000)},
                    {name: '河南',value: Math.round(Math.random()*1000)},
                    {name: '云南',value: Math.round(Math.random()*1000)},
                    {name: '辽宁',value: Math.round(Math.random()*1000)},
                    {name: '黑龙江',value: Math.round(Math.random()*1000)},
                    {name: '湖南',value: Math.round(Math.random()*1000)},
                    {name: '安徽',value: Math.round(Math.random()*1000)},
                    {name: '山东',value: Math.round(Math.random()*1000)},
                    {name: '新疆',value: Math.round(Math.random()*1000)},
                    {name: '江苏',value: Math.round(Math.random()*1000)},
                    {name: '浙江',value: Math.round(Math.random()*1000)},
                    {name: '江西',value: Math.round(Math.random()*1000)},
                    {name: '湖北',value: Math.round(Math.random()*1000)},
                    {name: '广西',value: Math.round(Math.random()*1000)},
                    {name: '甘肃',value: Math.round(Math.random()*1000)},
                    {name: '山西',value: Math.round(Math.random()*1000)},
                    {name: '内蒙古',value: Math.round(Math.random()*1000)},
                    {name: '陕西',value: Math.round(Math.random()*1000)},
                    {name: '吉林',value: Math.round(Math.random()*1000)},
                    {name: '福建',value: Math.round(Math.random()*1000)},
                    {name: '贵州',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '青海',value: Math.round(Math.random()*1000)},
                    {name: '西藏',value: Math.round(Math.random()*1000)},
                    {name: '四川',value: Math.round(Math.random()*1000)},
                    {name: '宁夏',value: Math.round(Math.random()*1000)},
                    {name: '海南',value: Math.round(Math.random()*1000)},
                    {name: '台湾',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            },
            {
                name: 'iphone4',
                type: 'map',
                mapType: 'china',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '重庆',value: Math.round(Math.random()*1000)},
                    {name: '河北',value: Math.round(Math.random()*1000)},
                    {name: '安徽',value: Math.round(Math.random()*1000)},
                    {name: '新疆',value: Math.round(Math.random()*1000)},
                    {name: '浙江',value: Math.round(Math.random()*1000)},
                    {name: '江西',value: Math.round(Math.random()*1000)},
                    {name: '山西',value: Math.round(Math.random()*1000)},
                    {name: '内蒙古',value: Math.round(Math.random()*1000)},
                    {name: '吉林',value: Math.round(Math.random()*1000)},
                    {name: '福建',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '西藏',value: Math.round(Math.random()*1000)},
                    {name: '四川',value: Math.round(Math.random()*1000)},
                    {name: '宁夏',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            },
            {
                name: 'iphone5',
                type: 'map',
                mapType: 'china',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '台湾',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            }
        ]
    };
    mapChart.setOption(mapoption);
    $(window).resize(mapChart.resize);




    var gaugeChart = echarts.init(document.getElementById("echarts-gauge-chart"));
    var gaugeoption = {
        tooltip : {
            formatter: "{a} <br/>{c} {b}"
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name:'速度',
                type:'gauge',
                min:0,
                max:220,
                splitNumber:11,
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        width: 10
                    }
                },
                axisTick: {            // 坐标轴小标记
                    length :15,        // 属性length控制线长
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: {           // 分隔线
                    length :20,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                title : {
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder',
                        fontSize: 20,
                        fontStyle: 'italic'
                    }
                },
                detail : {
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder'
                    }
                },
                data:[{value: 40, name: 'km/h'}]
            },
            {
                name:'转速',
                type:'gauge',
                center : ['25%', '55%'],    // 默认全局居中
                radius : '50%',
                min:0,
                max:7,
                endAngle:45,
                splitNumber:7,
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        width: 8
                    }
                },
                axisTick: {            // 坐标轴小标记
                    length :12,        // 属性length控制线长
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                splitLine: {           // 分隔线
                    length :20,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                pointer: {
                    width:5
                },
                title : {
                    offsetCenter: [0, '-30%'],       // x, y，单位px
                },
                detail : {
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontWeight: 'bolder'
                    }
                },
                data:[{value: 1.5, name: 'x1000 r/min'}]
            },
            {
                name:'油表',
                type:'gauge',
                center : ['75%', '50%'],    // 默认全局居中
                radius : '50%',
                min:0,
                max:2,
                startAngle:135,
                endAngle:45,
                splitNumber:2,
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: [[0.2, '#ff4500'],[0.8, '#48b'],[1, '#228b22']],
                        width: 8
                    }
                },
                axisTick: {            // 坐标轴小标记
                    splitNumber:5,
                    length :10,        // 属性length控制线长
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: 'auto'
                    }
                },
                axisLabel: {
                    formatter:function(v){
                        switch (v + '') {
                            case '0' : return 'E';
                            case '1' : return 'Gas';
                            case '2' : return 'F';
                        }
                    }
                },
                splitLine: {           // 分隔线
                    length :15,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                pointer: {
                    width:2
                },
                title : {
                    show: false
                },
                detail : {
                    show: false
                },
                data:[{value: 0.5, name: 'gas'}]
            },
            {
                name:'水表',
                type:'gauge',
                center : ['75%', '50%'],    // 默认全局居中
                radius : '50%',
                min:0,
                max:2,
                startAngle:315,
                endAngle:225,
                splitNumber:2,
                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: [[0.2, '#ff4500'],[0.8, '#48b'],[1, '#228b22']],
                        width: 8
                    }
                },
                axisTick: {            // 坐标轴小标记
                    show: false
                },
                axisLabel: {
                    formatter:function(v){
                        switch (v + '') {
                            case '0' : return 'H';
                            case '1' : return 'Water';
                            case '2' : return 'C';
                        }
                    }
                },
                splitLine: {           // 分隔线
                    length :15,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },
                pointer: {
                    width:2
                },
                title : {
                    show: false
                },
                detail : {
                    show: false
                },
                data:[{value: 0.5, name: 'gas'}]
            }
        ]
    };
    gaugeChart.setOption(gaugeoption);
    $(window).resize(gaugeChart.resize);


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
            var opts = "<option value=''>" +"请选择 "+"</option>";
            var optSon = "<option value=''>" +"请选择 "+"</option>";
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
    //获取
    var option = $("#administrativeDivision option:selected").val();
    var parentId = $("#administrativeDivision option:selected").attr("id");
    $("#country").find("option").remove();//清空option
    //根据乡镇获取村
    $.ajax({
        type: "get",
        url: "/ecosys/code/list",
        dataType: "json",
        data: {
            parentId: parentId
        },
        success: function (data) {
            var code_list = data.rows;
            var opts = "<option value=''>" +"请选择 "+"</option>";
            for (var i = 0; i < code_list.length; i++) {
                var code = code_list[i];
                opts += "<option value='" + code.orderNum + "'>" + code.name + "</option>";
            }
            $("#country").append(opts);
        }
    })
})

//监听村子
$("#country").bind("change", function(){
    loadEnterpriseProportion();
    envprotectionChart();
    loadEnterpriseNatureCode();
    loadPollutionCode();
    enterpriseHigh();
    fireEquipHigh();
    getEffectFireEquip();

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
                        /*itemStyle: {
                            normal: {
                                color: function(params) {
                                    var colorList = [
                                        '#8B0000','#2F4F4F','#008080','#F4A460','#87CECB',
                                        '#5F9EA0','#DAA520','#20B2AA','#40E0D0','#FA8072'
                                    ];
                                    return colorList[params.dataIndex]
                                },
                                label: {        //此处为指示线文字
                                    show: true,
                                    textStyle: {
                                        fontWeight: 200,
                                        fontSize: 10    //文字的字体大小
                                    }
                                },
                                labelLine: {    //指示线状态
                                    show: true,
                                    smooth: 0.2/!*,
                                    length: 10,
                                    length2: 20*!/
                                }
                            }
                        },*/
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
                        /*itemStyle: {
                            normal: {
                                color: function(params) {
                                    var colorList = [
                                        '#8B0000','#2F4F4F','#008080','#F4A460','#87CECB',
                                        '#5F9EA0','#DAA520','#20B2AA','#40E0D0','#FA8072'
                                    ];
                                    return colorList[params.dataIndex]
                                },
                                label: {        //此处为指示线文字
                                    show: true,
                                    textStyle: {
                                        fontWeight: 200,
                                        fontSize: 10    //文字的字体大小
                                    }
                                },
                                labelLine: {    //指示线状态
                                    show: true,
                                    smooth: 0.2/!*,
                                    length: 10,
                                    length2: 20*!/
                                }
                            }
                        },*/
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
                        /*itemStyle: {
                            normal: {
                                color: function(params) {
                                    var colorList = [
                                        '#8B0000','#2F4F4F','#008080','#F4A460','#87CECB',
                                        '#5F9EA0','#DAA520','#20B2AA','#40E0D0','#FA8072'
                                    ];
                                    return colorList[params.dataIndex]
                                },
                                label: {        //此处为指示线文字
                                    show: true,
                                    textStyle: {
                                        fontWeight: 200,
                                        fontSize: 10    //文字的字体大小
                                    }
                                },
                                labelLine: {    //指示线状态
                                    show: true,
                                    smooth: 0.2/!*,
                                    length: 10,
                                    length2: 20*!/
                                }
                            }
                        },*/
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
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
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
                /*itemStyle: {
                    normal: {
                        lineStyle:{
                            color: function(params) {
                                var colorList = [
                                    '#8B0000','#2F4F4F','#008080','#F4A460','#87CECB',
                                    '#5F9EA0','#DAA520','#20B2AA','#40E0D0','#FA8072'
                                ];
                                return colorList[params.dataIndex]
                            },
                        },
                    }
                },*/
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
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
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
                /*itemStyle: {
                    normal: {
                        lineStyle:{
                            color: function(params) {
                                var colorList = [
                                    '#8B0000','#2F4F4F','#008080','#F4A460','#87CECB',
                                    '#5F9EA0','#DAA520','#20B2AA','#40E0D0','#FA8072'
                                ];
                                return colorList[params.dataIndex]
                            },
                        },
                    }
                },*/
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
                toolbox: {
                    feature: {
                        restore: {},
                        saveAsImage: {}
                    }
                },
                series: [
                    {
                        name: '环保信息处理',
                        type: 'gauge',
                        center: ["50%", "60%"], // 仪表位置
                        radius: "100%", //仪表大小
                        /*startAngle: 200, //开始角度
                        endAngle: -20, //结束角度*/
                        /*axisLine:{
                            lineStyle:{
                                width:30,
                                color:[[0.2,'#40E0D0'],[0.4,'#008080'],[0.6,'#87CECB'],[0.8,'#DAA520'],[1,'#8B0000'],]
                            }
                        },*/
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
                    dataStr = "<li><a href=\"#\" class=\"btn\" style=\"pointer-events:none;background-color: #92B8B1;border: #92B8B1;width: 100%;color: white;font-size:12px\">" +
                        data.data[i].enterpriseName + "&nbsp;&nbsp;&nbsp;"
                        + data.data[i].equipmentName + "&nbsp;&nbsp;&nbsp;" + data.data[i].effectTime + "</a></li>" + dataStr;
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








