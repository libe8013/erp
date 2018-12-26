package com.zking.erp.authority.contoller;

import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * Xtree
     * @return
     */
    @RequestMapping("/queryModuleAll")
    @ResponseBody
    public List<Map<String,Object>> queryModuleAll(){
        Module module = new Module();

        List<Map<String, Object>> list = moduleService.queryModuleAll(module);

        List<Map<String,Object>> lmap = new ArrayList<>();

        for (int i=0;i<list.size();i++){
            List<Map<String,Object>> maps = new ArrayList<>();
            Map<String, Object> map = list.get(i);
            for (int j=0;j<list.size();j++){//遍历所有节点
                Map<String, Object> map2 = list.get(j);
                if(map.get("id").equals(map2.get("VALUE"))){//比较map与map2
                    maps.add(map2);
                }
            }
            if(maps.size()!=0){
                map.put("data",maps);
                lmap.add(map);
            }
        }

        return lmap;
    }
}
