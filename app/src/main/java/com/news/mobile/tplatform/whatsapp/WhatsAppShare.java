package com.news.mobile.tplatform.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import com.news.mobile.utils.CommonUtils;
import com.news.mobile.utils.ToastUtils;

import java.io.File;

/**
 * Created by sfy. on 2018/10/31 0031.
 */

public class WhatsAppShare {

    public Context mContext;

    public WhatsAppShare(Context mContext) {
        this.mContext = mContext;
    }

    public void shareLink(String linkUrl) {

        if (!CommonUtils.isApplicationAvilible(mContext, "com.whatsapp")) {
            ToastUtils.showLong(mContext, "You've not installed Whats App,Please re-try after installation.");
            return;
        }
        String type = "text/*";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(type);
        intent.putExtra(Intent.EXTRA_TEXT, linkUrl);
        intent.setPackage("com.whatsapp");
        mContext.startActivity(Intent.createChooser(intent, "Share to"));
    }

    public void shareImg(String pathname) {
        if (!CommonUtils.isApplicationAvilible(mContext, "com.whatsapp")) {
            ToastUtils.showLong(mContext, "You've not installed Whats App,Please re-try after installation.");
            return;
        }
        String type = "image/*";

        Uri uri = Uri.fromFile(new File(pathname));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(type);
        intent.putExtra(Intent.EXTRA_TEXT, "分享说明" + "https://juejin.im/user/568e61dc60b2ad083a795554/activities");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage("com.whatsapp");
        mContext.startActivity(Intent.createChooser(intent, "Share to"));
    }

    public void shareVideo() {
        if (!CommonUtils.isApplicationAvilible(mContext, "com.whatsapp")) {
            ToastUtils.showLong(mContext, "You've not installed Whats App,Please re-try after installation.");
            return;
        }
        String type = "video/*";
        String mediaPath = "/手机存储/DCIM/Camera/video_20180930_211220.mp4";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(type);
        intent.putExtra(Intent.EXTRA_TEXT, "分享说明");
        File media = new File(mediaPath);
        Uri uri = Uri.fromFile(media);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setPackage("com.whatsapp");
        mContext.startActivity(Intent.createChooser(intent, "Share to"));
    }
}
