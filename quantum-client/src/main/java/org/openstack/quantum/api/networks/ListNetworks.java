package org.openstack.quantum.api.networks;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.quantum.model.Networks;

public class ListNetworks implements OpenStackCommand<Networks> {

	public ListNetworks() {
	}
	
	public Networks execute(WebTarget target) {
		return target.path("v2.0").path("networks").request(MediaType.APPLICATION_JSON).get(Networks.class);
	}

}
