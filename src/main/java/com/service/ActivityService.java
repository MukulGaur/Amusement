package com.service;

import java.util.List;

import com.entity.Activity;

public interface ActivityService {
	
	public Activity insertActivity(Activity activity);
	public Activity updateActivityById(Activity activity, int activityId);
	public String deleteActivityById(int activityId);
	public List<Activity> getAllActivities();
	public Activity getActivityById(int activityId);
	
//	public List<Activity> viewActivitiesOfCharges(float charges);
//	public int countActivitiesOfCharges(float charges);

}
