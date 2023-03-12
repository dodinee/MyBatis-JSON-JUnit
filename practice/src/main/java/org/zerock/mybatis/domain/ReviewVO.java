package org.zerock.mybatis.domain;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class ReviewVO {

	private Integer sanReviewCd;
	private String sanName;
	private String nickname;
	private String userPic;
	private String title;
	private String contents;
	private Timestamp createdDt;
	private Integer likeCnt;
	
}// end class
