package com.example.androidtrainingsample.gettingstarted.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.androidtrainingsample.R;
import com.example.androidtrainingsample.databinding.ActivityFragmentContainerBinding;

public class FragmentContainerActivity extends AppCompatActivity {

	private ActivityFragmentContainerBinding mBinding;

	private Fragment curFragment;
	private Fragment titleFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_container);
		titleFragment = TitleFragment.newInstance();

		getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_container,
				titleFragment).commit();
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

}
