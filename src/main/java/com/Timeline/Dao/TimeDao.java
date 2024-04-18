package com.Timeline.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;

import com.Timeline.Dto.TimelineDto;

public class TimeDao {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	 public List<TimelineDto> getAllTname() {
		 
	        String jpqlQuery = "SELECT DISTINCT  timel.timeline,\r\n"
	        		+ "	 timel.start_date, timel.end_date FROM tb_timeline_keas timel";

	        Query query = (Query) entityManager.createNativeQuery(jpqlQuery);

	        List<Object[]> rows = query.getResultList();
	        
	        List<TimelineDto> responseList = new ArrayList<>();
	        TimelineDto obj = null;
	        for (Object[] row : rows) {
	        	  obj = new TimelineDto();
	            obj.setTimeLine(row[0] != null ? row[0].toString() : null);
	            obj.setStartDate(row[1] != null ? row[1].toString() : null);
	            obj.setEndDate(row[2] != null ? row[2].toString() : null);
	            responseList.add(obj);
	        }
	        return responseList;

	}
}
