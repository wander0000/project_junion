package com.boot.DAO;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.boot.DTO.NoticeDTO;

@Mapper
public interface JoinManagementDAO {

	// 입사지원 목록
	public ArrayList<NoticeDTO> joinManagementList(String login_email);
}
