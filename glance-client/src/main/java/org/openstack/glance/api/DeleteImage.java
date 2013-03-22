package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteImage implements OpenStackCommand<Void> {
	
	private String id;
	
	public DeleteImage(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackTarget target) {
		target.path("images").path(id).delete();
		return null;
	}
	
}
