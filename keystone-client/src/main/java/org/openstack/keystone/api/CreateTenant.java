package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Tenant;

public class CreateTenant implements OpenStackCommand<Tenant> {

	private Tenant tenant;
	
	public CreateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public Tenant execute(OpenStackTarget target) {
		return target.path("tenants").postEntity(tenant, Tenant.class);
	}
	
}
