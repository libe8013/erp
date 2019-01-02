package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeptMapper {




    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String uuid);



    int updateByPrimaryKey(Dept record);

    /**
     * 新增部门
     * @param record
     * @return
     */
    int insert(Dept record);

    /**
     *查询所有部门信息
     * @param dept
     * @return
     */
    List<Dept> queryDeptListPager(Dept dept);

    /**
     * 根据部门编号修改部门信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * 根据部门编号部门信息
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(String uuid);


}