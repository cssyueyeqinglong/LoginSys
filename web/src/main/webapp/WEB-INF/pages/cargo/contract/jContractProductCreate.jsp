<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
        //动态设置生产厂家的名称
        function setFactoryName(val) {
            document.getElementById("factoryName").value = val;
        }
    </script>
</head>

<body>
<form name="icform" method="post">
    <input type="hidden" name="contract.id" value="${contract.id}"/>

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="save"><a href="#"
                                         onclick="formSubmit('contractProductAction_insert','_self');this.blur();">保存</a>
                        </li>
                        <li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox-title">
        <img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
        新增货物
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

                    <input type="hidden" id="factoryName" name="factory_name" value=""/>
                </td>
                <td class="columnTitle">货号：</td>
                <td class="tableContentAuto"><input type="text" name="product_no" value=""/></td>
            </tr>
            <tr>
                <td class="columnTitle">货物照片：</td>
                <td class="tableContent"><input type="text" name="product_image" value=""/></td>
            </tr>
            <tr>
                <td class="columnTitle">数量：</td>
                <td class="tableContent"><input type="text" name="cnumber" value=""/></td>
                <td class="columnTitle">包装单位：</td>
                <td class="tableContentAuto">
                    <input type="radio" name="packing_unit" value="PCS" class="input">只
                    <input type="radio" name="packing_unit" value="SETS" class="input">套
                </td>
            </tr>
            <tr>
                <td class="columnTitle">装率：</td>
                <td class="tableContent"><input type="text" name="loading_rate" value=""/></td>
                <td class="columnTitle">箱数：</td>
                <td class="tableContent"><input type="text" name="box_num" value=""/></td>
            </tr>
            <tr>
                <td class="columnTitle">单价：</td>
                <td class="tableContent"><input type="text" name="price" value=""/></td>
                <td class="columnTitle">排序号：</td>
                <td class="tableContent"><input type="text" name="order_no" value=""/></td>
            </tr>
            <tr>
                <td class="columnTitle">货物描述：</td>
                <td class="tableContent"><textarea name="product_desc" style="height:150px;"></textarea>
                <td class="columnTitle">要求：</td>
                <td class="tableContent"><textarea name="product_request" style="height:150px;"></textarea>
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
            <tr>
                <td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
                <td class="tableHeader">序号</td>
                <td class="tableHeader">厂家</td>
                <td class="tableHeader">货号</td>
                <td class="tableHeader">装率</td>
                <td class="tableHeader">箱数</td>
                <td class="tableHeader">包装单位</td>
                <td class="tableHeader">数量</td>
                <td class="tableHeader">单价</td>
                <td class="tableHeader">总金额</td>
                <td class="tableHeader">操作</td>
            </tr>
            </thead>
            <tbody class="tableBody">
            ${links }
            <c:forEach items="${results}" var="o" varStatus="status">
                <tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" align="left">
                    <td><input type="checkbox" name="id" value="${o.id}"/></td>
                    <td>${status.index+1}</td>
                    <td>${o.factory_name}</td>
                    <td>${o.product_no}</td>
                    <td>${o.loading_rate}</td>
                    <td>${o.box_num}</td>
                    <td>${o.packing_unit}</td>
                    <td>${o.cnumber}</td>
                    <td>${o.price}</td>
                    <td>${o.amount}</td>
                    <td>
                        <a href="contractProductAction_toupdate.action?id=${o.id}">[修改]</a>
                        <a href="contractProductAction_delete.action?id=${o.id}&contract.id=${o.contract.id}">[删除]</a>
                        <a href="extCproductAction_tocreate.action?cp.contract.id=${o.contract.id}&cp.id=${o.id}">[附件]</a>
                    </td>
                </tr>

                <c:forEach items="${o.extCproducts}" var="ext" varStatus="status">
                    <tr height="40" class="odd" onmouseover="this.className='highlight'"
                        onmouseout="this.className='odd'" align="left">
                        <td>&nbsp;</td>
                        <td align="right"><font color="blue">附件：${status.index+1}&nbsp;</font></td>
                        <td>${ext.factory_name}</td>
                        <td>${ext.product_no}</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>${ext.packing_unit}</td>
                        <td>${ext.cnumber}</td>
                        <td>${ext.price}</td>
                        <td>${ext.amount}</td>
                    </tr>
                </c:forEach>

            </c:forEach>

            </tbody>
        </table>
    </div>

</form>
</body>
</html>

