package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Users;

public class ListUsers implements OpenStackCommand<Users> {

	@Override
	public Users execute(OpenStackTarget target) {
		return target.path("users").get(Users.class);
	}

}
