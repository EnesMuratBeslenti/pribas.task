package com.example.demo.business.abstracts;

import com.example.demo.entities.concretes.Timeline;
import com.example.demo.entities.dtos.TimelineDto;
import com.example.demo.result.DataResult;

import javax.xml.crypto.Data;
import java.sql.Time;

public interface TimelineService {
    DataResult<Timeline> addTimeline(TimelineDto timelinedto);
    DataResult<Timeline> deleteTimeline(TimelineDto timelinedto);
    DataResult<Timeline> updateTimeline(TimelineDto timelinedto);
}
