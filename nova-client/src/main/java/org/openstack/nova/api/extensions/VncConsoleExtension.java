package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.ServerAction.GetVncConsole;
import org.openstack.nova.model.ServerAction.VncConsole;

public class VncConsoleExtension {

	public static class GetVncConsoleServer implements OpenStackCommand<VncConsole> {
		
		private GetVncConsole action;

		private String id;
		
		public GetVncConsoleServer(String id, GetVncConsole action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public VncConsole execute(OpenStackTarget target) {
			return target.path("servers").path(id).path("action").postEntity(action, VncConsole.class);
		}

	}
	
	public static GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}

	
}
