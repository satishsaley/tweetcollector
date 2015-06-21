package com.twitter.satish;



//import twitter4j.internal.org.json.JSONObject;
//import twitter4j.json.DataObjectFactory;

import java.io.*;
//import java.nio.channels.FileChannel;
import java.util.List;
import java.util.StringTokenizer;

import com.twitter.satish.util.AuthUtil;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query.ResultType;
import twitter4j.conf.ConfigurationBuilder;

public class CollectTweet {
	private static final String FILEPATH = "C:\\Users\\Satish\\Google Drive\\WorkspaceWebsite\\";

	public static void main(String[] args) {
		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey(AuthUtil.getOAuthConsumerKeyString())
			.setOAuthConsumerSecret(AuthUtil.getOAuthConsumerSecretString())
			.setOAuthAccessToken(AuthUtil.getOAuthAccessTokenString())
			.setOAuthAccessTokenSecret(AuthUtil.getOAuthAccessTokenSecretString())
			;
			cb.setJSONStoreEnabled(true);
			TwitterFactory tf = new TwitterFactory(cb.build());

			CollectTweet collect = new CollectTweet();
			collect.collectTweets(tf,"food");
		} catch (Exception te) {
			te.printStackTrace();
			
		}

	}

	private void collectTweets(TwitterFactory tf,String subject) throws Exception {

		Twitter twitter = tf.getInstance();
		Query query = new Query(subject);
		String previousFileName="";
		FileWriter outputFile=null;
		while(true)
		{
			for (int page = 1; page <=1; page++) {
				System.out.println("\nPage: " + page);

				query.resultType(ResultType.recent);

				query.setCount(100); // set tweets per page to 100

				QueryResult qr = twitter.search(query);
				List<Status> qrTweets = qr.getTweets();
				StringBuilder sb = new StringBuilder();
				for(Status t : qrTweets) {

					sb.append(t.getText()).append("\n");

					String s=t.getCreatedAt().toString();
					StringTokenizer st=new StringTokenizer(s);

					StringBuilder fileName = new StringBuilder();

					fileName.append(st.nextToken());
					fileName.append("_").append(st.nextToken());
					fileName.append("_").append(st.nextToken());
					st.nextToken();
					st.nextToken();
					fileName.append("_").append(st.nextToken()).append(".txt");

					if(previousFileName.equals(fileName)==false)
					{
						outputFile=new FileWriter(FILEPATH+fileName,true);
						previousFileName=fileName.toString();
					}
					outputFile.write(sb.toString()); 
					outputFile.write("\n");
					outputFile.flush();
				}
			}

			System.out.println("END");
			Thread.sleep(400000);


		}

	}
}

