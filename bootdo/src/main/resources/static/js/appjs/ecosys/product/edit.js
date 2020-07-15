$().ready(function() {
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
		url : "/ecosys/product/update",
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
			prodectName : {
				required : true
			},
			produtProcess : {
				required : true
			},
			deviceName : {
				required : true
			},
			monthProduction : {
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
			prodectName : {
				required : icon + "请输入产品名称"
			},
			produtProcess : {
				required : icon + "请输入生产工艺"
			},
			deviceName : {
				required : icon + "请输入生产设施"
			},
			monthProduction : {
				required : icon + "请输入月产量"
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