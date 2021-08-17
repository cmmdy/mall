package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.UmsAdminMapper;
import com.zwt.mall.entity.UmsAdmin;
import com.zwt.mall.service.UmsAdminService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户表(UmsAdmin)表服务实现类
 *
 * @author zhouwt
 * @since 2021-08-17 16:36:50
 */
@Service
@Slf4j
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;
}
