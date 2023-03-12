package org.zerock.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.zerock.mybatis.domain.ReviewVO;
import org.zerock.mybatis.mapper.ReviewMapper;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewMapperTests {

	
	SqlSessionFactory factory;
	
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		Objects.nonNull(builder);
		log.info("builder = {} ::: type = {}", builder, builder.getClass().getName());
		
		
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		Objects.nonNull(is);
		log.info("is = {}", is);
		
		
		
		this.factory = builder.build(is); 
		
	}// beforeAll
	
	@Disabled
	@Test
	@Order(1)
	@DisplayName("selectAllReviews test")
	@Timeout(value = 10, unit = TimeUnit.SECONDS)
	void selectAllReviews() {
		log.trace("selectAllReviews() testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		// config에 등록된 매퍼 DP객체 획득 
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		
		Objects.nonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		
		
		//Mapper에서 추상메소드 호출 (결과 생성) 
		LinkedBlockingDeque<ReviewVO> reviews = mapper.selectAllReviews();
		
		Objects.requireNonNull(reviews);
		log.info("reviews type = {}", reviews.getClass().getName());
		
		
		reviews.forEach(log::info);
		
		
	}// selectAllReviews
	
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("selectReviewByReviewCd")
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	void selectReviewByReviewCd() {
		log.trace("selectReviewByReviewCd() testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		log.info("session = {}", session);
		
		
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		Integer reviewCd = 21;
		
		
		ReviewVO review = mapper.selectReviewByReviewCd(reviewCd);
		
		Objects.requireNonNull(review);
		log.info("review = {}", review);
		
	}// selectReviewByReviewCd
	

}// end class
