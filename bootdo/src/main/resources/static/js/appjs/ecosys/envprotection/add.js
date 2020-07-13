var enterpriseIdFa;
$().ready(function() {
	enterpriseIdFa = $("#enterpriseIdFa").val();
	validateRule();
	getEnterpriseList();//加载企业
	getIndustryCode();//加载行业类别
	getProjectManageCode();//加载项目管理类别
	getPollutionCategoryCode();//加载污染类别
	getAreaCode();//加载所在区域
	getMainEnergyCode();//加载主要能源
	getNormalFactorsCode();//加载常规因子
	getSpecialFactorsCode();//加载特征因子
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ecosys/envprotection/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			ecoEstimateFlg : {
				required : true
			},
			/*ecoLicence : {
				call: true
			},*/
			parkFlg : {
				required : true
			},
			ecoStandardFlg : {
				required : true
			},
			industryCode : {
				required : true
			},
			projectManageCode : {
				required : true
			},
			isOrNotAcceptance : {
				required : true
			},
			tradablePermitsCode : {
				required : true
			},
			pollutionLicenseFlg : {
				required : true
			},
			pollutionCategoryCode : {
				required : true
			},
			annualInspectionFlg : {
				required : true
			},
			areaCode : {
				required : true
			},
			mainEnergyCode: {
				required : true
			},
			dosage: {
				required : true
			},
			measures: {
				required : true
			},
			surveytedPersonName : {
				required : true
			},
			surveytedPersonPosition : {
				required : true
			},
			fullFormTime : {
				required : true
			},
			surveyPersonName : {
				required : true
			},
		},
		messages : {
			ecoEstimateFlg : {
				required : icon + "请选择是否有环评文号"
			},
			/*ecoLicence: {
				message:"请选择是否有环评文号",
				callback: function(value, validator) {
					var ecoEstimateFlg = $('input:radio[name="ecoEstimateFlg"]:checked').val();
					if(ecoEstimateFlg == '0'){
						return true;
					}
				}
			},*/
			parkFlg : {
				required : icon + "请选择是否属于园区"
			},
			ecoStandardFlg : {
				required : icon + "请选择是否有环保制度"
			},
			industryCode : {
				required : icon + "请选择行业类别"
			},
			projectManageCode : {
				required : icon + "请选择项目管理类别"
			},
			isOrNotAcceptance : {
				required : icon + "请选择是否竣工验收"
			},
			tradablePermitsCode : {
				required : icon + "请选择排污许可管理类别"
			},
			pollutionLicenseFlg : {
				required : icon + "请选择是否核发排污许可证"
			},
			pollutionCategoryCode : {
				required : icon + "请选择污染类别"
			},
			annualInspectionFlg : {
				required : icon + "请选择年检监测是否有效"
			},
			areaCode : {
				required : icon + "请选择所在区域"
			},
			mainEnergyCode: {
				required : icon + "请选择主要能源"
			},
			dosage: {
				required : icon + "请填写年消耗量"
			},
			measures: {
				required : icon + "请填写污染治理措施"
			},
			surveytedPersonName : {
				required : icon + "请输入被调查人姓名"
			},
			surveytedPersonPosition : {
				required : icon + "请输入被调查人职务"
			},
			fullFormTime : {
				required : icon + "请选择填表时间"
			},
			surveyPersonName : {
				required : icon + "请输入调查人姓名"
			},
		}
	})
}

//加载企业（用于信息归属）
function getEnterpriseList(){
	$.ajax({
		type: "get",
		url: "/ecosys/enterprise/getEnterpriseById",
		dataType: "json",
		data: {
			enterpriseId: enterpriseIdFa
		},
		success: function (data) {
			$("#enterpriseId").val(data.enterpriseId);
			$("#enterpriseId1").val(data.enterpriseName);
			layer.closeAll('loading');//关闭loading
		}
	})
}
//是否有环评文件控制环评文件编码输入框是否能够使用
$(".ecoEstimateFlg").change(
	function() {
		var flag = $("input[name='ecoEstimateFlg']:checked").val();
		if (flag == 0) {
			$('#ecoLicence').removeAttr("disabled");
		}else if (flag == 1){
			$('#ecoLicence').val("");//清空环评编码
			$('#ecoLicence').attr("disabled","disabled");
		}
	});
//加载行业类别
function getIndustryCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 26
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#industryCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='radio' name='industryCode' value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载项目管理类别
function getProjectManageCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 33
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#projectManageCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='radio' name='projectManageCode' value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载污染类别
function getPollutionCategoryCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 42
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#pollutionCategoryCode").append("<label class='radio-inline'><input type='checkbox' name='pollutionCategoryCode' value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载所在区域
function getAreaCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 48
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#areaCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='radio' name='areaCode' value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载主要能源
function getMainEnergyCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 53
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#mainEnergyCode").append("<label class='radio-inline'><input type='radio' name='mainEnergyCode' class='hhhbb' value=" + code_list[i].codeId + ">&nbsp;&nbsp;" + code_list[i].name + " <input type='text' name='dosage' class='form-control' id='dosage"+ code_list[i].codeId + "'/></label>");
			}
			$('input:input[name="dosage"]').attr("disabled","disabled");
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载常规因子
function getNormalFactorsCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 57
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#normalFactorsCode").append("<label class='radio-inline'><input type='checkbox' name='normalFactorsCode' value=" + code_list[i].codeId + ">&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载特征因子
function getSpecialFactorsCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 66
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#specialFactorsCode").append("<label class='radio-inline'><input type='checkbox' name='specialFactorsCode' value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}

//主要能源，监听事件
$(document).on('click', '.hhhbb', function() {
	var checkValue = $('input:radio[name="mainEnergyCode"]:checked').val();
	$('input:input[name="dosage"]').attr("disabled","disabled");
	$("#dosage" + checkValue).removeAttr("disabled");
	//清空
	$('input:input[name="dosage"]').val("");
})
