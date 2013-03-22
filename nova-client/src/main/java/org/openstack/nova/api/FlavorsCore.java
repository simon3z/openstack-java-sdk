package org.openstack.nova.api;

import java.util.Map;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.Flavors;
import org.openstack.nova.model.Metadata;

public class FlavorsCore {
	
	public static class ListFlavors implements OpenStackCommand<Flavors> {

		boolean detail;
		
		public ListFlavors(boolean detail) {
			this.detail = detail;
		}
		
		public ListFlavors() {
			this(false);
		}

		@Override
		public Flavors execute(OpenStackTarget target) {
			String path = detail ? "flavors/detail" : "flavors";
			return target.path(path).get(Flavors.class);
		}

	}
	
	public static class ShowFlavor implements OpenStackCommand<Flavor> {

		private String id;
		
		public ShowFlavor(String id) {
			this.id = id;
		}

		@Override
		public Flavor execute(OpenStackTarget target) {
			return target.path("flavors").path(id).get(Flavor.class);
		}
		
	}

	
	public static class ShowFlavorMetadata implements OpenStackCommand<Map<String, String>> {

		private String id;
		
		public ShowFlavorMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackTarget target) {
			Metadata metadata = target.path("flavors").path(id).path("metadata").get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}
	
	public static ListFlavors listFlavors(boolean detail) {
		return new ListFlavors(detail);
	}
	
	public static ListFlavors listFlavors() {
		return listFlavors(false);
	}
	
	public static ShowFlavor showFlavor(String id) {
		return new ShowFlavor(id);
	}
	
	public static ShowFlavorMetadata showFlavorMetadata() {
		return new ShowFlavorMetadata("");
	}

}
