package org.zerock.mybatis.domain;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class CommentVO {

	private Integer commentCd;		// 댓글 식별자
	private String commentGb;		// 댓글 구분 
	private Integer mentionCd;		// 멘션 코드 
	private String targetGb;		// 소속 게시판 
	private Integer targetCd;		// 소속 글 식별자
	private String nickname;		// 작성자 닉네임 
	private String contents;		// 댓글 내용 
	private Timestamp createdDt;	// 작성일 
	private String state;			// 삭제 상태값 
	
}// end class
