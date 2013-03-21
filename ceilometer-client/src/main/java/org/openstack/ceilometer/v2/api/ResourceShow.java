package org.openstack.ceilometer.v2.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.v2.model.Resource;
import org.openstack.common.command.OpenStackCommand;


public class ResourceShow implements OpenStackCommand<Resource> {

	private String id;
		
	public ResourceShow id(String id) {
		this.id = id;
		return this;
	}
	
	@Override
	public Resource execute(WebTarget target) {
		if(id == null) {
			throw new UnsupportedOperationException("resource id is mandatory");
		}
		return target.path("resources").path(id).request(MediaType.APPLICATION_JSON).get(Resource.class);
	}

}