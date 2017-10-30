<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<title></title>
	<script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript">
		//设置厂家名称隐藏域，这样无需再次查询数据库
		function setFactoryName( val ){
			document.getElementById("factoryName").value = val; 
		}
	</script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="cp.contract.id" value="${cp.contract.id}"/>
	<input type="hidden" name="cp.id" value="${cp.id}"/>
	
	<input type="hidden" name="amount" value="${amount }"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('extCproductAction_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改附件
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">生产厂家：</td>
	            <td class="tableContent">
	            	<s:select name="factory.id" list="factoryList" 
	            				listKey="id" listValue="factory_name"
	            				onchange="setFactoryName(this.options[this.selectedIndex].text);"
	            				headerKey="" headerValue="--请选择--"/>
	            	<input type="hidden" id="factoryName" name="factory_name" value=""/>
	            </td>
	            <td class="columnTitle">货号：</td>
	            <td class="tableContentAuto"><input type="text" name="product_no" value="${product_no}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物照片：</td>
	            <td class="tableContent"><input type="text" name="product_image" value="${product_image}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${cnumber}"/></td>
	            <td class="columnTitle">包装单位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="packing_unit" value="PCS" <c:if test="${packing_unit=='PCS'}">checked</c:if> class="input">只
	            	<input type="radio" name="packing_unit" value="SETS" <c:if test="${packing_unit=='SETS'}">checked</c:if> class="input">套
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value="${price}"/></td>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="order_no" value="${order_no}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物描述：</td>
	            <td class="tableContent"><textarea name="product_desc" style="height:150px;">${product_desc}</textarea>
	            <td class="columnTitle">要求：</td>
	            <td class="tableContent"><textarea name="product_request" style="height:150px;">${product_equest}</textarea>
	        </tr>		
		</table>
	</div>

 
</form>
</body>
</html>

