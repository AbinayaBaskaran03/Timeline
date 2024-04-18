package com.Timeline.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Timeline.Dao.TimeDao;
import com.Timeline.Dao.TimelineDao;
import com.Timeline.Dto.TimelineDto;
import com.Timeline.Repository.TimelineRep;
import com.Timeline.entity.TimeLine;

@Service

public class TimelineService {
	@Autowired
	private TimelineRep timelineRep;

	@Autowired
	private TimelineDao timelineDao;

	@Autowired
	private TimeDao timeDao;

//	@Autowired
//	SessionFactory sessionFactory;

	public void timelineschedule(TimeLine timeLine) {
		timelineRep.save(timeLine);
	}

	public List<TimelineDto> getAlldates() {
		return timelineDao.getAll();
	}


	public String findbytime(TimeLine timeLine) {

		TimelineDto timelineDto = new TimelineDto();
		timelineDto.setTimeLine(timeLine.getTimeLine());
		timelineDto.setEndDate(timeLine.getEndDate());
		try {
			ArrayList<LocalDate> dates = new ArrayList<LocalDate>();
			List<String> timeId = Arrays.asList("timeline_1", "timeline_2", "timeline_3", "timeline_4");

			outerLoop: for (String timelineName : timeId) {
				TimeLine timeObj = timelineRep.findById(timelineName).orElse(null);

				for (int i = 0; i <= timeId.size(); i++) {
					String tnames = timeId.get(i);
					if (tnames.equals(timelineDto.getTimeLine())) {
						TimeLine timesObj = timelineRep.findById(timelineDto.getTimeLine()).orElse(null);

						int j = timeId.indexOf(timelineDto.getTimeLine());

						System.out.println("size Of " + timelineDto.getTimeLine() + " is: " + j);

							for (int k = j; k <= timeId.size(); k--) {
								
							System.out.println("Before Timeline " + k);
							
							String beftname =  timeId.get(k);
							System.out.println("TNames :" + beftname);
                            if(k == 0) {
							break;
                                       }
						}
						String sdate = timesObj.getStartDate();
						String edate = timesObj.getEndDate();
						
						if (sdate != null && edate != null) {

							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

							LocalDate start = LocalDate.parse(sdate, dtf);
							LocalDate end = LocalDate.parse(edate, dtf);
							long difDate = ChronoUnit.DAYS.between(start.plusDays(1), end);
							System.out.println("*************************");

							System.out.println(
									"Days Between " + " " + timelineDto.getTimeLine() + " " + " is: " + difDate);
							System.out.println("**************************");

							if (timelineDto.getEndDate() != null) {

								LocalDate t3newendDate = LocalDate.parse(timelineDto.getEndDate(), dtf);
								long newdifDate = ChronoUnit.DAYS.between(LocalDate.parse(sdate, dtf),
										LocalDate.parse(edate, dtf));

								System.out.println("*************************");

								LocalDate t3newstartDate = t3newendDate.minusDays(newdifDate);

								System.out.println("Start date " + " " + "New" + timelineDto.getTimeLine() + " "
										+ "is : " + t3newstartDate);
								System.out.println("*************************");

								System.out.println("End Date " + " " + "New" + timelineDto.getTimeLine() + " "
										+ " is : " + t3newendDate);
								System.out.println("*************************");
								dates.add(t3newstartDate);
								dates.add(t3newendDate);

								break outerLoop;

							}
						} else {
							System.out.println("Start and End Null : ");
						}
					}

					else {
						System.out.println("Not Found : " + tnames);
					}
				}

				if (timeObj != null) {
					timelineRep.save(timeObj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "sdffgb";

	}

	public List<TimelineDto> getAlltimelines() {
				return timeDao.getAllTname();
	}
}

//	timeline_1 10-10-2023 14-10-2023
//	timeline_2 15-11-2023 17-11-2023
//	timeline_3 20-11-2023 22-11-2023
//	timeline_4 08-12-2023 11-12-2023
