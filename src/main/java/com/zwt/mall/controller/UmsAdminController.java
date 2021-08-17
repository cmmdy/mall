package com.zwt.mall.controller;

import com.zwt.mall.service.UmsAdminService;
import com.zwt.mall.common.CommonResult;
import com.zwt.mall.entity.UmsAdmin;
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
 * 后台用户表(UmsAdmin)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-17 16:37:11
 */
@Api(tags = "后台用户表(UmsAdmin)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("umsAdmin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("UmsAdmin表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<UmsAdmin>> getBrandList() {
        return CommonResult.success(umsAdminService.list());
    }

    @ApiOperation("UmsAdmin表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody UmsAdmin umsAdmin) {
        CommonResult commonResult;
        boolean success = umsAdminService.save(umsAdmin);
        if (success) {
            commonResult = CommonResult.success(umsAdmin);
            log.debug("createBrand success:{}", umsAdmin);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", umsAdmin);
        }
        return commonResult;
    }

    @ApiOperation("UmsAdmin表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody UmsAdmin umsAdmin) {
        CommonResult commonResult;
        boolean success = umsAdminService.updateById(umsAdmin);
        if (success) {
            commonResult = CommonResult.success(umsAdmin);
            log.debug("updateBrand success:{}", umsAdmin);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", umsAdmin);
        }
        return commonResult;
    }


    @ApiOperation("UmsAdmin表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = umsAdminService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("UmsAdmin表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsAdmin>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<UmsAdmin> page = new Page(pageNum, pageSize);
        List<UmsAdmin> brandList = umsAdminService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("UmsAdmin表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<UmsAdmin> brand(@PathVariable("id") Long id) {
        return CommonResult.success(umsAdminService.getById(id));
    }
}
