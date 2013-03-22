package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteTenant implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteTenant(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackTarget target) {
		target.path("tenants").path(id).delete();
		return null;
	}
	
}
