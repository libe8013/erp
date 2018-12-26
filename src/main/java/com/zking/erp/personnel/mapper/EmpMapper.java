package com.zking.erp.personnel.mapper;

import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmpMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

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