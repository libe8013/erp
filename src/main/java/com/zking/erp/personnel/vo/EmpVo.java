package com.zking.erp.personnel.vo;

import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.model.Role;

public class EmpVo extends Emp {

    private Role role;

    private EmpRole empRole;

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
