package org.openstack.ceilometer.v2.api;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Meter;
import org.openstack.common.client.OpenStackTarget;

public class MeterList extends QueriableCeilometerCommand<MeterList,List<Meter>> {
		
	@Override
	public List<Meter> execute(OpenStackTarget target) {
		return query(target.path("meters")).getWebTarget()
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Meter>>() {});
	}

}