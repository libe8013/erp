package com.zking.erp.personnel.service;


import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.vo.EmpVo;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface IEmpService {


    /**
     * 分页查询所有员工信息
     * @param empVo
     * @return
     */
    List<Map<String,Object>> queryEmpListPager(EmpVo empVo, PageBean pageBean);

    /**
     * 查询所有部门名称
     * @param dept
     * @return
     */
    List<Dept> queryDeptList(Dept dept);


    /**
     * 新增员工
     * @param record
     * @return
     */
    int insert(Emp record);
    /**
     * 根据员工编号修改员工信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Emp record);
    /**
     * 根据员工编号删除员工信息
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(String uuid);


    Emp selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(EmpVo empVo);

    List<Map<String,Object>> queryEmpPage(EmpVo empVo);

    List<Map<String,Object>> queryEmpStoreRole(Role role);

    /**
     * 修改密码
     * @param emp
     * @return
     */
    int updatePwd(Emp emp);

    List<Emp> Login(Emp emp);

}