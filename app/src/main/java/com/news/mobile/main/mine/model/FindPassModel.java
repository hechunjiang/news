package com.news.mobile.main.mine.model;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.request.GetCodeRequest;
import com.news.mobile.entiyt.request.ResetPassRequst;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.main.mine.contract.FindPassContract;
import com.news.mobile.utils.LogUtil;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 17
 */
public class FindPassModel extends FindPassContract.Model {
    @Override
    public void requestFindPassCode(GetCodeRequest request, final DataCallBack callBack) {
        getRetrofit().getSmsCode(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                LogUtil.showLog(json);
                callBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }

        });
    }

    @Override
    public void requestResetPassReset(ResetPassRequst requst, final DataCallBack callBack) {
        getRetrofit().resetPassWord(requst, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                callBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }

        });
    }
}
