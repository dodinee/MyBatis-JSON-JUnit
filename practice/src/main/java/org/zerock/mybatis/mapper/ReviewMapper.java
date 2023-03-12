package org.zerock.mybatis.mapper;

import java.util.concurrent.LinkedBlockingDeque;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.mybatis.domain.ReviewVO;

public interface ReviewMapper {

	
//	@Select({"SELECT * FROM san_review_v"})
//	public LinkedBlockingDeque<ReviewVO> selectAllReviews();
//	
//	@Select({"SELECT * FROM san_review_v WHERE review_cd = #{reviewCd}"})
//	public ReviewVO selectReview(@Param("reviewCd") Integer reviewCd);
	
	// 후기글 전체 조회 
	public abstract LinkedBlockingDeque<ReviewVO> selectAllReviews();
	
	// 특정 후기글 조회 
	public abstract ReviewVO selectReviewByReviewCd(@Param("reviewCd")Integer reviewCd);
	
	// 특정 유저 후기글 조회 
	public abstract LinkedBlockingDeque<ReviewVO> selectReviewsByUserCd(@Param("userCd")Integer userCd);
	
	
	
	
}// end interface
