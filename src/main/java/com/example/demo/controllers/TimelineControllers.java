package com.example.demo.controllers;


import com.example.demo.business.abstracts.TimelineService;
import com.example.demo.entities.concretes.Timeline;
import com.example.demo.entities.dtos.TimelineDto;
import com.example.demo.result.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "api/v1/timeline")
public class TimelineControllers {

    private final TimelineService timelineService;

    @Autowired
    public TimelineControllers(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @PostMapping(path = "/addTimeline")
    public ResponseEntity<?> addTimeline(@Valid @RequestBody TimelineDto timelineDto) {
        DataResult<Timeline> result = timelineService.addTimeline(timelineDto);
        if (!result.isSuccess()) {
            return new ResponseEntity<>(timelineDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
