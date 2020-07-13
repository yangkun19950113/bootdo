$().ready(function() {
	radioTransfer();
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
		url : "/ecosys/training/update",
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
			trainName : {
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
			trainName : {
				required : icon + "请输入培训主题"
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

function radioTransfer(){
	var trainingFlg = $("#trainingFlg").val();
	var laProvideFlg = $("#laProvideFlg").val();
	var traningFileFlg = $("#traningFileFlg").val();


	if(trainingFlg == '0'){
		$("#trainingFlg0").attr("checked","checked");
	}else {
		$("#trainingFlg1").attr("checked","checked");
	}

	if(laProvideFlg == '0'){
		$("#laProvideFlg0").attr("checked","checked");
	}else {
		$("#laProvideFlg1").attr("checked","checked");
	}

	if(traningFileFlg == '0'){
		$("#traningFileFlg0").attr("checked","checked");
	}else {
		$("#traningFileFlg1").attr("checked","checked");
	}
}