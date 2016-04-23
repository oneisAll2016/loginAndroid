package com.example.homework;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private FragmentManager mFragmentManager;
	private Button button;

	private PlayerAdapter mAdapter;
	private List<Player> playlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initview();
	}

	private void initview() {
		fragment1=new Fragment1();
		fragment2=new Fragment2();
		mFragmentManager=getSupportFragmentManager();
		mFragmentManager.beginTransaction().replace(R.id.fl1, fragment1).commit();
		mFragmentManager.beginTransaction().replace(R.id.fl2, fragment2).commit();
		button=(Button) findViewById(R.id.next);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,webinfo.class);
				Player player=fragment1.getPlayer();
				String player_link = player.getPlayer_link();
				intent.putExtra("URL", player_link);
				startActivity(intent);
			}
		});
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	public void setf2text(String s) {
		fragment2.settvinfo(s);
	}

}
