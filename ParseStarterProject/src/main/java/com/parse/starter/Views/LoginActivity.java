/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.starter.R;
import com.parse.starter.TweetApplication;
import com.parse.starter.services.ILogin;
import com.parse.starter.services.INavigate;

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


//    @Inject
//    Login loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ((TweetApplication) getApplication()).getTweetComponent().inject(this);

        ButterKnife.bind(this, this);


        login.setOnClickListener(this);

    }

    @Inject
    ILogin loginService;

    @Inject
    INavigate navigateService;

    @Override
    public void onClick(View v) {

        loginService.Login(this, userName.getText().toString(), password.getText().toString());

    }
}
