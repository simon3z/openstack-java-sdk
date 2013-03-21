package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.openstack.common.command.OpenStackCommand;

public class CreateDirectory implements OpenStackCommand<Void> {

	private String container;
	
	private String path;
	
	public CreateDirectory(String container, String path) {
		this.container = container;
		this.path = path;
	}

	@Override
	public Void execute(WebTarget endpoint) {
		endpoint.path(container).path(path).request().put(Entity.entity(new byte[1],"application/directory"));
		return null;
	}
	
	

}
