package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class RemoveMemberFromImage implements OpenStackCommand<Void> {

	private String id;
	
	private String tenantId;
	
	public RemoveMemberFromImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public Void execute(OpenStackTarget endpoint) {
		endpoint.path("images").path(id).path("members").path(tenantId).delete();
		return null;
	}

}
