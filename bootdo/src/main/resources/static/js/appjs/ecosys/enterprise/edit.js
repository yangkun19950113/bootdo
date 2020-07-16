
$().ready(function() {
	validateRule();
	transferEnterpriseScope();
	loadEnterpriseNatureCode();
	taxpayerCode();
	marketCode();
	administrativeDivision();
	/*transRegisteredTime();*/
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
		url : "/ecosys/enterprise/update",
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
			enterpriseName : {
				required : true
			},
			socialCreditCode : {
				required : true
			},
			registeredAddress : {
				required : true
			},
			registeredTime : {
				required : true
			},
			/*registeredFund : {
				required : true
			},*/
			employeeNum : {
				required : true
			},
			enterpriseScope : {
				required : true
			},
			coordinates : {
				required : true
			},
			enterpriseNatureCode : {
				/*notEmpty: true,*/
				required : true
			},
			enterpriseLegalPerson : {
				required : true
			},
			legalPersonPhoneNumber : {
				required : true
			},
			environmentalProtectionPerson : {
				required : true
			},
			enPersonPhoneNumber : {
				required : true
			},
			safeProdectPerson : {
				required : true
			},
			safePerPhoneNumber : {
				required : true
			},
			businessScope : {
				required : true
			},
			businessArea : {
				required : true
			},
			businessAreaNatureCode : {
				required : true
			},
			taxpayerCode : {
				required : true
			},
			marketCode : {
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
			/*surveyPersonName : {
				required : true
			},*/
			administrativeDivision: {
				required : true
			},
			country: {
				required : true
			},
		},
		messages : {
			enterpriseName : {
				required : icon + "请输入企业名称"
			},
			socialCreditCode : {
				required : icon + "请输入社会信用编码"
			},
			registeredAddress : {
				required : icon + "请输入注册地址"
			},
			registeredTime : {
				required : icon + "请选择注册时间"
			},
			/*registeredFund : {
				required : icon + "请输入注册资金"
			},*/
			employeeNum : {
				required : icon + "请输入员工数"
			},
			enterpriseScope : {
				required : icon + "请选择企业规模"
			},
			coordinates : {
				required : icon + "请输入坐标位置"
			},
			enterpriseNatureCode : {
				/*notEmpty :icon + "请选择企业性质",*/
				required : icon + "请选择企业性质"
			},
			enterpriseLegalPerson : {
				required : icon + "请输入企业法人"
			},
			legalPersonPhoneNumber : {
				required : icon + "请输入法人联系方式"
			},
			environmentalProtectionPerson : {
				required : icon + "请输入环保负责人"
			},
			enPersonPhoneNumber : {
				required : icon + "请输入环保负责人联系方式"
			},
			safeProdectPerson : {
				required : icon + "请输入安全生产责任人"
			},
			safePerPhoneNumber : {
				required : icon + "请输入安全生产责任人联系方式"
			},
			businessScope : {
				required : icon + "请输入经营范围"
			},
			businessArea : {
				required : icon + "请输入经营面积"
			},
			businessAreaNatureCode : {
				required : icon + "请选择经营场所取得方式"
			},
			taxpayerCode : {
				required : icon + "请选择纳税人性质"
			},
			marketCode : {
				required : icon + "请选择互联网营销方式"
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
			/*surveyPersonName : {
				required : icon + "请输入调查人姓名"
			},*/
			administrativeDivision: {
				required : icon + "请选择乡镇"
			},
			country: {
				required : icon + "请选择街道"
			},
		}
	})
}
//check企业规模
function transferEnterpriseScope(){
	var enterpriseScope = $("#enterpriseScope").val();
	if(enterpriseScope == '1'){
		$("#enterpriseScopeRadio1").attr("checked","checked");
	}else if(enterpriseScope == '2'){
		$("#enterpriseScopeRadio2").attr("checked","checked");
	}else if(enterpriseScope == '3'){
		$("#enterpriseScopeRadio3").attr("checked","checked");
	}
}
//check企业性质
function loadEnterpriseNatureCode() {
	var member = $("#enterpriseNatureCode1").val();
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 1
		},
		success: function (data) {
			var code_list = data.rows;
			var opts = "<option value=''>" +"请选择 "+"</option>";
			for (var i = 0; i < code_list.length; i++) {
				var code = code_list[i];
				if(code.codeId == member){
					opts += "<option value='" + code.codeId + "' selected = \"selected\">" + code.name + "</option>";
				}else {
					opts += "<option value='" + code.codeId + "' >" + code.name + "</option>";
				}
			}
			$("#enterpriseNatureCode").append(opts);
			layer.closeAll('loading');//关闭loading
		}
	})
}
//check纳税人性质
function taxpayerCode(){
	var member = $("#taxpayerCode1").val();
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 10
		},
		success: function (data) {
			var code_list = data.rows;
			var opts = "<option value=''>" +"请选择 "+"</option>";
			for (var i = 0; i < code_list.length; i++) {
				var code = code_list[i];
				if(code.codeId == member){
					opts += "<option value='" + code.codeId + "' selected = \"selected\">" + code.name + "</option>";
				}else {
					opts += "<option value='" + code.codeId + "'>" + code.name + "</option>";
				}
			}
			$("#taxpayerCode").append(opts);
			layer.closeAll('loading');//关闭loading
		}
	})
}

//check互联网营销方式多选框
function marketCode(){
	var member = $("#marketCode1").val().split(",");
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 14
		},
		success: function (data) {
			var code_list = data.rows;
			for (var i = 0; i < code_list.length; i++) {
				$("#marketCode").append("<label style='margin-left: 20px;' class='radio-inline'><input type='checkbox' name='marketCode' value=" + code_list[i].codeId + " id=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
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
//加载行政区划
function administrativeDivision(){
	var member = $("#administrativeDivision").val();
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
			for (var i = 0; i < code_list.length; i++) {
				var code = code_list[i];
				if(code.codeId == member){
					opts += "<option value='" + code.codeId + "' selected = \"selected\" id='" + code.id + "'>" + code.name + "</option>";
				}else {
					opts += "<option value='" + code.codeId + "' id='" + code.id + "'>" + code.name + "</option>";
				}
			}
			$("#administrativeDivision1").append(opts);
			layer.closeAll('loading');//关闭loading
			var parentId = $("#administrativeDivision1 option:selected").attr("id");
			$("#country").find("option").remove();//清空option
			var member1 = $("#country").val();
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
					var opts1 = "<option value=''>" +"请选择 "+"</option>";
					for (var i = 0; i < code_list.length; i++) {
						var code = code_list[i];
						if(code.orderNum == member1){
							opts1 += "<option value='" + code.orderNum + "' selected = \"selected\">" + code.name + "</option>";
						}else {
							opts1 += "<option value='" + code.orderNum + "'>" + code.name + "</option>";
						}
					}
					$("#country1").append(opts1);
					layer.closeAll('loading');//关闭loading
				}
			})
		}
	});
}
//行政区划更改监听
$("#administrativeDivision1").bind("change", function(){
	//获取
	var option = $("#administrativeDivision1 option:selected").val();
	var parentId = $("#administrativeDivision1 option:selected").attr("id");
	$("#country1").find("option").remove();//清空option
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
			$("#country1").append(opts);
			layer.closeAll('loading');//关闭loading
		}
	})
})


