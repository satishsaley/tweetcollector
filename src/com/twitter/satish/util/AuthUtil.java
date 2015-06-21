package com.twitter.satish.util;

import twitter4j.auth.AccessToken;

public class AuthUtil {

	private static final String O_AUTH_CONSUMER_KEY = "UrkUA4kVtrLfSnF9Lirg";
	private static final String O_AUTH_CONSUMER_SECRET = "rpdRIuV09XnjSXQWz6AsMf9UHZBlCsdh3Tqgy4B4vA";
	private static final String O_AUTH_ACCESS_TOKEN = "45519245-AbfXXOC0NOq9prqlm85VklS8FJBh6bBCoL4f6FARb";
	private static final String O_AUTH_ACCESS_TOKEN_SECRET = "TCqxpb5D1LeRiunWB9OCsFSzC7wkjTDpIaADH8DzuXQ";
	public static  String getOAuthConsumerKeyString(){
		return O_AUTH_CONSUMER_KEY;
	}
	
	public static String getOAuthConsumerSecretString(){
		return O_AUTH_CONSUMER_SECRET;
	}
	
	public static String getOAuthAccessTokenString(){
		return O_AUTH_ACCESS_TOKEN;
	}
	
	public static String getOAuthAccessTokenSecretString(){
		return O_AUTH_ACCESS_TOKEN_SECRET;
	}
	
	public static final AccessToken getOAuthAccessToken(){
		AccessToken token = new AccessToken(getOAuthAccessTokenString(), getOAuthAccessTokenSecretString());
		return token;
		
	}
	
}
