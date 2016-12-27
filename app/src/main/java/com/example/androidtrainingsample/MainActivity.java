package com.example.androidtrainingsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.androidtrainingsample.databinding.ActivityMainBinding;
import com.example.androidtrainingsample.gettingstarted.GettingStartedActivity;
import com.example.androidtrainingsample.utils.BaseUtils;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		mBinding.setHandlers(this);
	}

	public void startGettingStartedActivity(View v) {
		BaseUtils.startActivity(this, GettingStartedActivity.class);
	}
}
