var enterpriseIdFa;
$().ready(function() {
	enterpriseIdFa = $("#enterpriseIdFa").val();
	validateRule();
	getEnterpriseList();//加载企业下拉框
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
		url : "/ecosys/firedevice/save",
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
				required : icon + "请输入姓名"
			}
		}
	})
}

//加载企业（用于设备企业归属）
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
