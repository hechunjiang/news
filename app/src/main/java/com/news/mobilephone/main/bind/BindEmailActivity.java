package com.news.mobilephone.main.bind;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.entiyt.request.BindEmailRequest;
import com.news.mobilephone.entiyt.request.GetCodeRequest;
import com.news.mobilephone.main.bind.contract.BindEmailContract;
import com.news.mobilephone.main.bind.model.BinEmailModel;
import com.news.mobilephone.main.bind.persenter.BindEmailPresenter;
import com.news.mobilephone.utils.StatusBarUtils;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.view.LoginCodeCountDown;
import com.news.mobilephone.view.dialog.UploadProgressDialog;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BindEmailActivity extends BaseActivity<BindEmailPresenter, BinEmailModel> implements BindEmailContract.View {

    private ImageView action_bar_back_iv;
    private EditText bind_phone_et, bind_phone_code_et;
    private TextView bind_get_code_btn;
    private Button bind_commit_btn;
    private LoginCodeCountDown mLoginCodeCountDown;
    private UploadProgressDialog mDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_email;
    }

    @Override
    public void initView() {
        action_bar_back_iv = findViewById(R.id.action_bar_back_iv);
        bind_phone_et = findViewById(R.id.bind_phone_et);
        bind_phone_code_et = findViewById(R.id.bind_phone_code_et);
        bind_get_code_btn = findViewById(R.id.bind_get_code_btn);
        bind_commit_btn = findViewById(R.id.bind_commit_btn);
        mLoginCodeCountDown = new LoginCodeCountDown(bind_get_code_btn);
        bind_phone_et.addTextChangedListener(textWatcher);
        bind_phone_code_et.addTextChangedListener(textWatcher);

        bind_commit_btn.setBackground(getResources().getDrawable(R.drawable.btn_login_nor));
        bind_commit_btn.setEnabled(false);

        mDialog = UploadProgressDialog.initGrayDialog(this);
        mDialog.setCancelable(false);
        mDialog.setMessage("");
    }

    @Override
    public void initEvents() {
        action_bar_back_iv.setOnClickListener(this);
        bind_get_code_btn.setOnClickListener(this);
        bind_commit_btn.setOnClickListener(this);
    }

    @Override
    public void onClickEvent(View v) {
        if (v == action_bar_back_iv) {
            BindEmailActivity.this.finish();
        } else if (v == bind_get_code_btn) {//获取验证码
            mLoginCodeCountDown.start();
            mLoginCodeCountDown.setNotClick();
            mPresenter.getSmsCode(getSmsRequest());
        } else if (v == bind_commit_btn) {
            mDialog.show();
            mPresenter.bindEmail();
        }
    }

    @Override
    public void initObject() {
        setMVP();
        StatusBarUtils.setColor(BindEmailActivity.this, Color.parseColor("#FFFFFF"));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {
        mDialog.dismiss();
        ToastUtils.showLong(mContext, msg);
    }


    @Override
    public GetCodeRequest getSmsRequest() {
        GetCodeRequest request = new GetCodeRequest();
        request.setType("reg");
        request.setMail(bind_phone_et.getText().toString());
        return request;
    }

    @Override
    public BindEmailRequest getBindEmailRequest() {
        BindEmailRequest request = new BindEmailRequest();
        request.setMail(bind_phone_et.getText().toString());
        request.setVerify(bind_phone_code_et.getText().toString());
        return request;
    }

    @Override
    public void getsmsCodeSuccess() {
        ToastUtils.showShort(mContext, mContext.getResources().getString(R.string.successful));
    }

    @Override
    public void bindEmailSuccess(String s) {
        mDialog.dismiss();
        ToastUtils.showToastConis(mContext, getString(R.string.bind_email_success), s, -1);
        BindEmailActivity.this.finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginCodeCountDown.cancel();
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String inputEmail = bind_phone_et.getText().toString();
            String smsCode = bind_phone_code_et.getText().toString();
            if (isEmail(inputEmail) && smsCode.length() == 4) {
                bind_commit_btn.setBackground(getResources().getDrawable(R.drawable.task_top_shape));
                bind_commit_btn.setEnabled(true);
            } else {
                bind_commit_btn.setBackground(getResources().getDrawable(R.drawable.btn_login_nor));
                bind_commit_btn.setEnabled(false);
            }
        }
    };

    private static boolean isEmail(String email) {

        Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

        Matcher matcher = emailPattern.matcher(email);

        if (matcher.find()) {
            return true;
        }
        return false;

    }
}
