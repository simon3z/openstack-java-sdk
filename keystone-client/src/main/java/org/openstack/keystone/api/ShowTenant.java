package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Tenant;

public class ShowTenant implements OpenStackCommand<Tenant> {
	
	private String id;
	
	public ShowTenant(String id) {
		this.id = id;
	}

	@Override
	public Tenant execute(OpenStackTarget target) {
		return target.path("tenants").path(id).get(Tenant.class);
	}

}
