package com.bdxh.kmsale.utils;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.util.StringUtils;
import com.google.common.collect.Maps;

public class Permissions {

	public static final String CREATE_PERMISSION = "create";
    public static final String UPDATE_PERMISSION = "update";
    public static final String DELETE_PERMISSION = "delete";
    public static final String VIEW_PERMISSION = "view";
	
	private String resourceIdentity;
	private Map<String, String> resourcePermissions = Maps.newHashMap();

	public static Permissions newPermissions(String resourceIdentityPrefix) {
		Permissions permissions = new Permissions();
		permissions.resourceIdentity = resourceIdentityPrefix;
		permissions.resourcePermissions.put(CREATE_PERMISSION, resourceIdentityPrefix + ":" + CREATE_PERMISSION);
		permissions.resourcePermissions.put(UPDATE_PERMISSION, resourceIdentityPrefix + ":" + UPDATE_PERMISSION);
		permissions.resourcePermissions.put(DELETE_PERMISSION, resourceIdentityPrefix + ":" + DELETE_PERMISSION);
		permissions.resourcePermissions.put(VIEW_PERMISSION, resourceIdentityPrefix + ":" + VIEW_PERMISSION);
		return permissions;
	}
	
	public void assertHasCreatePermission() {
        assertHasPermission(CREATE_PERMISSION, "no.create.permission");
    }

    public void assertHasUpdatePermission() {
        assertHasPermission(UPDATE_PERMISSION, "no.update.permission");
    }

    public void assertHasDeletePermission() {
        assertHasPermission(DELETE_PERMISSION, "no.delete.permission");
    }

	public void assertHasViewPermission() {
		assertHasPermission(VIEW_PERMISSION, "no.view.permission");
	}

	public void assertHasPermission(String permission, String errorCode) {
        if (StringUtils.isEmpty(errorCode)) {
            errorCode = getDefaultErrorCode();
        }
        String resourcePermission = resourcePermissions.get(permission);
        if (resourcePermission == null) {
            resourcePermission = this.resourceIdentity + ":" + permission;
        }
        if (!SecurityUtils.getSubject().isPermitted(resourcePermission)) {
            throw new UnauthorizedException(MessageMapper.getInstance().getMessage(errorCode, new Object[]{resourcePermission}));
        }
    }
	
	private String getDefaultErrorCode() {
        return "no.permission";
    }
}
