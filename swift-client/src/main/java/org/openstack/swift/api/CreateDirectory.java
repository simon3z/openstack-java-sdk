package org.openstack.swift.api;

import javax.ws.rs.client.Entity;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;

public class CreateDirectory implements OpenStackCommand<Void> {

	private String container;
	
	private String path;
	
	public CreateDirectory(String container, String path) {
		this.container = container;
		this.path = path;
	}

	@Override
	public Void execute(OpenStackTarget endpoint) {
		endpoint.getWebTarget().path(container).path(path).request().put(Entity.entity(new byte[1],"application/directory"));
		return null;
	}
	
	

}
