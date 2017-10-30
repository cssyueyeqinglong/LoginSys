<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript">
		//动态设置生产厂家的名称 
		function setFactoryName(val){
			document.getElementById("factoryName").value = val;
		}
	</script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="contract.id" value="${contract.id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('contractProductAction_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改货物
  </div> 

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">生产厂家：</td>
	            <td class="tableContent">
	            	 <s:select name="factory.id" list="factoryList" 
	            				onchange="setFactoryName(this.options[this.selectedIndex].text);"
	            				listKey="id" listValue="factory_name"
	            				headerKey="" headerValue="--请选择--"/>
	            	<input type="hidden" id="factoryName" name="factory_name" value="${factory_name }"/>
	            </td>
	            <td class="columnTitle">货号：</td>
	            <td class="tableContentAuto"><input type="text" name="product_no" value="${product_no }"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物照片：</td>
	            <td class="tableContent"><input type="text" name="product_image" value="${product_image }"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${cnumber }"/>  
	                <input type="hidden" name="amount" value="${amount }"/>
	            </td>
	            <td class="columnTitle">包装单位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="packing_unit" value="PCS" ${packing_unit=='PCS'?"checked":"" } class="input">只
	            	<input type="radio" name="packing_unit" value="SETS" ${packing_unit=='SETS'?"checked":"" } class="input">套
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">装率：</td>
	            <td class="tableContent"><input type="text" name="loading_rate" value="${loading_rate }"/></td>
	            <td class="columnTitle">箱数：</td>
	            <td class="tableContent"><input type="text" name="box_num" value="${box_num }"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value="${price }"/></td>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="order_no" value="${order_no }"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物描述：</td>
	            <td class="tableContent"><textarea name="product_desc" style="height:150px;">${product_desc }</textarea>
	            <td class="columnTitle">要求：</td>
	            <td class="tableContent"><textarea name="product_request" style="height:150px;">${product_request }</textarea>
	        </tr>		
		</table>
	</div>

</form>
</body>
</html>

