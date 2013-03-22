package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteService implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteService(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackTarget target) {
		target.path("OS-KSADM/services").path(id).delete();
		return null;
	}
	
}
