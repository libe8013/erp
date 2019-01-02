package com.zking.erp.statistic.mapper;

import com.zking.erp.statistic.vo.StaticVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StaticMapper {
    /**
     * 销售统计
     * @param staticVo
     * @return
     */
    List<Map<String,Object>> salesStatPager(StaticVo staticVo);

    /**
     * 按年份统计各月份的销售额
     * @param staticVo
     * @return
     */
    List<Map<String,Object>> salesStatMonthPager(StaticVo staticVo);
}
