package com.example.androidtrainingsample.adapters;

import android.view.View;

/**
 * Created by zhangxu19 on 16/12/27.
 */

public interface OnItemClickedListener {

    public void onItemClicked(View view, int position);

    public void onItemLongClicked(View view, int position);
}
