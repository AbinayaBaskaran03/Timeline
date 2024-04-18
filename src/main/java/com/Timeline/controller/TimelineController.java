package com.Timeline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Timeline.Dto.TimelineDto;
import com.Timeline.Service.TimelineService;
import com.Timeline.entity.TimeLine;

@RestController
@RequestMapping("/timeline")
public class TimelineController {
	@Autowired
	private TimelineService timelineService;

	@PostMapping("/create-date")
	public ResponseEntity<String> createTimeline(@RequestBody TimeLine timeLine) {
		timelineService.timelineschedule(timeLine);
		return ResponseEntity.ok("Timeline Created");
	}

	@PostMapping(value = "/getbydate")
	public ResponseEntity<TimeLine> getBytime(@RequestBody TimeLine timeLine) {
		try {
			timelineService.findbytime(timeLine);
			return ResponseEntity.ok(timeLine);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping(value = "/get")
	public String getTimelines(TimeLine TimeLine) {
		try {
			List<TimelineDto> timelines = timelineService.getAlltimelines();

			return "Timeline";
		} catch (Exception e) {

			return e.getMessage();
		}
	}
}

//
//	@GetMapping(value = "/get")
//	public ResponseEntity<TimeLine> getTimelines(TimeLine timeLineobj) {
//	    System.out.println("111111111111111");
//	    List<TimelineDto> timelines;
//	    try {
//	        timelines = timelineService.getAlldates();
//	        if (timeLineobj == null || timeLineobj.getTimeLine() == null || timeLineobj.getStartDate() == null
//	                || timeLineobj.getEndDate() == null) {
//	        	System.out.println("*************");
//	                return ResponseEntity.badRequest().body(timeLineobj);
//	            }
//	    } catch (Exception e) {
//	        System.err.println("Error: " + e.getMessage());
//	        e.printStackTrace();
//	    }
//	    return ResponseEntity.ok(timeLineobj); 
//}
