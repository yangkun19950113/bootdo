var enterpriseId;
var prefix = "/ecosys/envprotection";
var industryCodeList;
var projectManageCodeList;
var pollutionCategoryCodeList;
var areaCodeList;
var mainEnergyCodeList;
var normalFactorsCodeList;
var specialFactorCodeList;
$(function() {
	enterpriseId = $("#enterpriseId").val();
	getSpecialFactorsCode();//加载特征因子
	getPollutionCategoryCode();//加载污染类别
	getAreaCode();//加载所在区域
	getMainEnergyCode();//加载主要能源
	getNormalFactorsCode();//加载常规因子
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list/"+enterpriseId, // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
								{
									field : 'enterpriseName', 
									title : '企业名称' 
								},
								{
									field : 'ecoEstimateFlg', 
									title : '是否有环评文号' ,
									formatter : function(value, row, index) {
										if(value == '0'){
											return row.ecoEstimateFlg = "是";
										}else if(value == '1') {
											return row.ecoEstimateFlg = "否";
										}
									}
								},
								{
									field : 'ecoLicence', 
									title : '环评文号' 
								},
								{
									field : 'parkFlg', 
									title : '是够属于园区' ,
									formatter : function(value, row, index) {
										if(value == '0'){
											return row.parkFlg = "是";
										}else if(value == '1') {
											return row.parkFlg = "否";
										}
									}
								},
								{
									field : 'ecoStandardFlg', 
									title : '是否有环保制度',
									formatter : function(value, row, index) {
										if(value == '0'){
											return row.ecoStandardFlg = "是";
										}else if(value == '1') {
											return row.ecoStandardFlg = "否";
										}
									}
								},
								{
									field : 'industryName',
									title : '行业类别'
								},
								{
									field : 'projectManageName',
									title : '项目管理类别'
								},
								{
									field : 'isOrNotAcceptance', 
									title : '是否竣工验收',
									formatter : function(value, row, index) {
										if(value == '0'){
											return row.isOrNotAcceptance = "是";
										}else if(value == '1') {
											return row.isOrNotAcceptance = "否";
										}
									}
								},
								{
									field : 'tradablePermitsCode', 
									title : '排污许可管理类别',
									formatter : function(value, row, index) {
										if(value == '091'){
											return row.tradablePermitsCode = "登记管理";
										}else if(value == '092') {
											return row.tradablePermitsCode = "简化管理";
										}else if(value == '093') {
											return row.tradablePermitsCode = "重点管理";
										}
									}
								},
								{
									field : 'pollutionLicenseFlg', 
									title : '是否核发排污许可证',
									formatter : function(value, row, index) {
										if(value == '0'){
											return row.pollutionLicenseFlg = "是";
										}else if(value == '1') {
											return row.pollutionLicenseFlg = "否";
										}
									}
								},
								{
									field : 'pollutionCategoryCode', 
									title : '污染类别',
									formatter : function(value, row, index) {
										var pollutionName = '' ;
										if(value != "" && value != null && value != undefined){
											var codeList = value.split(",");
											for(var i = 0;i<codeList.length;i++){
												for(var j = 0;j<pollutionCategoryCodeList.length;j++){
													if(codeList[i] == pollutionCategoryCodeList[j].codeId){
														pollutionName = pollutionCategoryCodeList[j].name + "," + pollutionName;
													}
												}
											}
										}
										return pollutionName;
									}
								},
								{
									field : 'annualInspectionFlg', 
									title : '年检监测是否有效',
									formatter : function(value, row, index) {
										if(value == '0'){
											return row.annualInspectionFlg = "是";
										}else if(value == '1') {
											return row.annualInspectionFlg = "否";
										}
									}
								},
								{
									field : 'areaCode', 
									title : '所在区域',
									formatter : function(value, row, index) {
										if (value != "" && value != null && value != undefined) {
											for (var i = 0; i < areaCodeList.length; i++) {
												if (value == areaCodeList[i].codeId) {
													return areaCodeList[i].name;
												}
											}
										}
									}
								},
								{
									field : 'mainEnergyCode', 
									title : '主要能源',
									formatter : function(value, row, index) {
										for(var i = 0;i<mainEnergyCodeList.length;i++){
											if(value == mainEnergyCodeList[i].codeId){
												return mainEnergyCodeList[i].name;
											}
										}
									}
								},
								{
									field : 'measures', 
									title : '污染治理措施' 
								},
								{
									field : 'normalFactorsCode', 
									title : '常规因子',
									formatter : function(value, row, index) {
										var normalFactorsName = '' ;
										if(value != "" && value != null && value != undefined){
											var codeList = value.split(",");
											for(var i = 0;i<codeList.length;i++){
												for(var j = 0;j<normalFactorsCodeList.length;j++){
													if(codeList[i] == normalFactorsCodeList[j].codeId){
														normalFactorsName = normalFactorsCodeList[j].name + "," + normalFactorsName;
													}
												}
											}
										}
										return normalFactorsName;
									}
								},
								{
									field : 'specialFactorsCode', 
									title : '特征因子',
									formatter : function(value, row, index) {
										var specialFactorsName = '' ;
										if(value != "" && value != null && value != undefined){
											var codeList = value.split(",");
											for(var i = 0;i<codeList.length;i++){
												for(var j = 0;j<specialFactorCodeList.length;j++){
													if(codeList[i] == specialFactorCodeList[j].codeId){
														specialFactorsName = specialFactorCodeList[j].name + "," + specialFactorsName;
													}
												}
											}
										}
										return specialFactorsName;
									}
								},
																{
									field : 'nomalWaste', 
									title : '一般固体废物' 
								},
																{
									field : 'dangerWaste', 
									title : '危险废物' 
								},
									/*							{
									field : 'surveytedPersonName', 
									title : '被调查人姓名' 
								},
																{
									field : 'surveytedPersonPosition', 
									title : '被调查人职务' 
								},
																{
									field : 'fullFormTime', 
									title : '填表日期' 
								},
																{
									field : 'surveyPersonName', 
									title : '调查人' 
								},*/
								/*								{
									field : 'administrativeDivision', 
									title : '行政区划' 
								},
																{
									field : 'urbanorrural', 
									title : '城乡分类' 
								},*/
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.envirProtectionId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.envirProtectionId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.envirProtectionId
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/' + enterpriseId // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'envir protectionId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['envir protectionId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}
//加载污染类别
function getPollutionCategoryCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 42
		},
		success: function (data) {
			pollutionCategoryCodeList = data.rows;
		}
	})
}
//加载所在区域
function getAreaCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 48
		},
		success: function (data) {
			areaCodeList = data.rows;
		}
	})
}
//加载主要能源
function getMainEnergyCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 53
		},
		success: function (data) {
			mainEnergyCodeList = data.rows;
		}
	})
}
//加载常规因子
function getNormalFactorsCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 57
		},
		success: function (data) {
			normalFactorsCodeList = data.rows;
		}
	})
}
//加载特征因子
function getSpecialFactorsCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 66
		},
		success: function (data) {
			specialFactorCodeList = data.rows;
		}
	})
}