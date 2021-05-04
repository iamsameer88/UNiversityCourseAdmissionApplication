package com.cg.ucaa.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.cg.ucaa.entities.AdmissionStatus;

public class AdmissionModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// generated value
	private Long admissionId;
	
	//Admission date cannot be a future date
	@PastOrPresent(message = "Admission Date cannot be a future date.")
	private LocalDate admissionDate;

	@NotEmpty(message = "status cannot be empty")
	@NotNull(message = "status cannot be null")
	@Enumerated(EnumType.STRING)
	private AdmissionStatus admissionStatus;
	
	private CourseModel course;
	
	private ApplicantModel applicant;
	
	private AdmissionCommiteeMemberModel admissionComMember;

	public AdmissionModel() {
		/*
		 * default constructor no implementation
		 */
	}

	public AdmissionModel(Long admissionId,
			@PastOrPresent(message = "Admission Date cannot be a future date.") LocalDate admissionDate,
			@NotEmpty(message = "status cannot be empty") @NotNull(message = "status cannot be null") AdmissionStatus admissionStatus,
			CourseModel course, ApplicantModel applicant, AdmissionCommiteeMemberModel admissionComMember) {
		super();
		this.admissionId = admissionId;
		this.admissionDate = admissionDate;
		this.admissionStatus = admissionStatus;
		this.course = course;
		this.applicant = applicant;
		this.admissionComMember = admissionComMember;
	}

	public AdmissionModel(Long admissionId,
			@PastOrPresent(message = "Admission Date cannot be a future date.") LocalDate admissionDate,
			@NotEmpty(message = "status cannot be empty") @NotNull(message = "status cannot be null") AdmissionStatus admissionStatus) {
		super();
		this.admissionId = admissionId;
		this.admissionDate = admissionDate;
		this.admissionStatus = admissionStatus;
	}

	public Long getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}

	public ApplicantModel getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantModel applicant) {
		this.applicant = applicant;
	}

	public AdmissionCommiteeMemberModel getAdmissionComMember() {
		return admissionComMember;
	}

	public void setAdmissionComMember(AdmissionCommiteeMemberModel admissionComMember) {
		this.admissionComMember = admissionComMember;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionComMember == null) ? 0 : admissionComMember.hashCode());
		result = prime * result + ((admissionDate == null) ? 0 : admissionDate.hashCode());
		result = prime * result + ((admissionId == null) ? 0 : admissionId.hashCode());
		result = prime * result + ((admissionStatus == null) ? 0 : admissionStatus.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdmissionModel other = (AdmissionModel) obj;
		if (admissionComMember == null) {
			if (other.admissionComMember != null)
				return false;
		} else if (!admissionComMember.equals(other.admissionComMember))
			return false;
		if (admissionDate == null) {
			if (other.admissionDate != null)
				return false;
		} else if (!admissionDate.equals(other.admissionDate))
			return false;
		if (admissionId == null) {
			if (other.admissionId != null)
				return false;
		} else if (!admissionId.equals(other.admissionId))
			return false;
		if (admissionStatus != other.admissionStatus)
			return false;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"AdmissionModel [admissionId=%s, admissionDate=%s, admissionStatus=%s, course=%s, applicant=%s, admissionComMember=%s]",
				admissionId, admissionDate, admissionStatus, course, applicant, admissionComMember);
	}

}