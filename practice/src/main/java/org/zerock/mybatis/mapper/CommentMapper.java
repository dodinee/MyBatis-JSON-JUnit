package org.zerock.mybatis.mapper;

import java.util.concurrent.LinkedBlockingDeque;

import org.apache.ibatis.annotations.Param;
import org.zerock.mybatis.domain.CommentVO;

public interface CommentMapper {

	// 특정 게시글 댓글 조회 
	public abstract LinkedBlockingDeque<CommentVO> selectCommentsByTarget(@Param("targetGb")String targetGb, @Param("targetCd")Integer targetCd);
	
	// 특정 게시글 대댓글 조회 == 만들고보니 필요없음 
	public abstract LinkedBlockingDeque<CommentVO> selectMentionsTarget(@Param("targetGb")String targetGb, @Param("targetCd") Integer targetCd);
	
	// 특정 댓글 대댓글 조회 
	public abstract LinkedBlockingDeque<CommentVO> selectMentionsByComment(@Param("commentCd")Integer commentCd);
	
	// 특정 회원 댓글 조회 
	public abstract LinkedBlockingDeque<CommentVO> selectCommentByUser(@Param("userCd") Integer userCd);
	
	// 댓글 코드로 댓글 삭제 
	public abstract void deleteCommentByCommentCd(@Param("commentCd")Integer commentCd);
	
	// 유저 코드로 댓글 삭제 
	public abstract void deleteCommentByUserCd(@Param("userCd")Integer userCd);
	
}// end interface
