package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Tenants;

public class ListTenants implements OpenStackCommand<Tenants> {

	@Override
	public Tenants execute(OpenStackTarget target) {
		return target.path("tenants").get(Tenants.class);
	}

}
