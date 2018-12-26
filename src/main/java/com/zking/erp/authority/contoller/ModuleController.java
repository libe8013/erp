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
            if(map.get("VALUE").equals("-1") && maps.size()==0){
                lmap.add(map);
            }
        }

        List<Map<String,Object>> node = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : lmap) {
            getNode(stringObjectMap,list,true);
        }

        return lmap;
    }

    public Map<String,Object> getNode(Map<String,Object> map,List<Map<String,Object>> list,boolean b){
        List<Map<String,Object>> maps = new ArrayList<>();
        for (Map<String, Object> m : list) {
            if(map.get("id").equals(m.get("VALUE")) && b){
                Map<String, Object> node = getNode(m, list, b);
                maps.add(node);
            }
        }

        if(maps.size()==0){
            b = false;
        }else{
            map.put("data",maps);
        }

        return map;
    }

}
