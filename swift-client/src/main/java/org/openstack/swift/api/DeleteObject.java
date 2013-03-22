package org.openstack.swift.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class DeleteObject implements OpenStackCommand<Response> {

	private String containerName;
	
	private String objectName;
	
	public DeleteObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public Response execute(OpenStackTarget target) {
		return target.getWebTarget().path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).delete();
	}

}
