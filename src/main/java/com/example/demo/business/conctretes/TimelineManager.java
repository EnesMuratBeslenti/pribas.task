package com.example.demo.business.conctretes;

import com.example.demo.business.abstracts.TimelineService;
import com.example.demo.data.acsess.concretes.TimelineDao;
import com.example.demo.entities.concretes.Timeline;
import com.example.demo.entities.concretes.User;
import com.example.demo.entities.dtos.TimelineDto;
import com.example.demo.result.DataResult;
import com.example.demo.result.ErrorDataResult;
import com.example.demo.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class TimelineManager implements TimelineService {

    private final TimelineDao timelineDao;

    @Autowired
    public TimelineManager(TimelineDao timelineDao) {
        this.timelineDao = timelineDao;
    }


    @Override
    public DataResult<Timeline> addTimeline(TimelineDto timelinedto) {
        if (!timelinedto.getTitle().isEmpty() &&
                !timelinedto.getDescription().isEmpty()) {

            Timeline timeline = new Timeline();
            timeline.setTitle(timelinedto.getTitle());
            timeline.setDescription(timelinedto.getDescription());
            timeline.setLocalDate(LocalDate.now());
            timeline.setTags(timelinedto.getTags());
            User user = new User();
            user.setUserId(timelinedto.getUserId());
            timeline.setUser(user);
            return  new SuccessDataResult<>(this.timelineDao.save(timeline));
        }
        else {
            return  new ErrorDataResult<>("Lütfen boş bırakmayınız");
        }

    }

    @Override
    public DataResult<Timeline> deleteTimeline(TimelineDto timelinedto) {
        return null;
    }

    @Override
    public DataResult<Timeline> updateTimeline(TimelineDto timelinedto) {
        return null;
    }
}


