package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.User;

public class UpdateUser implements OpenStackCommand<User> {

	private String id;
	
	private User userForCreate;
	
	public UpdateUser(String id, User userForCreate) {
		this.userForCreate = userForCreate;
	}

	@Override
	public User execute(OpenStackTarget target) {
		return target.path("users").path(id).putEntity(userForCreate, User.class);
	}
	
}
