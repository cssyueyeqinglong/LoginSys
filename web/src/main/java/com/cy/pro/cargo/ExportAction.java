package com.cy.pro.cargo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cy.pro.BaseAction;
import com.cy.pro.domain.Contract;
import com.cy.pro.domain.Export;
import com.cy.pro.domain.ExportProduct;
import com.cy.pro.service.ContractService;
import com.cy.pro.service.ExportProductService;
import com.cy.pro.service.ExportService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.UtilFuns;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExportAction extends BaseAction implements ModelDriven<Export> {

    private Export model = new Export();

    public void setPage(Page page) {
        this.page = page;
    }

    private Page page = new Page();

    //属性注入，获取jsp中的参数
    private String[] mr_id;
    private String[] mr_changed;
    private Integer[] mr_cnumber;
    private Double[] mr_gross_weight;
    private Double[] mr_net_weight;
    private Double[] mr_size_length;
    private Double[] mr_size_width;
    private Double[] mr_size_height;
    private Double[] mr_ex_price;
    private Double[] mr_tax;

    public void setMr_changed(String[] mr_changed) {
        this.mr_changed = mr_changed;
    }

    public void setMr_id(String[] mr_id) {
        this.mr_id = mr_id;
    }

    public void setMr_cnumber(Integer[] mr_cnumber) {
        this.mr_cnumber = mr_cnumber;
    }

    public void setMr_gross_weight(Double[] mr_gross_weight) {
        this.mr_gross_weight = mr_gross_weight;
    }

    public void setMr_net_weight(Double[] mr_net_weight) {
        this.mr_net_weight = mr_net_weight;
    }

    public void setMr_size_length(Double[] mr_size_length) {
        this.mr_size_length = mr_size_length;
    }

    public void setMr_size_width(Double[] mr_size_width) {
        this.mr_size_width = mr_size_width;
    }

    public void setMr_size_height(Double[] mr_size_height) {
        this.mr_size_height = mr_size_height;
    }

    public void setMr_ex_price(Double[] mr_ex_price) {
        this.mr_ex_price = mr_ex_price;
    }

    public void setMr_tax(Double[] mr_tax) {
        this.mr_tax = mr_tax;
    }

    @Override
    public Export getModel() {
        return model;
    }

    private ExportService exportService;
    private ContractService contractService;
    private ExportProductService epService;

    public void setEpService(ExportProductService epService) {
        this.epService = epService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    public void setExportService(ExportService contractService) {
        this.exportService = contractService;
    }

    //查看
    public String toview() {
        Export contract = exportService.get(Export.class, model.getId());
        pushVs(contract);
        return "contract_toview";
    }

    public String contractList() {
        contractService.findPage("from Contract where state<2", page, Contract.class, null);
        page.setUrl("exportAction_contractList");
        pushVs(page);
        return "contractList";
    }

    //获取购销合同的列表
    public String list() {
        exportService.findPage("from  Export", page, Export.class, null);
        pushVs(page);
        page.setUrl("exportAction_list");
        return "contract_list_succeed";
    }

    public String tocreate() {
        return "contract_tocreate";
    }

    //新增保运单
    public String insert() {
        //添加创建者
        model.setCreate_by(getUser().getId());
        model.setCreate_dept(getUser().getDept().getId());
        exportService.saveOrUpdate(model);
        return list();
    }

    //修改合同
    public String toupdate() {
        Export contract = exportService.get(Export.class, model.getId());
        pushVs(contract);
        Set<ExportProduct> epSet = contract.getEps();
        StringBuilder sb = new StringBuilder();
        //遍历集合
        for(ExportProduct ep :epSet){
            sb.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId());
            sb.append("\", \"").append(ep.getProduct_no());
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getCnumber()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getGross_weight()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getNet_weight()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getSize_length()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getSize_width()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getSize_height()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getEx_price()));
            sb.append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
        }

        //4.将接好的串放入值栈中
        setVs("mRecordData", sb.toString());
        return "contract_toupdate";
    }

    /*  private String[] mr_id;
    private String[] mr_order_no;
    private String[] mr_changed;
    private String[] mr_cnumber;
    private String[] mr_gross_weight;
    private String[] mr_net_weight;
    private String[] mr_size_length;
    private String[] mr_size_width;
    private String[] mr_size_height;
    private String[] mr_ex_price;
    private String[] mr_tax;*/
    //保存修改的合同
    public String update() {
        Export contract = exportService.get(Export.class, model.getId());
        contract.setCustomer_contract(model.getCustomer_contract());
        contract.setInput_date(model.getInput_date());
        contract.setLcno(model.getLcno());
        contract.setConsignee(model.getConsignee());
        contract.setShipment_port(model.getShipment_port());
        contract.setDestination_port(model.getDestination_port());
        contract.setTransport_mode(model.getTransport_mode());
        contract.setPrice_condition(model.getPrice_condition());
        contract.setMarks(model.getMarks());
        contract.setRemark(model.getRemark());
        Set<ExportProduct> eps=new HashSet<>(0);
        for (int i = 0; i < mr_id.length; i++) {
            ExportProduct ep = epService.get(ExportProduct.class, mr_id[i]);
            if("1".equals(mr_changed[i])){//数据有改变
                ep.setCnumber(mr_cnumber[i]);
                ep.setGross_weight(mr_gross_weight[i]);
                ep.setNet_weight(mr_net_weight[i]);
                ep.setSize_height(mr_size_height[i]);
                ep.setSize_length(mr_size_length[i]);
                ep.setSize_width(mr_size_width[i]);
                ep.setEx_price(mr_ex_price[i]);
                ep.setTax(mr_tax[i]);
            }
            eps.add(ep);
        }
        contract.setEps(eps);
        exportService.saveOrUpdate(contract);
        return list();
    }

    public String delete() {
        String ids[] = model.getId().split(", ");
        //调用业务方法，实现批量删除
        exportService.delete(Export.class, ids);
        return list();
    }

    public String submit() {
        String[] ids = model.getId().split(",");
        exportService.changeState(ids, 1);
        return list();
    }

    public String cancel() {
        String[] ids = model.getId().split(",");
        exportService.changeState(ids, 0);
        return list();
    }

    public String print() throws Exception{
        Contract contract = contractService.get(Contract.class, model.getId());
        ContractPrint cp=new ContractPrint();
        HttpServletResponse response= ServletActionContext.getResponse();
        String path= ServletActionContext.getServletContext().getRealPath("/");
        cp.print(contract,path,response);
        return NONE;
    }
}
