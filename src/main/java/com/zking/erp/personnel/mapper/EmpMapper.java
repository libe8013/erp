package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.vo.EmpVo;
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

    List<Map<String,Object>> queryEmpPage(EmpVo empVo);
}