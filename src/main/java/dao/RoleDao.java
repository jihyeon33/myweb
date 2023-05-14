package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Role;

public class RoleDao {
	private static String dburl="jdbc:mysql://localhost:3306/connectdb?useSSL=false";
	private static String dbuser="connectuser";
	private static String dbpswd= "connect123!@#";
	
	/* 셀렉트 JDBCExam1.java*/
	public Role getRole(Integer roleId) {
		Role role =null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(dburl, dbuser, dbpswd);
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,roleId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String description= rs.getString(1);
				int id= rs.getInt("role_id");
				role = new Role(id, description);
			}			
		}catch(Exception e){
			e.printStackTrace();			
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}			
		}
		return role;
	}

	/* 인서트 JDBCExam2.java*/
	public int addRole(Role role) {
		Connection conn = null;
		PreparedStatement ps= null;
		int cnt = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			conn = DriverManager.getConnection(dburl, dbuser, dbpswd);
			ps = conn.prepareStatement("INSERT INTO role (role_id, description) VALUES ( ?, ? )");
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			cnt = ps.executeUpdate();				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;	
	}

	/* 셀렉트 JDBCExam3.java*/
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection conn= DriverManager.getConnection(dburl, dbuser, dbpswd);
			PreparedStatement ps = conn.prepareStatement("SELECT description, role_id FROM role order by role_id desc")){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					int roleId= rs.getInt("role_id");
					String description = rs.getString("description");
					Role role = new Role(roleId, description);
					list.add(role);
				}				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		return list;
	}
	/* 삭제 JDBCExam4.java*/
	public int deleteRole(int roleId) {
		Connection conn=null;
		PreparedStatement ps= null;
		int cnt=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection(dburl, dbuser, dbpswd);
			ps= conn.prepareStatement("DELETE FROM role WHERE role_id= ?");
			ps.setInt(1, roleId);
			cnt = ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	/* 업데이트 JDBCExam5.java*/
	public int updateRole(Role role) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn= DriverManager.getConnection(dburl, dbuser, dbpswd);
			ps= conn.prepareStatement("UPDATE role set description=? where role_id=?");
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
}
