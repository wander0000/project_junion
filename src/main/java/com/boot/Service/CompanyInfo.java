package com.boot.Service;

import java.util.HashMap;
import java.util.List;

import com.boot.DTO.CompanyInfoDTO;
import com.boot.DTO.JoinDTO;

public interface CompanyInfo {
	public CompanyInfoDTO companyInfo(String email);//기업 정보 관리 페이지 뿌려질 내용
	public CompanyInfoDTO InfoMini(String email);//기업 기본정보 수정 페이지 이동
	public void modify_Info(HashMap<String, String> param);//기업 정보 수정(기본)
	public CompanyInfoDTO companyInfoUpdate(String com_email);//기업 상세정보 수정 페이지 이동
	public void modify_Detail(HashMap<String, String> param);//기업 정보 수정(상세)
	
	public void modify_Detail(CompanyInfoDTO companyInfoDTO);

}
