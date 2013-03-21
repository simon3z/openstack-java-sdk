package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.OpenStackCommand;

import org.openstack.glance.model.Images;

public class ListImages implements OpenStackCommand<Images> {

	boolean detail;
	
	public ListImages(boolean detail) {
		this.detail = detail;
	}
	
	public ListImages() {
		this(false);
	}

	@Override
	public Images execute(WebTarget target) {
		String path = detail ? "images/detail" : "images";
		return target.path(path).request(MediaType.APPLICATION_JSON).get(Images.class);
	}

}
