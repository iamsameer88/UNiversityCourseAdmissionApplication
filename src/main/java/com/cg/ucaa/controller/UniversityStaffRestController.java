package com.cg.ucaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.exception.UniversityStaffMemberNotFoundException;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.models.UniversityStaffMemberModel;
import com.cg.ucaa.service.ICourseService;
import com.cg.ucaa.service.IUniversityStaffService;

@RestController
@RequestMapping(path = "/universitystaffs")
public class UniversityStaffRestController {

	@Autowired
	private IUniversityStaffService staffService;
	
	@Autowired
	private ICourseService courseService;
	
	/**
	 * Fetching all staff members
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<UniversityStaffMemberModel>> viewAllStaffs()
			throws UniversityStaffMemberNotFoundException {
		return new ResponseEntity<>(staffService.viewAllStaffs(), HttpStatus.OK);

	}

	/**
	 * Fetching staff by staff id
	 * @param staffId
	 * @return
	 */
	@GetMapping("/{staffId}")
	public ResponseEntity<UniversityStaffMemberModel> viewStaff(@PathVariable("staffId") Long staffId)
			throws UniversityStaffMemberNotFoundException {
		return ResponseEntity.ok(staffService.viewStaff(staffId));
	}
	
	
	/**
	 * Adding staff to University
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<UniversityStaffMemberModel> addStaff(@RequestBody UniversityStaffMemberModel staff)
			throws UniversityStaffMemberNotFoundException {
		ResponseEntity<UniversityStaffMemberModel> response = new ResponseEntity<UniversityStaffMemberModel>(
				staffService.addStaff(staff), HttpStatus.OK);

		return response;

	}
	
	/**
	 * Deleting staff by staff id
	 * @param staffId
	 * @return
	 */
	@DeleteMapping("/{staffId}")
	public ResponseEntity<Boolean> removeStaff(@PathVariable("staffId") Long staffId)
			throws UniversityStaffMemberNotFoundException {
		Boolean result = staffService.removeStaff(staffId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Updating staff details of University
	 * @return
	 */
	@PutMapping("/{staffId}")
	public ResponseEntity<UniversityStaffMemberModel> updateStaff(@RequestBody UniversityStaffMemberModel staff)
			throws UniversityStaffMemberNotFoundException {
		ResponseEntity<UniversityStaffMemberModel> response = new ResponseEntity<UniversityStaffMemberModel>(staffService.updateStaff(staff),
				HttpStatus.OK);
		return response;

	}
	
	/**
	 * Deleting course by course id
	 * @param courseId
	 * @return
	 */

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Boolean> removeCourse(@PathVariable("courseId") Long courseId)
			throws CourseNotFoundException {
		Boolean result = courseService.removeCourse(courseId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;

	}
	/**
	 * Adding course
	 * @return
	 */
	@PostMapping("/courses/add")
	public ResponseEntity<CourseModel> addCourse(@RequestBody CourseModel course) throws CourseNotFoundException {
		ResponseEntity<CourseModel> response = new ResponseEntity<CourseModel>(courseService.addCourse(course),
				HttpStatus.OK);
		return response;
	}

	/**
	 * Updating course details
	 * @return
	 */
	@PutMapping("/courses/{courseId}")
	public ResponseEntity<CourseModel> updateCourse(@RequestBody CourseModel course) throws CourseNotFoundException {
		ResponseEntity<CourseModel> response = new ResponseEntity<CourseModel>(courseService.updateCourse(course),
				HttpStatus.OK);
		return response;

	}

}
