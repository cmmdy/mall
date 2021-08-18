package com.zwt.mall.controller;

import com.zwt.mall.service.UmsAdminRoleRelationService;
import com.zwt.mall.common.api.CommonResult;
import com.zwt.mall.entity.UmsAdminRoleRelation;
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
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:06
 */
@Api(tags = "后台用户和角色关系表(UmsAdminRoleRelation)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("umsAdminRoleRelation")
public class UmsAdminRoleRelationController {
    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;

    @ApiOperation("UmsAdminRoleRelation表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<UmsAdminRoleRelation>> getBrandList() {
        return CommonResult.success(umsAdminRoleRelationService.list());
    }

    @ApiOperation("UmsAdminRoleRelation表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody UmsAdminRoleRelation umsAdminRoleRelation) {
        CommonResult commonResult;
        boolean success = umsAdminRoleRelationService.save(umsAdminRoleRelation);
        if (success) {
            commonResult = CommonResult.success(umsAdminRoleRelation);
            log.debug("createBrand success:{}", umsAdminRoleRelation);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", umsAdminRoleRelation);
        }
        return commonResult;
    }

    @ApiOperation("UmsAdminRoleRelation表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody UmsAdminRoleRelation umsAdminRoleRelation) {
        CommonResult commonResult;
        boolean success = umsAdminRoleRelationService.updateById(umsAdminRoleRelation);
        if (success) {
            commonResult = CommonResult.success(umsAdminRoleRelation);
            log.debug("updateBrand success:{}", umsAdminRoleRelation);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", umsAdminRoleRelation);
        }
        return commonResult;
    }


    @ApiOperation("UmsAdminRoleRelation表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = umsAdminRoleRelationService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("UmsAdminRoleRelation表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsAdminRoleRelation>> listBrand(@RequestParam(value = "pageNum", defaultValue =
            "1") Integer pageNum,
                                                                    @RequestParam(value = "pageSize", defaultValue =
                                                                            "10") Integer pageSize) {
        Page<UmsAdminRoleRelation> page = new Page(pageNum, pageSize);
        List<UmsAdminRoleRelation> brandList = umsAdminRoleRelationService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("UmsAdminRoleRelation表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<UmsAdminRoleRelation> brand(@PathVariable("id") Long id) {
        return CommonResult.success(umsAdminRoleRelationService.getById(id));
    }
}
