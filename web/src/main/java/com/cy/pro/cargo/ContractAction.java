package com.cy.pro.cargo;

import com.cy.pro.BaseAction;
import com.cy.pro.domain.Contract;
import com.cy.pro.domain.User;
import com.cy.pro.service.ContractService;
import com.cy.pro.utils.Page;
import com.cy.pro.utils.SysConstant;
import com.opensymphony.xwork2.ModelDriven;

public class ContractAction extends BaseAction implements ModelDriven<Contract> {



    private Contract model = new Contract();

    public void setPage(Page<Contract> page) {
        this.page = page;
    }

    private Page<Contract> page = new Page<>();

    @Override
    public Contract getModel() {
        return model;
    }

    private ContractService contractService;

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    //查看
    public String toview() {
        Contract contract = contractService.get(Contract.class, model.getId());
        pushVs(contract);
        return "contract_toview";
    }

    //获取购销合同的列表
    public String list() {
        String hql = "from Contract where 1=1 ";
        int degree = 0;
        if (getUser().getUserInfo() != null) {
            degree = getUser().getUserInfo().getDegree();
        }
        if (degree == 4) {//普通员工
            hql += " and create_by='" + getUser().getId() + "'";
        } else if (degree == 3) {//部门经理,管理本部门
            hql += " and create_dept='" + getUser().getDept().getId() + "'";
        } else if (degree == 2) {//产品经理，管理本部门以及下属部门

        } else if (degree == 1) {//总经理

        } else {//老板

        }
        contractService.findPage(hql, page, Contract.class, null);
        page.setUrl("contractAction_list");
        pushVs(page);
        return "contract_list_succeed";
    }

    public String tocreate() {
        return "contract_tocreate";
    }

    //新增购销合同
    public String insert() {
        //添加创建者
        model.setCreate_by(getUser().getId());
        model.setCreate_dept(getUser().getDept().getId());
        contractService.saveOrUpdate(model);
        return "change_succeed_to_list";
    }

    //修改合同
    public String toupdate() {
        Contract contract = contractService.get(Contract.class, model.getId());
        pushVs(contract);
        return "contract_toupdate";
    }

    //保存修改的合同
    public String update() {
        Contract contract = contractService.get(Contract.class, model.getId());
        contract.setCustom_name(model.getCustom_name());
        contract.setPrint_style(model.getPrint_style());
        contract.setContract_no(model.getContract_no());
        contract.setOfferor(model.getOfferor());
        contract.setInput_by(model.getInput_by());
        contract.setCheck_by(model.getCheck_by());
        contract.setInspector(model.getInspector());
        contract.setSigning_date(model.getSigning_date());
        contract.setImport_num(model.getImport_num());
        contract.setShip_time(model.getShip_time());
        contract.setTrade_terms(model.getTrade_terms());
        contract.setDelivery_period(model.getDelivery_period());
        contract.setCrequest(model.getCrequest());
        contract.setRemark(model.getRemark());
        contractService.saveOrUpdate(contract);
        return "change_succeed_to_list";
    }

    public String delete() {
        String is[] = model.getId().split(", ");
        //调用业务方法，实现批量删除
        contractService.delete(Contract.class, is);
        return "change_succeed_to_list";
    }

    public String submit() {
        String[] ids = model.getId().split(",");
        contractService.changeState(ids, 1);
        return "change_succeed_to_list";
    }

    public String cancel() {
        String[] ids = model.getId().split(",");
        contractService.changeState(ids, 0);
        return "change_succeed_to_list";
    }
}
