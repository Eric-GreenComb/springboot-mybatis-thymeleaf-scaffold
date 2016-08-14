package com.ecloudtime.rs.shiro;

import com.ecloudtime.rs.bean.Permission;
import com.ecloudtime.rs.bean.Role;
import com.ecloudtime.rs.bean.User;
import com.ecloudtime.rs.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义shiro realm
 *
 * @author luoshengsha
 *         <p>
 *         2016年5月10日-下午6:40:21
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        String username = (String) principals.getPrimaryPrincipal();
        List<Role> roles = userService.getByName(username).getRoles();

        if (null == roles) {
            return authorizationInfo;
        }
        Set<String> roleSet = new HashSet<String>();
        Set<String> permissionSet = new HashSet<String>();

        for (Role role : roles) {
            roleSet.add(role.getName());
            for (Permission p : role.getPermissions()) {
                permissionSet.add(p.getPermission());
            }
        }

        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = (String) token.getPrincipal();

        User user = userService.getByName(username);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
    }
}
