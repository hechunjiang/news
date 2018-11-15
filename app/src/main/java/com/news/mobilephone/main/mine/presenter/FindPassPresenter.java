package com.news.mobilephone.main.mine.presenter;

import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.main.mine.contract.FindPassContract;
import com.news.mobilephone.utils.ToastUtils;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 17
 */
public class FindPassPresenter extends FindPassContract.Presenter {

    @Override
    public void getFindPassCode() {
        mModel.requestFindPassCode(mView.getFindPassCodeRequest(), new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                ToastUtils.showShort(mContext, mContext.getResources().getString(R.string.the_verifacation_code_has_been_send_to_your_email));
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                ToastUtils.showShort(mContext, mContext.getResources().getString(R.string.sendCodeerror));
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }
        });
    }

    @Override
    public void resetNotPass() {
        mModel.requestResetPassReset(mView.getResetPassRequset(), new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                mView.resetPassSuccess(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }

        });
    }
}
