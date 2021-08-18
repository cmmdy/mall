package com.zwt.mall.service;

import com.zwt.mall.common.api.CommonResult;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-9:50 上午
 * @Email zhouwt@shuyilink.com
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);


    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
