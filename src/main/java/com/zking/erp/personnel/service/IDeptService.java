package com.zking.erp.personnel.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.model.Dept;

import java.util.List;

public interface IDeptService {
    /**
     *
     * @param dept
     * @return
     */
    List<Dept> queryDeptListPager(Dept dept,PageBean pageBean);
    /**
     * 新增部门
     * @param record
     * @return
     */
    int insert(Dept record);
    /**
     * 根据部门编号修改部门信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dept record);
    /**
     * 根据部门编号删除部门信息
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(String uuid);
}
