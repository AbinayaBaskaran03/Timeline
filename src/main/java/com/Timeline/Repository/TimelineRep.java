package com.Timeline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Timeline.entity.TimeLine;

@Repository
public interface TimelineRep extends JpaRepository<TimeLine, String>{


}
