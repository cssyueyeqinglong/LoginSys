<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="save"><a href="#"
                                         onclick="formSubmit('contractAction_insert','_self');this.blur();">保存</a></li>
                        <li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">
                    新增购销合同
                </div>
            </div>
        </div>


        <div>
            <table class="commonTable" cellspacing="1">
                <tr>
                    <td class="columnTitle">客户名称：</td>
                    <td class="tableContent"><input type="text" name="custom_name" value=""/></td>
                    <td class="columnTitle">打印版式：</td>
                    <td class="tableContentAuto">
                        <input type="radio" name="print_style" value="2" checked class="input">两款
                        <input type="radio" name="print_style" value="1" class="input">一款
                    </td>
                </tr>
                <tr>
                    <td class="columnTitle">合同号：</td>
                    <td class="tableContent"><input type="text" name="contract_no" value=""/></td>
                    <td class="columnTitle">收购方：</td>
                    <td class="tableContent"><input type="text" name="offeror" value=""/></td>
                </tr>
                <tr>
                    <td class="columnTitle">制单人：</td>
                    <td class="tableContent"><input type="text" name="input_by" value=""/></td>
                    <td class="columnTitle">审单人：</td>
                    <td class="tableContent"><input type="text" name="check_by" value=""/></td>
                </tr>
                <tr>
                    <td class="columnTitle">验货员：</td>
                    <td class="tableContent"><input type="text" name="inspector" value=""/></td>
                    <td class="columnTitle">签单日期：</td>
                    <td class="tableContent">
                        <input type="text" style="width:90px;" name="signing_date"
                               value=""
                               onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                    </td>
                </tr>
                <tr>
                    <td class="columnTitle">重要程度：</td>
                    <td class="tableContentAuto">
                        <input type="radio" name="import_num" value="3" checked class="input">★★★
                        <input type="radio" name="import_num" value="2" class="input">★★
                        <input type="radio" name="import_num" value="1" class="input">★
                    </td>
                    <td class="columnTitle">船期：</td>
                    <td class="tableContent">
                        <input type="text" style="width:90px;" name="ship_time"
                               value=""
                               onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                    </td>
                </tr>
                <tr>
                    <td class="columnTitle">贸易条款：</td>
                    <td class="tableContent"><input type="text" name="trade_terms" value=""/></td>
                    <td class="columnTitle">交货期限：</td>
                    <td class="tableContent">
                        <input type="text" style="width:90px;" name="delivery_period"
                               value=""
                               onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                    </td>
                </tr>
                <tr>
                    <td class="columnTitle">要求：</td>
                    <td class="tableContent"><textarea name="crequest" style="height:150px;"></textarea>
                    <td class="columnTitle">说明：</td>
                    <td class="tableContent"><textarea name="remark" style="height:150px;"></textarea>
                </tr>
            </table>
        </div>

    </div>
</form>
</body>
</html>

