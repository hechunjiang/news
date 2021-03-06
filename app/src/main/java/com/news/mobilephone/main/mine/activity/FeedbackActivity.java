package com.news.mobilephone.main.mine.activity;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.entiyt.FeedBackClassifyResponse;
import com.news.mobilephone.entiyt.FeedBackResponse;
import com.news.mobilephone.entiyt.request.FeedBackRequest;
import com.news.mobilephone.main.mine.contract.FeedbackContract;
import com.news.mobilephone.main.mine.model.FeefbackModel;
import com.news.mobilephone.main.mine.presenter.FeedbackPresenter;
import com.news.mobilephone.utils.StatusBarUtils;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.view.EmptyLayout;
import com.news.mobilephone.view.dialog.UploadProgressDialog;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FeedbackActivity extends BaseActivity<FeedbackPresenter, FeefbackModel> implements FeedbackContract.View {
    private TagFlowLayout taglayout;
    private TextView btnSend;
    private EditText et_input;
    private ImageView iv_back;

    private List<FeedBackClassifyResponse.DataBean> tags;
    private List<FeedBackClassifyResponse.DataBean> selectedTags = new ArrayList<>();
    private UploadProgressDialog mDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    public void initView() {
        StatusBarUtils.setColor(FeedbackActivity.this, Color.parseColor("#FFFFFF"));

        iv_back = findViewById(R.id.action_bar_back_iv);
        taglayout = findViewById(R.id.taglayout);
        btnSend = findViewById(R.id.btnSend);
        et_input = findViewById(R.id.et_input);
        mEmptyLayout = findViewById(R.id.mEmptyLayout);

       // mEmptyLayout.setErrorType(EmptyLayout.LOADING, -1);

        mDialog = UploadProgressDialog.initGrayDialog(this);
        mDialog.setCancelable(false);
        mDialog.setMessage("");
    }

    @Override
    public void initEvents() {
        btnSend.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        mEmptyLayout.setOnEmptyRefreshLisenter(new EmptyLayout.onEmptyRefreshLisenter() {
            @Override
            public void onEmptyRefresh() {
                mPresenter.getFeedClassifyList();
            }
        });
    }

    @Override
    public void onClickEvent(View v) {
        if (v == btnSend) {
            if (getSelectedTags().size() == 0) {
                ToastUtils.showShort(this, R.string.feedback_select_type);
                return;
            }
            if (TextUtils.isEmpty(et_input.getText())) {
                ToastUtils.showShort(this, R.string.feedback_inpit_detail);
                return;
            }
            mDialog.show();
            FeedBackRequest request = new FeedBackRequest();
            request.setType(selectedTags.get(0).getId() + "");
            request.setContent(et_input.getText().toString());
            mPresenter.sendFeed(request);
        } else if (v == iv_back) {

        }
        finish();
    }

    @Override
    public void initObject() {
        setMVP();
        mPresenter.getFeedClassifyList();
    }

    @Override
    public void getFeedClassify(FeedBackClassifyResponse response) {
        mEmptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);
        initTags(response.getData());
    }

    @Override
    public void sendFeed(FeedBackResponse response) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {
        mDialog.cancel();
        ToastUtils.showShort(this, msg);
    }

    public List<FeedBackClassifyResponse.DataBean> getSelectedTags() {
        selectedTags.clear();
        Set<Integer> set = taglayout.getSelectedList();
        for (Integer i : set) {
            selectedTags.add(tags.get(i));
        }
        return selectedTags;
    }

    private void initTags(final List<FeedBackClassifyResponse.DataBean> tags) {
        this.tags = tags;

        taglayout.setAdapter(new TagAdapter(tags) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tag_feedback_item, taglayout, false);
                tv.setText(tags.get(position).getName());
                return tv;
            }
        });
    }
}
