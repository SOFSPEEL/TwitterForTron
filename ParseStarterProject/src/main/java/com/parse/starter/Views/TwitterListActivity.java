package com.parse.starter.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.parse.starter.R;
import com.parse.starter.domain.Tweet;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TwitterListActivity extends ActionBarActivity {

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


        ParseQuery.getQuery("Tweet").findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> tweets, com.parse.ParseException e) {

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
                    tweet.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            _tweets.add(tweet);
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
