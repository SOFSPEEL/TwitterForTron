package com.parse.starter.Views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.parse.starter.R;
import com.parse.starter.dependencies.DaggerTweetComponent;
import com.parse.starter.dependencies.TweetComponent;
import com.parse.starter.dependencies.TweetModule;
import com.parse.starter.domain.Tweet;
import com.parse.starter.services.ITweetService;
import com.parse.starter.services.TweetService;

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
    private ITweetService tweetService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweets);

        ButterKnife.bind(this, this);

        TweetComponent component = DaggerTweetComponent.builder().tweetModule(new TweetModule()).build();
         tweetService = component.provideTweetService();

        tweetService.FetchAllTweets(new FindCallback<ParseObject>(){

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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TwitterList Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.parse.starter.Views/http/host/path")
        );
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TwitterList Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.parse.starter.Views/http/host/path")
        );
    }

    private class TweetAdapter extends ArrayAdapter<ParseObject> {
        public TweetAdapter(Context context, List<ParseObject> list) {
            super(context, android.R.layout.simple_list_item_1, list);
        }

    }
}
