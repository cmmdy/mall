package com.zwt.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.mapper.UmsRoleMapper;
import com.zwt.mall.entity.UmsRole;
import com.zwt.mall.service.UmsRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台用户角色表(UmsRole)表服务实现类
 *
 * @author zhouwt
 * @since 2021-08-17 16:39:20
 */
@Service
@Slf4j
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {

    @Autowired
    private UmsRoleMapper umsRoleMapper;
}
