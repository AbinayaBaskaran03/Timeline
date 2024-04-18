package com.Timeline.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Timeline.Dto.TimelineDto;
import com.Timeline.entity.TimeLine;

@Repository
public class TimelineDao {
	@Autowired
	SessionFactory sessionFactory;
	
	

	 public List<TimelineDto> getAll() {
		 try {
	Session session = sessionFactory.getCurrentSession();

		String selectquery = "SELECT t.timeline, t.start_date,t.end_date FROM tb_timeline_keas t  ";

		Query queryObj = session.createSQLQuery(selectquery);
		List<Object[]> rows = queryObj.list();
		List<TimelineDto> list = new ArrayList<>();
		
		for (Object[] row : rows) {
			TimelineDto obj = new TimelineDto();

			obj.setTimeLine(row[0] != null ? row[0].toString() : null);
			//obj.setStartDate(row[1] != null ? row[1].toString() : null);
			obj.setEndDate(row[2] != null ? row[2].toString() : null);
			list.add(obj);
		}

		return list;
	
		  
	}catch(Exception e) {
		e.printStackTrace();
		throw e;
	}
	}
}
	
//     System.out.println("+++++++++++++++");
//     Criteria crit = sessionFactory.getCurrentSession().createCriteria(TimeLine.class);
//     System.out.println("..............");
//     List<TimeLine> list = crit.list();
//     System.out.println("///////////////");
//     return list;
// }
//	