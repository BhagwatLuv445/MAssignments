package com.mindtree.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mindtree.dao.PlayerDao;
import com.mindtree.entity.Player;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.PersistException;

public class PlayerDaoImpl implements PlayerDao{
	int playerNo=-1;
	public int addPlayer(Player player) throws PersistException {
		boolean f = false;	
		
	
		
		String sql = "insert into player(player_name, category, highestScore, bestFigure) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			/*
			 * get database connection
			 */
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,player.getPlayerName());
			ps.setString(2,player.getCategory());
			ps.setInt(3,player.getHighestScore());
			ps.setString(4,player.getBestFigure());
			ps.executeUpdate();
			f = true;

			//return player no
			sql="Select count(*) from player";
			ps = con.prepareStatement(sql);
//			ps.setString(1,player.getPlayerName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				this.playerNo = rs.getInt(1);
				break;
				
			}
			
		} catch (Exception cause) {
			
			throw new PersistException("Exception Occured in saving record");
		}
		
		
		
		finally {
			/*
			 * release PreparedStatement
			 */
			DBUtil.releaseResource(ps);
			/*
			 * release Connection
			 */
			DBUtil.releaseResource(con);
		}
		
		
		return this.playerNo;
	}
	

	public boolean addTeam_Player(Player player) throws PersistException, DaoException {
		boolean f = false;	
		
		TeamDaoImpl teamDao=new TeamDaoImpl();
		int teamId=teamDao.getTeamIdByName(player.getTeam().getTeamName());
		
		String sql = "insert into Team_Player(player_no, Team_Id) values(?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			/*
			 * get database connection
			 */
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,player.getPlayerNo());
			ps.setInt(2,teamId);/*
			ps.setString(3,player.getCategory());
			ps.setInt(4,player.getHighestScore());
			ps.setString(5,player.getBestFigure());*/
			ps.executeUpdate();
			f = true;

		} catch (Exception cause) {
			
			throw new PersistException("Exception Occured in saving record");
		}
		
		finally {
			/*
			 * release PreparedStatement
			 */
			DBUtil.releaseResource(ps);
			/*
			 * release Connection
			 */
			DBUtil.releaseResource(con);
		}
		
		
		return f;
	}
	public boolean checkNotDuplicate(Player player) throws PersistException
		{
		boolean flag=true;
		Connection con = null;
			PreparedStatement ps = null;
			String name = null;
			String playerName = player.getPlayerName();
			
			//player is not already 
			String sql1 = "select p.Player_Name, p.category from  Player p "
					+ " inner join Team_Player  tp on p.Player_No= tp.Player_No inner join"
					+" Team t on tp.Team_Id = t.Team_Id where p.Player_Name=?";
			try
			{
				
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, playerName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				name = rs.getString("emp_name");
				flag=false;
				
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new PersistException("Exception occured in validity of record");
			}
			
			return flag;
		}

}
