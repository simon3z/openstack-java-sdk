package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Endpoint;

public class CreateEndpoint implements OpenStackCommand<Endpoint> {

	private Endpoint endpointForCreate;
	
	public CreateEndpoint(Endpoint endpointForCreate) {
		this.endpointForCreate = endpointForCreate;
	}

	@Override
	public Endpoint execute(OpenStackTarget target) {
		return target.path("endpoints").postEntity(endpointForCreate, Endpoint.class);
	}
	
}
