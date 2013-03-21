package org.openstack.quantum.api.ports;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Port;

public class ShowPort implements OpenStackCommand<Port> {

private String id;
	
	public ShowPort(String id) {
		this.id = id;
	}
	
	public Port execute(WebTarget target) {
		return target.path("v2.0").path("ports").path(id).request(MediaType.APPLICATION_JSON).get(Port.class);
	}

}
