package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Roles;

public class ListRoles implements OpenStackCommand<Roles> {

	@Override
	public Roles execute(OpenStackTarget target) {
		return target.path("OS-KSADM/roles").get(Roles.class);
	}

}
