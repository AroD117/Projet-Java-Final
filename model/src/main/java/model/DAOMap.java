package model;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.motionless.MotionlessEntityFactory;
import entity.Map;
import entity.mobile.*;



public class DAOMap {

	private final Connection connection;
	private static int x =0, y=0;

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	
	public static final Map BDD(int level) throws IOException {
		Map map =null;
		
		try {
			final String sql = "SELECT map FROM map" + level;
			final CallableStatement call = prepareCall(sql);
			call.execute();
			final ResultSet rs = call.getResultSet();
			map = Switch(rs, level);
			return map;
		
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Map Switch(final ResultSet rs, int level) throws SQLException, IOException{

		Map tempMap = new Map(level, new Entity[Map.getWidth()][Map.getHeight()]);

		while (rs.next()) {
			
			for(char ch : rs.getString("map").toCharArray()) { 
					if (x == Map.getWidth()) {
						x = 0;
						y++;
					}
				
					tempMap.setOnMapXY(MotionlessEntityFactory.getFromDBSymbol(ch), x, y);

					if(ch == 'd') {
						tempMap.add(new Diamond(x, y, tempMap));
						tempMap.increaseDiamondCount();
					}
					if(ch == 'c') {
						tempMap.add(new Rock(x, y, tempMap));
					}
					
				
					++x;
			}	
		}
		return tempMap;
	}
	
	public static CallableStatement prepareCall(final String query) throws SQLException {
		return DBConnection.getInstance().getConnection().prepareCall(query);
	}
}


















