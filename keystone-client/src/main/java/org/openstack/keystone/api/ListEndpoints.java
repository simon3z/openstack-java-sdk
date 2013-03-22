package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Endpoints;

public class ListEndpoints implements OpenStackCommand<Endpoints> {

	@Override
	public Endpoints execute(OpenStackTarget target) {
		return target.path("endpoints").get(Endpoints.class);
	}

}
