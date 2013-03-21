package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.User;

public class UpdateUser implements OpenStackCommand<User> {

	private String id;
	
	private User userForCreate;
	
	public UpdateUser(String id, User userForCreate) {
		this.userForCreate = userForCreate;
	}

	@Override
	public User execute(WebTarget target) {
		return target.path("users").path(id).request(MediaType.APPLICATION_JSON).put(Entity.json(userForCreate), User.class);
	}
	
}
