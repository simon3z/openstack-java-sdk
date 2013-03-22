package org.openstack.nova.api.extensions;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Cloudpipe;
import org.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
	
	public static class ListCloudpipes implements OpenStackCommand<Cloudpipes> {

		@Override
		public Cloudpipes execute(OpenStackTarget target) {
			return target.path("os-cloudpipes").get(Cloudpipes.class);
		}

	}

	public static class CreateCloudpipe implements OpenStackCommand<Cloudpipe> {

		private Cloudpipe cloudpipe;
		
		public CreateCloudpipe(Cloudpipe cloudpipe) {
			this.cloudpipe = cloudpipe;
		}

		@Override
		public Cloudpipe execute(OpenStackTarget target) {
			return target.path("os-cloudpipes").postEntity(cloudpipe, Cloudpipe.class);
		}
		
	}

	public static ListCloudpipes listCloudpipes() {
		return new ListCloudpipes();
	}
	
	public static CreateCloudpipe createCloudpipe(Cloudpipe cloudpipe) {
		return new CreateCloudpipe(cloudpipe);
	}
	
}
