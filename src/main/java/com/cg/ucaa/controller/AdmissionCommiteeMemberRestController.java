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

import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.service.IAdmissionCommiteeMemberService;
import com.cg.ucaa.service.IAdmissionService;

@RestController
@RequestMapping(path = "/admissioncommiteemember")
public class AdmissionCommiteeMemberRestController {

	@Autowired
	private IAdmissionCommiteeMemberService AdmissionCommiteeMemberService;
	
	@Autowired
	private IAdmissionService admissionService;

	/**
	 * Fetching Committee members by admin id
	 * @param adminId
	 * @return
	 */
	
	@GetMapping("/{adminId}")
	public ResponseEntity<AdmissionCommiteeMemberModel> viewAdmissionCommiteeMember(@PathVariable("adminId") Long adminId)
			throws AdmissionCommiteeMemberNotFoundException {
		return ResponseEntity.ok(AdmissionCommiteeMemberService.viewCommiteeMember(adminId));
	}

	/**
	 * Fetching all committee members
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<AdmissionCommiteeMemberModel>> viewAllAdmissionCommiteeMember()
			throws AdmissionCommiteeMemberNotFoundException {
		return new ResponseEntity<>(AdmissionCommiteeMemberService.viewAllCommiteeMembers(), HttpStatus.OK);

	}

	
	/**
	 * Deleting Committee member by admin id
	 * @param adminId
	 * @return
	 */	
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Boolean> removeCommiteeMember(@PathVariable("adminId") Long adminId)
			throws AdmissionCommiteeMemberNotFoundException {
		Boolean result = AdmissionCommiteeMemberService.removeCommiteeMember(adminId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}


	/**
	 * Adding committee member to Admission Commitee
	 * @return
	 */	
	@PostMapping("/add")
	public ResponseEntity<AdmissionCommiteeMemberModel> addCommiteeMember(@RequestBody AdmissionCommiteeMemberModel admin)
			throws AdmissionCommiteeMemberNotFoundException {
		ResponseEntity<AdmissionCommiteeMemberModel> response = new ResponseEntity<AdmissionCommiteeMemberModel>(
				AdmissionCommiteeMemberService.addCommiteeMember(admin), HttpStatus.OK);

		return response;

	}
	
	/**
	 * Updating staff details of University
	 * @return
	 */
	@PutMapping("/{adminId}")
	public ResponseEntity<AdmissionCommiteeMemberModel> updateCommiteeMember(@RequestBody AdmissionCommiteeMemberModel commiteeMember)
			throws AdmissionCommiteeMemberNotFoundException {
		ResponseEntity<AdmissionCommiteeMemberModel> response = new ResponseEntity<AdmissionCommiteeMemberModel>(AdmissionCommiteeMemberService.updateCommiteeMember(commiteeMember),
				HttpStatus.OK);
		return response;

	}
	@GetMapping("admission/{admissionId}")
	public ResponseEntity<AdmissionModel> findByIdAction(@PathVariable("admissionId") Long admissionId) throws AdmissionNotGrantedException{
		ResponseEntity<AdmissionModel> response = null;
		AdmissionModel admission = admissionService.viewByAdmissionId(admissionId);
		if(admission == null) {
			response = new ResponseEntity<>(admission,HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(admission,HttpStatus.OK);
		}
		return response;
	}

}
