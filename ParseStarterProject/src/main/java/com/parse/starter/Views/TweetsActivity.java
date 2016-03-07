package com.parse.starter.Views;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.parse.starter.services.TweetCallback;

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

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                tweetSyncService.sync(_tweets, userId, new TweetCallback() {
                    @Override
                    public void onTweetsFetched(List<Tweet> tweets) {
                        _tweets.addAll(tweets);
                    }
                });
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                _adapter.notifyDataSetChanged();
            }
        }.execute();



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
                    enterTweet.setText("");
                    _tweets.add(0, tweet);

                    _adapter.notifyDataSetChanged();

                }
            }

        });
    }

    private class TweetAdapter extends ArrayAdapter<Tweet> {
        public TweetAdapter(Context context) {
            super(context, R.layout.tweet, R.id.text, _tweets);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = super.getView(position, convertView, parent);
            Tweet tweet = _tweets.get(position);
            view.findViewById(R.id.synced).setVisibility(tweet.getSynced() ? View.INVISIBLE : View.VISIBLE);

            return view;
        }
    }
}
