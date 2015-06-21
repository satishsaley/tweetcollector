package com.twitter.satish;

import com.twitter.satish.listeners.RawStreamListenerImpl;
import com.twitter.satish.listeners.StatusListenerImpl;
import com.twitter.satish.util.AuthUtil;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class TweetStream {

	public static void main(String[] args) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("UrkUA4kVtrLfSnF9Lirg")
    	  .setOAuthConsumerSecret("rpdRIuV09XnjSXQWz6AsMf9UHZBlCsdh3Tqgy4B4vA")
    	  .setOAuthAccessToken("45519245-AbfXXOC0NOq9prqlm85VklS8FJBh6bBCoL4f6FARb")
    	  .setOAuthAccessTokenSecret("TCqxpb5D1LeRiunWB9OCsFSzC7wkjTDpIaADH8DzuXQ")
    	  ;
    	
    	cb.setJSONStoreEnabled(true);
    	TwitterStreamFactory twitterStreamF = new TwitterStreamFactory(cb.build());
    	TwitterStream twitterStream = twitterStreamF.getInstance();
		/* twitterStream.setOAuthConsumer(AuthUtil.getOAuthConsumerKeyString(),
				 AuthUtil.getOAuthConsumerSecretString());
		 twitterStream.setOAuthAccessToken(AuthUtil.getOAuthAccessToken());*/
    	
    	//getTweetsFromFirehose(twitterStream);
    	
    	getTweetsFromSample(twitterStream);
	}

	private static void getTweetsFromFirehose(TwitterStream twitterStream) {
		twitterStream.addListener(new StatusListenerImpl());
        twitterStream.firehose(0);
		
	}
	private static void getTweetsFromSample(TwitterStream twitterStream) {
		twitterStream.addListener(new RawStreamListenerImpl());
        twitterStream.sample();
		
	}

}
