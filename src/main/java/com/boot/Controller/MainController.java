package com.boot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@RequestMapping("/main")
	public String main() {
		log.info("main!!!!!!");
//		String user_email ="tls123";
//		int user_type = 1;

//		HttpSession session = request.getSession();
//		LoginDTO dto = (LoginDTO) session.getAttribute("user_email");
//		return "login_ok";
		return "main";
	};
}
