package com.zking.erp.log.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.log.model.Log;

import java.util.List;

public interface ILogService {
    /**
     * 新增日志信息
     * @param record
     * @return
     */
    int insert(Log record);

    int insertSelective(Log record);

    /**
     * 查询日志
     * @param log
     * @return
     */
    List<Log> queryLogPage(Log log, PageBean pageBean);
}