package com.twitter.satish.listeners;

import twitter4j.RawStreamListener;

public class RawStreamListenerImpl implements RawStreamListener{
	    @Override
        public void onMessage(String rawJSON) {
            System.out.println(rawJSON);
        }

        @Override
        public void onException(Exception ex) {
            ex.printStackTrace();
        }
}
