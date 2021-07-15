package com.shorten.shortening;

import java.math.BigInteger;

import com.shorten.shortening.util.Base62Util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShorteningApplicationTests {

	static String alpabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012356789";
	final String urlRegex = "^(https|http)?://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$";
   
	@Test
	void contextLoads() {
		   //This method returns the time in millis
		  	BigInteger param2 = new BigInteger("218340105584895");
			String encoding = Base62Util.encoding(param2);
			System.out.println("1 -> "+ encoding );
			System.out.println("2 -> "+ Base62Util.decoding("99999999") );
	}

	@Test
	void checkUrl() {
		String url = "https://www.naver.com";
		System.out.println("URL : " + url.matches(urlRegex));
	}

	@Test
	void checkMax() {
		BigInteger maxIdx = new BigInteger("218340105584895");
		BigInteger checkIdx = new BigInteger("318340105584896");
		System.out.println("URL : " + maxIdx.compareTo(checkIdx));
	}
}
