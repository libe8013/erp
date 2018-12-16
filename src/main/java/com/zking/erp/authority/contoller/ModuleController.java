package com.zking.erp.authority.contoller;

import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/authority")
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @RequestMapping("/queryModuleLike")
    @ResponseBody
    public List<Module> queryModuleLike(Module module){

        List<Module> lst = moduleService.queryModuleLike(module);

        return lst;
    }

}
