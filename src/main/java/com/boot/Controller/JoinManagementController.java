package com.boot.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.DTO.NoticeDTO;
import com.boot.Service.JoinManagementService;
import com.boot.Service.JoinService;
import com.boot.Service.LoginService;
import com.boot.Service.ResumeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JoinManagementController {
	
	@Autowired
	ResumeService resumeService;	
	@Autowired
	private JoinService joinService;	
	@Autowired
	private LoginService loginService;
	@Autowired
	private JoinManagementService joinManagementService;
	
	// 개인 - 입사지원관리
	@RequestMapping("/joinManagementList")
	public String joinManagementList(Model model, HttpServletRequest request) 
	{
		log.info("@# joinManagementList");
		// 세션에 이메일 담아서 쓰는 법
		HttpSession session = request.getSession();		
		String login_email = (String)session.getAttribute("login_email");
		ArrayList<NoticeDTO> noticeDTO = joinManagementService.joinManagementList(login_email);
		
		
		model.addAttribute("joinManagementList",noticeDTO);
		
		SimpleDateFormat dataformat = new SimpleDateFormat("YYYY-MM-DD");
		
		
		return "joinManagementList";
	}
	
}
