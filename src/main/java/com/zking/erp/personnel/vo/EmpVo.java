package com.zking.erp.personnel.vo;

import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.model.RoleModule;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.model.Emp;

public class EmpVo extends Emp {

    private Role role;

    private EmpRole empRole;

    private Module module;

    private RoleModule roleModule;

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public RoleModule getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(RoleModule roleModule) {
        this.roleModule = roleModule;
    }

    private Dept empdept;

    private String deptuuid;
    private String deptname;

    private String endtime;

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Dept getEmpdept() {
        return empdept;
    }

    public void setEmpdept(Dept empdept) {
        this.empdept = empdept;
    }

    public String getDeptuuid() {
        return deptuuid;
    }

    public void setDeptuuid(String deptuuid) {
        this.deptuuid = deptuuid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
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
