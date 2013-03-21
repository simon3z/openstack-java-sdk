package org.openstack.quantum.api.ports;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Ports;

public class ListPorts implements OpenStackCommand<Ports> {

	public ListPorts() {
	}
	
	public Ports execute(WebTarget target) {
		return target.path("v2.0").path("ports").request(MediaType.APPLICATION_JSON).get(Ports.class);
	}

}
