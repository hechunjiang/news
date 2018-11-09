package com.news.mobile.main.mine.presenter;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.UserDatasResponse;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.mine.contract.PersonContract;

import java.io.File;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 21
 */
public class PersonPresenter extends PersonContract.Presenter {
    @Override
    public void getUserDetailsDataInfo(boolean fasle) {
        mModel.requestUserInfo(new DataResponseCallback<UserDatasResponse>() {
            @Override
            public void onSucceed(UserDatasResponse response) {
                mView.setUserInfo(response);
            }

            @Override
            public void onFail(BaseResponse response) {
                mView.showErrorTip(response.getCode(), response.getMsg());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void uploadeHeadImage(File file) {
        mModel.requestUploadHeadImage(file, new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                mView.uploadImageSuccess(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }
        });
    }

    @Override
    public void upLoadPerMsg() {
        mModel.requestUploadPerMsg(mView.getUserMsgRequest(), new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                mView.uploadPerMsgSuccess();
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }
        });
    }
}