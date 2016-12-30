package com.example.androidtrainingsample.gettingstarted;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.androidtrainingsample.R;
import com.example.androidtrainingsample.databinding.ActivityGettingStartedBinding;
import com.example.androidtrainingsample.gettingstarted.fragments.FragmentContainerActivity;
import com.example.androidtrainingsample.gettingstarted.interactwithotherapp.InteractWithOtherAppActivity;
import com.example.androidtrainingsample.utils.BaseUtils;

public class GettingStartedActivity extends AppCompatActivity {

	private ActivityGettingStartedBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_getting_started);
		mBinding.setHandlers(this);
	}

	public void showDynamicUIWithFragment(View v) {
		BaseUtils.startActivity(this, FragmentContainerActivity.class);
	}

	public void startInteractWithOtherApp(View v) {
		BaseUtils.startActivity(this, InteractWithOtherAppActivity.class);
	}

}
