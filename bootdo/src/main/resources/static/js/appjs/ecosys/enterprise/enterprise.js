var prefix = "/ecosys/enterprise";
var prefixFire = "/ecosys/firedevice";
var prefixElectric = "/ecosys/electric";
var prefixEnvprotection = "/ecosys/envprotection";
var prefixDangerSource = "/ecosys/dangersource";
var prefixMaterial = "/ecosys/material";
var prefixProduct = "/ecosys/product";
var prefixEcoEquipment = "/ecosys/ecoequipment";
var prefixTraining = "/ecosys/training";
var prefixRisk = "/ecosys/risk";



var enterpriseNatureCodeList;
var taxpayerCodeList;
var marketCodeList;
$(function() {
	/*loadEnterpriseNatureCode();
	taxpayerCode();
	marketCode();*/
	load();
});

function load() {
	$('#exampleTable').bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						/*search : true, // 是否显示搜索框*/
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
								enterpriseName:$('#searchName').val(),
								administrativeDivision:$('#administrativeDivision').val()
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
									field : 'socialCreditCode', 
									title : '社会信用编码' 
								},
								{
									field : 'registeredAddress', 
									title : '注册地址' 
								},
								{
									field : 'employeeNum',
									title : '企业规模'
								},
								/*{
									field : 'registeredTime',
									title : '注册时间' 
								},*/
								{
								title : '企业相关',
								field : 'id',
								/*align : 'center',*/
								width:'470',
								formatter : function(value, row, index) {
									var a = '<a class="btn btn-danger btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixFire +'\',\'' + prefixFire +'/'+row.enterpriseId+'\',\'' + '消防设备管理' + '\')">'+'消'+'</a>';
									var b = '<a class="btn btn-primary btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixElectric +'\',\'' + prefixElectric +'/'+row.enterpriseId+'\',\'' + '用电设备管理' + '\')">'+'电'+'</a>';
									var c = '<a class="btn btn-success btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixEnvprotection +'\',\'' + prefixEnvprotection +'/'+row.enterpriseId+'\',\'' + '环保信息管理' + '\')">'+'环'+'</a>';
									var d = '<a class="btn btn-danger btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixDangerSource +'\',\'' + prefixDangerSource +'/'+row.enterpriseId+'\',\'' + '危险源信息管理' + '\')">'+'危'+'</a>';
									var e = '<a class="btn btn-info btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixMaterial +'\',\'' + prefixMaterial +'/'+row.enterpriseId+'\',\'' + '物料信息管理' + '\')">'+'物'+'</a>';
									var f = '<a class="btn btn-warning btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixProduct +'\',\'' + prefixProduct +'/'+row.enterpriseId+'\',\'' + '产品信息管理' + '\')">'+'产'+'</a>';
									var g = '<a class="btn btn-default btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixEcoEquipment +'\',\'' + prefixEcoEquipment +'/'+row.enterpriseId+'\',\'' + '防治设备管理' + '\')">'+'防'+'</a>';
									var h = '<a class="btn btn-success btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixTraining +'\',\'' + prefixTraining +'/'+row.enterpriseId+'\',\'' + '安全生产培训管理' + '\')">'+'培'+'</a>';
									var i = '<a class="btn btn-info btn-sm" style="margin-left: 15px;" href="#" onclick="openPageJump(\'' + prefixRisk +'\',\'' + prefixRisk +'/'+row.enterpriseId+'\',\'' + '安全隐患管理' + '\')">'+'患'+'</a>';
									return a + b + c + d + e + f + g + h + i ;
								}
							},


							/*
																{
									field : 'registeredFund', 
									title : '注册资金' 
								},
																{
									field : 'employeeNum', 
									title : '员工数' 
								},
																{
									field : 'enterpriseScope', 
									title : '企业规模',
									formatter : function(value, row, index) {
										if(value == 1){
											return row.enterpriseScope = "大";
										}else if(value == 2){
											return row.enterpriseScope = "中";
										}else if(value == 3){
											return row.enterpriseScope = "小";
										}else{
											return row.enterpriseScope = "";
										}
									}
								},
																{
									field : 'coordinates', 
									title : '坐标位置' 
								},
																{
									field : 'enterpriseNatureCode', 
									title : '企业性质',
									formatter : function(value, row, index) {
										for(var i = 0;i<enterpriseNatureCodeList.length;i++){
											if(value == enterpriseNatureCodeList[i].codeId){
												return enterpriseNatureCodeList[i].name;
											}
										}
									}
								},
																{
									field : 'enterpriseLegalPerson',
									title : '企业法人'
								},
																{
									field : 'legalPersonPhoneNumber',
									title : '法人电话'
								},
																{
									field : 'environmentalProtectionPerson',
									title : '环保负责人'
								},
																{
									field : 'enPersonPhoneNumber',
									title : '环保负责人电话'
								},
																{
									field : 'safeProdectPerson',
									title : '安全生产责任人'
								},
																{
									field : 'safePerPhoneNumber',
									title : '安全生产责任人电话'
								},
																{
									field : 'businessScope',
									title : '经营范围'
								},
																{
									field : 'businessArea',
									title : '经营面积'
								},
																{
									field : 'businessAreaNatureCode',
									title : '经营场所取得',
									formatter : function(value, row, index) {
										if(value == '021'){
											return "自有";
										}else if(value == '022'){
											return "租赁";
										}
									}
								}, {
									field : 'dept',
									title : '部门设置'
								},
																{
									field : 'taxpayerCode',
									title : '纳税人性质',
									formatter : function(value, row, index) {
										for(var i = 0;i<taxpayerCodeList.length;i++){
											if(value == taxpayerCodeList[i].codeId){
												return taxpayerCodeList[i].name;
											}
										}
									}
								},
																{
									field : 'marketCode',
									title : '互联网营销方式',
									formatter : function(value, row, index) {
										var marketName = '' ;
										//拆分
										if(value != "" && value != null && value != undefined){
											var codeList = value.split(",");
											for(var i = 0;i<codeList.length;i++){
												for(var j = 0;j<marketCodeList.length;j++){
													if(codeList[i] == marketCodeList[j].codeId){
														marketName = marketCodeList[j].name + "," + marketName;
													}
												}
											}
										}
										return marketName;
									}
								},
																{
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
								},
																{
									field : 'createTime',
									title : '创建时间'
								},
																{
									field : 'createUserName',
									title : '创建人'
								},
																{
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
										var e = '<a class="btn btn-primary btn-sm '+'" href="#" mce_href="#" title="编辑" onclick="edit(\'' + row.enterpriseId + '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+'" href="#" title="删除"  mce_href="#" onclick="remove(\'' + row.enterpriseId + '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\'' + row.enterpriseId + '\')"><i class="fa fa-key"></i></a> ';
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
		content : prefix + '/add' // iframe的url
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
				'enterpriseId' : id
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
			ids[i] = row['enterpriseId'];
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



//加载企业性质
function loadEnterpriseNatureCode() {
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 1
		},
		success: function (data) {
			enterpriseNatureCodeList = data.rows;
		}
	})
}
//加载纳税人性质
function taxpayerCode(){
	$.ajax({
		type: "get",
		url: "/ecosys/code/list",
		dataType: "json",
		data: {
			parentId: 10
		},
		success: function (data) {
			taxpayerCodeList = data.rows;
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
			marketCodeList = data.rows;
		}
	})
}

function doSubmit(){
	/*window.location.href='/ecosys/firedevice/';*/



}



