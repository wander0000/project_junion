package com.boot.Service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.DAO.JoinManagementDAO;
import com.boot.DTO.NoticeDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("JoinManagementService")
public class JoinManagementServiceImpl implements JoinManagementService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
//	public ResumeDTO resumeList(String login_email) {
	public ArrayList<NoticeDTO> joinManagementList(String login_email) {
		log.info("@# resumeList");
			
		JoinManagementDAO dao = sqlSession.getMapper(JoinManagementDAO.class);
		ArrayList<NoticeDTO> joinCompanyList = dao.joinManagementList(login_email);		
		
		return joinCompanyList;
	}


	

	
	
}
