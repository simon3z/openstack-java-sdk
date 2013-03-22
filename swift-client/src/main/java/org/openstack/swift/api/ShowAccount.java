package org.openstack.swift.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class ShowAccount implements OpenStackCommand<Response> {

	@Override
	public Response execute(OpenStackTarget target) {
		return target.getWebTarget().request(MediaType.APPLICATION_JSON).head();
	}

}
