package com.zking.erp.personnel.service.imp;

import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.model.Role;
import com.zking.erp.base.util.BaseTestCase;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import com.zking.erp.personnel.vo.EmpVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

public class EmpServiceImplTest extends BaseTestCase {

    @Autowired
    private IEmpService empService;

    public void setUp() throws Exception{
        super.setUp();
    }

    @Test
    public void insert() {
        EmpVo empVo = new EmpVo();
        Date date = new Date(1999-11-22);
        System.out.println(date);
        Role role = new Role();

        role.setId("de1a1ea3006011e99bfda81e8416b6b4");

        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        empVo.setUuid(uuid);
        empVo.setUsername("nihao");
        empVo.setPwd("123456");
        empVo.setName("小张1");
        empVo.setGender(1);
        empVo.setEmail("2494210446@qq.com");
        empVo.setTele("1254678935455");
        empVo.setAddress("长沙");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        empVo.setBirthday(date);
        empVo.setDepuuid(1);
        empVo.setRole(role);
        empService.insert(empVo);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        EmpVo empVo = new EmpVo();//用户
        empVo.setUuid("8F256DE1C43A4DA68C8280AECF6B012D");
        Role role = new Role();
        role.setId("de1a1ea3006011e99bfda81e8426b6b3");

        empVo.setUsername("你好啊3");

        empVo.setRole(role);

        empService.updateByPrimaryKeySelective(empVo);
    }

    @Test
    public void deleteByPrimaryKey() {
        EmpVo empVo = new EmpVo();
        empVo.setUuid("FDF16585035946CFBCEF09977CE93558");
        EmpRole empRole = new EmpRole();
        empRole.setUserid("FDF16585035946CFBCEF09977CE93558");
        empVo.setEmpRole(empRole);
        empService.deleteByPrimaryKey(empVo);

    }

    @Test
    public void queryEmpPage() {
        EmpVo empVo = new EmpVo();

        empVo.setUsername("ni%");
        empVo.setRole(new Role());
        List<Map<String, Object>> maps = empService.queryEmpPage(empVo);

        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
}