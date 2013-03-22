package org.openstack.swift.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.common.command.OpenStackCommand;

public class ShowObject implements OpenStackCommand<Response> {

	private String containerName;
	
	private String objectName;
	
	public ShowObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).head();
	}

}
