package com.boot.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.DAO.recentNoticeDAO;
import com.boot.DTO.BoardDTO;
import com.boot.DTO.ComNoticeDTO;
import com.boot.DTO.CompanyInfoDTO;
import com.boot.DTO.JoinDTO;
import com.boot.DTO.LoginDTO;
import com.boot.DTO.ResumeDTO;
import com.boot.DTO.UserDTO;
import com.boot.Service.ComNoticeService;
import com.boot.Service.CompanyInfo;
import com.boot.Service.IndividualService;
import com.boot.Service.JoinService;
import com.boot.Service.LoginServiceImpl;
import com.boot.Service.ResumeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class individualController {
	
	@Autowired
	private IndividualService serivce;
	
	@Autowired
	private JoinService joinService;
	
	@Autowired
	private CompanyInfo comService;
		
	
	@RequestMapping("/individualMain")//개인 마이페이지 메인으로
	public String individualMain(Model model) {
		log.info("@# individualMain");		
		
		return "individualMain";
	}
	
	@RequestMapping("/jobOffer")//받은 제안
	public String individualJobOffer(Model model){
		log.info("@# individualMain");		
		
		return "individualJobOffer";
	}
		
	
	
	
	@RequestMapping("/interComlist")//관심기업
	public String individualInterComlist(HttpServletRequest request, Model model) {
		log.info("@# individualInterComlist");		
//		
//		HttpSession session = request.getSession();
//		String user_email = (String)session.getAttribute("login_email");
//		
//		UserDTO dto = serivce.getUserInfo(user_email);
//		log.info("@# individualInterComlist dto=>"+dto);
//		
//		String comScrapArray = dto.getComScrapArray();
//		
//		// 사용자정보의 관심기업 목록 가져오기
//		CompanyInfoDTO dto = comService.getRecentNoticeList(recent_noticeNumArr);
//		log.info("@# recentNotice recent_notice list=>"+list);		
//		
//
//		// 쉼표로 구분된 문자열을 정수 리스트로 변환
//		List<Integer> noticeArr = Arrays.stream(recent_noticeNumArr.split(","))
//				.map(String::trim)          // 각 문자열의 양쪽 공백 제거
//				.map(Integer::parseInt)     // 문자열을 정수로 변환
//				.collect(Collectors.toList());
//		log.info("@# getRecentNoticeList noticeArr=>"+noticeArr);
//		
//		
//		// noticeArr 번호를 하나하나씩 넣어서 쿼리 실행
//		ArrayList<ComNoticeDTO> list = new ArrayList<>();
//		
//		recentNoticeDAO dao = sqlSession.getMapper(recentNoticeDAO.class);
//		
//		 for (int noticeNum : noticeArr) {
//			 CompanyInfoDTO dto = dao.getRecentNotice(noticeNum);
//	            list.add(dto);
//			log.info("@# getRecentNoticeList list=>"+list);
//	     }
		
		
		return "individualInterComlist";
	}
	@RequestMapping("/userInfo")//회원정보수정 메뉴 > 회원정보 확인
	public String individualUserInfo(@RequestParam HashMap<String, String> param, HttpServletRequest request, Model model) {
	
		log.info("@# individualUserInfo");
		HttpSession session = request.getSession();
		String user_email = (String)session.getAttribute("login_email");
		
		UserDTO dto = serivce.getUserInfo(user_email);
		log.info("@# individualUserInfo dto=>"+dto);
		model.addAttribute("userInfo", dto);
		
		return "individualUserInfo";
	}
	@RequestMapping("/modifyPage")//회원정보수정 페이지
	public String individualModifyInfo(@RequestParam HashMap<String, String> param,HttpServletRequest request, Model model) {
		
		log.info("@# individualModifyInfo");
		HttpSession session = request.getSession();
		String user_email = (String)session.getAttribute("login_email");
		
		UserDTO dto = serivce.getUserInfo(user_email);
		log.info("@# individualModifyInfo dto=>"+dto);
		model.addAttribute("userInfo", dto);
		
		return "individualUserInfoModify";
	}

	@RequestMapping("/userInfoModifyPop")
	public String userInfoModifyPop(@RequestParam HashMap<String, String> param, Model model) 
	{
		log.info("@# joinPop2로 넘어옴");	
		
		
		List<JoinDTO> job = joinService.job();		
		model.addAttribute("job_name", job);
		
		List<JoinDTO> job2 = joinService.job2();		
		model.addAttribute("job_name2", job2);
		
		List<JoinDTO> job3 = joinService.job3();		
		model.addAttribute("job_name3", job3);
		
		
		
		return "userInfoModifyPop";
	}
	
	@RequestMapping("/userInfoModifyPop2")
	public String userInfoModifyPop2(@RequestParam HashMap<String, String> param, Model model) 
	{
		log.info("@# joinPop로 넘어옴");	
		
		List<JoinDTO> stack =  joinService.stack();		
		model.addAttribute("stack_name", stack);
		
		List<JoinDTO> stack2 = joinService.stack2();		
		model.addAttribute("stack_name2", stack2);
		
		List<JoinDTO> stack3 = joinService.stack3();				
		model.addAttribute("stack_name3", stack3);
		
		
		return "userInfoModifyPop2";
	}
	
	
	
	
	@RequestMapping("/modifyInfo")//회원정보수정하기
	public String individualUserInfoModify(@RequestParam HashMap<String, String> param, HttpServletRequest request, Model model){ 
	
		log.info("@# individualUserInfoModify");	
		log.info("@# individualUserInfoModify param =>" +param);	
		
//		String input_pw = request.getParameter("input_pw");
//        String session_pw = request.getParameter("session_pw");
        String input_pw = param.get("input_pw");
        String session_pw = param.get("session_pw");
        
		log.info("@# individualUserInfoModify session_pw =>"+input_pw);//세션 pw화인
		log.info("@# individualUserInfoModify input_pw =>"+session_pw);//사용자가 입력한 pw화인
		
//		serivce.modify(param);		
//		
//		UserDTO newDTO = serivce.getUserInfo(request.getParameter("user_email"));	
//		log.info("@# individualUserInfoModify newDTO=>"+newDTO);
//		model.addAttribute("userInfo", newDTO);//업데이트 한 새 정보를 다시 모델에 담아서 넘겨줌
//		
//		return "individualUserInfo";
		
		
			if (input_pw == session_pw) {//입력한 비번이 세션의 비번과 같으면 
				
				serivce.modify(param); //회원정보 update	
				
				UserDTO newDTO = serivce.getUserInfo(param.get("user_email"));	
				log.info("@# individualUserInfoModify newDTO=>"+newDTO);
				model.addAttribute("userInfo", newDTO);//업데이트 한 새 정보를 다시 모델에 담아서 넘겨줌
				
				return "individualUserInfo";
			}else {//입력한 비번이 세션의 비번과 다르면 다시 회원정보 수정페이지로
				log.info("@# 실패 ㅠㅠ");
				
//				return "/alert";
				return "redirect:individualUserInfo";
			}
		}
		
		
	
	
	
	
	
	
}
