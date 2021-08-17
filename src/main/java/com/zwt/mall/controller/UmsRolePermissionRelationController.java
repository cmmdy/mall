package com.zwt.mall.controller;

import com.zwt.mall.service.UmsRolePermissionRelationService;
import com.zwt.mall.common.CommonResult;
import com.zwt.mall.entity.UmsRolePermissionRelation;
import com.zwt.mall.common.CommonPage;
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
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:21
 */
@Api(tags = "后台用户角色和权限关系表(UmsRolePermissionRelation)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("umsRolePermissionRelation")
public class UmsRolePermissionRelationController {
    @Autowired
    private UmsRolePermissionRelationService umsRolePermissionRelationService;

    @ApiOperation("UmsRolePermissionRelation表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<UmsRolePermissionRelation>> getBrandList() {
        return CommonResult.success(umsRolePermissionRelationService.list());
    }

    @ApiOperation("UmsRolePermissionRelation表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody UmsRolePermissionRelation umsRolePermissionRelation) {
        CommonResult commonResult;
        boolean success = umsRolePermissionRelationService.save(umsRolePermissionRelation);
        if (success) {
            commonResult = CommonResult.success(umsRolePermissionRelation);
            log.debug("createBrand success:{}", umsRolePermissionRelation);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", umsRolePermissionRelation);
        }
        return commonResult;
    }

    @ApiOperation("UmsRolePermissionRelation表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody UmsRolePermissionRelation umsRolePermissionRelation) {
        CommonResult commonResult;
        boolean success = umsRolePermissionRelationService.updateById(umsRolePermissionRelation);
        if (success) {
            commonResult = CommonResult.success(umsRolePermissionRelation);
            log.debug("updateBrand success:{}", umsRolePermissionRelation);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", umsRolePermissionRelation);
        }
        return commonResult;
    }


    @ApiOperation("UmsRolePermissionRelation表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = umsRolePermissionRelationService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("UmsRolePermissionRelation表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsRolePermissionRelation>> listBrand(@RequestParam(value = "pageNum",
            defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(value = "pageSize",
                                                                                 defaultValue = "10") Integer pageSize) {
        Page<UmsRolePermissionRelation> page = new Page(pageNum, pageSize);
        List<UmsRolePermissionRelation> brandList = umsRolePermissionRelationService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("UmsRolePermissionRelation表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<UmsRolePermissionRelation> brand(@PathVariable("id") Long id) {
        return CommonResult.success(umsRolePermissionRelationService.getById(id));
    }
}
