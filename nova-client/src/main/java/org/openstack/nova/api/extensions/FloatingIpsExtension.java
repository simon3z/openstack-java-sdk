package org.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.FloatingIp;
import org.openstack.nova.model.FloatingIps;

public class FloatingIpsExtension {
	
	public static class ListFloatingIps implements OpenStackCommand<FloatingIps> {

		@Override
		public FloatingIps execute(OpenStackTarget target) {
			return target.path("os-floating-ips").get(FloatingIps.class);
		}

	}

	public static class AllocateFloatingIp implements OpenStackCommand<FloatingIp> {
		
		private Map<String, String> body;
			
		public AllocateFloatingIp(String pool) {
			body = new HashMap<String, String>();
			if(pool != null) {
				body.put("pool", pool);
			}
		}

		@Override
		public FloatingIp execute(OpenStackTarget target) {
			return target.path("os-floating-ips").postEntity(body, FloatingIp.class);
		}

	}
	
	public static class DeallocateFloatingIp implements OpenStackCommand<Void> {

		private String id;
		
		public DeallocateFloatingIp(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-floating-ips").path(id).delete();
			return null;
		}
		
	}

	
	public static class AssociateFloatingIp implements OpenStackCommand<Void> {
		
		private org.openstack.nova.model.ServerAction.AssociateFloatingIp action;

		private String id;
		
		public AssociateFloatingIp(String id, org.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class DisassociateFloatingIp implements OpenStackCommand<Void> {
		
		private org.openstack.nova.model.ServerAction.DisassociateFloatingIp action;

		private String id;
		
		public DisassociateFloatingIp(String id, org.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}

	public static ListFloatingIps listFloatingIps() {
		return new ListFloatingIps();
	}
	
	public static AllocateFloatingIp allocateFloatingIp(String pool) {
		return new AllocateFloatingIp(pool);
	}
	
	public static DeallocateFloatingIp deallocateFloatingIp(String id) {
		return new DeallocateFloatingIp(id);
	}
	
	public static AssociateFloatingIp associateFloatingIp(String serverId, String floatingIpAddress) {
		org.openstack.nova.model.ServerAction.AssociateFloatingIp action = new org.openstack.nova.model.ServerAction.AssociateFloatingIp(floatingIpAddress);
		return new AssociateFloatingIp(serverId, action);
	}
	
	public static DisassociateFloatingIp disassociateFloatingIp(String serverId, String floatingIpAddress) {
		org.openstack.nova.model.ServerAction.DisassociateFloatingIp action = new org.openstack.nova.model.ServerAction.DisassociateFloatingIp(floatingIpAddress);
		return new DisassociateFloatingIp(serverId, action);
	}
	
}
