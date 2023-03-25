package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import util.DbUtil;
import entity.User;

public class JdbcUserDao implements UserDao {
	
	@Override
	public User findByUsername(String username) throws Exception {
		Connection conn = DbUtil.getConnection();
		User user = null;
		Statement stat = conn.createStatement();
		String sql = "select * from user where username='" + username + "'";
		ResultSet rs = stat.executeQuery(sql);
		if (rs.next()) {
			String id = rs.getString("uid");
			String password = rs.getString("password");
			String rights = rs.getString("rights");
			String dept = rs.getString("dept");
			user = new User();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setRights(rights);
			user.setDept(dept);
		}
		DbUtil.closeConnection();
		return user;
	}

	@Override
	public void save(User user) throws Exception {
		String sql = "insert into user(uid,username,password,rights,dept) values(?,?,?,?,?)";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		UUID id = UUID.randomUUID();
		pst.setString(1, id.toString());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getRights());
		pst.setString(5, user.getDept());
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	@Override
	public List<User> findAll(int page, int pageSize, String username) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from user where 1=1");
		if (username != null && !username.equals("")) {
			sql.append(" and username like'%" + username + "%'");
		}
		sql.append(" order by uid limit ?,?");
		String sqlUser = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sqlUser);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pst.setInt(1, begin);// 设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);// 设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<User> list = new ArrayList<User>();
		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRights(rs.getString("rights"));
			user.setDept(rs.getString("dept"));
			list.add(user);
		}
		DbUtil.closeConnection();
		return list;
	}

	@Override
	public int countTotalPage(int pageSize, String username) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from user where 1=1");
		if (username != null && !username.equals("")) {
			sql.append(" and username like'%" + username + "%'");
		}
		String str = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(str);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int totalRows = rs.getInt(1);
		DbUtil.closeConnection();
		// 根据totalRows和pageSize计算总页数totalPages
		if (totalRows == 0) {
			return 1;// 没有记录认为1页
		} else if (totalRows % pageSize == 0) {
			return totalRows / pageSize;
		} else {
			return totalRows / pageSize + 1;
		}
	}

	@Override
	public User findById(String username) throws Exception {
		String sql = "select * from user where username=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRights(rs.getString("rights"));
			user.setDept(rs.getString("dept"));
		}
		DbUtil.closeConnection();
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		String sql = "update user set username=?,password=?," 
	    + "rights=?,dept=? where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getRights());
		pst.setString(4, user.getDept());
		pst.setString(5, user.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	@Override
	public void deleteById(String username) throws Exception {
		String sql = "delete from user where username=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);
		pst.executeUpdate();
		DbUtil.closeConnection();
	}
}
