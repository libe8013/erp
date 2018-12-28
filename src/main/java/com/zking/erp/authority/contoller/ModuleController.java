package com.zking.erp.authority.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    /**
     * 绑定导航栏tree (查询pid,在找子节点)
     * @param module
     * @return
     */
    @RequestMapping("/queryModuleLike")
    @ResponseBody
    public List<Map<String,Object>> queryModuleLike(Module module){

        List<Module> lst = moduleService.queryModuleLike(module);

        List<Map<String,Object>> listPid = new ArrayList<>();

        for (Module m : lst) {
            if(m.getPid().equals("-1")){
                Map<String,Object> map = new HashMap<>();
                map.put("name",m.getText());
                map.put("id",m.getId());
                if(m.getUrl()!=null && !m.getUrl().equals("")){
                    map.put("href","javascript:initTab(&quot;"+m.getText()+"&quot;,&quot;"+m.getUrl()+"&quot;,&quot;"+m.getId()+"&quot;)");
                }
                listPid.add(map);
            }
        }

        for (Map<String, Object> stringObjectMap : listPid) {
            getModuleNode(stringObjectMap,lst,true);
        }

        return listPid;
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

    /**
     * 绑定到导航栏tree
     * @param map
     * @param list
     * @param b
     * @return
     */
    public Map<String,Object> getModuleNode(Map<String,Object> map,List<Module> list,boolean b){
        List<Map<String,Object>> maps = new ArrayList<>();
        for (Module m : list) {
            if(map.get("id").equals(m.getPid()) && b){
                Map<String,Object> map2 = new HashMap<>();
                map2.put("name",m.getText());
                map2.put("href","javascript:initTab(&quot;"+m.getText()+"&quot;,&quot;"+m.getUrl()+"&quot;,&quot;"+m.getId()+"&quot;)");
                maps.add(map2);
            }
        }

        if(maps.size()==0){
            b = false;
        }else{
            map.put("children",maps);
        }

        return map;
    }

}
