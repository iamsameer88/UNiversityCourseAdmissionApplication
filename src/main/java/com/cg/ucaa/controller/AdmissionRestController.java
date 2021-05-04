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

import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.service.IAdmissionService;


@RestController
@RequestMapping("/admissions")
public class AdmissionRestController {
	
	@Autowired
	private IAdmissionService admissionService;
	
	@GetMapping
	public ResponseEntity<String> defaultAction(){
		return new ResponseEntity<>("welcome",HttpStatus.OK);
	}
	
	/*
	 * to retrieve all admissions
	 * return: List<AdmissionModel>
	 * */
	@GetMapping("/all")
	public ResponseEntity<List<AdmissionModel>> findAllAction(){
		return new ResponseEntity<>(admissionService.viewAllAdmissions(),HttpStatus.OK);
	}
	
	
	/*
	 * to retrieve admission by id
	 * return type: AdmissionModel
	 * param: admissionId
	 * */
	@GetMapping("/id/{admissionId}")
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
	
	/*
	 * to add a new admission
	 * return type: AdmissionModel 
	 * param: AdmissionModel Object
	 * */
	@PostMapping("/add")
	public ResponseEntity<AdmissionModel> createAdmission(@RequestBody AdmissionModel admission) throws AdmissionNotGrantedException{
		admission = admissionService.addAdmission(admission);
		return new ResponseEntity<>(admission,HttpStatus.CREATED);
		
	}
	
	/*
	 * to update existing object
	 * return type: AdmissionModel
	 * param: AdmissionModel
	 * */
	@PutMapping("/{admissionId}")
	public ResponseEntity<AdmissionModel> updateAdmission(@RequestBody AdmissionModel admission) throws AdmissionNotGrantedException{
		admission = admissionService.updateAdmission(admission);
		return new ResponseEntity<>(admission,HttpStatus.OK);
	}
	
	/*
	 * to delete an admission
	 * param: admissionId */
	@DeleteMapping("/admissionId{admissionId}")
	public ResponseEntity<Boolean> deleteAdmission(@PathVariable ("admissionId") Long admissionId) throws AdmissionNotGrantedException{
		Boolean result = admissionService.removeAdmission(admissionId);
		ResponseEntity<Boolean> response = new ResponseEntity<>(result,HttpStatus.OK);
		return response;
	}
	
//	@GetMapping("/date/{admissionDate}")
//	public ResponseEntity<List<AdmissionModel>> findByDateAction(@PathVariable("admissionDate") LocalDate admissionDate) throws AdmissionNotGrantedException{
//		ResponseEntity<List<AdmissionModel>> response = null;
//		List<AdmissionModel> admission = admissionService.showAllAdmissionsByDate(LocalDate.parse(admissionDate));
//		if(admission == null) {
//			response = new ResponseEntity<List<AdmissionModel>>(admission,HttpStatus.NOT_FOUND);
//		} else {
//			response = new ResponseEntity<List<AdmissionModel>>(admission,HttpStatus.OK);
//		}
//		return response;
//	}
	
}
