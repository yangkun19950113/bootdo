var enterpriseIdFa;
$().ready(function() {
	enterpriseIdFa = $("#enterpriseIdFa").val();
	validateRule();
	getEnterpriseList(enterpriseIdFa);//加载企业下拉框
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
		url : "/ecosys/electric/save",
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
			equipmentUse : {
				required : true
			},
			equipmentPower : {
				required : true
			},
			phaseNumber : {
				required : true
			},
			number : {
				required : true
			},
			installPosition : {
				required : true
			},
			isOrNotThrough : {
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
		},
		messages : {
			equipmentName : {
				required : icon + "请输入设备名称"
			},
			equipmentUse : {
				required : icon + "请输入设备用途"
			},
			equipmentPower : {
				required : icon + "请输入设备功率"
			},
			phaseNumber : {
				required : icon + "请输入相数"
			},
			number : {
				required : icon + "请输入台数"
			},
			installPosition : {
				required : icon + "请输入安装位置"
			},
			isOrNotThrough : {
				required : icon + "请选择是否穿管"
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
		}
	})
}
//加载企业（用于设备企业归属）
function getEnterpriseList(enterpriseId){
	$.ajax({
		type: "get",
		url: "/ecosys/enterprise/getEnterpriseById",
		dataType: "json",
		data: {
			enterpriseId: enterpriseId
		},
		success: function (data) {
			$("#enterpriseId").val(data.enterpriseId);
			$("#enterpriseId1").val(data.enterpriseName);
			layer.closeAll('loading');//关闭loading
		}
	})
}