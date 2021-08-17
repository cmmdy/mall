package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.UmsPermissionMapper;
import com.zwt.mall.entity.UmsPermission;
import com.zwt.mall.service.UmsPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户权限表(UmsPermission)表服务实现类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:19
 */
@Service
@Slf4j
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission> implements UmsPermissionService {

    @Autowired
    private UmsPermissionMapper umsPermissionMapper;
}
