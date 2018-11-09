package com.news.mobile.main.home.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.news.mobile.R;
import com.news.mobile.main.mine.fragment.MineNewFragment;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.entiyt.event.LogoutEvent;
import com.news.mobile.main.mine.fragment.MineFragment;
import com.news.mobile.main.news.fragment.NewsFragment;
import com.news.mobile.main.task.fragment.TaskFragment;
import com.news.mobile.utils.StatusBarUtils;
import com.news.mobile.view.CustomLoginDialog;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private FrameLayout fl_main_containt;
    private List<Fragment> fragments = new ArrayList<>();
    private BottomBar bottomBar;
    private FragmentTransaction fragmentTransaction;
    private Fragment newsFragment, taskFragment, mineFragment;
    private CustomLoginDialog loginDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        fl_main_containt = findViewById(R.id.fl_main_containt);
        bottomBar = findViewById(R.id.bottomBar);
        loginDialog = new CustomLoginDialog(MainActivity.this, this);

        newsFragment = new NewsFragment();
        taskFragment = new TaskFragment();
        mineFragment = new MineNewFragment();
        fragments.add(newsFragment);
        fragments.add(taskFragment);
        fragments.add(mineFragment);

    }

    @Override
    public void initEvents() {

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                if (tabId == R.id.news) {
                    switchFragment(0);
                } else if (tabId == R.id.me_l_daily) {
                    switchFragment(1);
                } else if (tabId == R.id.me) {
                    switchFragment(2);
                }
            }
        });
    }

    private void switchFragment(int postion) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (postion == i) {
                if (fragment.isAdded()) {
                    fragmentTransaction.show(fragment);
                } else {
                    fragmentTransaction.add(R.id.fl_main_containt, fragment);
                }
                if (i == 2) {
                    StatusBarUtils.setColor(MainActivity.this, Color.parseColor("#DD001B"));
                } else {
                    StatusBarUtils.setColor(MainActivity.this, Color.parseColor("#FFFFFF"));
                }

            } else {
                if (fragment.isAdded()) {
                    fragmentTransaction.hide(fragment);
                }
            }
        }
        fragmentTransaction.commitAllowingStateLoss();

    }

    @Override
    public void onClickEvent(View v) {

    }

    @Override
    public void initObject() {

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutEvent(LogoutEvent event) {
        startActivity(MainActivity.class);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginDialog.registerCallBack(requestCode, resultCode, data, false);

        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment f : fragments) {
            if (f instanceof MineFragment) {
                f.onActivityResult(requestCode, resultCode, data);
            }
            if (f instanceof TaskFragment) {
                f.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
