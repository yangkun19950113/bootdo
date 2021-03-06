var enterpriseMsgMapping = "/ecosys/enterprise";
var envprotectionMsgMapping = "/ecosys/envprotection";
var productMsgMapping = "/ecosys/product";
var materialMsgMapping = "/ecosys/material";
var ecoequipmentMsgMapping = "/ecosys/ecoequipment";
var dangersourceMsgMapping = "/ecosys/dangersource";
var trainingMsgMapping = "/ecosys/training";
var electricMsgMapping = "/ecosys/electric";
var riskMsgMapping = "/ecosys/risk";
var firedeviceMsgMapping = "/ecosys/firedevice";
$('#demo').carousel({
    interval: 3000
})
$(function() {
    var socialCreditCode = $('#socialCreditCode').val();
    if(null != socialCreditCode || undefined !=socialCreditCode){
        reLoad(socialCreditCode);
    }
});




function reLoad(socialCreditCode) {
    $.ajax({
        type: 'GET',
        url: '/showData/showData/enterpriseList',
        dataType: "json",
        data:{enterpriseName:$('#enterpriseName').val(),socialCreditCode:$('#socialCreditCode').val()},
        success: function (res) {
            if(200 == res.code){
                $("#lunbotu").empty();
                $("#enterprise").empty();
                $("#envprotection").empty();
                $("#product").empty();
                $("#material").empty();
                $("#ecoequipment").empty();
                $("#dangersource").empty();
                $("#training").empty();
                $("#electric").empty();
                $("#risk").empty();
                $("#firedevice").empty();
                $("#myAlert2").empty();
                var data = res.data;
                var enterpriseId = data.enterpriseId;
                var proimgsurl = data.imgUrls;
                var minImgUrl = data.minImgUrl;
                var enterpriseName = data.enterpriseName;
                var socialCreditCode = data.socialCreditCode;
                var registeredAddress = data.registeredAddress;
                // var registeredTime = data.registeredTime;
                var enterpriseNatureCode = data.enterpriseNatureCode;
                var ecoEstimateFlg = data.ecoEstimateFlg;
                var pp = document.querySelector('#pp');
                if(0==ecoEstimateFlg){
                    ecoEstimateFlg = '是'
                }else{
                    ecoEstimateFlg = '否'
                };
                var parkFlg = data.parkFlg;
                if(0==parkFlg){
                    parkFlg = '是'
                }else{
                    parkFlg = '否'
                };
                var ecoStandardFlg = data.ecoStandardFlg;
                if(0==ecoStandardFlg){
                    ecoStandardFlg = '是'
                }else{
                    ecoStandardFlg = '否'
                };
                var envprotectionMinImgUrl = data.envprotectionMinImgUrl;
                var productMinImgUrl =data.productMinImgUrl;
                var prodectName = data.prodectName;
                var specifical = data.specifical;
                var model = data.model;
                var materialMinImgUrl = data.materialMinImgUrl;
                var materialType = data.materialType;
                var materialName = data.materialName;
                var monthConsumption = data.monthConsumption;
                var ecoequipmentMinImgUrl = data.ecoequipmentMinImgUrl;
                var equipmentName = data.equipmentName;
                var protectionPerson = data.protectionPerson;
                var phoneNumber = data.phoneNumber;
                var dangerSourceName= data.dangerSourceName;
                var partDetail = data.partDetail;
                var dangerprotectionPerson = data.dangerprotectionPerson;
                var dangersourceMinImgUrl = data.dangersourceMinImgUrl;
                var trainName = data.trainName;
                var trainType = data.trainType;
                var personNumber = data.personNumber;
                var trainingMinImgUrl = data.trainingMinImgUrl;
                var electricMinImgUrl = data.electricMinImgUrl;
                var eleequipmentName = data.eleequipmentName;
                var eleequipmentCode = data.eleequipmentCode;
                var number = data.number;
                var peopleFindName = data.peopleFindName;
                var findTime = data.findTime;
                if(null == findTime){
                    var findTime = "";
                }
                var type = data.type;
                var riskMinImgUrl = data.riskMinImgUrl;
                var fireequipmentName = data.fireequipmentName;
                var fireequipmentCode = data.fireequipmentCode;
                var buyTime = data.buyTime;
                if(null == buyTime){
                    var buyTime = "";
                }
                var firedeviceMinImgUrl = data.firedeviceMinImgUrl;
                var industryCode = data.industryCode;
                var monthProduction = data.monthProduction;
                var level = data.level;


                //填充每幅图像的具体信息
                if(null == proimgsurl ||proimgsurl.length==0 ){
                    $("#pp").css({"margin-top":"-400px"});
                }else {
                     $("#pp").css({"margin-top":"-20px"});
                    for(var i = 0; i < proimgsurl.length; i++) {
                        if(i == 0) {
                            $("#lunbotu").append("<div class='carousel-item active'>" +
                                "<img src='" + proimgsurl[i] + "' alt=''>" +
                                "</div>");
                        } else {
                            $("#lunbotu").append("<div class='carousel-item'>" +
                                "<img src='" + proimgsurl[i] + "' alt=''>" +
                                "</div>");
                        }
                    }
                }

                $("#enterprise").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+minImgUrl+"' alt='' class='card-img-top'style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>" + enterpriseName + "</h6>" +
                    "<p class='card-text'> 信用编码:" + socialCreditCode + "</p>" +
                    "<p style='font-size: 14px' class='card-text'>" + registeredAddress + "</p >" +
                    "<p class='card-text'> 企业性质:" + enterpriseNatureCode + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + enterpriseMsgMapping +'\',\'' + enterpriseMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '企业信息' + '\')">'+'企业信息'+'</a>'+
                    "</div>"
                );
                $("#envprotection").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+envprotectionMinImgUrl+"' alt='' class='card-img-top' style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>环保基本信息</h6>" +
                    "<p class='card-text'> 是否有环评文号:" + ecoEstimateFlg + "</p>" +
                    "<p class='card-text'> 是够属于园区:" + parkFlg + "</p>" +
                    "<p class='card-text'> 是否有环保制度:" + ecoStandardFlg + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + envprotectionMsgMapping +'\',\'' + envprotectionMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '环保信息' + '\')">'+'环保信息'+'</a>'+
                    "</div>"
                );
                $("#product").append("<div class='card' style='width: 18rem;' >" +
                    "<img src='"+productMinImgUrl+"' alt='' class='card-img-top' style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>企业产品及产能</h6>" +
                    "<p class='card-text'> 产品名称:" + prodectName + "</p>" +
                    "<p class='card-text'> 规格:" + specifical + "</p>" +
                    "<p class='card-text'> 月产量:" + monthProduction + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + productMsgMapping +'\',\'' + productMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '产品产能信息' + '\')">'+'产品产能信息'+'</a>'+
                    "</div>"
                );
                $("#material").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+materialMinImgUrl+"' alt='' class='card-img-top' style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>产品原材料</h6>" +
                    "<p class='card-text'> 原材料类型:" + materialType + "</p>" +
                    "<p class='card-text'> 原材料名称:" + materialName + "</p>" +
                    "<p class='card-text'> 月使用量:" + monthConsumption + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + materialMsgMapping +'\',\'' + materialMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '原料信息' + '\')">'+'原料信息'+'</a>'+
                    "</div>"
                );
                $("#ecoequipment").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+ecoequipmentMinImgUrl+"' alt='' class='card-img-top'style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>防治设备</h6>" +
                    "<p class='card-text'> 设备名称:" + equipmentName + "</p>" +
                    "<p class='card-text'> 设备负责人:" + protectionPerson + "</p>" +
                    "<p class='card-text'> 联系电话:" + phoneNumber + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + ecoequipmentMsgMapping +'\',\'' + ecoequipmentMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '防治设备信息' + '\')">'+'防治设备信息'+'</a>'+
                    "</div>"
                );
                $("#dangersource").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+dangersourceMinImgUrl+"' alt='' class='card-img-top' style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>重点部位</h6>" +
                    "<p class='card-text'> 危险源信息名称:" + dangerSourceName + "</p>" +
                    "<p class='card-text'> 具体位置:" + partDetail + "</p>" +
                    "<p class='card-text'> 危险责任人:" + dangerprotectionPerson + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + dangersourceMsgMapping +'\',\'' + dangersourceMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '安全重点部位信息' + '\')">'+'安全重点部位信息'+'</a>'+
                    "</div>"
                );
                $("#training").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+trainingMinImgUrl+"' alt='' class='card-img-top'style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>安全生产培训</h6>" +
                    "<p class='card-text'> 培训主题:" + trainName + "</p>" +
                    "<p class='card-text'> 培训类型:" + trainType + "</p>" +
                    "<p class='card-text'> 参加人数:" + personNumber + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + trainingMsgMapping +'\',\'' + trainingMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '安全生产培训信息' + '\')">'+'安全生产培训信息'+'</a>'+
                    "</div>"
                );
                $("#electric").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+electricMinImgUrl+"' alt='' class='card-img-top'style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>用电设备</h6>" +
                    "<p class='card-text'> 设备名称:" + eleequipmentName + "</p>" +
                    "<p class='card-text'> 设备编码:" + eleequipmentCode + "</p>" +
                    "<p class='card-text'> 台数:" + number + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + electricMsgMapping +'\',\'' + electricMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '用电设施信息' + '\')">'+'用电设施信息'+'</a>'+
                    "</div>"
                );
                $("#risk").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+riskMinImgUrl+"' alt='' class='card-img-top'style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>安全隐患</h6>" +
                    "<p class='card-text'> 发现人员:" + peopleFindName + "</p>" +
                    "<p class='card-text'> 发现时间:" + findTime + "</p>" +
                    "<p class='card-text'> 级别:" + level + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + riskMsgMapping +'\',\'' + riskMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '安全隐患信息' + '\')">'+'安全隐患信息'+'</a>'+
                    "</div>"
                );
                $("#firedevice").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='"+firedeviceMinImgUrl+"' alt='' class='card-img-top'style='width: 80px;height: 80px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h6 class='card-title'>消防设备</h6>" +
                    "<p class='card-text'> 设备名称:" + fireequipmentName + "</p>" +
                    "<p class='card-text'> 设备编码:" + fireequipmentCode + "</p>" +
                    "<p class='card-text'> 采购时间:" + buyTime + "</p>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + firedeviceMsgMapping +'\',\'' + firedeviceMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '消防设备信息' + '\')">'+'消防设备信息'+'</a>'+
                    "</div>"
                );

            }

            else{
                $("#lunbotu").empty();
                $("#enterprise").empty();
                $("#envprotection").empty();
                $("#product").empty();
                $("#material").empty();
                $("#ecoequipment").empty();
                $("#dangersource").empty();
                $("#training").empty();
                $("#electric").empty();
                $("#risk").empty();
                $("#firedevice").empty();
                $("#myAlert2").empty();
                $("#myAlert2").append("<a href='#' class='close' data-dismiss='alert'>&times;</a>"+
                    "<strong>输入的企业名称或社会信用编码不存在</strong>");
            }
        }
    });
}
