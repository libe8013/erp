package com.zking.erp.personnel.vo;

import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Emp;

public class EmpVo extends Emp {

    private Role role;

    private EmpRole empRole;

    private String context;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public EmpRole getEmpRole() {
        return empRole;
    }

    public void setEmpRole(EmpRole empRole) {
        this.empRole = empRole;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
