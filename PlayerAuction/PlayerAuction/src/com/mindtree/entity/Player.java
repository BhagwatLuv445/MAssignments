package com.mindtree.entity;

public class Player {
	private int playerNo;
	private String playerName;
	private String category;
	private int highestScore;
	private String bestFigure;
	private Team team;
	
	public int getPlayerNo() {
		return playerNo;
	}
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public Player( String playerName, String category, int highestScore, String bestFigure, Team team) {
		super();
		
		this.playerName = playerName;
		this.category = category;
		this.highestScore = highestScore;
		this.bestFigure = bestFigure;
		this.team = team;
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public String getBestFigure() {
		return bestFigure;
	}
	public void setBestFigure(String bestFigure) {
		this.bestFigure = bestFigure;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	

}
