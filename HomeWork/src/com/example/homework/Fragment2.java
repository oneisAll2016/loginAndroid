package com.example.homework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2  extends Fragment{
	private View view;
	private TextView textView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_layout2, null);
		initview();
		return view;
	}
	private void initview() {
		textView=(TextView) view.findViewById(R.id.show_tv);
		
	}
	public void settvinfo(String s) {
		textView.setText(s);
		
	}

}
