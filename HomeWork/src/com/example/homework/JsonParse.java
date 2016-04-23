package com.example.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.homework.R.id;

import android.R.integer;
import android.content.Context;

public class JsonParse {

	private Context mContext;

public JsonParse(Context context) {
		mContext = context;
	}
public List<Player> parse() {
		List<Player> players = new ArrayList<Player>();
		String streamtoString = streamtoString(mContext.getResources()
				.openRawResource(R.raw.nba));
		try {

			JSONObject jsonObject = new JSONObject(streamtoString);
			JSONArray jsonArray = jsonObject.getJSONArray("result");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = (JSONObject) jsonArray.get(i);
					String string_name = object.getString("player_name");
					String string_id = object.getString("player_id");
					String string_aname = object.getString("alias");
					String string_teamname = object.getString("team_name");

					String string_rank = object.getString("rank");
					String string_player_link = object.getString("player_link");
					JSONObject jsonObject2 = object
							.getJSONObject("personal_data");
					String string2 = jsonObject2.getString("season");
					String string3 = jsonObject2.getString("fgac");
					Player player = new Player(string_name, string_id,
							string_aname, string_teamname, string_rank,
							string_player_link, string2, string3);
					players.add(player);
					
					System.out.println("-------------"+string_name);	
              } 
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return players;

	}

	// 把资源流转化为String
	private String streamtoString(InputStream is) {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line+"\n");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();

	}

}
