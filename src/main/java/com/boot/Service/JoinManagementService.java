package com.boot.Service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.boot.DTO.BoardDTO;
import com.boot.DTO.LoginDTO;
import com.boot.DTO.NoticeDTO;
import com.boot.DTO.ResumeDTO;
import com.boot.DTO.UserDTO;


public interface JoinManagementService {
	
	// 입사지원 목록
	public ArrayList<NoticeDTO> joinManagementList(String login_email);

	
}
