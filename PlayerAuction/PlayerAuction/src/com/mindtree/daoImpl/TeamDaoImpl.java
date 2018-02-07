package com.mindtree.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.entity.Team;
import com.mindtree.exceptions.DaoException;

public class TeamDaoImpl {
	
	public Team[] getTeams() throws DaoException {
		
		List<Team> teams=new ArrayList<Team>();
		boolean flag=false;
		String sql = "select * from Team";
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement(sql);
//			st.setString(1,mId);
			rs = st.executeQuery();
			if (rs.isBeforeFirst())
			{
			while(rs.next()) {
				teams.add(new Team(rs.getInt("team_id"),rs.getString("team_name")));
			}
			}
		} catch (SQLException e) {
			throw new DaoException("Exception Occured in fetching record");
		}
		return teams.toArray(new Team[teams.size()]);
	}

	public int getTeamIdByName(String teamName) throws DaoException {
			
			
			boolean flag=false;
			String sql = "select Team_Id from Team where Team_Name=?";
			PreparedStatement st = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = DBUtil.getConnection();
				st = con.prepareStatement(sql);
				st.setString(1,teamName);
				rs = st.executeQuery();
				if (rs.isBeforeFirst())
				{
				while(rs.next()) {
					return rs.getInt(1);
				}
				}
			} catch (SQLException e) {
				throw new DaoException("Exception Occured in fetching record");
			}
			return -1;
		}
	
	public String[] getPlayersAndCategoryByTeam(String teamName) throws DaoException {
		
		ArrayList<String> players= new ArrayList<String>();
		boolean flag=false;
		String sql = "select p.Player_Name,p.category from  Player p inner join Team_Player "
				+ " tp on p.Player_No= tp.Player_No inner join"
				+"  Team t on tp.Team_Id = t.Team_Id where t.Team_name=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1,teamName);
			rs = st.executeQuery();
			if (rs.isBeforeFirst())
			{
			while(rs.next()) {
				players.add(rs.getString(1)+","+rs.getString(2));
			}
			}
		} catch (SQLException e) {
			throw new DaoException("Exception Occured in fetching record");
		}
		
		return players.toArray(new String[players.size()]);
	}
}
