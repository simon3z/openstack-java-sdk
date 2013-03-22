package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.FloatingIpDomain;
import org.openstack.nova.model.FloatingIpDomains;

public class FloatingIpDnsExtension {
	
	public class ListFloatingIpDomains implements OpenStackCommand<FloatingIpDomains> {

		@Override
		public FloatingIpDomains execute(OpenStackTarget target) {
			return target.path("os-floating-ip-dns").get(FloatingIpDomains.class);
		}

	}

	public static class CreateFloatingIpDomain implements OpenStackCommand<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public CreateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
		}

		@Override
		public FloatingIpDomain execute(OpenStackTarget target) {
			return target.path("os-floating-ip-dns").postEntity(floatingIpDomain, FloatingIpDomain.class);
		}
		
	}
	
	public static class ShowFloatingIpDomain implements OpenStackCommand<FloatingIpDomain> {

		private String id;
		
		public ShowFloatingIpDomain(String id) {
			this.id = id;
		}

		@Override
		public FloatingIpDomain execute(OpenStackTarget target) {
			return target.path("os-floating-ip-dns").path(id).get(FloatingIpDomain.class);
		}
		
	}

	
	public static class UpdateFloatingIpDomain implements OpenStackCommand<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public UpdateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
		}

		@Override
		public FloatingIpDomain execute(OpenStackTarget target) {
			return target.path("os-floating-ip-dns").postEntity(floatingIpDomain, FloatingIpDomain.class);
		}
		
	}

	
	public class DeleteFloatingIpDomain implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteFloatingIpDomain(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-floating-ip-dns").path(id).delete();
			return null;
		}
		
	}
	
	public ListFloatingIpDomains listFloatingIpDomains() {
		return new ListFloatingIpDomains();
	}
	
	public CreateFloatingIpDomain createFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
		return new CreateFloatingIpDomain(floatingIpDomain);
	}
	
	public ShowFloatingIpDomain showFloatingIpDomain(String id) {
		return new ShowFloatingIpDomain(id);
	}
	
	public UpdateFloatingIpDomain updateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
		return new UpdateFloatingIpDomain(floatingIpDomain);
	}
	
	public DeleteFloatingIpDomain deleteFloatingIpDomain(String id) {
		return new DeleteFloatingIpDomain(id);
	}
	
}
