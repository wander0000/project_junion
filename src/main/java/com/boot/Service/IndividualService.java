package com.boot.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.boot.DTO.BoardDTO;
import com.boot.DTO.UserDTO;

public interface IndividualService {
//	public ArrayList<UserDTO> list();
	public UserDTO getUserInfo(String user_email);
//	public UserDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
//	public void updateUserNoticeNum(String recentJobPostsStr, String user_email);
	public void updateUserNoticeNum(UserDTO userDTO);
//	public void delete(HashMap<String, String> param);
}
