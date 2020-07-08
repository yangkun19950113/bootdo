$().ready(function() {
	validateRule();
	enterpriseNatureCode();//加载企业性质下拉框
	taxpayerCode();//加载纳税人性质下拉框
	marketCode();//加载互联网营销方式多选框
});

$.validator.setDefaults({
	submitHandler : function() {
		//校验
		/*if($('#enterpriseName').val().trim() == "" || $('#enterpriseName').val().trim() == null || $('#enterpriseName').val().trim() == undefined){
			return layer.msg("请输入企业名称");
		}*/




		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ecosys/enterprise/save",
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
			registeredFund : {
				required : true
			},
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
			dept : {
				required : true
			},
			taxpayerCode : {
				/*notEmpty : true,*/
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
			surveyPersonName : {
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
			registeredFund : {
				required : icon + "请输入注册资金"
			},
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
			dept : {
				required : icon + "请输入部门设置"
			},
			taxpayerCode : {
				/*notEmpty :icon + "请选择纳税人性质",*/
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
			surveyPersonName : {
				required : icon + "请输入调查人姓名"
			},
		}
	})
}
//企业性质下拉框
function enterpriseNatureCode() {
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
				opts += "<option value='" + code.codeId + "'>" + code.name + "</option>";
			}
			$("#enterpriseNatureCode").append(opts);
			/*$("#enterpriseNatureCode").selectpicker("refresh");*/
			layer.closeAll('loading');//关闭loading
		}
	})
}

//加载纳税人性质选择项
function taxpayerCode(){
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
				opts += "<option value='" + code.codeId + "'>" + code.name + "</option>";
			}
			$("#taxpayerCode").append(opts);
			/*$("#taxpayerCode").selectpicker("refresh");*/
			layer.closeAll('loading');//关闭loading
		}
	})
}
//加载互联网营销方式多选框
function marketCode(){
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
				$("#marketCode").append("<label style='margin-left: 20px;' class='radio-inline'><input type='checkbox' name='marketCode' value=" + code_list[i].codeId + " />&nbsp;&nbsp;" + code_list[i].name + "</label>");
			}
			//设置复选框默认不选中
			/*$("input[name='roleCheck']").iCheck('uncheck');*/
			layer.closeAll('loading');//关闭loading
		}
	})
}

