package com.zking.erp.authority.Vo;

import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.model.RoleModule;

public class RoleModuleVo extends RoleModule{
    private Role role;

    private Module module;

    private String[] ids;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
