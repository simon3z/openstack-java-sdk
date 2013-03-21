package org.openstack.nova;

import org.openstack.common.client.AbstractOpenStackClient;

public class NovaClient extends AbstractOpenStackClient {
	
	public NovaClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

}
