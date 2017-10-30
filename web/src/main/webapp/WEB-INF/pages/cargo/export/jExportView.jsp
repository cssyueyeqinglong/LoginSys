<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">
    <input type="hidden" name="id" value="${id}"/>

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox-title">
        <img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
        浏览出口报运
    </div>


    <div>
        <table class="commonTable" cellspacing="1">
            <tr>
                <td class="columnTitle">报运号：</td>
                <td class="tableContent">${customer_contract}</td>
                <td class="columnTitle">制单日期：</td>
                <td class="tableContent">${input_date}</td>
            </tr>
            <tr>
                <td class="columnTitle">信用证号</td>
                <td class="tableContent">${lcno}</td>
                <td class="columnTitle">收货人及地址：</td>
                <td class="tableContent">${consignee}</td>
            </tr>
            <tr>
                <td class="columnTitle">装运港：</td>
                <td class="tableContent">${shipment_port}</td>
                <td class="columnTitle">目的港：</td>
                <td class="tableContent">${destination_port}</td>
            </tr>
            <tr>
                <td class="columnTitle">运输方式：</td>
                <td class="tableContent">${transport_mode}</td>
                <td class="columnTitle">价格条件：</td>
                <td class="tableContent">${price_condition}</td>
            </tr>
            <tr>
                <td class="columnTitle">唛头：</td>
                <td class="tableContent">
                    <pre>${marks}</pre>
                </td>
                <td class="columnTitle">备注：</td>
                <td class="tableContent">
                    <pre>${remark}</pre>
                </td>
            </tr>


        </table>
    </div>


    <div class="textbox-title">
        <img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
        货物列表
    </div>


    <div class="eXtremeTable">
        <table id="ec_table" class="tableRegion" width="98%">
            <thead>
            <tr align="left">
                <td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
                <td class="tableHeader">序号</td>
                <td class="tableHeader">货号</td>
                <td class="tableHeader">数量</td>
            </tr>
            </thead>
            <tbody class="tableBody">
            ${links }
            <c:forEach items="${eps}" var="o" varStatus="status">
                <tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" align="left">
                    <td><input type="checkbox" name="id" value="${o.id}"/></td>
                    <td>${status.index+1}</td>
                    <td>${o.product_no}</td>
                    <td>${o.cnumber}</td>
                </tr>
                <c:forEach items="${o.extEproducts}" var="ext" varStatus="status">
                    <tr height="40" class="odd" onmouseover="this.className='highlight'"
                        onmouseout="this.className='odd'" align="left">
                        <td>&nbsp;</td>
                        <td align="right"><font color="blue">附件：${status.index+1}&nbsp;</font></td>
                        <td>${ext.product_no}</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>${ext.cnumber}</td>
                    </tr>
                </c:forEach>

            </c:forEach>

            </tbody>
        </table>
    </div>

</form>
</body>
</html>

