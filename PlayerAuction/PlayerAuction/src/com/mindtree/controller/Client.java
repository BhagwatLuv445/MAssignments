package com.mindtree.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.mindtree.exception.DuplicateEntryException;
import com.mindtree.exception.InvalidTeamNameException;
import com.mindtree.exception.NotABatsmanException;
import com.mindtree.exception.NotABowlerException;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.InvalidCategoryException;
import com.mindtree.exceptions.PersistException;
import com.mindtree.serviceImpl.PlayerService;
import com.mindtree.serviceImpl.TeamService;

public class Client {
	String playerName;
	String category;
	int highScore;
	String bestFigure;
	String teamName;
	int playerNo;
	
	String[] teamPlayers; 

	public  boolean addPlayer() throws IOException {
		
		
		System.out.println("Add Player!!");
		System.out.println("--------------------------");
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Player Name:");
		playerName=sc.nextLine();
		
		System.out.println("Enter Category:");
		category=sc.nextLine();
		
		System.out.println("Enter Highest Score :");
		highScore=sc.nextInt();
		
		System.out.println("Enter Best Figure :");
		bestFigure=sc.next();
		
		System.out.println("Enter Team Name :");
		teamName=sc.next();
		
		int playerNo;
		try {
			PlayerService service=new PlayerService();
			playerNo = service.addPlayer(playerName, category,  highScore,  bestFigure,  teamName);
			System.out.println("Player added successfully with player No.:"+playerNo);
		} catch (InvalidCategoryException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid category of the player");
			return false;
		}
		catch (InvalidTeamNameException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Team Name");
			return false;
		}
		catch (NotABatsmanException e) {
			// TODO Auto-generated catch block
			System.out.println("Not a batsman");
			return false;
		}
		
		catch (NotABowlerException e) {
			// TODO Auto-generated catch block
			System.out.println("Not a batsman");
			return false;
		}
		
		catch (DuplicateEntryException e) {
			// TODO Auto-generated catch block
			System.out.println("Duplicate Entry for player");
			return false;
		}
		
		catch (DaoException|PersistException e) {
			// TODO Auto-generated catch block
			System.out.println("There is something wrong with query execution...! :(");
			return false;
		}
		return true;
	}

	public boolean showPlayers() throws IOException{
		System.out.println(" Display Players!!");
		System.out.println("--------------------------------");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Team Name:");
		teamName=br.readLine();
		
		int playerNo;
		try {
			TeamService service=new TeamService();
			teamPlayers = service.showPlayers(teamName);
			System.out.println("Player Name\t Category");
			System.out.println("------------------------------------------");
			for(String itr:teamPlayers){
				System.out.println(itr.split(",")[0]+"\t"+itr.split(",")[1]);
				
			}
			return true;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}
	
	public static void main(String args[]) throws IOException{
		System.out.println("Please choose from the following optins ");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String choice;
		Client client=new Client();
		do{
			System.out.println("1. Add a player "
					+ "2. Display players "
					+ "3. Exit ");
			choice=br.readLine();
			switch(choice){
				case "1":
					client.addPlayer();
					break;
				case "2":
					client.showPlayers();
					break;
					
				case "3":
					System.out.println("Exiting the program!!");
					System.exit(0);
				
			
			}
			
		}while(choice!="3");
		
	}
}
