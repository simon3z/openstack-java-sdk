package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Endpoint;

public class CreateEndpoint implements OpenStackCommand<Endpoint> {

	private Endpoint endpointForCreate;
	
	public CreateEndpoint(Endpoint endpointForCreate) {
		this.endpointForCreate = endpointForCreate;
	}

	@Override
	public Endpoint execute(WebTarget target) {
		return target.path("endpoints").request(MediaType.APPLICATION_JSON).post(Entity.json(endpointForCreate), Endpoint.class);
	}
	
}
