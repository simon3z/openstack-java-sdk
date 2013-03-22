package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteUser implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteUser(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackTarget target) {
		target.path("users").path(id).delete();
		return null;
	}
	
}
