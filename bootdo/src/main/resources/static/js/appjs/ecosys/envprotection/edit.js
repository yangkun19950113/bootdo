$().ready(function() {
	radioTransfer();
	getPollutionCategoryCode();//加载污染类别
	getIndustryCode();
	getAreaCode();//加载所在区域
	getMainEnergyCode();//加载主要能源
	getNormalFactorsCode();//加载常规因子
	getSpecialFactorsCode();//加载特征因子
	getProjectManageCode();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ecosys/envprotection/update",
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
				callback: {
					message: '请输入环评文号',
					callback: function(value, validator) {
						var ecoEstimateFlg = $('input:radio[name="ecoEstimateFlg"]:checked').val();
						if(ecoEstimateFlg == '0'){
							return true;
						}
					}
				},
			},*/
			/*parkFlg : {
				required : true
			},*/
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
			/*areaCode : {
				required : true
			},*/
			mainEnergyCode: {
				required : true
			},
			dosage: {
				required : true
			},
			/*measures: {
				required : true
			},*/
			surveytedPersonName : {
				required : true
			},
			surveytedPersonPosition : {
				required : true
			},
			fullFormTime : {
				required : true
			},
			/*surveyPersonName : {
				required : true
			},*/
		},
		messages : {
			ecoEstimateFlg : {
				required : icon + "请选择是否有环评文号"
			},
			/*ecoLicence: {
				callback : icon + "请选择是否属于园区"
			},*/
			/*parkFlg : {
				required : icon + "请选择是否属于园区"
			},*/
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
			/*areaCode : {
				required : icon + "请选择所在区域"
			},*/
			mainEnergyCode: {
				required : icon + "请选择主要能源"
			},
			dosage: {
				required : icon + "请填写年消耗量"
			},
			/*measures: {
				required : icon + "请填写污染治理措施"
			},*/
			surveytedPersonName : {
				required : icon + "请输入被调查人姓名"
			},
			surveytedPersonPosition : {
				required : icon + "请输入被调查人职务"
			},
			fullFormTime : {
				required : icon + "请选择填表时间"
			},
			/*surveyPersonName : {
				required : icon + "请输入调查人姓名"
			},*/
		}
	})
}
//加载行业类别
function getIndustryCode(){
	var industryCode = $("#industryCode1").val();
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
				$("#industryCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='radio' name='industryCode' id=" + code_list[i].codeId + " class='lopiu' value=" + code_list[i].codeId + "/>&nbsp;&nbsp;" + code_list[i].name + "</label>");
				if(code_list[i].codeId == industryCode ){
					$("#"+ code_list[i].codeId +"").prop("checked",true);
				}
			}
			if(industryCode == '076'){
				$("#other").removeAttr("disabled");
			}else{
				$("#other").attr("disabled","disabled");
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}

function radioTransfer(){
	var ecoEstimateFlg = $("#ecoEstimateFlg").val();
	var parkFlg = $("#parkFlg").val();
	var ecoStandardFlg = $("#ecoStandardFlg").val();
	var isOrNotAcceptance = $("#isOrNotAcceptance").val();
	var tradablePermitsCode = $("#tradablePermitsCode").val();
	var pollutionLicenseFlg = $("#pollutionLicenseFlg").val();
	var annualInspectionFlg = $("#annualInspectionFlg").val();

	if(ecoEstimateFlg == '0'){
		$("#ecoEstimateFlg0").attr("checked","checked");
	}else {
		$("#ecoEstimateFlg1").attr("checked","checked");
	}

	if(parkFlg == '0'){
		$("#parkFlg0").attr("checked","checked");
		$("#ecoLicence").removeAttr("disabled");
	}else {
		$("#parkFlg1").attr("checked","checked");
		$("#ecoLicence").attr("disabled","disabled");
	}

	if(ecoStandardFlg == '0'){
		$("#ecoStandardFlg0").attr("checked","checked");
	}else {
		$("#ecoStandardFlg1").attr("checked","checked");
	}

	if(isOrNotAcceptance == '0'){
		$("#isOrNotAcceptance0").attr("checked","checked");
	}else {
		$("#isOrNotAcceptance1").attr("checked","checked");
	}

	if(tradablePermitsCode == '091'){
		$("#tradablePermitsCode091").attr("checked","checked");
	}else if(tradablePermitsCode == '092'){
		$("#tradablePermitsCode092").attr("checked","checked");
	}else if(tradablePermitsCode == '093'){
		$("#tradablePermitsCode093").attr("checked","checked");
	}

	if(pollutionLicenseFlg == '0'){
		$("#pollutionLicenseFlg0").attr("checked","checked");
	}else {
		$("#pollutionLicenseFlg1").attr("checked","checked");
	}

	if(annualInspectionFlg == '0'){
		$("#annualInspectionFlg0").attr("checked","checked");
	}else {
		$("#annualInspectionFlg1").attr("checked","checked");
	}
}

