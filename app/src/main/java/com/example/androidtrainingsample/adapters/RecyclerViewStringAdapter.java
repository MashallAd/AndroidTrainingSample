package com.example.androidtrainingsample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidtrainingsample.R;

import java.util.List;

/**
 * Created by zhangxu19 on 16/12/23.
 */

public class RecyclerViewStringAdapter extends RecyclerView.Adapter<RecyclerViewStringAdapter.ViewHolder> {

	private Context context;
	private List<String> dataList;
	private LayoutInflater inflater;

	private OnItemClickedListener mOnItemClickedListener;

	public RecyclerViewStringAdapter(Context context, List<String> dataList) {
		this.context = context;
		this.dataList = dataList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ViewHolder holder = new ViewHolder(
				inflater.inflate(R.layout.recycleview_string_item, parent, false));

		return holder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		holder.tv.setText(dataList.get(position));
		holder.tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (mOnItemClickedListener != null)
					mOnItemClickedListener.onItemClicked(view, position);
			}
		});
	}

	@Override
	public int getItemCount() {
		return dataList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		private TextView tv;

		public ViewHolder(View itemView) {
			super(itemView);
			tv = (TextView) itemView.findViewById(R.id.tv_title);
		}
	}

	public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
		this.mOnItemClickedListener = onItemClickedListener;
	}
}
