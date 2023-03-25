package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import util.DbUtil;
import entity.Dept;

public class JdbcDeptDao implements DeptDao {
	public List<Dept> findAll(int page, int pageSize, String deptname, String manager) throws Exception {
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select * from dept where 1=1");
		if(deptname != null && !deptname.equals("")) {
			sqlbuf.append(" and name like'%" + deptname + "%'");
		}
		if(manager != null && !manager.equals("")) {
			sqlbuf.append(" and manager like'%" + manager + "%'");
		}
		sqlbuf.append(" order by number limit ?,?");	
		String sql = sqlbuf.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		// ���÷�ҳ��ѯ����
		int begin = (page - 1) * pageSize;
		pst.setInt(1, begin);// ����ץȡ����ʼ��(��0��ʼ)
		pst.setInt(2, pageSize);// �������ץȡ��¼��
		ResultSet rs = pst.executeQuery();
		List<Dept> list = new ArrayList<Dept>();
		while (rs.next()) {
			Dept dept = new Dept();
			dept.setId(rs.getString("id"));
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
			list.add(dept);
		}
		DbUtil.closeConnection();
		return list;
	}

	public int countTotalPage(int pageSize, String deptname, String manager) throws Exception {
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select count(*) from dept where 1=1");
		if(deptname != null && !deptname.equals("")) {
			sqlbuf.append(" and name like'%" + deptname + "%'");
		}
		if(manager != null && !manager.equals("")) {
			sqlbuf.append(" and manager like'%" + manager + "%'");
		}	
		String sql = sqlbuf.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();// �κ�����¶�����һ������ſ�����ôд
		int totalRows = rs.getInt(1);
		DbUtil.closeConnection();
		// ����totalRows��pageSize������ҳ��totalPages
		if (totalRows == 0) {
			return 1;// û�м�¼��Ϊ1ҳ
		} else if (totalRows % pageSize == 0) {
			return totalRows / pageSize;
		} else {
			return totalRows / pageSize + 1;
		}
	}

	public void save(Dept dept) throws Exception {
		String sql = "insert into dept(id,name,remark,manager,number,tel) values(?,?,?,?,?,?)";
		Connection conn = DbUtil.getConnection();
		DbUtil.startTransaction();
		PreparedStatement pst = conn.prepareStatement(sql);
		UUID id = UUID.randomUUID();
		pst.setString(1, id.toString());
		pst.setString(2, dept.getName());
		pst.setString(3, dept.getRemark());
		pst.setString(4, dept.getManager());
		pst.setString(5, dept.getNumber());
		pst.setString(6, dept.getTel());
		pst.executeUpdate();
		
		//�������Ž�������
		String sql2 = "insert into attendenceset(cdept,clatecome,cearlyleave,cleave,covertime,cnegletwork) values(?,0,0,0,0,0)";
		conn = DbUtil.getConnection();
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst2.setString(1, dept.getName());
		pst2.executeUpdate();
		DbUtil.commit();
		DbUtil.closeConnection();
	}

	public Dept findById(String id) throws Exception {
		String sql = "select * from dept where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Dept dept = null;
		if (rs.next()) {
			dept = new Dept();
			dept.setId(id);
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
		}
		DbUtil.closeConnection();
		return dept;
	}

	public void update(Dept dept) throws Exception {
		String sql = "update dept set name=?,remark=?," + "manager=?,number=?,tel=? where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, dept.getName());
		pst.setString(2, dept.getRemark());
		pst.setString(3, dept.getManager());
		pst.setString(4, dept.getNumber());
		pst.setString(5, dept.getTel());
		pst.setString(6, dept.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();

	}

	public void deleteById(String id) throws Exception {
		String sql = "delete from dept where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();

	}

	/*public List<Dept> findDept(String name, String manager) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from dept where 1=1");
		if (name != null && !name.equals("")) {
			sql.append(" and name like'%" + name + "%'");
		}
		if (manager != null && !manager.equals("")) {
			sql.append(" and manager like'%" + manager + "%'");
		}
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		String str = sql.toString();
		ResultSet rs = stmt.executeQuery(str);
		List<Dept> list = new ArrayList<Dept>();
		while (rs.next()) {
			Dept dept = new Dept();
			dept.setId(rs.getString("id"));
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
			list.add(dept);
		}
		DbUtil.closeConnection();
		return list;
	}*/

	public List<Dept> showDept() throws Exception {
		String sql = "select * from dept order by number";
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Dept> list = new ArrayList<Dept>();
		while (rs.next()) {
			Dept dept = new Dept();
			dept.setId(rs.getString("id"));
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
			list.add(dept);
		}
		DbUtil.closeConnection();
		return list;
	}
	
	public List<Dept> showDept2(String dept) throws Exception {
		String sql = "select * from dept where name=?";		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, dept);
		ResultSet rs = pst.executeQuery();
		List<Dept> list = new ArrayList<Dept>();
		while (rs.next()) {
			Dept depts = new Dept();
			depts.setId(rs.getString("id"));
			depts.setManager(rs.getString("manager"));
			depts.setName(rs.getString("name"));
			depts.setNumber(rs.getString("number"));
			depts.setRemark(rs.getString("remark"));
			depts.setTel(rs.getString("tel"));
			list.add(depts);
		}
		DbUtil.closeConnection();
		return list;
	}

	public List<String> showName(String dept) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select name from dept where 1=1");
		if (!dept.equals("super") && !dept.equals("ALL")) {
			sql.append(" and name = '" + dept + "'");
		}
		sql.append(" order by number");
		String str = sql.toString();
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		List<String> deptlist = new ArrayList<String>();
		if (dept.equals("super") || dept.equals("ALL")) {
			deptlist.add("ALL");
		}
		while (rs.next()) {
			String depts = rs.getString("name");
			deptlist.add(depts);
		}
		DbUtil.closeConnection();
		return deptlist;
	}
	
	public List<String> showName2() throws Exception {
		String sql = "select name from dept order by number";
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<String> deptlist = new ArrayList<String>();
		deptlist.add("ALL");
		while (rs.next()) {
			String depts = rs.getString("name");
			deptlist.add(depts);
		}
		DbUtil.closeConnection();
		return deptlist;
	}
}
