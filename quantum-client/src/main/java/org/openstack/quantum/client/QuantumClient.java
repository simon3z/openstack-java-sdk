package org.openstack.quantum.client;

import org.openstack.common.client.AbstractOpenStackClient;


public class QuantumClient extends AbstractOpenStackClient {

	public QuantumClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

}
