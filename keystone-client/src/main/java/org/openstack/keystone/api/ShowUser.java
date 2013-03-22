package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.User;

public class ShowUser implements OpenStackCommand<User> {
	
	private String id;
	
	public ShowUser(String id) {
		this.id = id;
	}

	@Override
	public User execute(OpenStackTarget target) {
		return target.path("users").path(id).get(User.class);
	}

}
