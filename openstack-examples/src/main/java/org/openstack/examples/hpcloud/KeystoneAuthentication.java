package org.openstack.examples.hpcloud;

import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;

public class KeystoneAuthentication {
	
	private static final String KEYSTONE_AUTH_URL = "https://region-a.geo-1.identity.hpcloudsvc.com:35357/v2.0";
	
	private static final String KEYSTONE_USERNAME = "";
	
	private static final String KEYSTONE_PASSWORD = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(KEYSTONE_AUTH_URL);
		
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(KEYSTONE_USERNAME, KEYSTONE_PASSWORD));
		
		System.out.println(access);

	}

}
