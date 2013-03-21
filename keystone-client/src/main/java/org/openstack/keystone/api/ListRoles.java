package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Roles;

public class ListRoles implements OpenStackCommand<Roles> {

	@Override
	public Roles execute(WebTarget target) {
		return target.path("OS-KSADM/roles").request(MediaType.APPLICATION_JSON).get(Roles.class);
	}

}
