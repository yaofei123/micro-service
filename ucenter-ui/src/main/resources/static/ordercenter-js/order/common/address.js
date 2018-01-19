var provinceId = "";
var cityId = "";
var districtId = "";
/**
 * 页面初始化后加载
 */
$(document).ready(function(){
//	$.getScript("http://design.ehaoyao.com/mall/js/commonArea_v2.js",function(){
	$.getScript("http://design.ehaoyao.com/mall/js/commonArea.js",function(){
		setProvince();
	});
});

/**
 * 省份
 */
function setProvince(){
	var options = getOption("","所有省份",provinceId);
	$.each(areaAllJson,function(index,area){
		if(area.parentId=='0'){
			options += getOption(area.areaCode,area.areaName,provinceId);
		}
	});
	$('#provinceId').html(options);
	$("#provinceId").trigger("change");
	setCity(cityId);
	setDistrict(districtId);
}
/**
 * 市
 */
function setCity(selectCityId){
	var options = getOption("","所有城市",selectCityId);
	var optionDistrict = getOption("","所有区域","");
	var selectId = $("#provinceId").val();
	if(selectId!=""){
		$.each(areaAllJson,function(index,area){
			if(area.parentId==selectId){
				options += getOption(area.areaCode,area.areaName,selectCityId);
			}
		});
	}
	$('#cityId').html(options);
	$("#cityId").trigger("change");
	$('#districtId').html(optionDistrict);
}

/**
 * 区
 */
function setDistrict(selectDistrictId){
	var options = getOption("","所有区域",selectDistrictId);
	var selectId = $("#cityId").val();
	if(selectId!=""){
		$.each(areaAllJson,function(index,area){
			if(area.parentId==selectId){
				options += getOption(area.areaCode,area.areaName,selectDistrictId);
			}
		});
	}
	$('#districtId').html(options);
	$("#districtId").trigger("change");
}


/**
 * 省市区下拉菜单拼接
 */
function getOption(id,name,selectId){
	var s = "";
	if(id==selectId){
		s += 'selected="selected"';
	}
	return '<option '+s+' value="'+id+'">'+name+'</option>';
}
