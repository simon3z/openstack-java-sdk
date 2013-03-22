package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Roles;

public class ListUserRolesOnTenant implements OpenStackCommand<Roles> {
	
	private String tenantId;
	private String userId;
	
	public ListUserRolesOnTenant(String tenantId, String userId) {
		this.tenantId = tenantId;
		this.userId = userId;
	}

	@Override
	public Roles execute(OpenStackTarget target) {
		return target.path("tenants").path(tenantId).path("users").path(userId).path("roles").get(Roles.class);
	}

}
