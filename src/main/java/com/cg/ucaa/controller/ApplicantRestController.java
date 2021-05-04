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

import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.service.IApplicantService;

@RestController
@RequestMapping(path = "/applicant")
public class ApplicantRestController {

	@Autowired
	private IApplicantService applicantService;

	/**
	 * Fetching applicant by applicant id
	 * @param applicantId
	 * @return
	 */	
	@GetMapping("/{applicantId}")
	public ResponseEntity<ApplicantModel> viewApplicant(@PathVariable("applicantId") Long applicantId)
			throws ApplicantNotFoundException {
		return ResponseEntity.ok(applicantService.viewApplicant(applicantId));
	}

	/**
	 * Fetching all applicants
	 * @return
	 */	
	@GetMapping
	public ResponseEntity<List<ApplicantModel>> viewAllApplicants()
			throws ApplicantNotFoundException {
		return new ResponseEntity<>(applicantService.viewAllApplicants(), HttpStatus.OK);

	}

	/**
	 * Deleting applicant by applicant id
	 * @param applicantId
	 * @return
	 */	
	@DeleteMapping("/{ApplicantId}")
	public ResponseEntity<Boolean> removeApplicant(@PathVariable("ApplicantId") Long applicantId)
			throws ApplicantNotFoundException {
		Boolean result = applicantService.removeApplicant(applicantId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Updating applicant details in applicant
	 * @return
	 */
	@PutMapping("/update/{applicantId}")
	public ResponseEntity<ApplicantModel> updateApplicant(@RequestBody ApplicantModel applicant) throws ApplicantNotFoundException {
		ResponseEntity<ApplicantModel> response = new ResponseEntity<ApplicantModel>(applicantService.updateApplicant(applicant),
				HttpStatus.OK);
		return response;

	}
	
	/**
	 * Adding new applicant to applicant
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<ApplicantModel> addApplicant(@RequestBody ApplicantModel Applicant)
			throws ApplicantNotFoundException {
		ResponseEntity<ApplicantModel> response = new ResponseEntity<ApplicantModel>(
				applicantService.registerApplicant(Applicant), HttpStatus.OK);
		
		return response;
		
	}
	
	
}