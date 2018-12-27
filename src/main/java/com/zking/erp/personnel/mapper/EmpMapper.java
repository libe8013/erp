package com.zking.erp.personnel.mapper;

import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.vo.EmpVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmpMapper {
    /**
     * 根据员工编号删除员工信息
     * @param uuid
     * @return
     */
    int deleteByPrimaryKey(String uuid);
    /**
     * 新增员工
     * @param record
     * @return
     */
    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Emp record);
    /**
     * 根据员工编号修改员工信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Emp record);
    /**
     * 分页查询所有员工信息
     * @param empVo
     * @return
     */
    List<Map<String,Object>> queryEmpListPager(EmpVo empVo);

    /**
     * 时间范围分页查询所有员工信息
     * @param empVo
     * @return
     */
    List<Map<String,Object>> queryEmp2ListPager(EmpVo empVo);
    /**
     * 查询所有部门名称
     * @param dept
     * @return
     */
    List<Dept> queryDeptList(Dept dept);

    List<Emp> queryEmpLikePager(Emp emp);

    List<Map<String,Object>> queryEmpStoreRole(Role role);

    /**
     * 修改密码
     * @param emp
     * @return
     */
    int updatePwd(Emp emp);

    List<Emp> Login(Emp emp);
}