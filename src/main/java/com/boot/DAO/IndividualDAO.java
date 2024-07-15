package com.boot.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import com.boot.DTO.BoardDTO;
import com.boot.DTO.UserDTO;

//실행시 매퍼파일을 읽어 들이도록 지정
@Mapper
public interface IndividualDAO {
//	public ArrayList<UserDTO> list();
	public UserDTO getUserInfo(String user_email);
//	public UserDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
//	public void updateUserNoticeNum(String recentJobPostsStr, String user_email);
	public void updateUserNoticeNum(UserDTO userDTO);
//	public void delete(HashMap<String, String> param);

	
}
















