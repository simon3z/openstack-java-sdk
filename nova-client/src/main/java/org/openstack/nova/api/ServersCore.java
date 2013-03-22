package org.openstack.nova.api;

import java.util.Map;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Server;
import org.openstack.nova.model.ServerAction.ChangePassword;
import org.openstack.nova.model.ServerAction.ConfirmResize;
import org.openstack.nova.model.ServerAction.CreateImage;
import org.openstack.nova.model.ServerAction.Reboot;
import org.openstack.nova.model.ServerAction.Rebuild;
import org.openstack.nova.model.ServerAction.Resize;
import org.openstack.nova.model.ServerAction.RevertResize;
import org.openstack.nova.model.ServerForCreate;
import org.openstack.nova.model.Servers;

public class ServersCore {
	
	public static class ListServers implements OpenStackCommand<Servers> {
		
		boolean detail;
		
		public ListServers(boolean detail) {
			this.detail = detail;
		}
		
		public ListServers() {
			this(false);
		}

		@Override
		public Servers execute(OpenStackTarget target) {
			String path = detail ? "servers/detail" : "servers";
			return target.path(path).get(Servers.class);
		}

	}

	public static class CreateServer implements OpenStackCommand<Server> {

		private ServerForCreate serverForCreate;
		
		public CreateServer(ServerForCreate serverForCreate) {
			this.serverForCreate = serverForCreate;
		}

		@Override
		public Server execute(OpenStackTarget target) {
			return target.path("servers").postEntity(serverForCreate, Server.class);
		}
		
	}
	
	public static class ShowServer implements OpenStackCommand<Server> {

		private String id;
		
		public ShowServer(String id) {
			this.id = id;
		}

		@Override
		public Server execute(OpenStackTarget target) {
			return target.path("servers").path(id).get(Server.class);
		}
		
	}
	
	public static class ShowServerMetadata implements OpenStackCommand<Map<String, String>> {

		private String id;
		
		public ShowServerMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackTarget target) {
			Metadata metadata = target.path("servers").path(id).path("metadata").get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}
	
	public static class ShowServerAddresses implements OpenStackCommand<Server.Addresses> {

		private String id;
		
		public ShowServerAddresses(String id) {
			this.id = id;
		}

		@Override
		public Server.Addresses execute(OpenStackTarget target) {
			return target.path("servers").path(id).path("ips").get(Server.Addresses.class);
		}
		
	}


	
	public static class UpdateServer implements OpenStackCommand<Server> {

		private ServerForCreate serverForCreate;
		
		public UpdateServer(ServerForCreate serverForCreate) {
			this.serverForCreate = serverForCreate;
		}

		@Override
		public Server execute(OpenStackTarget target) {
			return target.path("servers").postEntity(serverForCreate, Server.class);
		}
		
	}

	
	public static class DeleteServer implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteServer(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).delete();
			return null;
		}
		
	}
	
	public static class ChangePasswordServer implements OpenStackCommand<Void> {
		
		private ChangePassword action;

		private String id;
		
		public ChangePasswordServer(String id, ChangePassword action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class RebootServer implements OpenStackCommand<Void> {
		
		private Reboot action;

		private String id;
		
		public RebootServer(String id, Reboot action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class RebuildServer implements OpenStackCommand<Void> {
		
		private final Rebuild action;

		private final String id;
		
		public RebuildServer(String id, Rebuild action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class ResizeServer implements OpenStackCommand<Void> {
		
		private final Resize action;

		private final String id;
		
		public ResizeServer(String id, Resize action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class ConfirmResizeServer implements OpenStackCommand<Void> {
		
		private static final ConfirmResize action = new ConfirmResize();

		private final String id;
		
		public ConfirmResizeServer(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class RevertResizeServer implements OpenStackCommand<Void> {
		
		private static final RevertResize action = new RevertResize();

		private final String id;
		
		public RevertResizeServer(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}
	
	public static class CreateImageServer implements OpenStackCommand<Void> {
		
		private CreateImage action;

		private String id;
		
		public CreateImageServer(String id, CreateImage action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("servers").path(id).path("action").postEntity(action);
			return null;
		}

	}

	
	public static ListServers listServers(boolean detail) {
		return new ListServers(detail);
	}
	
	public static ListServers listServers() {
		return listServers(false);
	}
	
	public static CreateServer createServer(ServerForCreate serverForCreate) {
		return new CreateServer(serverForCreate);
	}
	
	public static ShowServer showServer(String id) {
		return new ShowServer(id);
	}
	
	public static ShowServerMetadata showServerMetadata(String id) {
		return new ShowServerMetadata(id);
	}
	
	public static ShowServerAddresses showServerAddresses(String id) {
		return new ShowServerAddresses(id);
	}
	
	
	
	public static DeleteServer deleteServer(String id) {
		return new DeleteServer(id);
	}
	
	public static ChangePasswordServer changePassword(String id, String adminPass) {
		ChangePassword changePassword = new ChangePassword(adminPass);
		return new ChangePasswordServer(id, changePassword);
	}
	
	public static RebootServer reboot(String id, String type) {
		Reboot action = new Reboot();
		action.setType(type);
		return new RebootServer(id, action);
	}
	
	public static RebuildServer rebuild(String id, Rebuild rebuild) {
		return new RebuildServer(id, rebuild);
	}
	
	public static ResizeServer resize(String id, Resize action) {
		return new ResizeServer(id, action);
	}
	
	public static RevertResizeServer revertResize(String id) {
		return new RevertResizeServer(id);
	}
	
	public static ConfirmResizeServer confirmResize(String id) {
		return new ConfirmResizeServer(id);
	}
	
	public static CreateImageServer createImageServer(String id, CreateImage action) {
		return new CreateImageServer(id, action);
	}

}
