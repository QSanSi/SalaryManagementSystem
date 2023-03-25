package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import util.DbUtil;
import entity.Emp;

public class JdbcEmpDao implements EmpDao {
	public List<Emp> findAll(int page, int pageSize, String empid,String truename, String dept) throws Exception {
		StringBuffer sqlemp = new StringBuffer();
		sqlemp.append("select * from emp where 1=1");
		if (empid != null && !empid.equals("")) {
			sqlemp.append(" and uempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sqlemp.append(" and utruename like'%" + truename + "%'");
		}
		if(dept != null && !dept.equals("ALL")) {
			sqlemp.append(" and deptname='" + dept +"'");
		}
		sqlemp.append(" order by uempid limit ?,?");
		String sql = sqlemp.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pst.setInt(1, begin);// 设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);// 设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Emp> list = new ArrayList<Emp>();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setId(rs.getString("uid"));
			emp.setEmpId(rs.getString("uempid"));
			emp.setTrueName(rs.getString("utruename"));
			emp.setAge(rs.getString("age"));
			emp.setSex(rs.getString("sex"));
			emp.setDeptName(rs.getString("deptname"));
			emp.setStartDate(rs.getString("startdate"));
			list.add(emp);
		}
		DbUtil.closeConnection();
		return list;
	}

