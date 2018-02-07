package com.mindtree.serviceImpl;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exception.DuplicateEntryException;
import com.mindtree.exception.InvalidTeamNameException;
import com.mindtree.exception.NotABatsmanException;
import com.mindtree.exception.NotABowlerException;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.InvalidCategoryException;
import com.mindtree.exceptions.PersistException;
import com.mindtree.managerImpl.PlayerManagerImpl;

public class PlayerService {
	
	public int addPlayer(String playerName,String playerCategory, int highScore, String bestFigure, String teamName) throws InvalidCategoryException, InvalidTeamNameException, DaoException, NotABatsmanException, NotABowlerException, DuplicateEntryException, PersistException{
		
		Team team=new Team(teamName);
		Player player =new Player(playerName, playerCategory, highScore, bestFigure, team);
		
		PlayerManagerImpl playerManager=new PlayerManagerImpl();
		int playerN0 =playerManager.addPlayer(player);
		
		if(playerN0!=-1)
			System.out.println("Player Added Successfullly!!");
		
		
		return playerN0;
	}
}
