package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.ServerAction.Rescue;
import org.openstack.nova.model.ServerAction.Unrescue;

public class ServerRescueExtension {

	public class RescueServer implements OpenStackCommand<Void> {
		
		private Rescue action;

		private String id;
		
		public RescueServer(String id, Rescue action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}

	public class UnrescueServer implements OpenStackCommand<Void> {
		
		private Unrescue action;

		private String id;
		
		public UnrescueServer(String id) {
			this.id = id;
			this.action = new Unrescue();
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public RescueServer rescue(String serverId, String adminPass) {
		Rescue action = new Rescue(adminPass);
		return new RescueServer(serverId, action);
	}
	
	public UnrescueServer unrescue(String serverId) {
		return new UnrescueServer(serverId);
	}
}