	public int countTotalPage(int pageSize,String empid,String truename, String dept) throws Exception {
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select count(*) from emp where 1=1");
		if (empid != null && !empid.equals("")) {
			sqlbuf.append(" and uempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sqlbuf.append(" and utruename like'%" + truename + "%'");
		}
		if (dept != null && !dept.equals("ALL")) {
			sqlbuf.append(" and deptname = '" + dept + "'");
		}
		String sql = sqlbuf.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();// 任何情况下都返回一个结果才可以这么写
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

	public void save(Emp emp) throws Exception {
		Connection conn = DbUtil.getConnection();
		DbUtil.startTransaction();
		String sql = "insert into emp(uid,uempid,utruename,age,sex,birthday,idnum,"
				+ "marry,polity,city,telnum,address,school,degree,startdate,deptname,remark) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		UUID id1 = UUID.randomUUID();
		pst.setString(1, id1.toString());
		pst.setString(2, emp.getEmpId());
		pst.setString(3, emp.getTrueName());
		pst.setString(4, emp.getAge());
		pst.setString(5, emp.getSex());
		pst.setString(6, emp.getBirthday());
		pst.setString(7, emp.getIdNum());
		pst.setString(8, emp.getMarry());
		pst.setString(9, emp.getPolity());
		pst.setString(10, emp.getCity());
		pst.setString(11, emp.getTelNum());
		pst.setString(12, emp.getAddress());
		pst.setString(13, emp.getSchool());
		pst.setString(14, emp.getDegree());
		pst.setString(15, emp.getStartDate());
		pst.setString(16, emp.getDeptName()); //
		pst.setString(17, emp.getRemark());
		pst.executeUpdate();

		String sql2 = "insert into salarystandard(uid,did,dempid,dtruename,ddept,dbasesalary) values(?,?,?,?,?,?)";
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst2.setString(1, id1.toString());
		UUID id2 = UUID.randomUUID();
		pst2.setString(2, id2.toString());
		pst2.setString(3, emp.getEmpId());
		pst2.setString(4, emp.getTrueName());
		pst2.setString(5, emp.getDeptName());
		pst2.setDouble(6, emp.getBasesalary());
		pst2.executeUpdate();
		
		String sql3 = "insert into bank(uid,bid,bempid,btruename,bsex,bdept,btel) values(?,?,?,?,?,?,?)";
		PreparedStatement pst3 = conn.prepareStatement(sql3);		
		pst3.setString(1, id1.toString());
		UUID id3 = UUID.randomUUID();
		pst3.setString(2, id3.toString());
		pst3.setString(3, emp.getEmpId());
		pst3.setString(4, emp.getTrueName());
		pst3.setString(5, emp.getSex());
		pst3.setString(6, emp.getDeptName());
		pst3.setString(7, emp.getTelNum());
		pst3.executeUpdate();

		DbUtil.commit();
		DbUtil.closeConnection();
	}

	public Emp findById(String id) throws Exception {
		String sql = "select * from emp where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Emp user = null;
		if (rs.next()) {
			user = new Emp();
			user.setId(id);
			user.setTrueName(rs.getString("utruename"));
			user.setAddress(rs.getString("address"));
			user.setAge(rs.getString("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getString("city"));
			user.setDegree(rs.getString("degree"));
			user.setDeptName(rs.getString("deptname"));
			user.setEmpId(rs.getString("uempid"));
			user.setIdNum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setSchool(rs.getString("school"));
			user.setStartDate(rs.getString("startdate"));
			user.setTelNum(rs.getString("telnum"));
			user.setTrueName(rs.getString("utruename"));
		}
		DbUtil.closeConnection();
		return user;
	}

	public void update(Emp emp) throws Exception {
		String sql = "update emp set uempid=?,utruename=?,age=?,sex=?,birthday=?,"
				+ "idnum=?,marry=?,polity=?,city=?,telnum=?,address=?,school=?,"
				+ "degree=?,startdate=?,deptname=?,remark=? where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, emp.getEmpId());
		pst.setString(2, emp.getTrueName());
		pst.setString(3, emp.getAge());
		pst.setString(4, emp.getSex());
		pst.setString(5, emp.getBirthday());
		pst.setString(6, emp.getIdNum());
		pst.setString(7, emp.getMarry());
		pst.setString(8, emp.getPolity());
		pst.setString(9, emp.getCity());
		pst.setString(10, emp.getTelNum());
		pst.setString(11, emp.getAddress());
		pst.setString(12, emp.getSchool());
		pst.setString(13, emp.getDegree());
		pst.setString(14, emp.getStartDate());
		pst.setString(15, emp.getDeptName());
		pst.setString(16, emp.getRemark());
		pst.setString(17, emp.getId());
		pst.executeUpdate();
		String sql1 = "update salary set sempid=?,struename=?,sdept=? where uid=?";
		String sql2 = "update salarystandard set dempid=?,dtruename=?,ddept=? where uid=?";
		String sql3 = "update attendence set aempid=?,atruename=?,adept=? where uid=?";
		String sql4 = "update tax set tempid=?,ttruename=?,tsex=?,tidnum=?,tdept=? where uid=?";
		String sql5 = "update bank set bempid=?,btruename=?,bsex=?,bdept=?,btel=? where uid=?";
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		pst1.setString(1, emp.getEmpId());
		pst1.setString(2, emp.getTrueName());
		pst1.setString(3, emp.getDeptName());
		pst1.setString(4, emp.getId());
		pst1.executeUpdate();

		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst2.setString(1, emp.getEmpId());
		pst2.setString(2, emp.getTrueName());
		pst2.setString(3, emp.getDeptName());
		pst2.setString(4, emp.getId());
		pst2.executeUpdate();

		PreparedStatement pst3 = conn.prepareStatement(sql3);
		pst3.setString(1, emp.getEmpId());
		pst3.setString(2, emp.getTrueName());
		pst3.setString(3, emp.getDeptName());
		pst3.setString(4, emp.getId());
		pst3.executeUpdate();
		
		PreparedStatement pst4 = conn.prepareStatement(sql4);
		pst4.setString(1, emp.getEmpId());
		pst4.setString(2, emp.getTrueName());
		pst4.setString(3, emp.getSex());
		pst4.setString(4, emp.getIdNum());
		pst4.setString(5, emp.getDeptName());
		pst4.setString(6, emp.getId());
		pst4.executeUpdate();
		
		PreparedStatement pst5 = conn.prepareStatement(sql5);
		pst5.setString(1, emp.getEmpId());
		pst5.setString(2, emp.getTrueName());
		pst5.setString(3, emp.getSex());
		pst5.setString(4, emp.getDeptName());
		pst5.setString(5, emp.getTelNum());
		pst5.setString(6, emp.getId());
		pst5.executeUpdate();
		DbUtil.closeConnection();
	}

	public void deleteById(String id) throws Exception {
		Connection conn = DbUtil.getConnection();
		String sql = "delete from emp where uid=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();

		String sql1 = "delete from salary where uid=?";
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		pst1.setString(1, id);
		pst1.executeUpdate();

		String sql2 = "delete from salarystandard where uid=?";
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst2.setString(1, id);
		pst2.executeUpdate();

		String sql3 = "delete from attendence where uid=?";
		PreparedStatement pst3 = conn.prepareStatement(sql3);
		pst3.setString(1, id);
		pst3.executeUpdate();
		
		String sql4 = "delete from tax where uid=?";
		PreparedStatement pst4 = conn.prepareStatement(sql4);
		pst4.setString(1, id);
		pst4.executeUpdate();
		
		String sql5 = "delete from bank where uid=?";
		PreparedStatement pst5 = conn.prepareStatement(sql5);
		pst5.setString(1, id);
		pst5.executeUpdate();
		DbUtil.closeConnection();
	}

	/*public List<Emp> findEmp(Emp emp) throws Exception {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from emp where 1=1");
			if (emp.getEmpId() != null && !emp.getEmpId().equals("")) {
				sql.append(" and uempid like '%" + emp.getEmpId() + "%'");
			}
			if (emp.getTrueName() != null && !emp.getTrueName().equals("")) {
				sql.append(" and utruename like '%" + emp.getTrueName() + "%'");
			}
			Connection conn = DbUtil.getConnection();
			Statement stmt = conn.createStatement();
			String str = sql.toString();
			ResultSet rs = stmt.executeQuery(str);
			Emp user = null;
			List<Emp> emps = new ArrayList<Emp>();
			while (rs.next()) {
				user = new Emp();
				user.setId(rs.getString("uid"));
				user.setTrueName(rs.getString("utruename"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getString("age"));
				user.setBirthday(rs.getString("birthday"));
				user.setCity(rs.getString("city"));
				user.setDegree(rs.getString("degree"));
				user.setDeptName(rs.getString("deptname"));
				user.setEmpId(rs.getString("uempid"));
				user.setIdNum(rs.getString("idnum"));
				user.setMarry(rs.getString("marry"));
				user.setPolity(rs.getString("polity"));
				user.setRemark(rs.getString("remark"));
				user.setSex(rs.getString("sex"));
				user.setSchool(rs.getString("school"));
				user.setStartDate(rs.getString("startdate"));
				user.setTelNum(rs.getString("telnum"));
				user.setTrueName(rs.getString("utruename"));
				emps.add(user);
			}
			DbUtil.closeConnection();
			return emps;
		}*/
	}
