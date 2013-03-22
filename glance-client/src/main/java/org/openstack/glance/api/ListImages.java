package org.openstack.glance.api;

import org.openstack.common.client.OpenStackTarget;
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
	public Images execute(OpenStackTarget target) {
		String path = detail ? "images/detail" : "images";
		return target.path(path).get(Images.class);
	}

}
