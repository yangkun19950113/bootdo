var enterpriseMsgMapping = "/ecosys/envprotection";
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
            console.log(res);
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
                var enterpriseId = enterpriseId;
                var proimgsurl = data.imgUrls;
                console.log(proimgsurl);
                // var minImgUrl = "../img/enterprise.png";
                var enterpriseName = data.enterpriseName;
                var socialCreditCode = data.socialCreditCode;
                var registeredAddress = data.registeredAddress;
                // var registeredTime = data.registeredTime;
                var enterpriseNatureCode = data.enterpriseNatureCode;
                var ecoEstimateFlg = data.ecoEstimateFlg;
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
                // var envprotectionMinImgUrl = data.envprotectionMinImgUrl;
                // var productMinImgUrl =data.productMinImgUrl;
                var prodectName = data.prodectName;
                var specifical = data.specifical;
                var model = data.model;
                // var materialMinImgUrl = data.materialMinImgUrl;
                var materialType = data.materialType;
                var materialName = data.materialName;
                var monthConsumption = data.monthConsumption;
                // var ecoequipmentMinImgUrl = data.ecoequipmentMinImgUrl;
                var equipmentName = data.equipmentName;
                var protectionPerson = data.protectionPerson;
                var phoneNumber = data.phoneNumber;
                var dangerSourceName= data.dangerSourceName;
                var partDetail = data.partDetail;
                var dangerprotectionPerson = data.dangerprotectionPerson;
                // var dangersourceMinImgUrl = data.dangersourceMinImgUrl;
                var trainName = data.trainName;
                var trainType = data.trainType;
                var personNumber = data.personNumber;
                // var trainingMinImgUrl = data.trainingMinImgUrl;
                // var electricMinImgUrl = data.electricMinImgUrl;
                var eleequipmentName = data.eleequipmentName;
                var eleequipmentCode = data.eleequipmentCode;
                var number = data.number;
                var peopleFindName = data.peopleFindName;
                var findTime = data.findTime;
                if(null == findTime){
                    var findTime = "";
                }
                var type = data.type;
                // var riskMinImgUrl = data.riskMinImgUrl;
                var fireequipmentName = data.fireequipmentName;
                var fireequipmentCode = data.fireequipmentCode;
                var buyTime = data.buyTime;
                if(null == buyTime){
                    var buyTime = "";
                }
                // var firedeviceMinImgUrl = data.firedeviceMinImgUrl;
                var industryCode = data.industryCode;
                var monthProduction = data.monthProduction;
                var level = data.level;


                //填充每幅图像的具体信息
                if(null == proimgsurl){

                }else {
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
                    "<img src='../img/enterprise.png' alt='' class='card-img-top'style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>" + enterpriseName + "</h5>" +
                    "<p class='card-text'> 社会信用编码:" + socialCreditCode + "</p>" +
                    "<p class='card-text'> 注册地址:" + registeredAddress + "</p>" +
                    "<p class='card-text'> 企业性质:" + enterpriseNatureCode + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#envprotection").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/envprotection.png' alt='' class='card-img-top' style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>环保基本信息</h5>" +
                    "<p class='card-text'> 是否有环评文号:" + ecoEstimateFlg + "</p>" +
                    "<p class='card-text'> 是够属于园区:" + parkFlg + "</p>" +
                    "<p class='card-text'> 是否有环保制度:" + ecoStandardFlg + "</p>" +
                    // "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    '<a class="btn btn-primary"  href="#" onclick="openPageJump(\'' + enterpriseMsgMapping +'\',\'' + enterpriseMsgMapping +'/showExcelInfo/'+enterpriseId+'\',\'' + '环保表格信息' + '\')">'+'环保表格信息'+'</a>'+
                    "</div>"
                );
                $("#product").append("<div class='card' style='width: 18rem;' >" +
                    "<img src='../img/product.png' alt='' class='card-img-top' style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>企业产品及产能</h5>" +
                    "<p class='card-text'> 产品名称:" + prodectName + "</p>" +
                    "<p class='card-text'> 规格:" + specifical + "</p>" +
                    "<p class='card-text'> 月产量:" + monthProduction + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#material").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/material.png' alt='' class='card-img-top' style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>产品原材料</h5>" +
                    "<p class='card-text'> 原材料类型:" + materialType + "</p>" +
                    "<p class='card-text'> 原材料名称:" + materialName + "</p>" +
                    "<p class='card-text'> 月使用量:" + monthConsumption + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#ecoequipment").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/ecoequipment.png' alt='' class='card-img-top'style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>防治设备</h5>" +
                    "<p class='card-text'> 设备名称:" + equipmentName + "</p>" +
                    "<p class='card-text'> 设备负责人:" + protectionPerson + "</p>" +
                    "<p class='card-text'> 联系电话:" + phoneNumber + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#dangersource").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/dangersource.png' alt='' class='card-img-top' style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>重点部位</h5>" +
                    "<p class='card-text'> 危险源信息名称:" + dangerSourceName + "</p>" +
                    "<p class='card-text'> 具体位置:" + partDetail + "</p>" +
                    "<p class='card-text'> 危险责任人:" + dangerprotectionPerson + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#training").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/training.png' alt='' class='card-img-top'style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>安全生产培训</h5>" +
                    "<p class='card-text'> 培训主题:" + trainName + "</p>" +
                    "<p class='card-text'> 培训类型:" + trainType + "</p>" +
                    "<p class='card-text'> 参加人数:" + personNumber + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#electric").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/electric.png' alt='' class='card-img-top'style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>用电设备</h5>" +
                    "<p class='card-text'> 设备名称:" + eleequipmentName + "</p>" +
                    "<p class='card-text'> 设备编码:" + eleequipmentCode + "</p>" +
                    "<p class='card-text'> 台数:" + number + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#risk").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/risk.png' alt='' class='card-img-top'style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>安全隐患</h5>" +
                    "<p class='card-text'> 发现人员:" + peopleFindName + "</p>" +
                    "<p class='card-text'> 发现时间:" + findTime + "</p>" +
                    "<p class='card-text'> 级别:" + level + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
                    "</div>"
                );
                $("#firedevice").append("<div class='card' style='width: 18rem;'>" +
                    "<img src='../img/firedevice.png' alt='' class='card-img-top'style='width: 100px;height: 100px;margin-left: 90px'>" +
                    "<div class='card-body'> " +
                    "<h5 class='card-title'>消防设备</h5>" +
                    "<p class='card-text'> 设备名称:" + fireequipmentName + "</p>" +
                    "<p class='card-text'> 设备编码:" + fireequipmentCode + "</p>" +
                    "<p class='card-text'> 采购时间:" + buyTime + "</p>" +
                    "<a href='#' class='btn btn-primary'>表格信息</a>" +
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
