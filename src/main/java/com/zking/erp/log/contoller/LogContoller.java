package com.zking.erp.log.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.log.model.Log;
import com.zking.erp.log.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/log")
public class LogContoller {
    @Autowired
    private ILogService logService;


    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(Log log){

        String message="添加成功";

        log.setId((UUID.randomUUID().toString().replace("-","")));

        Map<String,Object> map = new HashMap<String, Object>();

        try {
            logService.insert(log);
        } catch (Exception e) {
            message="添加失败";
        }

        map.put("meg",message);
        return map;
    }


    @RequestMapping("/queryLogPage")
    @ResponseBody
    public Map<String,Object> queryLogPage(HttpServletRequest req,Log log){

        PageBean pageBean = new PageBean();
        log = new Log();
        List<Log> list = logService.queryLogPage(log, pageBean);
        pageBean.setRequest(req);

        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }

}
