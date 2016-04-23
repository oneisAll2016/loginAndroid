package com.example.homework;

public class Player {

	private String player_name;
	private String player_id;
	private String alias;
	private String team_name;
	private String rank;
	private String player_link;
	private String season;
	private String fgac;
	public Player(String player_name, String player_id, String alias,
			String team_name, String rank, String player_link, String season,
			String fgac) {
		super();
		this.player_name = player_name;
		this.player_id = player_id;
		this.alias = alias;
		this.team_name = team_name;
		this.rank = rank;
		this.player_link = player_link;
		this.season = season;
		this.fgac = fgac;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public String getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getPlayer_link() {
		return player_link;
	}
	public void setPlayer_link(String player_link) {
		this.player_link = player_link;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getFgac() {
		return fgac;
	}
	public void setFgac(String fgac) {
		this.fgac = fgac;
	}
	
	

}
