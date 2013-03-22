package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteRole implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteRole(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackTarget target) {
		target.path("OS-KSADM/roles").path(id).delete();
		return null;
	}
	
}
