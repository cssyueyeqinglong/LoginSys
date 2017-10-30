package com.cy.pro.cargo;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.Contract;
import com.cy.pro.domain.ContractProduct;
import com.cy.pro.domain.Factory;
import com.cy.pro.service.ContractProductService;
import com.cy.pro.service.ContractService;
import com.cy.pro.service.FactoryService;
import com.cy.pro.utils.Page;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class ContractProductAction extends BaseAction implements ModelDriven<ContractProduct> {

    private ContractProduct model = new ContractProduct();

    public Page<ContractProduct> getPage() {
        return page;
    }

    public void setPage(Page<ContractProduct> page) {
        this.page = page;
    }

    private Page<ContractProduct> page = new Page<>();

    @Override
    public ContractProduct getModel() {
        return model;
    }

    private ContractProductService contractService;
    private FactoryService factoryService;

    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void setContractService(ContractProductService contractService) {
        this.contractService = contractService;
    }

    //进入货物页面时
    public String tocreate() {
        List<Factory> factories = factoryService.find("from Factory", Factory.class, null);
        setVs("factoryList", factories);
        contractService.findPage("from ContractProduct where contract.id=?", page, ContractProduct.class,
                new String[]{model.getContract().getId()});
        page.setUrl("contractProductAction_tocreate");
        pushVs(page);
        return "contract_tocreate";
    }

    //新增购销合同
    public String insert() {
        contractService.saveOrUpdate(model);
        return tocreate();
    }

    //修改合同
    public String toupdate() {
        ContractProduct contract = contractService.get(ContractProduct.class, model.getId());
        pushVs(contract);
        List<Factory> factories = factoryService.find("from Factory", Factory.class, null);
        setVs("factoryList", factories);
        return "contract_toupdate";
    }

    public String delete() {
        contractService.delete(ContractProduct.class, model);
        return tocreate();
    }

    //保存修改的合同
    public String update() {
        ContractProduct contract = contractService.get(ContractProduct.class, model.getId());
        contract.setFactory_name(model.getFactory_name());
//        contract.setFactory_id(model.getFactory_id());
        contract.setProduct_no(model.getProduct_no());
        contract.setProduct_image(model.getProduct_image());
        contract.setCnumber(model.getCnumber());
        contract.setPacking_unit(model.getPacking_unit());
        contract.setLoading_rate(model.getLoading_rate());
        contract.setBox_num(model.getBox_num());
        contract.setPrice(model.getPrice());
        contract.setOrder_no(model.getOrder_no());
        contract.setProduct_desc(model.getProduct_desc());
        contract.setProduct_request(model.getProduct_request());
        contractService.saveOrUpdate(contract);
        return tocreate();
    }


}
