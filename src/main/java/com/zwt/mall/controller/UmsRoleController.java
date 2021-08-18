package com.zwt.mall.controller;

import com.zwt.mall.service.UmsRoleService;
import com.zwt.mall.common.api.CommonResult;
import com.zwt.mall.entity.UmsRole;
import com.zwt.mall.common.api.CommonPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;


/**
 * 后台用户角色表(UmsRole)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:20
 */
@Api(tags = "后台用户角色表(UmsRole)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("umsRole")
public class UmsRoleController {
    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("UmsRole表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<UmsRole>> getBrandList() {
        return CommonResult.success(umsRoleService.list());
    }

    @ApiOperation("UmsRole表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody UmsRole umsRole) {
        CommonResult commonResult;
        boolean success = umsRoleService.save(umsRole);
        if (success) {
            commonResult = CommonResult.success(umsRole);
            log.debug("createBrand success:{}", umsRole);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", umsRole);
        }
        return commonResult;
    }

    @ApiOperation("UmsRole表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody UmsRole umsRole) {
        CommonResult commonResult;
        boolean success = umsRoleService.updateById(umsRole);
        if (success) {
            commonResult = CommonResult.success(umsRole);
            log.debug("updateBrand success:{}", umsRole);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", umsRole);
        }
        return commonResult;
    }


    @ApiOperation("UmsRole表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = umsRoleService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("UmsRole表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsRole>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<UmsRole> page = new Page(pageNum, pageSize);
        List<UmsRole> brandList = umsRoleService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("UmsRole表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<UmsRole> brand(@PathVariable("id") Long id) {
        return CommonResult.success(umsRoleService.getById(id));
    }
}
