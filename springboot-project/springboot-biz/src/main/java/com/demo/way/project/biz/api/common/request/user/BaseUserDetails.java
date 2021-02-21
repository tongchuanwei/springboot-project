package com.demo.way.project.biz.api.common.request.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @author ：way
 * SpringSecurity需要的用户详情
 * Created by way on 2019/11/28.
 */
public class BaseUserDetails implements UserDetails {
    private BaseUserRequest userDetails;
    private List<BaseUserPermission> permissionList;
    public BaseUserDetails(BaseUserRequest userDetails, List<BaseUserPermission> permissionList) {
        this.userDetails = userDetails;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetails.getUserName();
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
        return userDetails.getStatus().equals(1);
    }
}
