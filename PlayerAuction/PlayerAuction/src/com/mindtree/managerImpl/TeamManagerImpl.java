package com.mindtree.managerImpl;

import com.mindtree.daoImpl.TeamDaoImpl;
import com.mindtree.entity.Team;
import com.mindtree.exceptions.DaoException;

public class TeamManagerImpl {
	
	public String[] showPlayers(String teamName) throws DaoException{
		
		TeamDaoImpl dao=new TeamDaoImpl();
		String []players=dao.getPlayersAndCategoryByTeam(teamName);
		return players;
		
	}

}
