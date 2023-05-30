package com.li.auth;

import com.li.auth.service.SysRoleService;
import com.li.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMpDemo2 {
    @Autowired
    private SysRoleService service;

    @Test
    public void select(){
        List<SysRole> list = service.list();
        System.out.println(list);
    }
}
