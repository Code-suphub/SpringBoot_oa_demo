package com.li.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.auth.service.SysRoleService;
import com.li.common.exception.MyException;
import com.li.common.result.Result;
import com.li.model.system.SysRole;
import com.li.vo.system.SysRoleQueryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

@Api(tags="角色管理的接口")//这个注解是没有任何效果的，只是标识一下
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

//    @GetMapping("/findAll")
//    public List<SysRole> findAll(){
//        List<SysRole> roleListlist = sysRoleService.list();
//        return roleListlist;
//    }

    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result findAll(){
        try{
            int i = 1/0;
        }catch (Exception e){
            throw new MyException(20001,"执行了自定义异常");
        }
        int i = 1/0;
        List<SysRole> roleListlist = sysRoleService.list();
        return Result.ok(roleListlist);
    }

    //条件分页查询
    // page当前页 limit 每页显示记录数
    // SysRoleQueryVo 条件的对象
    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo){
        // sysRoleQueryVo 通过post表单自动反射赋值对象
        // 创建 Page 对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page,limit);
        // 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(sysRoleQueryVo.getRoleName())){
            wrapper.like(SysRole::getRoleName,sysRoleQueryVo.getRoleName());
        }
        IPage<SysRole> pageModel =  sysRoleService.page(pageParam,wrapper);
        return Result.ok(pageModel);
    }
    //添加角色
    @ApiOperation("添加角色")
    @PostMapping("/save")
    public Result save(@RequestBody SysRole role){
        boolean success = sysRoleService.save(role);
        return success?Result.ok():Result.fail();
    }

    // 修改角色- 根据id查询
    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    // 修改角色-最终修改
    @ApiOperation("修改角色")
    @PutMapping("/update")
    public Result update(@RequestBody SysRole role){
        boolean success = sysRoleService.updateById(role);
        return success?Result.ok():Result.fail();
    }

    // 根据id删除
    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        boolean success = sysRoleService.removeById(id);
        return success?Result.ok():Result.fail();
    }

    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        boolean success = sysRoleService.removeByIds(idList);
        return success?Result.ok():Result.fail();
    }
}
