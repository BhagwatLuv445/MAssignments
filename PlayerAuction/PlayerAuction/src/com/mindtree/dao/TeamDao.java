package com.mindtree.dao;

import com.mindtree.entity.Team;
import com.mindtree.exceptions.DaoException;

public interface TeamDao {

	public Team[] getTeams() throws DaoException;
	public String[] getPlayersAndCategoryByTeam(String teamName) throws DaoException;
}
