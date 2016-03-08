/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.trov.twitter.Views;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.parse.twitter.R;
import com.trov.twitter.TweetApplication;
import com.trov.twitter.domain.ILogin;
import com.trov.twitter.domain.INavigate;
import com.trov.twitter.domain.User;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends FragmentActivity implements View.OnClickListener {

    @Bind(R.id.userName)
    EditText userName;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.login)
    Button login;

    @Inject
    ILogin loginService;

    @Inject
    INavigate navigateService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ((TweetApplication) getApplication()).getTweetComponent().inject(this);

        ButterKnife.bind(this, this);

        login.setOnClickListener(this);

        loginService.LoginAutomatically(this);

    }


    @Override
    public void onClick(View v) {

        final ProgressFragment progressFragment = new ProgressFragment();
        progressFragment.show(getSupportFragmentManager(), "Progress");

        User user = new User(userName.getText().toString(), password.getText().toString());

        loginInBackground(progressFragment, user);


    }

    private void loginInBackground(final ProgressFragment progressFragment, User user) {
        new AsyncTask<User, Void, Void>() {
            @Override
            protected Void doInBackground(User... params) {

                User user = params[0];
                loginService.LoginManually(LoginActivity.this, user.getName(), user.getPassword());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                progressFragment.dismiss();
            }
        }.execute(user);
    }
}
