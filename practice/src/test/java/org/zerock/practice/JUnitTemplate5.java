package org.zerock.practice;

import java.util.concurrent.TimeUnit;

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

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitTemplate5 {

	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeall() invoked.");
		
	}// beforeAll
	
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
	@DisplayName("test1")
	@Timeout(value= 1000, unit=TimeUnit.MICROSECONDS)
	void test1(){
		log.trace("test1() invoked.");
		
	}// test1
	
}// end class
