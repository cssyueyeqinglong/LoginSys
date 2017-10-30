package com.cy.pro.cargo;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.ContractProduct;
import com.cy.pro.domain.ExtCproduct;
import com.cy.pro.domain.Factory;
import com.cy.pro.service.ExtCproductService;
import com.cy.pro.service.FactoryService;
import com.cy.pro.utils.Page;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class ExtCproductAction extends BaseAction implements ModelDriven<ExtCproduct> {

    private ExtCproduct model = new ExtCproduct();
    private ExtCproductService extCproductService;
    private FactoryService factoryService;
    private Page<ExtCproduct> page = new Page<>();

    public void setPage(Page<ExtCproduct> page) {
        this.page = page;
    }

    public Page<ExtCproduct> getPage() {
        return page;
    }

    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void setExtCproductService(ExtCproductService extCproductService) {
        this.extCproductService = extCproductService;
    }

    @Override
    public ExtCproduct getModel() {
        return model;
    }

    public String tocreate() throws Exception {
        List<Factory> factories = factoryService.find("from Factory", Factory.class, null);
        setVs("factoryList", factories);
        extCproductService.findPage("from ExtCproduct where cp.id=?", page, ExtCproduct.class,
                new String[]{model.getCp().getId()});
        page.setUrl("extCproductAction_tocreate");
        pushVs(page);
        return "contract_tocreate";
    }

    //新增购销合同
    public String insert() throws Exception {
        try {
            extCproductService.saveOrUpdate(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tocreate();
    }


    public String toupdate() {
        List<Factory> factories = factoryService.find("from Factory", Factory.class, null);
        setVs("factoryList", factories);
        ExtCproduct cproduct = extCproductService.get(ExtCproduct.class, model.getId());
        pushVs(cproduct);
        return "contract_toupdate";
    }

    public String update() throws Exception{
        ExtCproduct contract = extCproductService.get(ExtCproduct.class, model.getId());
        contract.setFactory_name(model.getFactory_name());
//        contract.setFactory_id(model.getFactory_id());
        contract.setProduct_no(model.getProduct_no());
        contract.setProduct_image(model.getProduct_image());
        contract.setCnumber(model.getCnumber());
        contract.setPacking_unit(model.getPacking_unit());
        contract.setPrice(model.getPrice());
        contract.setOrder_no(model.getOrder_no());
        contract.setProduct_desc(model.getProduct_desc());
        contract.setProduct_request(model.getProduct_request());
        extCproductService.saveOrUpdate(contract);
        return tocreate();
    }

    public String delete() throws Exception {
        extCproductService.delete(ExtCproduct.class, model);
        return tocreate();
    }
}
