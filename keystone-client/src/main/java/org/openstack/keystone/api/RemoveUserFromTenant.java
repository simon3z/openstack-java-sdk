package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;

public class RemoveUserFromTenant implements OpenStackCommand<Void> {

	private String tenantId;
	private String userId;
	private String roleId;
	
	public RemoveUserFromTenant(String tenantId, String userId, String roleId) {
		this.tenantId = tenantId;
		this.userId = userId;
		this.roleId = roleId;
	}
	
	@Override
	public Void execute(WebTarget target) {
		target.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
