package com.zwt.mall.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author zhouwentao
 * @Date 2021-08-12-5:06 下午
 * @Email zhouwt@shuyilink.com
 */
@Data

public class UserDTO implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorityList;


    public UserDTO() {
    }

    public UserDTO(String username, String password, List<GrantedAuthority> grantedAuthorityList) {
        this.username = username;
        this.password = password;
        this.grantedAuthorityList = grantedAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
