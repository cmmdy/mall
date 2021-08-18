package com.zwt.mall.controller;

import com.zwt.mall.service.UmsAdminPermissionRelationService;
import com.zwt.mall.common.api.CommonResult;
import com.zwt.mall.entity.UmsAdminPermissionRelation;
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
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-17 16:38:34
 */
@Api(tags = "后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("umsAdminPermissionRelation")
public class UmsAdminPermissionRelationController {
    @Autowired
    private UmsAdminPermissionRelationService umsAdminPermissionRelationService;

    @ApiOperation("UmsAdminPermissionRelation表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<UmsAdminPermissionRelation>> getBrandList() {
        return CommonResult.success(umsAdminPermissionRelationService.list());
    }

    @ApiOperation("UmsAdminPermissionRelation表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody UmsAdminPermissionRelation umsAdminPermissionRelation) {
        CommonResult commonResult;
        boolean success = umsAdminPermissionRelationService.save(umsAdminPermissionRelation);
        if (success) {
            commonResult = CommonResult.success(umsAdminPermissionRelation);
            log.debug("createBrand success:{}", umsAdminPermissionRelation);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", umsAdminPermissionRelation);
        }
        return commonResult;
    }

    @ApiOperation("UmsAdminPermissionRelation表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody UmsAdminPermissionRelation umsAdminPermissionRelation) {
        CommonResult commonResult;
        boolean success = umsAdminPermissionRelationService.updateById(umsAdminPermissionRelation);
        if (success) {
            commonResult = CommonResult.success(umsAdminPermissionRelation);
            log.debug("updateBrand success:{}", umsAdminPermissionRelation);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", umsAdminPermissionRelation);
        }
        return commonResult;
    }


    @ApiOperation("UmsAdminPermissionRelation表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = umsAdminPermissionRelationService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("UmsAdminPermissionRelation表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsAdminPermissionRelation>> listBrand(@RequestParam(value = "pageNum",
            defaultValue = "1") Integer pageNum,
                                                                          @RequestParam(value = "pageSize",
                                                                                  defaultValue = "10") Integer pageSize) {
        Page<UmsAdminPermissionRelation> page = new Page(pageNum, pageSize);
        List<UmsAdminPermissionRelation> brandList = umsAdminPermissionRelationService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("UmsAdminPermissionRelation表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<UmsAdminPermissionRelation> brand(@PathVariable("id") Long id) {
        return CommonResult.success(umsAdminPermissionRelationService.getById(id));
    }
}
