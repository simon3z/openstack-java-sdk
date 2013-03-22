package org.openstack.swift.api;

import java.io.InputStream;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.common.client.OpenStackTarget;
import org.openstack.common.command.OpenStackCommand;
import org.openstack.swift.model.ObjectDownload;

public class DownloadObject implements OpenStackCommand<ObjectDownload> {

	private String containerName;
	
	private String objectName;
	
	public DownloadObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public ObjectDownload execute(OpenStackTarget target) {
		Response response = target.getWebTarget().path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).get();
		ObjectDownload objectDownload = new ObjectDownload();
		objectDownload.setInputStream((InputStream) response.getEntity());
		return objectDownload;
	}

}
