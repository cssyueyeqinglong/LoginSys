<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
        //设置厂家名称隐藏域，这样无需再次查询数据库
        function setFactoryName(val) {
            document.getElementById("factoryName").value = val;
        }
    </script>
</head>

<body>
<form name="icform" method="post">
    <input type="hidden" name="cp.contract.id" value="${cp.contract.id}"/>
    <input type="hidden" name="cp.id" value="${cp.id}"/>


    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="save"><a href="#" onclick="formSubmit('extCproductAction_insert','_self');this.blur();">保存</a>
                        </li>
                        <li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox-title">
        <img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
        新增附件
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


    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">
                    附件列表
                </div>
            </div>
        </div>

        <div>


            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
                        <td class="tableHeader">序号</td>
                        <td class="tableHeader">厂家</td>
                        <td class="tableHeader">货号</td>
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
                        <tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'"
                            align="left">
                            <td><input type="checkbox" name="id" value="${o.id}"/></td>
                            <td>${status.index+1}</td>
                            <td>${o.factory_name}</td>
                            <td>${o.product_no}</td>
                            <td>${o.packing_unit}</td>
                            <td>${o.cnumber}</td>
                            <td>${o.price}</td>
                            <td>${o.amount}</td>
                            <td>
                                <a href="extCproductAction_toupdate.action?id=${o.id}">[修改]</a>
                                <a href="extCproductAction_delete.action?id=${o.id}&cp.id=${o.cp.id}&cp.contract.id=${cp.contract.id}">[删除]</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>
