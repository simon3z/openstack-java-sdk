package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Endpoints;

public class ListEndpoints implements OpenStackCommand<Endpoints> {

	@Override
	public Endpoints execute(WebTarget target) {
		return target.path("endpoints").request(MediaType.APPLICATION_JSON).get(Endpoints.class);
	}

}
