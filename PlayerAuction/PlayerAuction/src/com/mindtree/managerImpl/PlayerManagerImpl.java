package com.mindtree.managerImpl;

import com.mindtree.daoImpl.PlayerDaoImpl;
import com.mindtree.daoImpl.TeamDaoImpl;
import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exception.DuplicateEntryException;
import com.mindtree.exception.InvalidTeamNameException;
import com.mindtree.exception.NotABatsmanException;
import com.mindtree.exception.NotABowlerException;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.InvalidCategoryException;
import com.mindtree.exceptions.PersistException;

public class PlayerManagerImpl {
	int playerNo;
	public int addPlayer(Player player) throws InvalidCategoryException, InvalidTeamNameException, DaoException, 
													NotABatsmanException, NotABowlerException, DuplicateEntryException, PersistException{
		if(!isValidCategory(player))
			return -1;
		
		if(!isValidTeamName(player))
		return -1;
		
		if(player.getCategory().equalsIgnoreCase("batsman")){
			if(!checkBatsman(player))
				return -1;
		}
		
		if(player.getCategory().equalsIgnoreCase("bowler")){
			if(!checkBowler(player))
				return -1;
		}
		
		isNotDuplicate(player);
//			return -1;
		
		PlayerDaoImpl playerDao=new PlayerDaoImpl();
		playerNo=playerDao.addPlayer(player);
		if(playerNo==-1)
			return -1;
		player.setPlayerNo(playerNo);
		
		if(!playerDao.addTeam_Player(player))
			return -1;
		
		
			return playerNo;
		
	}
	

	public boolean isValidCategory(Player player) throws InvalidCategoryException{
		String category=player.getCategory();
		if(category.equalsIgnoreCase("bowler")||category.equalsIgnoreCase("batsman")||category.equalsIgnoreCase("all rounder"))
			return true;
		
			throw new InvalidCategoryException("The category is invalid");
		
		
	}
	
	
	public boolean isValidTeamName(Player player) throws InvalidTeamNameException, DaoException{
		String teamName=player.getTeam().getTeamName();
		TeamDaoImpl teamDao=new TeamDaoImpl();
		for(Team itr:teamDao.getTeams()){
			
			if(itr.getTeamName().equalsIgnoreCase(teamName))
				return true;
		}
			throw new InvalidTeamNameException("Team name not available in the database");
	}

	public boolean checkBatsman(Player player) throws NotABatsmanException {
		String category=player.getCategory();
		int highScore=player.getHighestScore();
		if(category.equalsIgnoreCase("batsman")){
			if(!(highScore>=50 && highScore<=200))
				throw new NotABatsmanException("Not A Bats man");;
		}
		
		return true;
	}
		
	public boolean checkBowler(Player player) throws NotABowlerException {
		String category=player.getCategory();
		int highScore=player.getHighestScore();
		String figure=player.getBestFigure();
		if(category.equalsIgnoreCase("bowler")){
			if(highScore==-1)
				throw new NotABowlerException ("Not A Bowler");;
				
			if(figure==null)
				throw new NotABowlerException ("Not A Bowler");;
		}
		
		return true;
	}

	public boolean isNotDuplicate(Player player) throws DuplicateEntryException, PersistException {
		
		PlayerDaoImpl playerDao=new PlayerDaoImpl();
		if(playerDao.checkNotDuplicate(player))
			return true;
		
		
		throw new DuplicateEntryException("Duplicate Entry for player");
		
		
	}
	
}
