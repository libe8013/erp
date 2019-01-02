package com.zking.erp.personnel.vo;

import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.model.ReturnOrders;

public class ReturnOrdersVo extends ReturnOrders {
    private Emp emp;
    private String supplieruuid;

    public String getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(String supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
