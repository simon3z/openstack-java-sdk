package org.openstack.swift;

import org.openstack.common.client.AbstractOpenStackClient;

public class SwiftClient extends AbstractOpenStackClient {
	
	public SwiftClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

}
