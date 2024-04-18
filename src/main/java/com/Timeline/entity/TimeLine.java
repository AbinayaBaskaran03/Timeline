package com.Timeline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_timeline_keas")
public class TimeLine {

	@Id
	@Column(name = "timeline")
	private String timeLine;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;
}