//加载污染类别
function getPollutionCategoryCode(){
	var member = $("#pollutionCategoryCode1").val().split(",");
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
				$("#pollutionCategoryCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='checkbox' name='pollutionCategoryCode' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
				for(var j = 0; j < member.length; j++ ){
					if(code_list[i].codeId == member[j]){
						$("#"+ code_list[i].codeId +"").prop("checked",true);
					}
				}
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}

//加载所在区域
function getAreaCode(){
	var member = $("#areaCode1").val();
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
				$("#areaCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='radio' name='areaCode' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
				if(code_list[i].codeId == member ){
					$("#"+ code_list[i].codeId +"").prop("checked",true);
					/*$("#"+ code_list[i].codeId +"").attr("checked","checked");*/
				}
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载主要能源
function getMainEnergyCode(){
	var member = $("#mainEnergyCode1").val();
	var dosage = $("#dosage1").val();
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
				$("#mainEnergyCode").append("<label class='radio-inline'><input type='radio' name='mainEnergyCode' class='hhhbb' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "<input type='text' name='dosage' class='form-control' id='dosage"+ code_list[i].codeId + "'/></label>");
				if(code_list[i].codeId == member){
					$("#"+ code_list[i].codeId +"").prop("checked",true);
					$("#dosage" + member).val(dosage);
				}
			}
			$('input:input[name="dosage"]').attr("disabled","disabled");
			$("#dosage" + member).removeAttr("disabled");
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载常规因子
function getNormalFactorsCode(){
	var member = $("#normalFactorsCode1").val().split(",");
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
				$("#normalFactorsCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='checkbox' name='normalFactorsCode' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
				for(var j = 0; j < member.length; j++ ){
					if(code_list[i].codeId == member[j]){
						$("#"+ code_list[i].codeId +"").prop("checked",true);
					}
				}
			}
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载特征因子
function getSpecialFactorsCode(){
	var member = $("#specialFactorsCode1").val().split(",");
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
				$("#specialFactorsCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='checkbox' name='specialFactorsCode' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
				for(var j = 0; j < member.length; j++ ){
					if(code_list[i].codeId == member[j]){
						$("#"+ code_list[i].codeId +"").prop("checked",true);
					}
				}
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

//行业类别监听
$(document).on('click', '.lopiu', function() {
	var checkValue = $('input:radio[name="industryCode"]:checked').val();
	if(checkValue == '076'){//其他
		$("#other").removeAttr("disabled");
	}else{
		$("#other").val("");
		$("#other").attr("disabled","disabled");
	}
})
//监听是否有环评文号
$("#ecoEstimateFlg2 :radio").on('click', function () {
	   var item = $('input:radio[name="ecoEstimateFlg"]:checked').val();
	   if(item == '0'){
		   $("#ecoLicence").removeAttr("disabled");
	   }else{
		   $("#ecoLicence").val("");
		   $("#ecoLicence").attr("disabled","disabled");
	   }
})

//加载项目管理类别
function getProjectManageCode(){
	var member = $("#projectManageCode1").val();
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
				$("#projectManageCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='radio' name='projectManageCode' id=" + code_list[i].codeId + " value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
				if(code_list[i].codeId == member){
					$("#"+ code_list[i].codeId +"").prop("checked",true);
				}

			}
			layer.closeAll('loading');//关闭loading
		}
	})
}