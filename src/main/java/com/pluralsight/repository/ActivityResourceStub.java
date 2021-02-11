package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityResourceStub implements ActivityRepository {
	@Override
	public void create(Activity activity) {
		// TODO Auto-generated method stub
		
	}
	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimimg");
		activity1.setDuration(55);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(60);
		
		activities.add(activity1);
		activities.add(activity2);
		
		return activities;
	}
	
	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("7777")) {
			return null;
		}
		
		Activity activity1 = new Activity();
		activity1.setActivityId(activityId);
		activity1.setDescription("Swimimg");
		activity1.setDuration(55);
		
		User user = new User();
		user.setId("068002");
		user.setName("Narasimha");
		activity1.setUser(user);
		
		return activity1;
	}
	
	@Override
	public Activity update(Activity activity) {
		// search the database with the activity with that id
		return activity;
		
	}
	
	@Override
	public Response delete(String id) {
		// delete activity using the activiy id
		
		return Response.ok().build();
		
	}
}
