package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Network;
import org.openstack.nova.model.Networks;

public class NetworksExtension {
	
	public static class ListNetworks implements OpenStackCommand<Networks> {

		@Override
		public Networks execute(OpenStackTarget target) {
			return target.path("os-networks").get(Networks.class);
		}

	}

	public static class CreateNetwork implements OpenStackCommand<Network> {

		private Network network;
		
		public CreateNetwork(Network network) {
			this.network = network;
		}

		@Override
		public Network execute(OpenStackTarget target) {
			return target.path("os-networks").postEntity(network, Network.class);
		}
		
	}
	
	public class ShowNetwork implements OpenStackCommand<Network> {

		private String id;
		
		public ShowNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Network execute(OpenStackTarget target) {
			return target.path("os-networks").path(id).get(Network.class);
		}

	}

	
	public static class DisassociateNetwork implements OpenStackCommand<Void> {

		private String id;
		
		public DisassociateNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-networks").path(id).postEntity("{\"action\":\"disassociate\"}");
			return null;
		}

	}
	
	public static class DeleteNetwork implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Void execute(OpenStackTarget target) {
			target.path("os-networks").path(id).delete();
			return null;
		}

	}
	
	public ListNetworks listNetworks() {
		return new ListNetworks();
	}
	
	public ShowNetwork showNetwork(String id) {
		return new ShowNetwork(id);
	}
	
	public DeleteNetwork deleteNetwork(String id) {
		return new DeleteNetwork(id);
	}
	
	public DisassociateNetwork disassociateNetwork(String id) {
		return new DisassociateNetwork(id);
	}
	
}
