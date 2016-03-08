/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.trov.twitter.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.parse.twitter.R;
import com.trov.twitter.TweetApplication;
import com.trov.twitter.tests.ILogin;
import com.trov.twitter.tests.INavigate;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends TwitterServiceActivity implements View.OnClickListener {

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

        loginService.LoginManually(this, userName.getText().toString(), password.getText().toString());

    }
}
