package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Role;

public class CreateRole implements OpenStackCommand<Role> {

	private Role roleForCreate;
	
	public CreateRole(Role roleForCreate) {
		this.roleForCreate = roleForCreate;
	}

	@Override
	public Role execute(OpenStackTarget target) {
		return target.path("OS-KSADM/roles").postEntity(roleForCreate, Role.class);
	}
	
}
