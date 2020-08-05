package com.bit2020.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2020.mysite.repository.UserRepository;
import com.bit2020.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void join(UserVo userVo) {
		// TODO Auto-generated method stub
		userRepository.save(userVo);
	}

	public UserVo getUser(UserVo vo) {
		// TODO Auto-generated method stub
		
		return userRepository.findByEmailAndPassWord(vo);
	}
	public UserVo getUser(Long no) {
		// TODO Auto-generated method stub
		UserVo userVo = userRepository.findByNo(no);
		return userVo;
	}

	public void updateUser(UserVo vo) {
		// TODO Auto-generated method stub
		userRepository.update(vo);
	}
}
