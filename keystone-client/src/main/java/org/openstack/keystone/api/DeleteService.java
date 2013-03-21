package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;

public class DeleteService implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteService(String id) {
		this.id = id;
	}

	@Override
	public Void execute(WebTarget target) {
		target.path("OS-KSADM/services").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
