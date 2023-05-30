package com.li.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.auth.mapper.SysRoleMapper;
import com.li.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleMapper mapper;

    @Test
    public void getAll(){
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }

    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员1");
        sysRole.setRoleCode("role1");
        sysRole.setDescription("角色管理员1");

        int rows = mapper.insert(sysRole);
        System.out.println(sysRole);
        System.out.println(sysRole.getId());
        System.out.println(rows);
    }

    @Test
    public void update(){
        SysRole sysRole = mapper.selectById(10);
        System.out.println(sysRole);
        sysRole.setRoleName("角色管理员_new");

        int rows = mapper.updateById(sysRole);
        System.out.println(rows);
        sysRole = mapper.selectById(10);
        System.out.println(sysRole);
    }


    @Test
    public void delete(){
        mapper.deleteById(10);
    }

    @Test
    public void deleteBatchIds(){
        int i = mapper.deleteBatchIds(Arrays.asList(8, 9));
        System.out.println(i);
    }

    @Test
    public void Query1(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","系统管理员");
        List<SysRole> ls = mapper.selectList(wrapper);
        System.out.println(ls);
    }

    @Test
    public void Query2(){
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"系统管理员");
        List<SysRole> ls = mapper.selectList(wrapper);
        System.out.println(ls);
    }
}
