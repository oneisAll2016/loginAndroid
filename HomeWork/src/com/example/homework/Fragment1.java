package com.example.homework;

import java.util.List;

import android.R.integer;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Fragment1  extends Fragment{
	private View view;
	private List<Player>playlist;
	protected static final int SHOW_1 = 0;

	private ListView lV;
	private Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
		switch (msg.what) {
		case SHOW_1:
			PlayerAdapter playerAdapter = new PlayerAdapter(getActivity(), playlist);
			lV.setAdapter(playerAdapter);
			
			break;

		default:
			break;
		}	
		};
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_layout1, null);
		initview();
		return view;
	}
	private void initview() {
		lV=(ListView) view.findViewById(R.id.lv);
			initdata();
			lV.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					lV.setTag(position);
					Player players=playlist.get(position);
					((MainActivity)getActivity()).setf2text(players.getPlayer_name()+"\n"+
					                              players.getAlias()+"\n"+
					                             players.getFgac()+"\n"+
					                              players.getPlayer_id()+"\n"+
					                             players.getPlayer_link()+"\n"+
					                              players.getRank());
					
				}
			});
		
		
	}
	private void initdata() {
		new Thread(){
			@Override
			public void run() {
				List<Player> list = new JsonParse(getActivity()).parse();
				if (list!=null) {
					playlist=list;
					mHandler.sendEmptyMessage(SHOW_1);
				}
				
				
			}
		}.start();
			
		}
	public Player getPlayer() {
		int pos = (Integer) lV.getTag();
		Player players=playlist.get(pos);
		return players;
		
	}
}
