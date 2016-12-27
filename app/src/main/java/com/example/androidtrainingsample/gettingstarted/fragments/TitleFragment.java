package com.example.androidtrainingsample.gettingstarted.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidtrainingsample.R;
import com.example.androidtrainingsample.adapters.OnItemClickedListener;
import com.example.androidtrainingsample.adapters.RecyclerViewStringAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TitleFragment.OnTitleSelectedListener} interface
 * to handle interaction events.
 * Use the {@link TitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TitleFragment extends Fragment {

	private static final String DATA_SOURCE = "data_sourece";

	private OnTitleSelectedListener mListener;

	private List<String> titleList;
	private RecyclerView recyclerView;
	private View containerView;

	public TitleFragment() {
		// Required empty public constructor
	}

	public static TitleFragment newInstance(List<String> titleList) {
		TitleFragment fragment = new TitleFragment();
		Bundle bundle = new Bundle();
		bundle.putStringArrayList(DATA_SOURCE, (ArrayList<String>) titleList);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();
		if (args != null) {
			titleList = args.getStringArrayList(DATA_SOURCE);
		}

		if (titleList == null) {
			titleList = new ArrayList<>();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		containerView = inflater.inflate(R.layout.fragment_title, container, false);
		recyclerView = (RecyclerView) containerView.findViewById(R.id.recyclerview);

		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		RecyclerViewStringAdapter adapter = new RecyclerViewStringAdapter(getContext(), titleList);
		adapter.setOnItemClickedListener(new OnItemClickedListener() {
			@Override
			public void onItemClicked(View view, int position) {
				onButtonPressed(position);
			}

			@Override
			public void onItemLongClicked(View view, int position) {

			}
		});
		recyclerView.setAdapter(adapter);

		return containerView;
	}

	public void onButtonPressed(int position) {
		if (mListener != null) {
			mListener.onTitleSelected(position);
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnTitleSelectedListener) {
			mListener = (OnTitleSelectedListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnTitleSelectedListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnTitleSelectedListener {
		// TODO: Update argument type and name
		void onTitleSelected(int position);
	}
}
