<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
    
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('${ctx}/cargo/contractAction_toview','_self');this.blur();">查看</a></li>
<li id="print"><a href="#" onclick="formSubmit('${ctx}/cargo/exportAction_print','_self');this.blur();">打印</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx}/cargo/exportAction_tocreate','_self');this.blur();">报运</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
	购销合同列表
  </div> 


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">客户名称</td>
		<td class="tableHeader">合同号</td>
		<td class="tableHeader">货物数/附件数</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">审单人</td>
		<td class="tableHeader">验货员</td>
		<td class="tableHeader">签单日期</td>
		<td class="tableHeader">交货期限</td>
		<td class="tableHeader">船期</td>
		<td class="tableHeader">贸易条款</td>
		<td class="tableHeader">总金额</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	${links }
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.custom_name}</td>
		<td>
			<a href="contractAction_toview?id=${o.id}">${o.contract_no}</a>
		</td>
		<td align="center">
			${o.cps.size()}
			/
			<c:set var="extNumber" value="0"></c:set><!-- 设置一个变量，用来累加，初始值0 -->
			<c:forEach items="${o.cps}" var="cp">
				<c:set var="extNumber" value="${ext_number + cp.extCproducts.size()}"/>
			</c:forEach>
			${ext_number}
		</td>
		<td>${o.input_by}</td>
		<td>${o.check_by}</td>
		<td>${o.inspector}</td>
		<td><fmt:formatDate value="${o.signing_date}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.delivery_period}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.ship_time}" pattern="yyyy-MM-dd"/></td>
		<td>${o.trade_terms}</td>
		<td>${o.total_amount}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>


</div>
 
 
</form>
</body>
</html>

