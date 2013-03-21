package org.openstack.glance;

import org.openstack.common.client.AbstractOpenStackClient;

public class GlanceClient extends AbstractOpenStackClient {
	
	public GlanceClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

}
