var enterpriseIdFa;
$().ready(function() {
	enterpriseIdFa = $("#enterpriseIdFa").val();
	validateRule();
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
		url : "/ecosys/material/save",
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
			materialName : {
				required : true
			},
			materialType : {
				required : true
			},
			/*specifical : {
				required : true
			},*/
			orgionWay : {
				required : true
			},
			monthConsumption : {
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
			materialName : {
				required : icon + "请输入物料名称"
			},
			materialType : {
				required : icon + "请选择物料类型"
			},
			/*specifical : {
				required : icon + "请输入规格"
			},*/
			orgionWay : {
				required : icon + "请输入进货渠道"
			},
			monthConsumption : {
				required : icon + "请输入月使用量"
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