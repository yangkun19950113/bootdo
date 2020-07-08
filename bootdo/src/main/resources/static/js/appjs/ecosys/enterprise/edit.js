
$().ready(function() {
	validateRule();
	transferEnterpriseScope();
	loadEnterpriseNatureCode();
	taxpayerCode();
	marketCode();
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
//转换注册时间
function transRegisteredTime(){
	var registeredTime = $("#registeredTime").val();
	$('#datetimepicker1').datetimepicker({
		format: 'YYYY-MM-DD',
		locale: moment.locale('zh-cn'),
		weekStart: 0, //一周从哪一天开始
		todayBtn:  1, //
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
		showMeridian: 1
	});
	$('#datetimepicker1').datetimepicker('update');

}