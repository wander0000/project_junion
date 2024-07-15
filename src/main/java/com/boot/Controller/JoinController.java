package com.boot.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.DTO.JoinDTO;
import com.boot.Service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	// 회원가입 선택 개인or기업
	@RequestMapping("/joinSelect")
	public String joinSelect() 
	{
		log.info("@# joinSelect");		
		
		return "joinSelect";
	}
	
	// 개인 1단계
	@RequestMapping("/joinIndividual")
	public String joinIndividual() 
	{
		log.info("@# joinIndividual");
		
		
		return "joinIndividual";
	}		

	
	// 중복 이메일 확인
	@PostMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(@RequestParam("user_email") String user_email) 
	{
		log.info("@# emailCheck");
		int result = joinService.emailCheck(user_email);
		
		return result;
	}
		
	// 가입확인
	@RequestMapping("/joinOk")
	public String joinOk(@RequestParam HashMap<String, String> param, Model model) 
	{
		log.info("@# joinOk");		
		
		log.info("@# param 1 : 날리기전 " + param);
		model.addAttribute("user_email", param.get("user_email"));		
		
		joinService.join(param);
		log.info("@# param 2 : 날린 후" + param);		
			
		return "joinIndividualTwo";
//		return null;
//		return "redirect:joinIndividualTwo?user_email=${user_email}";
	}
	
	// 가입확인
	@RequestMapping("/joinIndividualTwo")
	public String joinIndividualTwo(@RequestParam HashMap<String, String> param, Model model) 
//	public void joinIndividualTwo(@RequestParam HashMap<String, String> param) 
	{
		log.info("@# joinIndividualTwo로 넘어옴");		
		log.info("@# param3 2단계==>" + param);
//				model.addAttribute(null, param.);
				
		joinService.modify(param);		
		
		return "login";
//		return "joinIndividualTwo";
	}
	
	@RequestMapping("/joinPop")
	public String Pop(@RequestParam HashMap<String, String> param, Model model) 
	{
		log.info("@# joinPop로 넘어옴");	
		
		List<JoinDTO> stack = joinService.stack();		
		model.addAttribute("stack_name", stack);
		
		List<JoinDTO> stack2 = joinService.stack2();		
		model.addAttribute("stack_name2", stack2);
		
		List<JoinDTO> stack3 = joinService.stack3();		
		model.addAttribute("stack_name3", stack3);
		
		log.info("@# joinIndividualTwo stack 단계==>" + stack);
		
		return "joinPop";
	}
	
	@RequestMapping("/joinPop2")
	public String Pop2(@RequestParam HashMap<String, String> param, Model model) 
	{
		log.info("@# joinPop2로 넘어옴");	
		
		
		List<JoinDTO> job = joinService.job();		
		model.addAttribute("job_name", job);
		
		List<JoinDTO> job2 = joinService.job2();		
		model.addAttribute("job_name2", job2);
		
		List<JoinDTO> job3 = joinService.job3();		
		model.addAttribute("job_name3", job3);
		
		
		
		return "joinPop2";
	}
	
	
	
	
}
