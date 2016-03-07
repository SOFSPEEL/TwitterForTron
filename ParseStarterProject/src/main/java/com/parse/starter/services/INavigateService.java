package com.parse.starter.services;

import android.app.Activity;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public interface INavigateService {
    void NavigateTo(Activity activity, String path, User user);

    void NavigateToToast(Activity activity, String toast);
}

