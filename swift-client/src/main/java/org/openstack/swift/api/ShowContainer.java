package org.openstack.swift.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.common.command.OpenStackCommand;

public class ShowContainer implements OpenStackCommand<Response> {

	private String containerName;
	
	public ShowContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return target.path(containerName).request(MediaType.APPLICATION_JSON).head();
	}

}
