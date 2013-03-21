package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.keystone.model.Tenant;

public class UpdateTenant implements OpenStackCommand<Tenant> {

	private Tenant tenant;
	
	public UpdateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public Tenant execute(WebTarget target) {
		return target.path("tenants").path(tenant.getId()).request(MediaType.APPLICATION_JSON).put(Entity.json(tenant), Tenant.class);
	}
	
}
