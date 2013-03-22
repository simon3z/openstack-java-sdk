package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Endpoint;

public class UpdateEndpoint implements OpenStackCommand<Endpoint> {

	private Endpoint endpointForCreate;
	
	public UpdateEndpoint(Endpoint endpointForCreate) {
		this.endpointForCreate = endpointForCreate;
	}

	@Override
	public Endpoint execute(OpenStackTarget target) {
		return target.path("endpoints").putEntity(endpointForCreate, Endpoint.class);
	}
	
}
