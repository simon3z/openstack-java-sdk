package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.Image;

public class UpdateImage implements OpenStackCommand<Image> {

	private Image image;
	
	public UpdateImage(Image image) {
		this.image = image;
	}
	
	@Override
	public Image execute(OpenStackTarget endpoint) {
		return endpoint.path("images").path(image.getId()).putEntity(image, Image.class);
	}

}
