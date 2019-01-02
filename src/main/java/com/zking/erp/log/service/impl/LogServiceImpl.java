package com.zking.erp.log.service.impl;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.log.mapper.LogMapper;
import com.zking.erp.log.model.Log;
import com.zking.erp.log.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public int insert(Log record) {
        return logMapper.insert(record);
    }

    @Override
    public int insertSelective(Log record) {
        return 0;
    }

    @Override
    public List<Log> queryLogPage(Log log, PageBean pageBean) {
        return logMapper.queryLogPage(log);
    }
}
