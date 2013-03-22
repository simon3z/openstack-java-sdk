package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class CreateContainer implements OpenStackCommand<Response> {

	private String containerName;
	
	public CreateContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(OpenStackTarget target) {
		return target.getWebTarget().path(containerName).request().method("PUT", Entity.text("*"));
	}

}
