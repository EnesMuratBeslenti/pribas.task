package com.example.demo.data.acsess.concretes;

import com.example.demo.entities.concretes.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineDao extends JpaRepository<Timeline,Long> {

}
