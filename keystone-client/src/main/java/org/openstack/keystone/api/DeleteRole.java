package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;

public class DeleteRole implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteRole(String id) {
		this.id = id;
	}

	@Override
	public Void execute(WebTarget target) {
		target.path("OS-KSADM/roles").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
