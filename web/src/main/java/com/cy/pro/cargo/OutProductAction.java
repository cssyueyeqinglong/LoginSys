package com.cy.pro.cargo;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.ContractProduct;
import com.cy.pro.service.ContractProductService;
import com.cy.pro.utils.DownloadUtil;
import com.cy.pro.utils.UtilFuns;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class OutProductAction extends BaseAction {

    private String input_date;
    private ContractProductService cpService;

    public void setCpService(ContractProductService cpService) {
        this.cpService = cpService;
    }

    public void setInput_date(String input_date) {
        this.input_date = input_date;
    }

    public String toedit() {
        return "to_out_product";
    }

    public String print() throws Exception{
        Workbook wb = new HSSFWorkbook();//工作簿
        Sheet sheet = wb.createSheet();//工作表
        int cellNo = 1;
        int rowNo=1;
        sheet.setColumnWidth(cellNo++, 26);//设置列宽
        sheet.setColumnWidth(cellNo++, 11);//设置列宽
        sheet.setColumnWidth(cellNo++, 29);//设置列宽
        sheet.setColumnWidth(cellNo++, 12);//设置列宽
        sheet.setColumnWidth(cellNo++, 15);//设置列宽
        sheet.setColumnWidth(cellNo++, 10);//设置列宽
        sheet.setColumnWidth(cellNo++, 10);//设置列宽
        sheet.setColumnWidth(cellNo++, 8);//设置列宽
        cellNo=1;
//        创建行对象：
        Row nRow = sheet.createRow(1);//第2行
        nRow.setHeightInPoints(36);//行高
        Cell nCell = nRow.createCell(cellNo);//创建单元格对象
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8));
        //设置单元格内容
        nCell.setCellValue(input_date.replace("-0","年")+"月份出货表");
        List<ContractProduct> products = cpService.find("from ContractProduct where to_char(contract.ship_time,'yyyy-MM')=?",
                ContractProduct.class, new String[]{input_date});

        String titles[] = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        //创建小标题的行对象
        nRow = sheet.createRow(rowNo++);
        nRow.setHeightInPoints(26.25f);//设置行高

        //创建单元格对象，并设置内容 ，并设置样式
        for(String title :titles){
            nCell = nRow.createCell(cellNo++);//创建单元格对象
            nCell.setCellValue(title);//设置内容
            nCell.setCellStyle(this.title(wb));//设置样式
        }
        for(ContractProduct cp :products){
            nRow = sheet.createRow(rowNo++);//产生数据行
            nRow.setHeightInPoints(24);//设置行高

            cellNo=1;
            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(cp.getContract().getCustom_name());//客户名称
            nCell.setCellStyle(this.text(wb));//设置文本样式

            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(cp.getContract().getContract_no());//订单号--- 合同号
            nCell.setCellStyle(this.text(wb));//设置文本样式

            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(cp.getProduct_no());     //        货号
            nCell.setCellStyle(this.text(wb));//设置文本样式


            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(cp.getCnumber());//      数量
            nCell.setCellStyle(this.text(wb));//设置文本样式


            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(cp.getFactory_name());//工厂名
            nCell.setCellStyle(this.text(wb));//设置文本样式


            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDelivery_period()));//交期
            nCell.setCellStyle(this.text(wb));//设置文本样式


            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShip_time()));//船期
            nCell.setCellStyle(this.text(wb));//设置文本样式


            nCell = nRow.createCell(cellNo++);//产生单元格对象
            nCell.setCellValue(cp.getContract().getTrade_terms());//贸易条款
            nCell.setCellStyle(this.text(wb));//设置文本样式
            DownloadUtil downUtil = new DownloadUtil();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();//流  内存中的缓存区
            wb.write(baos);//将excel表格中的内容输出到缓存
            baos.close();//刷新缓存


            HttpServletResponse response = ServletActionContext.getResponse();//得到response对象

            downUtil.download(baos, response, "out.xls");//如果是中文，下载时可能会产生乱码，如何解决？
        }
        return NONE;
    }
    //小标题的样式
    public CellStyle title(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }
    //文字样式
    public CellStyle text(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)10);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }
}
