package com.cg.ucaa.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.models.AdmissionModel;

public interface IAdmissionService {
	AdmissionModel addAdmission(AdmissionModel admission) throws AdmissionNotGrantedException;
	AdmissionModel updateAdmission(AdmissionModel admission) throws AdmissionNotGrantedException;
	boolean removeAdmission(Long admissionId) throws AdmissionNotGrantedException;
	
	AdmissionModel viewByAdmissionId(Long admissionId) throws AdmissionNotGrantedException;
	List<AdmissionModel> viewAllAdmissions();
	
	public List<AdmissionModel> showAllAdmissionsByCourseId(int courseId) throws CourseNotFoundException;
	public List<AdmissionModel> showAllAdmissionsByDate(LocalDate admissionDate) throws AdmissionNotGrantedException;
	
}