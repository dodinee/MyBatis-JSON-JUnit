package org.zerock.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SqlSessionFactoryBuilderTests {
	
	
	private SqlSessionFactoryBuilder builder;
	private SqlSessionFactory sqlSessionFactory;
	
	
	@BeforeAll
	void beforeAll() throws IOException {
		log.trace("beforeAll() invoked.");
		
		
		this.builder = new SqlSessionFactoryBuilder();
		log.info("builder = {}", builder);
		
		
		
		String config = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(config);
		
		Objects.nonNull(is);
		log.info("is = {}", is);
		
		
		this.sqlSessionFactory = this.builder.build(is);
		Objects.nonNull(this.sqlSessionFactory);
		
		log.info("sqlSessionFactory = {}", this.sqlSessionFactory);
		
	}// beforeall
	
	@BeforeEach
	void beforeEach() {
		log.trace("beforeEach() invoked.");
	}// beforeEach
	
	@AfterAll
	void afterAll() {
		log.trace("afterAll() invoked.");
		
	}// afterAll
	
	@AfterEach
	void afterEach() {
		log.trace("afterEach() invoked.");
		
	}// afterEach
	
	@Test
	@Order(1)
	@DisplayName("sqlSessionFactoryTests")
	@Timeout(value=1000, unit=TimeUnit.MILLISECONDS)
	void sqlSessionFactoryTests() {
		log.trace("sqlSessionFactoryTests() invoked.");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		
		Objects.nonNull(sqlSession);
		log.info("sqlSession = {}", sqlSession);
		
		
		Connection conn = sqlSession.getConnection();
		Objects.nonNull(conn);
		log.info("conn = {}", conn);
		
		
	}// sqlSessionFactoryTests
}// end class
