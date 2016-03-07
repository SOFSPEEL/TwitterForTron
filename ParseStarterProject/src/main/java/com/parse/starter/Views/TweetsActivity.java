package com.parse.starter.Views;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.starter.R;
import com.parse.starter.services.ITweetFeed;
import com.parse.starter.services.ITweetSyncService;
import com.parse.starter.services.NavigateService;
import com.parse.starter.services.ServiceManager;
import com.parse.starter.TweetApplication;
import com.parse.starter.domain.Tweet;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TweetsActivity extends TwitterServiceActivity {

    @Bind(R.id.list)
    ListView list;

    @Bind(R.id.buttonTweet)
    Button buttonTweet;

    @Bind(R.id.enterTweet)
    EditText enterTweet;

    List<Tweet> _tweets;
    private TweetAdapter _adapter;

    @Inject
    ITweetFeed tweetService;

    @Inject
    ServiceManager serviceManager;

    @Inject
    NetworkInfo networkInfo;


    @Inject
    ITweetSyncService tweetSyncService;

    private long userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweets);

        userId = getIntent().getLongExtra(NavigateService.extraUserId, -1);

        ((TweetApplication) getApplication()).getTweetComponent().inject(this);

        ButterKnife.bind(this, this);

        boolean isConnected = networkInfo.isConnected();

        _tweets = tweetService.fetchAllTweets(userId);





        _adapter = new TweetAdapter(this);
        list.setAdapter(_adapter);

        buttonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tweet();
            }

            private void Tweet() {

                String message = enterTweet.getText().toString();
                if (!message.isEmpty()) {

                    final Tweet tweet = new Tweet(userId, message);

                    tweetService.save(tweet);

                    _tweets.add(0, tweet);
                    _adapter.notifyDataSetChanged();

                }
            }

        });
    }

    private class TweetAdapter extends ArrayAdapter<Tweet> {
        public TweetAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1, _tweets);
        }

    }
}
