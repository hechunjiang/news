package com.news.mobile.main.home.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.news.mobile.MyApplication;
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
import com.tbruyelle.rxpermissions.RxPermissions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

public class MainActivity extends BaseActivity {

    private FrameLayout fl_main_containt;
    private List<Fragment> fragments = new ArrayList<>();
    private BottomBar bottomBar;
    private FragmentTransaction fragmentTransaction;
    private Fragment newsFragment, taskFragment, mineFragment;
    private CustomLoginDialog loginDialog;
    private TextView foryou, daily_task, me;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        fl_main_containt = findViewById(R.id.fl_main_containt);
//        bottomBar = findViewById(R.id.bottomBar);
        //底部按钮
        foryou = findViewById(R.id.foryou);
        daily_task = findViewById(R.id.daily_task);
        me = findViewById(R.id.me);

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
        foryou.setOnClickListener(this);
        daily_task.setOnClickListener(this);
        me.setOnClickListener(this);


//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelected(int tabId) {
//                if (tabId == R.id.news) {
//                    switchFragment(0);
//                } else if (tabId == R.id.me_l_daily) {
//                    switchFragment(1);
//                } else if (tabId == R.id.me) {
//                    switchFragment(2);
//                }
//            }
//        });
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
        if (v == foryou) {
            choseToMenuItem(0);
        } else if (v == daily_task) {
            choseToMenuItem(1);
        } else if (v == me) {
            choseToMenuItem(2);
        }


    }

    private Drawable imgForyou, imgDayliTask, imgMe;

    public void choseToMenuItem(int position) {
        backToAllBg();
        imgForyou = ContextCompat.getDrawable(MainActivity.this, R.mipmap.foryou);
        imgForyou.setBounds(0, 0, imgForyou.getMinimumWidth(), imgForyou.getMinimumHeight());
        imgDayliTask = ContextCompat.getDrawable(MainActivity.this, R.mipmap.daily);
        imgDayliTask.setBounds(0, 0, imgDayliTask.getMinimumWidth(), imgDayliTask.getMinimumHeight());
        imgMe = ContextCompat.getDrawable(MainActivity.this, R.mipmap.mepress);
        imgMe.setBounds(0, 0, imgMe.getMinimumWidth(), imgMe.getMinimumHeight());

        switch (position) {
            case 0:
                foryou.setCompoundDrawables(null, imgForyou, null, null);
                foryou.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 1:
                daily_task.setCompoundDrawables(null, imgDayliTask, null, null);
                daily_task.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case 2:
                me.setCompoundDrawables(null, imgMe, null, null);
                me.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
        switchFragment(position);
    }

    public void backToAllBg() {
        imgForyou = ContextCompat.getDrawable(MainActivity.this, R.mipmap.foryou_background_nu);
        imgForyou.setBounds(0, 0, imgForyou.getMinimumWidth(), imgForyou.getMinimumHeight());
        imgDayliTask = ContextCompat.getDrawable(MainActivity.this, R.mipmap.video_nu);
        imgDayliTask.setBounds(0, 0, imgDayliTask.getMinimumWidth(), imgDayliTask.getMinimumHeight());
        imgMe = ContextCompat.getDrawable(MainActivity.this, R.mipmap.me_nu);
        imgMe.setBounds(0, 0, imgMe.getMinimumWidth(), imgMe.getMinimumHeight());


        foryou.setTextColor(getResources().getColor(R.color.c999999));
        daily_task.setTextColor(getResources().getColor(R.color.c999999));
        me.setTextColor(getResources().getColor(R.color.c999999));
        foryou.setCompoundDrawables(null, imgForyou, null, null);
        daily_task.setCompoundDrawables(null, imgDayliTask, null, null);
        me.setCompoundDrawables(null, imgMe, null, null);
    }

    @Override
    public void initObject() {
        choseToMenuItem(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkPermissions();
    }

    private String[] permissions = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    private void checkPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(permissions).subscribe(new Observer<Boolean>() {
            @Override
            public void onNext(Boolean aBoolean) {

            }

            @Override
            public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {

            }
        });
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
            if (f instanceof MineNewFragment) {
                f.onActivityResult(requestCode, resultCode, data);
            }
            if (f instanceof TaskFragment) {
                f.onActivityResult(requestCode, resultCode, data);
            }

            if (f instanceof NewsFragment) {
                f.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
