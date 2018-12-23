package com.zking.erp.authority.Vo;

import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.model.Emp;

public class EmpRoleVo extends EmpRole {
    private Emp emp;
    private Role role;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
