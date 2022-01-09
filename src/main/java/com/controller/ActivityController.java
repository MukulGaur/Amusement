package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Activity;
import com.service.ActivityService;

@RestController
@RequestMapping("/api")
public class ActivityController {
	
	@Autowired
	ActivityService activityService;
	
	@PostMapping("/insertActivity")
	public ResponseEntity<Activity> insertActivity(@RequestBody Activity activity){
		return new ResponseEntity<Activity>(activityService.insertActivity(activity), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllActivities")
	public List<Activity> getAllActivities(){
		return activityService.getAllActivities();
	}
	
	@GetMapping("/getActivityById/{activityId}")
	public ResponseEntity<Activity> getActivityById(@PathVariable int activityId){
		return new ResponseEntity<Activity>(activityService.getActivityById(activityId), HttpStatus.OK);
	}
	
	@PutMapping("/updateActivityById/{activityId}")
	public ResponseEntity<Activity> updateActivity(@PathVariable int activityId, @RequestBody Activity activity){
		return new ResponseEntity<Activity>(activityService.updateActivityById(activity, activityId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteActivityById/{activityId}")
	public ResponseEntity<String> deleteActivityById(@PathVariable int activityId){
		activityService.deleteActivityById(activityId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
