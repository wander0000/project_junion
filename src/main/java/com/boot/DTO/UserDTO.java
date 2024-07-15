package com.boot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String user_email;
	private String user_pw;
	private String user_pw_check;
	private String user_name;
	private int user_profileNum;
	private String user_stack;
	private String user_position;
	private int user_questionNum;
	private String user_questionAnswer;
	private String user_tel;
	private char user_type;
	private String user_location;
	private String user_location2;
	private String user_birthdate;
	private String user_gender;
	private String recent_noticeNumArray;
	
	private int stack_no;
	private String stack_name;
	private int job_no;
	private String job_name;
}
