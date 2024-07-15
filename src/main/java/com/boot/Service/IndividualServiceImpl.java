package com.boot.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.DAO.BoardDAO;
import com.boot.DAO.IndividualDAO;
import com.boot.DTO.BoardDTO;
import com.boot.DTO.UserDTO;
import com.mysql.cj.Session;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("IndividualService")
public class IndividualServiceImpl implements IndividualService{
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Override
	//세션에 있는 정보를 이용해서 userDTO 가져오기
	public UserDTO getUserInfo(String user_email) {
		
		log.info("@# IndividualServiceImpl getUserInfo");
		
		IndividualDAO dao = sqlSession.getMapper(IndividualDAO.class);
		UserDTO userDTO = dao.getUserInfo(user_email);
		
		log.info("@# userDTO=>"+userDTO);
		return userDTO;
		
	}



	@Override
	public void modify(HashMap<String, String> param) {
		log.info("@# IndividualServiceImpl modify");
		
		IndividualDAO dao = sqlSession.getMapper(IndividualDAO.class);
		dao.modify(param);
	}



	@Override
//	public void updateUserNoticeNum(String recentJobPostsStr, String user_email) {
	public void updateUserNoticeNum(UserDTO userDTO) {
		log.info("@# IndividualServiceImpl updateUserNoticeNum");
//		log.info("@# IndividualServiceImpl user_email =>"+user_email);
//		log.info("@# IndividualServiceImpl recentJobPostsStr =>"+recentJobPostsStr);
		
		IndividualDAO dao = sqlSession.getMapper(IndividualDAO.class);
//		dao.updateUserNoticeNum(recentJobPostsStr, user_email);
		dao.updateUserNoticeNum(userDTO);
		
	}



}







