package org.zerock.usingapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
public class HttpURLConnectionTests {
	
	private String serviceKey = "openweather serviceKey";
	private String endPoint = "https://api.openweathermap.org/data/3.0/onecall";
	
	@Test
	@Order(1)
	@DisplayName("HttpURLConnectionTests")
	@Timeout(value=1000, unit=TimeUnit.MILLISECONDS)
	void HttpURLConnectionTest() throws IOException {
		log.trace("HttpURLConnectionTest() invoked.");
		
		
		String queryString = String.format("?lat=%s&lon=%s&exclude=hourly&appid=%s", "37", "127", serviceKey );
		
		URL url = new URL(endPoint + queryString);
		
		Objects.nonNull(url);
		log.info("url = {}", url);
		
		
		@Cleanup("disconnect")
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Objects.nonNull(conn);
		log.info("conn = {}", conn);
		log.info("conn Type = {}", conn.getClass().getName());
		
		
		conn.setConnectTimeout(3000);
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(false);
		conn.setRequestMethod("GET");
		conn.setReadTimeout(3000);
		
		conn.connect();
		
		
		int statusCode = conn.getResponseCode();
		String responseMessage = conn.getResponseMessage();
		
		log.info("statusCode = {}", statusCode);
		log.info("reaponseMessage = {}", responseMessage);
		
		if(statusCode == 200) {
			
			@Cleanup
			InputStream is = conn.getInputStream();
			@Cleanup
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				
				System.out.println(line);
			}// while
		}// if
		
	}// HttpURLConnectionTest
	
}// end class
