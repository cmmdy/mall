package com.zwt.mall.controller;

import com.zwt.mall.service.UmsPermissionService;
import com.zwt.mall.common.api.CommonResult;
import com.zwt.mall.entity.UmsPermission;
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
 * 后台用户权限表(UmsPermission)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:19
 */
@Api(tags = "后台用户权限表(UmsPermission)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("umsPermission")
public class UmsPermissionController {
    @Autowired
    private UmsPermissionService umsPermissionService;

    @ApiOperation("UmsPermission表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<UmsPermission>> getBrandList() {
        return CommonResult.success(umsPermissionService.list());
    }

    @ApiOperation("UmsPermission表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody UmsPermission umsPermission) {
        CommonResult commonResult;
        boolean success = umsPermissionService.save(umsPermission);
        if (success) {
            commonResult = CommonResult.success(umsPermission);
            log.debug("createBrand success:{}", umsPermission);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", umsPermission);
        }
        return commonResult;
    }

    @ApiOperation("UmsPermission表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody UmsPermission umsPermission) {
        CommonResult commonResult;
        boolean success = umsPermissionService.updateById(umsPermission);
        if (success) {
            commonResult = CommonResult.success(umsPermission);
            log.debug("updateBrand success:{}", umsPermission);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", umsPermission);
        }
        return commonResult;
    }


    @ApiOperation("UmsPermission表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = umsPermissionService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("UmsPermission表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsPermission>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<UmsPermission> page = new Page(pageNum, pageSize);
        List<UmsPermission> brandList = umsPermissionService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("UmsPermission表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<UmsPermission> brand(@PathVariable("id") Long id) {
        return CommonResult.success(umsPermissionService.getById(id));
    }
}
