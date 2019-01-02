package com.zking.erp.authority.Interceptor;

import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.service.IModuleService;
import com.zking.erp.log.model.Log;
import com.zking.erp.log.service.ILogService;
import com.zking.erp.personnel.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomInterceptor implements HandlerInterceptor {

    @Autowired
    private IModuleService  ModuleService;
    @Autowired
    private ILogService logService;

    List<String>  passurl=new ArrayList<>();
    /**
     * 该方法会在控制器方法前执行，其返回值表示是否中断后续操作。当其返回值为true时，表示继续向下执行；
     当其返回值为false时，会中断后续的所有操作（包括调用下一个拦截器和控制器类中的方法执行等）
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)throws Exception {

        List<Module> list = ModuleService.queryModuleUrl("99");
        for (Module module : list) {
            passurl.add(module.getUrl());
        }


        String requestURI = request.getRequestURI();//获取方法的请求全路径
        int start = requestURI.lastIndexOf("/");//获取方法请求全路径的最后一个"/"
        String url = requestURI.substring(start+1);   //截取获取截取后的路径名
        String[] split = requestURI.split("/");

        System.out.println("1:"+url);


        Emp emp = (Emp) request.getSession().getAttribute("emp");

        if (url.lastIndexOf(".jsp")>-1||url.lastIndexOf(".png")>-1||url.lastIndexOf(".jpg")>-1||
                url.lastIndexOf(".js")>-1||url.lastIndexOf(".css")>-1||url.lastIndexOf(".gif")>-1){
            return true;
        }else{
            if(passurl.contains(url)){
                return true;
            }else {
                    if(request.getSession().getAttribute("emp")==null){

                    }else {
                    Emp emp1 = (Emp) request.getSession().getAttribute("emp");
                    System.out.println(emp1.getModules());
                     if(query(emp1,url)){

                         return true;
                     }else {
                         Map<String,Object> map = new HashMap<String, Object>();
                         map.put("message","无权限，请联系管理员");
                     }

                }

            }

        }

        return true;
    }



    /**
     * 该方法会在控制器方法调用之后，且解析视图之前执行。可以通过此方法对请求域中的模型和视图做出进一步的修改。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("我进来了二");
    }

    /**
     * 该方法会在整个请求完成，即视图渲染结束之后执行。可以通过此方法实现一些资源清理、记录日志信息等工作。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        HttpSession session = request.getSession();
        System.out.println("我进来了三");
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        String className = handlerMethod.getBean().getClass().toString();//类

        String methodName = handlerMethod.getMethod().getName();//方法名称

        String contextPath = request.getContextPath();

        String requestURI = request.getRequestURI();//获取全路径
        String[] split = requestURI.split("/erp");



//        requestURI.substring("");

        Map<String,String[]> pramMap = request.getParameterMap();//获取请求参数

        List<Module> list = ModuleService.queryModuleUrl(requestURI);
        for (Module module : list) {
            if (module.getPid().equals("99")){

            }
        }


        String ip = request.getRemoteAddr();

        Emp emp = (Emp) session.getAttribute("emp");

        String content =  className+"."+methodName+":"+pramMap;
        for (Module module : list) {
            if (null!=module){
                Log l = new Log(emp.getUuid(),ip,module.getId(),content);
                logService.insert(l);
            }
        }
    }


    public boolean query(Emp emp,String url) {

        if (emp.getUsername().equals("admin")){
            return true;
        }

        boolean b = false;
        for (String s : passurl) {
            if(s.equals(url)){
                b=true;
                break;
            }

        }

        List<Module> modules = emp.getModules();

        for (Module module : modules) {
            if(module.getUrl().equals(url)){
                    b=true;
            }
        }

        return   b;

    }
}
