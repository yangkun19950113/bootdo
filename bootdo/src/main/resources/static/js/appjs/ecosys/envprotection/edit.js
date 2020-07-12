$().ready(function() {
	radioTransfer();
	getPollutionCategoryCode();//加载污染类别
	getAreaCode();//加载所在区域
	getMainEnergyCode();//加载主要能源
	getNormalFactorsCode();//加载常规因子
	getSpecialFactorsCode();//加载特征因子
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
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
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
	}else {
		$("#parkFlg1").attr("checked","checked");
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
	var member = $("#mainEnergyCode1").val().split(",");
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
				$("#mainEnergyCode").append("<label style='margin-left: 15px;' class='radio-inline'><input type='checkbox' name='mainEnergyCode' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
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