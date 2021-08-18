package com.zwt.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwt.mall.common.api.CommonResult;
import com.zwt.mall.entity.PmsBrand;
import com.zwt.mall.entity.UmsAdmin;
import com.zwt.mall.entity.UmsPermission;

import java.util.List;

/**
 * 后台用户表(UmsAdmin)表服务接口层
 *
 * @author zhouwt
 * @since 2021-08-17 16:36:50
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    UmsAdmin getAdminByUserName(String username);

    List<UmsPermission> getPermissionListById(Long id);

    CommonResult register(UmsAdmin umsAdmin);

    String login(String username, String password);
}
