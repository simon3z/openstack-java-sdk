package org.openstack.nova.api.extensions;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.FloatingIpPools;

public class FloatingIpPoolsExtension {

	public static class ListFloatingIpPools implements OpenStackCommand<FloatingIpPools> {

		@Override
		public FloatingIpPools execute(WebTarget target) {
			return target.path("os-floating-ip-pools").request(MediaType.APPLICATION_JSON).get(FloatingIpPools.class);
		}

	}
	
	public static ListFloatingIpPools listFloatingIpPools() {
		return new ListFloatingIpPools();
	}
	
}
