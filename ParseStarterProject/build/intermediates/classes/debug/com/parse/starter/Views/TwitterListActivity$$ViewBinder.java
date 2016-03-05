// Generated code from Butter Knife. Do not modify!
package com.parse.starter.Views;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TwitterListActivity$$ViewBinder<T extends com.parse.starter.Views.TwitterListActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492964, "field 'list'");
    target.list = finder.castView(view, 2131492964, "field 'list'");
    view = finder.findRequiredView(source, 2131492963, "field 'buttonTweet'");
    target.buttonTweet = finder.castView(view, 2131492963, "field 'buttonTweet'");
    view = finder.findRequiredView(source, 2131492962, "field 'enterTweet'");
    target.enterTweet = finder.castView(view, 2131492962, "field 'enterTweet'");
  }

  @Override public void unbind(T target) {
    target.list = null;
    target.buttonTweet = null;
    target.enterTweet = null;
  }
}
