package com.news.mobile.tplatform.twitter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import com.news.mobile.entiyt.event.ShareResponseEvent;
import com.news.mobile.utils.Common;
import com.twitter.sdk.android.tweetcomposer.TweetUploadService;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by sfy. on 2018/4/25 0025.
 */

public class MyResultReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ShareResponseEvent shareResponseEvent = new ShareResponseEvent();
        if (TweetUploadService.UPLOAD_SUCCESS.equals(intent.getAction())) {
            shareResponseEvent.setShareResponseType(Common.JS_RESPONSE_CODE_SUCCEED);
        } else if (TweetUploadService.UPLOAD_FAILURE.equals(intent.getAction())) {

            shareResponseEvent.setShareResponseType(Common.JS_RESPONSE_CODE_FAIL);
        } else if (TweetUploadService.TWEET_COMPOSE_CANCEL.equals(intent.getAction())) {
            shareResponseEvent.setShareResponseType(Common.JS_RESPONSE_CODE_CANCEL);
        }
        EventBus.getDefault().post(shareResponseEvent);
    }
}
