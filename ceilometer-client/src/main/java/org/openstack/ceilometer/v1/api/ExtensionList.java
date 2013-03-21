package org.openstack.ceilometer.v1.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.v1.model.Extensions;
import org.openstack.common.command.OpenStackCommand;

public class ExtensionList implements OpenStackCommand<Extensions> {

	@Override
	public Extensions execute(WebTarget target) {
		return target.path("extensions").request(MediaType.APPLICATION_JSON).get(Extensions.class);
	}

}
