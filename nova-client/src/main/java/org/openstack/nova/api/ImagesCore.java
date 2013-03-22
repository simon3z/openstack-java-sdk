package org.openstack.nova.api;

import java.util.Map;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.nova.model.Image;
import org.openstack.nova.model.Images;
import org.openstack.nova.model.Metadata;

public class ImagesCore {
	
	public static class ListImages implements OpenStackCommand<Images> {

		boolean detail;
		
		public ListImages(boolean detail) {
			this.detail = detail;
		}
		
		public ListImages() {
			this(false);
		}

		@Override
		public Images execute(OpenStackTarget target) {
			String path = detail ? "images/detail" : "images";
			return target.path(path).get(Images.class);
		}

	}
	
	public static class ShowImage implements OpenStackCommand<Image> {

		private String id;
		
		public ShowImage(String id) {
			this.id = id;
		}

		@Override
		public Image execute(OpenStackTarget target) {
			return target.path("images").path(id).get(Image.class);
		}
		
	}

	public static class ShowImageMetadata implements OpenStackCommand<Map<String, String>> {

		private String id;
		
		public ShowImageMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(OpenStackTarget target) {
			Metadata metadata = target.path("images").path(id).path("metadata").get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}


	public static class DeleteImage implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteImage(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackTarget target) {
			target.path("images").path(id).delete();
			return null;
		}
		
	}
	
	public static ListImages listImages(boolean detail) {
		return new ListImages(detail);
	}

	public static ListImages listImages() {
		return listImages(false);
	}
	
	public static ShowImage showImage(String id) {
		return new ShowImage(id);
	}
	
	public static ShowImageMetadata showImageMetadata(String id) {
		return new ShowImageMetadata(id);
	}
	
	public static DeleteImage deleteImage(String id) {
		return new DeleteImage(id);
	}
	
}
