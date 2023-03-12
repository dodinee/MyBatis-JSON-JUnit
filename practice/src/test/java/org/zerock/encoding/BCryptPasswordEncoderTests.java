package org.zerock.encoding;

import static org.junit.Assert.assertNotNull;

import java.util.Objects;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BCryptPasswordEncoderTests {

	@BeforeAll
	void beforeAll() {
		
	}/// beforeAll
	
	@BeforeEach
	void beforeEach() {
		
	}// beforeEach
	
	@AfterAll
	void afterAll() {
		
	}// afterAll
	
	@AfterEach
	void afterEach() {
		
	}// afterEach
	
	@Test
	@Order(1)
	@DisplayName("BCryptPasswordEncoderTest1")
	@Timeout(value = 1000, unit=TimeUnit.MILLISECONDS)
	void BcryptPasswordEncoderTest() {
		log.trace("BcryptPasswordEncoderTest1() invoked.");
		
		String password = "Wego12345678";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String cyperText = encoder.encode(password);
		
		assertNotNull(cyperText);
		log.info("cyperText = {}", cyperText);
		
	}// BcryptPasswordEncoderTest
	
	
	@Test
	@Order(2)
	@DisplayName("passwordMatchingTest")
	@Timeout(value= 1000, unit=TimeUnit.MILLISECONDS)
	void passwordMatchingTest() {
		log.trace("passwordMatchingTest() invoked.");
		
		String password = "Wego12345678";
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		String savedIntoDb = encoder.encode(password);
		Objects.nonNull(savedIntoDb);
		log.info("cyperText = {}", savedIntoDb);
		
		String rpassword = password;
		
		boolean isMatched = encoder.matches(savedIntoDb, rpassword);
		
		log.info("isMatched = {}", isMatched);
		
		
		
		
		
		
		
	}// passwordMatchingTest
}// end class
