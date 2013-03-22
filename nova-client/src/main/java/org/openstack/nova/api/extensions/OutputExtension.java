package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.ServerAction.ConsoleOutput;
import org.openstack.nova.model.ServerAction.GetConsoleOutput;

public class OutputExtension {

	public static class GetConsoleOutputServer implements OpenStackCommand<ConsoleOutput> {
		
		private GetConsoleOutput action;

		private String id;
		
		public GetConsoleOutputServer(String id, GetConsoleOutput action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public ConsoleOutput execute(OpenStackTarget target) {
			return target.path("servers").path(id).path("action").postEntity(action, ConsoleOutput.class);
		}

	}
	
	public static GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}

	
}
