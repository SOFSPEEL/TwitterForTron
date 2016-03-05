// Generated code from Butter Knife. Do not modify!
package com.parse.starter.Views;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.parse.starter.Views.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492945, "field 'userName'");
    target.userName = finder.castView(view, 2131492945, "field 'userName'");
    view = finder.findRequiredView(source, 2131492946, "field 'password'");
    target.password = finder.castView(view, 2131492946, "field 'password'");
    view = finder.findRequiredView(source, 2131492947, "field 'login'");
    target.login = finder.castView(view, 2131492947, "field 'login'");
  }

  @Override public void unbind(T target) {
    target.userName = null;
    target.password = null;
    target.login = null;
  }
}
