package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class AddUserToTenant implements OpenStackCommand<Void> {

	private String tenantId;
	private String userId;
	private String roleId;
	
	public AddUserToTenant(String tenantId, String userId, String roleId) {
		this.tenantId = tenantId;
		this.userId = userId;
		this.roleId = roleId;
	}
	
	@Override
	public Void execute(OpenStackTarget target) {
		target.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId).putEntity("{}");
		return null;
	}

}
