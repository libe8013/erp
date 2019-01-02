package com.zking.erp.personnel.service.Impl;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.mapper.DeptMapper;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptImp  implements  IDeptService{
@Autowired
private DeptMapper deptMapper;
    @Override
    public List<Dept> queryDeptListPager(Dept dept, PageBean pageBean) {
        return deptMapper.queryDeptListPager(dept);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return deptMapper.deleteByPrimaryKey(uuid);
    }
}
