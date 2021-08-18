package com.zwt.mall.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouwentao
 * @Date 2021-08-13-5:04 下午
 * @Email zhouwt@shuyilink.com
 */
//public class MyTokenEnhancer implements TokenEnhancer {
//   @Override
//   public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//      Map<String, Object> map = new HashMap<>();
//      map.put("enhance", "fuck");
//      ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
//      return accessToken;
//   }
//}
