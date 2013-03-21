package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Services;

public class ListServices implements OpenStackCommand<Services> {

	@Override
	public Services execute(WebTarget target) {
		return target.path("OS-KSADM/services").request(MediaType.APPLICATION_JSON).get(Services.class);
	}

}
