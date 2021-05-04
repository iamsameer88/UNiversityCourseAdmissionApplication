package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.CourseEntity;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.repository.ICourseRepository;

@Service
public class EMParserCourse {
	
	@Autowired
	private ICourseRepository courseRepo;
	
	@Autowired
	private EMParserUniversityStaff parser;
	
	/**
	 * default constructor
	 */
	public EMParserCourse() {
		super();
		this.parser = new EMParserUniversityStaff();
	}

	/**
	 * parameterized constructor
	 * @param courseRepo
	 */
	public EMParserCourse(ICourseRepository courseRepo) {
		super();
		this.courseRepo = courseRepo;
		this.parser = new EMParserUniversityStaff();
	}

	public CourseEntity parse(CourseModel source) {
		return source == null ? null
				: new CourseEntity(source.getCourseId(),source.getCourseName(),source.getCourseDuration(),source.getCourseStartDate(),
					source.getCourseEndDate(),source.getCourseFees(),parser.parse(source.getUniversityStaffMember()));
	}
	
	public CourseModel parse(CourseEntity source) {
		return source == null ? null
				: new CourseModel(source.getCourseId(),source.getCourseName(),source.getCourseDuration(),source.getCourseStartDate(),
					source.getCourseEndDate(),source.getCourseFees(),parser.parse(source.getUniversityStaffMember()));
	}
	
}