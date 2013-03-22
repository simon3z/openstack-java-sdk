package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Host;
import org.openstack.nova.model.Hosts;

public class HostsExtension {

	public static class ListHosts implements OpenStackCommand<Hosts> {

		@Override
		public Hosts execute(OpenStackTarget target) {
			return target.path("os-hosts").get(Hosts.class);
		}

	}

	public static class ShowHost implements OpenStackCommand<Host> {

		private String id;
		
		public ShowHost(String id) {
			this.id = id;
		}

		@Override
		public Host execute(OpenStackTarget target) {
			return target.path("os-hosts").path(id).get(Host.class);
		}
		
	}

	public static ListHosts listHosts() {
		return new ListHosts();
	}
	
	public static ShowHost showHost(String id) {
		return new ShowHost(id);
	}
	
}
