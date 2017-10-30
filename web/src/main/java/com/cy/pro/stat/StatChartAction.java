package com.cy.pro.stat;

import com.cy.pro.BaseAction;
import com.cy.pro.service.impl.SQLServiceImpl;
import com.cy.pro.utils.file.FileUtil;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class StatChartAction extends BaseAction {
    private SQLServiceImpl sqlService;

    public void setSqlService(SQLServiceImpl sqlService) {
        this.sqlService = sqlService;
    }

    /**
     * 获取各个工厂的销售额情况
     *
     * @return
     */
    public String factorysale() {
        try {
            String sql = "select factory_name,sum(amount) totalSal from contract_product_p  group by factory_name order by  totalSal desc";
            List<String> list = sqlService.executeSQL(sql);

           String file="stat\\chart\\factorysale\\data.xml";
           String content=getXmlString(list);
            createXML(file,content);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return "factorysale";
    }

    /**
     * 产品销量前15名
     * @return
     */
    public String productsale(){
        try {
            String sql = "select * from (select product_no,sum(amount) totalSal from contract_product_p  group by product_no order by  totalSal desc)" +
                    "where rownum<16";
            List<String> list = sqlService.executeSQL(sql);

            String file="stat\\chart\\productsale\\data.xml";
            String content=getXmlString(list);
            createXML(file,content);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return "productsale";
    }

    private void createXML(String file,String content) throws Exception{
        FileUtil fu=new FileUtil();
        String path= ServletActionContext.getServletContext().getRealPath("/");//获取项目根路径
        fu.createTxt(path,file,content,"utf-8");//将生成的字符串重新生成data.xml
    }

    /**
     * 生成饼状图的数据源
     * @param list
     * @return
     */
    private String getXmlString(List<String> list){
        StringBuffer sb=new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<pie>");
        for (int i = 0; i < list.size(); i++) {
            sb.append("<slice title=\""+list.get(i)+"\" pull_out=\"true\">"+list.get(++i)+"</slice>");
        }
        sb.append("</pie>");
        return sb.toString();
    }
}
