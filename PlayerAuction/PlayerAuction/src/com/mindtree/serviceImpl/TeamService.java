package com.mindtree.serviceImpl;

import com.mindtree.daoImpl.TeamDaoImpl;
import com.mindtree.exceptions.DaoException;
import com.mindtree.managerImpl.TeamManagerImpl;

public class TeamService {
	
	public String[] showPlayers(String teamName) throws DaoException{
			
			return new TeamManagerImpl().showPlayers(teamName);
			
		}

}
