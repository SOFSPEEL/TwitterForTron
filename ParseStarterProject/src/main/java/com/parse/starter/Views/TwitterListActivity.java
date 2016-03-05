package com.parse.starter.Views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.parse.starter.R;
import com.parse.starter.StarterApplication;
import com.parse.starter.domain.Tweet;
import com.parse.starter.services.ITweetService;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TwitterListActivity extends TwitterServiceActivity {

    @Bind(R.id.list)
    ListView list;

    @Bind(R.id.buttonTweet)
    Button buttonTweet;

    @Bind(R.id.enterTweet)
    EditText enterTweet;

    List<ParseObject> _tweets;
    private TweetAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweets);

        ButterKnife.bind(this, this);

        StarterApplication application = (StarterApplication) getApplication();

        final ITweetService tweetService = application.getTweetService();

        tweetService.fetchAllTweets(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> tweets, ParseException e) {
                _tweets = tweets;
                _adapter = new TweetAdapter(TwitterListActivity.this, tweets);
                list.setAdapter(_adapter);
            }
        });

        buttonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tweet();
            }

            private void Tweet() {

                String message = enterTweet.getText().toString();
                if (!message.isEmpty()) {

                    final Tweet tweet = new Tweet();
                    tweet.setMessage(message);
                    tweetService.Add(tweet, new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            _tweets.add(0, tweet);
                            _adapter.notifyDataSetChanged();
                        }
                    });
                }
            }

        });
    }


    private class TweetAdapter extends ArrayAdapter<ParseObject> {
        public TweetAdapter(Context context, List<ParseObject> list) {
            super(context, android.R.layout.simple_list_item_1, list);
        }

    }
}
