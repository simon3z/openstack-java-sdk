package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Services;

public class ListServices implements OpenStackCommand<Services> {

	@Override
	public Services execute(OpenStackTarget target) {
		return target.path("OS-KSADM/services").get(Services.class);
	}

}
