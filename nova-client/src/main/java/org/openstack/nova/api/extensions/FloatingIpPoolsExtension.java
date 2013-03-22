package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.FloatingIpPools;

public class FloatingIpPoolsExtension {

	public static class ListFloatingIpPools implements OpenStackCommand<FloatingIpPools> {

		@Override
		public FloatingIpPools execute(OpenStackTarget target) {
			return target.path("os-floating-ip-pools").get(FloatingIpPools.class);
		}

	}
	
	public static ListFloatingIpPools listFloatingIpPools() {
		return new ListFloatingIpPools();
	}
	
}
