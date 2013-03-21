package org.openstack.ceilometer;

import org.openstack.common.client.AbstractOpenStackClient;

public class CeilometerClient extends AbstractOpenStackClient {
	
	public CeilometerClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

}
