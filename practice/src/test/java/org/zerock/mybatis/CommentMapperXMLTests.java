package org.zerock.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
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
import org.zerock.mybatis.domain.CommentVO;
import org.zerock.mybatis.mapper.CommentMapper;

import handler.BlockingDequeResultHandler;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentMapperXMLTests {

	
	SqlSessionFactory factory;
	
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		Objects.nonNull(is);
		log.info("is = {}", is);
		
		
		this.factory = builder.build(is);
		
		Objects.requireNonNull(factory);
		log.info("factory = {}", factory);
		
	}// beforeAll
	
	
	
	@Disabled
	@Test
	@Order(1)
	@DisplayName("CommentMapperXML Test")
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void selectCommentsByTarget() {
		log.trace("selectCommentsByTarget testing invoked.");
		
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		Objects.nonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		
		try(session){
			
//			Map<String, String> param = new HashMap<>();
//			
//			param.put("targetGb", "SAN_REVIEW");
//			param.put("targetCD", "1");
			
			String targetGb = "SAN_REVIEW";
			Integer targetCd = 1;
			
			LinkedBlockingDeque<CommentVO> comments = mapper.selectCommentsByTarget(targetGb, targetCd);
			
			
			Objects.requireNonNull(comments);
			comments.forEach(log::info);
			log.info("comments size = {}", comments.size());
			
		}// try-with-resources
		
	}// selectComment
	
	
	
	@Disabled
	@Test
	@Order(2)
	@DisplayName("CommentMapperXML Test2")
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void selectAllComments() {
		log.trace("selectAllComments testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		Configuration config = session.getConfiguration();
		
		Objects.nonNull(config);
		log.info("config = {}", config);
		
		
		
		StringBuffer mapperStatement = new StringBuffer();
		mapperStatement.append("org.zerock.mybatis.mapper.CommentMapper")
						.append(".selectAllComments");
		
		
		log.info("mapperStatement = {}", mapperStatement.toString());
		
		
		try(session){
			
//			만들고보니 필요없음 
			BlockingDequeResultHandler<CommentVO> resultHandler = new BlockingDequeResultHandler<>();
			
			session.select(mapperStatement.toString(), resultHandler);
			
			
			LinkedBlockingDeque<CommentVO> comments = resultHandler.getResults();
			
			Objects.requireNonNull(comments);
			log.info("comments type = {}", comments.getClass().getName());
			
			
			comments.forEach(log::info);
			
		}// try-with-resources
		
	}// selectAllComment
	
	
//	@Disabled
//	@Test
//	@Order(3)
//	@DisplayName("CommentMapperXML Test3") /* 어노테이션 + XML */
//	@Timeout(value = 2, unit= TimeUnit.MINUTES)
//	void selectCommentTarget() {
//		log.trace("selectCommentTarget testing invoked.");
//		
//		
//		@Cleanup
//		SqlSession session = this.factory.openSession();
//		
//		Objects.nonNull(session);
//		log.info("session = {}", session);
//		
//		
//		
//		CommentMapper mapper = session.getMapper(CommentMapper.class);
//		
//		Objects.requireNonNull(mapper);
//		log.info("mapper type = {}", mapper.getClass().getName());
//		
//		
//		
//		String targetGb = "SAN_REVIEW";
//		Integer targetCd = 1;
//		
//		LinkedBlockingDeque<CommentVO> comments = mapper.selectCommentTarget(targetGb, targetCd);
//		
//		Objects.requireNonNull(comments);
//		comments.forEach(log::info);
//		
//		
//	}// selectCommentTarget
	
	
	@Disabled
	@Test
	@Order(4)
	@DisplayName("CommentMapperXML Test4") /* 어노테이션 + XML */
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void selectMentionsTarget() {
		log.trace("selectMentionsTarget testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		String targetGb = "SAN_REVIEW";
		Integer targetCd = 21;
		
		LinkedBlockingDeque<CommentVO> mentions = mapper.selectMentionsTarget(targetGb, targetCd);
		
		Objects.requireNonNull(mentions);
		mentions.forEach(log::info);
		
		
	}// selectMentionTarget
	
	
	@Disabled
	@Test
	@Order(5)
	@DisplayName("CommentMapperXML Test5") /* 어노테이션 + XML */
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void selectCommentMentions() {
		log.trace("selectCommentMentions testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		Integer commentCd = 300;
		
		LinkedBlockingDeque<CommentVO> mentions = mapper.selectMentionsByComment(commentCd);
		
		Objects.requireNonNull(mentions);
		mentions.forEach(log::info);
		
	}// selectCommentMentions
	
	
	@Disabled
	@Test
	@Order(6)
	@DisplayName("CommentMapperXML Test6") /* 어노테이션 + XML */
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void selectCommentUser() {
		log.trace("selectCommentUser testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		
		Integer userCd = 2;
		
		LinkedBlockingDeque<CommentVO> comments = mapper.selectCommentByUser(userCd);
		
		Objects.requireNonNull(comments);
		comments.forEach(log::info);
		
		
	}// selectCommentUser
	
	
	@Disabled
	@Test
	@Order(7)
	@DisplayName("CommentMapperXML Test7") /* 어노테이션 + XML */
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void deleteCommentByCommentCd() {
		log.trace("deleteCommentByCommentCd testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		
		Integer commentCd = 1;
		
		mapper.deleteCommentByCommentCd(commentCd);
		
	}// deleteCommentByCommentCd
	
	
	@Disabled
	@Test
	@Order(7)
	@DisplayName("CommentMapperXML Test7") /* 어노테이션 + XML */
	@Timeout(value = 2, unit= TimeUnit.MINUTES)
	void deleteCommentByUserCd() {
		log.trace("deleteCommentByUserCd testing invoked.");
		
		
		@Cleanup
		SqlSession session = this.factory.openSession();
		
		Objects.nonNull(session);
		log.info("session = {}", session);
		
		
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper type = {}", mapper.getClass().getName());
		
		
		
		Integer userCd = 1;
		
		mapper.deleteCommentByCommentCd(userCd);
		
	}// deleteCommentByCommentCd
}// end class
