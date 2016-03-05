/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.Views;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.StarterApplication;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends TwitterServiceActivity implements View.OnClickListener {

  @Bind(R.id.userName) EditText userName;
  @Bind(R.id.password) EditText password;
  @Bind(R.id.login) Button login;
  /**
   * ATTENTION: This was auto-generated to implement the App Indexing API.
   * See https://g.co/AppIndexing/AndroidStudio for more information.
   */
  private GoogleApiClient client;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
    ButterKnife.bind(this, this);
    ParseAnalytics.trackAppOpenedInBackground(getIntent());

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    login.setOnClickListener(this);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public void onClick(View v) {

      StarterApplication application = (StarterApplication) getApplication();

      application.getTweetService().Login(userName.getText().toString(),password.getText().toString(), new LogInCallback() {
        @Override
        public void done(ParseUser user, com.parse.ParseException e) {

            if (user != null) {
                startActivity(new Intent(LoginActivity.this, TwitterListActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    });
  }
}
