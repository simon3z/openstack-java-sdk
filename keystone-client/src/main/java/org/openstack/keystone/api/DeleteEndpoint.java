package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteEndpoint implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteEndpoint(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackTarget target) {
		target.path("endpoints").path(id).delete();
		return null;
	}
	
}
