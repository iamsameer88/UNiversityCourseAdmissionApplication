package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.entities.LoginEntity;
import com.cg.ucaa.exception.LoginFailedException;
import com.cg.ucaa.models.LoginModel;
import com.cg.ucaa.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginRepository loginRepo;

	@Autowired
	private EMParserLogin parser;
	
	/**
	 * default constructor
	 */
	public LoginServiceImpl() {

	}
	
	/**
	 * parameterized constructor
	 * @param loginRepo
	 */
	public LoginServiceImpl(ILoginRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
		this.parser = new EMParserLogin();
	}
	
	/**
	 * service implementation for validating credentials of an applicant
	 **/
	@Transactional
	@Override
	public String loginAsApplicant(LoginModel loginAsApplicant) throws LoginFailedException {
		LoginEntity logEn = loginRepo.findById(loginAsApplicant.getLoginId()).orElse(null);
		LoginModel logMod = parser.parse(logEn);

		if (logEn == null) {
			throw new LoginFailedException("Couldn't verify login, Applicant credential isn't correct");
		}

		Long userId = logMod.getLoginId();
		String userName = logMod.getUserName();
		String userPassword = logMod.getPassword();

		Long entityUserId = logEn.getLoginId();
		String entityUserName = logEn.getUserName();
		String entityUserPassword = logEn.getPassword();
		if (userId == entityUserId && userName.equals(entityUserName) && userPassword.equals(entityUserPassword)) {
			return "Login Successfull! " + logEn.getUserName() + " Welcome";
		}else
			throw new LoginFailedException("Login Unsuccessfull");

	}
	
	/**
	 * service implementation for validating credentials of committee member
	 **/
	@Transactional
	@Override
	public String loginAsAdmissionCommiteeMember(LoginModel loginAsMember) throws LoginFailedException {
		LoginEntity logEn = loginRepo.findById(loginAsMember.getLoginId()).orElse(null);
		LoginModel logMod = parser.parse(logEn);

		if (logEn == null) {
			throw new LoginFailedException("Admission Commitee cannot verify the login, credentials isn't correct");
		}

		Long userId = logMod.getLoginId();
		String userName = logMod.getUserName();
		String userPassword = logMod.getPassword();

		Long entityUserId = logEn.getLoginId();
		String entityUserName = logEn.getUserName();
		String entityUserPassword = logEn.getPassword();
		if (userId == entityUserId && userName.equals(entityUserName) && userPassword.equals(entityUserPassword)) {
			return "Login Successfull! " + logEn.getUserName() + " Welcome";
		}else
			throw new LoginFailedException("Login Unsuccessfull");
	}
	
	/**
	 * service implementation for validating credentials of staff member
	 **/
	@Transactional
	@Override
	public String loginAsUniversityStaffMember(LoginModel loginAsStaff) throws LoginFailedException {
		LoginEntity logEn = loginRepo.findById(loginAsStaff.getLoginId()).orElse(null);
		LoginModel logMod = parser.parse(logEn);

		if (logEn == null) {
			throw new LoginFailedException("Couldn't verify login, Staff credential isn't correct");
		}

		Long userId = logMod.getLoginId();
		String userName = logMod.getUserName();
		String userPassword = logMod.getPassword();

		Long entityUserId = logEn.getLoginId();
		String entityUserName = logEn.getUserName();
		String entityUserPassword = logEn.getPassword();
		if (userId == entityUserId && userName.equals(entityUserName) && userPassword.equals(entityUserPassword)) {
			return "Login Successfull! " + logEn.getUserName() + " Welcome";
		}else
			throw new LoginFailedException("Login Unsuccessfull");

	}
	
	/**
	 * to be  implemented using front end
	 * @return
	 */
	@Transactional
	@Override
	public boolean logOut(LoginModel login) {
		return false;
	}

}
