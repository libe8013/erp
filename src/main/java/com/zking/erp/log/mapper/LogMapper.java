package com.zking.erp.log.mapper;

import com.zking.erp.log.model.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {
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
    List<Log> queryLogPage(Log log);
}