package org.zerock.jsonexample;

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
import org.zerock.jsonexample.domain.Foo;

import com.google.gson.Gson;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GsonTests {

	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
	}
	@BeforeEach
	void beforeEach() {
		log.trace("beforeEach() invoked.");
	}
	@AfterAll
	void AfterAll() {
		log.trace("afterAll() invoked.");
	}
	@AfterEach
	void AfterEach() {
		log.trace("afterEach() invoked.");
	}
	
	@Test
	@Order(1)
	@DisplayName("Gson Serialize Test")
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testSerialize() {
		log.trace("testSerialize() invoked.");
		
		Foo foo = new Foo();
		
		foo.setName("dododo");
		foo.setAge(22);
		
		log.info("foo = {}", foo);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(foo);
		log.info("Gson::json = {}", json);
		
	}// testSerialize
	
	@Test
	@Order(2)
	@DisplayName("Gson Deserialize Test")
	@Timeout(value=1000, unit=TimeUnit.MILLISECONDS)
	void testDeserialize() {
		log.trace("testDeserialize() invoked.");
		
		String json = "{\"name\":\"dododo\", \"age\":22}";
		
		Gson gson = new Gson();
		Foo foo = gson.fromJson(json, Foo.class);
		
		Objects.nonNull(foo);
		log.info("foo = {}", foo);
		
		
	}// testDeserialize
}// end class
