package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.openstack.ceilometer.v1.model.MeterEvent;
import org.openstack.ceilometer.v1.model.MeterEvents;
import org.openstack.common.client.OpenStackTarget;

public class MeterList extends MeterCommand<List<MeterEvent>> {

	@Override
	public List<MeterEvent> execute(OpenStackTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} else if(project != null) {
			target = target.path("projects").path(project);
		} else if(user != null) {
			target = target.path("users").path(user);
		}
		return target.path("v1/meters").get(MeterEvents.class).getMeterEvents();
	}

}
