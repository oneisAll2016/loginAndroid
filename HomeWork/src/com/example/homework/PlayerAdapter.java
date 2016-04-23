package com.example.homework;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerAdapter extends BaseAdapter {
	private List<Player>players;
	private Context mContext;
	public  PlayerAdapter(Context context,List<Player>playerlist) {
		if(playerlist==null||context==null){
			Toast.makeText(context, "kong", Toast.LENGTH_LONG).show();
		}
		mContext = context;
		players=playerlist;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return players==null?0:players.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			 convertView=View.inflate(mContext, R.layout.player_name_layout, null);
			 holder=new ViewHolder();
			 holder.tV=(TextView) convertView.findViewById(R.id.tv);
			 convertView.setTag(holder);
			 
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		Player player=players.get(position);
		
		holder.tV.setText(player.getPlayer_name());
		
		return convertView;
	}
	class ViewHolder{
		TextView tV;
	}

}
