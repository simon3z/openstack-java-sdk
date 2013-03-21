package org.openstack.glance.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;
import org.openstack.glance.model.Image;

public class UpdateImage implements OpenStackCommand<Image> {

	private Image image;
	
	public UpdateImage(Image image) {
		this.image = image;
	}
	
	@Override
	public Image execute(WebTarget endpoint) {
		return endpoint.path("images").path(image.getId()).request(MediaType.APPLICATION_JSON).put(Entity.json(image), Image.class);
	}

}
