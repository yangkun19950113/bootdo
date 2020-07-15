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
			equipmentName : {
				required : true
			},
			equipmentType : {
				required : true
			},
			buyTime : {
				required : true
			},
			effectTime : {
				required : true
			},
			brand : {
				required : true
			},
			installPosition : {
				required : true
			},
			protectionPerson : {
				required : true
			},
			/*phoneNumber : {
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
			equipmentName : {
				required : icon + "请输入设备名称"
			},
			equipmentType : {
				required : icon + "请输入设备类型"
			},
			buyTime : {
				required : icon + "请选择采购时间"
			},
			effectTime : {
				required : icon + "请选择有效时间"
			},
			brand : {
				required : icon + "请输入品牌"
			},
			installPosition : {
				required : icon + "请输入安装位置"
			},
			protectionPerson : {
				required : icon + "请输入设备负责人"
			},
			/*phoneNumber : {
				required : icon + "请输入联系电话"
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
