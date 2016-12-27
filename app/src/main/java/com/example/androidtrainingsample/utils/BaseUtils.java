package com.example.androidtrainingsample.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by zhangxu19 on 16/12/23.
 */

public class BaseUtils {

	public static void startActivity(Context context, Class<?> intentClass) {
		context.startActivity(new Intent(context, intentClass));
	}
}
