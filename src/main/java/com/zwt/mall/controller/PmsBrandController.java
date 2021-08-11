package com.zwt.mall.controller;

import com.zwt.mall.service.PmsBrandService;
import com.zwt.mall.common.CommonResult;
import com.zwt.mall.entity.PmsBrand;
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
 * 品牌表(PmsBrand)表服务控制层
 *
 * @author zhouwt
 * @since 2021-08-11 09:13:51
 */
@Api(tags = "品牌表(PmsBrand)")
@Validated
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("pmsBrand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation("PmsBrand表获取所有")
    @GetMapping(value = "listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.list());
    }

    @ApiOperation("PmsBrand表添加")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        boolean success = pmsBrandService.save(pmsBrand);
        if (success) {
            commonResult = CommonResult.success(pmsBrand);
            log.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("PmsBrand表根据ID更新")
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        boolean success = pmsBrandService.updateById(pmsBrand);
        if (success) {
            commonResult = CommonResult.success(pmsBrand);
            log.debug("updateBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }


    @ApiOperation("PmsBrand表根据ID删除")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        boolean success = pmsBrandService.removeById(id);
        if (success) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("PmsBrand表分页查询")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<PmsBrand> page = new Page(pageNum, pageSize);
        List<PmsBrand> brandList = pmsBrandService.page(page).getRecords();
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("PmsBrand表根据ID获得")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getById(id));
    }
}
