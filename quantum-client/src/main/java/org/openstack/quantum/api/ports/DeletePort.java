package org.openstack.quantum.api.ports;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;

public class DeletePort implements OpenStackCommand<Void> {

private String id;
	
	public DeletePort(String portId){
		this.id = portId;
	}

	public Void execute(WebTarget target) {
		target.path("v2.0").path("ports").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
}
