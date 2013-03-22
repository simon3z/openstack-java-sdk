package org.openstack.ceilometer.v2.api;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Sample;
import org.openstack.common.client.OpenStackTarget;


public class MeterShow extends QueriableCeilometerCommand<MeterShow, List<Sample>> {

	private String name;
		
	public MeterShow name(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public List<Sample> execute(OpenStackTarget target) {
		if(name == null) {
			throw new UnsupportedOperationException("meter id is mandatory");
		}
		return query(target.path("meters").path(name)).getWebTarget()
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Sample>>() {});
	}

}