package com.zwt.mall.service.impl;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwt.mall.common.api.CommonResult;
import com.zwt.mall.common.utils.JwtTokenUtil;
import com.zwt.mall.entity.UmsPermission;
import com.zwt.mall.mapper.UmsAdminMapper;
import com.zwt.mall.entity.UmsAdmin;
import com.zwt.mall.mapper.UmsAdminRoleRelationMapper;
import com.zwt.mall.service.UmsAdminPermissionRelationService;
import com.zwt.mall.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

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
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public UmsAdmin getAdminByUserName(String username) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return getOne(queryWrapper);
    }

    @Override
    public List<UmsPermission> getPermissionListById(Long id) {
        return umsAdminRoleRelationMapper.getPermissionListById(id);
    }

    @Override
    public CommonResult register(UmsAdmin umsAdmin) {
        UmsAdmin mUmsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdmin, mUmsAdmin);
        mUmsAdmin.setCreateTime(new Date());
        mUmsAdmin.setStatus(1);
        //用户名是否存在
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", umsAdmin.getUsername());
        if (getOne(queryWrapper) != null) {
            return CommonResult.failed("用户名已存在");
        }
        //密码加密
        mUmsAdmin.setPassword(passwordEncoder.encode(mUmsAdmin.getPassword()));
        if (save(mUmsAdmin)) {
            return CommonResult.success("注册成功");
        } else {
            return CommonResult.failed("系统错误,请联系管理员");
        }

    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("用户名或密码不正确");
            } else {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                token = jwtTokenUtil.generateToken(userDetails);
                return token;
            }
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }
}
