package org.openstack.nova.api.extensions;

import java.util.UUID;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.FlavorForCreate;

public class FlavorsExtension {
	
	public static class CreateFlavor implements OpenStackCommand<Flavor> {

		private FlavorForCreate flavorForCreate;
		
		public CreateFlavor(FlavorForCreate flavorForCreate) {
			this.flavorForCreate = flavorForCreate;
		}

		@Override
		public Flavor execute(OpenStackTarget target) {
			if(flavorForCreate.getId() == null) {
				flavorForCreate.setId(UUID.randomUUID().toString());
			}
			return target.path("flavors").postEntity(flavorForCreate, Flavor.class);
		}
		
	}

	public static class DeleteFlavor implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteFlavor(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("flavors").path(id).delete();
			return null;
		}
		
	}
	
	public static CreateFlavor createFlavor(FlavorForCreate flavorForCreate) {
		return new CreateFlavor(flavorForCreate);
	}
	
	public static DeleteFlavor deleteFlavor(String id) {
		return new DeleteFlavor(id);
	}
	
}
