package com.zking.erp.statistic.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.statistic.vo.StaticVo;

import java.util.List;
import java.util.Map;

public interface IStaticService {
    /**
     * 销售统计
     * @param staticVo
     * @return
     */
    List<Map<String,Object>> salesStatPager(StaticVo staticVo, PageBean pagebean);
    /**
     * 按年份统计各月份的销售额
     * @param staticVo
     * @return
     */
    List<Map<String,Object>> salesStatMonthPager(StaticVo staticVo,PageBean pagebean);
}
