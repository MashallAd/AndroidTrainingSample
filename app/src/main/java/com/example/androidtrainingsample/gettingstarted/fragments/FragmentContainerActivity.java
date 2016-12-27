package com.example.androidtrainingsample.gettingstarted.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.androidtrainingsample.R;
import com.example.androidtrainingsample.databinding.ActivityFragmentContainerBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentContainerActivity extends AppCompatActivity implements TitleFragment.OnTitleSelectedListener {

    private static final String TAG = FragmentContainerActivity.class.getSimpleName();

    private ActivityFragmentContainerBinding mBinding;

    private Fragment curFragment;
    private TitleFragment titleFragment;
    private ContentFragment contentFragment;

    private List<String> titleSourceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_container);
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_container);

        initTitleSource();

        titleFragment = TitleFragment.newInstance(titleSourceList);

        contentFragment = ContentFragment.newInstance();

        getSupportFragmentManager().beginTransaction().
                add(R.id.activity_fragment_container, contentFragment).
                add(R.id.activity_fragment_container, titleFragment).
                hide(contentFragment).commit();

        curFragment = titleFragment;
    }

    private void initTitleSource() {
        titleSourceList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            titleSourceList.add("Title: " + i);
        }
    }

    private void switchFragmentContent(Fragment from, Fragment to) {
        if (from != to) {
            curFragment = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                ft.hide(from).add(R.id.activity_fragment_container, to);
            } else {
                ft.show(to).hide(from);
            }
            ft.commit();
        }
    }

    @Override
    public void onTitleSelected(int position) {
        String title = titleSourceList.get(position);
        contentFragment.setContentTitle(title);
        switchFragmentContent(titleFragment, contentFragment);
    }

    /**
     * 显示 content 的 fragment 回退时到显示 title 的 fragment
     * 显示 title 的 fragment 就直接后退
     */
    @Override
    public void onBackPressed() {
        if (curFragment == contentFragment) {
            switchFragmentContent(contentFragment, titleFragment);
        } else {
            super.onBackPressed();
        }
    }
}
