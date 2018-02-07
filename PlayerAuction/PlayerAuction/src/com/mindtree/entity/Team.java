package com.mindtree.entity;

import java.util.List;

public class Team {
	
	private int teamId;
	private String teamName;
	
	private List<Player> playersList;
	
	
	public Team(int teamId, String teamName) {
		
		this.teamId=teamId;
		this.teamName=teamName;
	}
	public Team(String teamName2) {
		this.teamName=teamName2;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Player> getPlayersList() {
		return playersList;
	}
	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}
	
	

}
