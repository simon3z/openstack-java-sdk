package org.openstack.keystone.api;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Tenant;

public class UpdateTenant implements OpenStackCommand<Tenant> {

	private Tenant tenant;
	
	public UpdateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public Tenant execute(OpenStackTarget target) {
		return target.path("tenants").path(tenant.getId()).putEntity(tenant, Tenant.class);
	}
	
}
