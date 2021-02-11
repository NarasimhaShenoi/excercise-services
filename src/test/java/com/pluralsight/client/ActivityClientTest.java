package com.pluralsight.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;

public class ActivityClientTest {

	@Test
	public void testPut() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Test put");
		activity.setDuration(60);
		activity.setActivityId("40");
		activity = client.update(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Swiming");
		activity.setDuration(60);
		activity = client.create(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity =  client.get("1234");
		System.out.println(activity);
		assertNotNull(activity);
	}

	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activity =  client.get();
		System.out.println(activity);
		assertNotNull(activity);
	}
	
	@Test //(expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("123");
	}
	
	@Test //(expected=RuntimeException.class)
	public void testGetWithNotFound() {
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}
	
	@Test
	public void testDelete() {
		ActivityClient client = new ActivityClient();
		client.delete("1234");
	}
}
