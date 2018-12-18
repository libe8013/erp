package com.zking.erp.market.vo;


import com.zking.erp.market.model.Orders;
import com.zking.erp.personnel.model.Emp;

public class OrderVo extends Orders {
    private Emp emp;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
