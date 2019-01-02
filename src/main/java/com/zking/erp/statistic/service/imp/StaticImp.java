package com.zking.erp.statistic.service.imp;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.statistic.mapper.StaticMapper;
import com.zking.erp.statistic.service.IStaticService;
import com.zking.erp.statistic.vo.StaticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaticImp implements IStaticService {
    @Autowired
    private StaticMapper staticMapper;
    @Override
    public List<Map<String,Object>> salesStatPager(StaticVo staticVo, PageBean pagebean) {
        return staticMapper.salesStatPager(staticVo);
    }

    @Override
    public List<Map<String,Object>> salesStatMonthPager(StaticVo staticVo, PageBean pagebean) {
        return staticMapper.salesStatMonthPager(staticVo);
    }
}
