package com.zking.erp.base.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {

    /*
        @Around 增强处理 可控制方法什么时候执行甚至不执行等操作
        第一个*代表返回值(*前面可以加修饰符)
        第二个*代表所属包(全路径)
        ..*表示数所类名 ..*后面可以指定方法以结尾什么结尾 比如..*Service 那么只有以Service结尾的类才切入
        .*(..)表示任何方法名，括号表示参数，两个点表示任何参数类型 方法名想以什么结尾可以在.*后面加
        (..) 括号表示参数 两个点表示任何参数类型
     */
    @Around("execution(* * ..*Service .*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {

        Object[] params = args.getArgs();
        PageBean pageBean = null;
        for (Object param : params) {
            if(param instanceof PageBean){
                pageBean=(PageBean) param;
                break;
            }
        }
        //设置分页参数
        if(null!=pageBean && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        //执行方法，设置方法参数
        Object result = args.proceed(params);

        //将分页的总记录数设置到PageBean中
        if(null!=pageBean && pageBean.isPagination()){
            List lst = (List) result;
            PageInfo pageInfo = new PageInfo(lst);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        ;
        return result;
    }
}
