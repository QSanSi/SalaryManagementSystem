package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import util.DbUtil;
import entity.Attendence;
import entity.AttendenceSet;
import entity.Emp;
import entity.User;

public class JdbcAttendenceDao implements AttendenceDao {
	public List<Attendence> findAll(int page, int pageSize,  String empid,String truename, String dept, String year, String month) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from attendence where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and aempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and atruename like'%" + truename + "%'");
		}
		if (!dept.equals("super") && !dept.equals("ALL")) {
			sql.append(" and adept='" + dept +"'");
		}
		sql.append(" and ayear=? and amonth=? order by aempid limit ?,?");
		String sqlAttendence = sql.toString();
		Connection conn = DbUtil.getConnection();
		// ��ѯ������Ϣ
		PreparedStatement pstAttendence = conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		// ���÷�ҳ��ѯ����
		int begin = (page - 1) * pageSize;
		pstAttendence.setInt(3, begin);// ����ץȡ����ʼ��(��0��ʼ)
		pstAttendence.setInt(4, pageSize);// �������ץȡ��¼��
		ResultSet rsAttendence = pstAttendence.executeQuery();
		List<Attendence> attendences = new ArrayList<Attendence>();
		Attendence attendence = null;
		while (rsAttendence.next()) {
			attendence = new Attendence();
			attendence.setId(rsAttendence.getString("aid"));
			attendence.setEmpId(rsAttendence.getString("aempid"));
			attendence.setDept(rsAttendence.getString("adept"));
			attendence.setTrueName(rsAttendence.getString("atruename"));
			attendence.setYear(rsAttendence.getString("ayear"));
			attendence.setMonth(rsAttendence.getString("amonth"));
			attendence.setLateCome(rsAttendence.getInt("alatecome"));
			attendence.setEarlyLeave(rsAttendence.getInt("aearlyleave"));
			attendence.setLeave(rsAttendence.getInt("aleave"));
			attendence.setOvertime(rsAttendence.getInt("aovertime"));
			attendence.setNegletwork(rsAttendence.getInt("anegletwork"));
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}

	public int countTotalPage(int pageSize, String empid,String truename, String dept, String year, String month) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from attendence where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and aempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and atruename like'%" + truename + "%'");
		}
		if (!dept.equals("super") && !dept.equals("ALL")) {
			sql.append(" and adept = '" + dept + "'");
		}
		sql.append(" and ayear=? and amonth=?");
		String str = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(str);
		pst.setString(1, year);
		pst.setString(2, month);
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

	public void save(Attendence attendence) throws Exception {
		/*
		 * String sql =
		 * "insert into attendence(aid,aempid,ayear,amonth,aworkhour,alatecome," +
		 * "aearlyleave,aleavedays,atruename) values(?,?,?,?,?,?,?,?,?)"; Connection
		 * conn = DbUtil.getConnection(); PreparedStatement pst =
		 * conn.prepareStatement(sql); UUID id=UUID.randomUUID();
		 * pst.setString(1,id.toString()); pst.setString(2,attendence.getEmpId());
		 * pst.setString(3,attendence.getYear());
		 * pst.setString(4,attendence.getMonth());
		 * pst.setInt(5,attendence.getWorkHour());
		 * pst.setInt(6,attendence.getLateCome()); pst.setInt(7,
		 * attendence.getEarlyLeave()); // pst.setFloat(8, attendence.getLeaveDays());
		 * pst.setString(9, attendence.getTrueName()); pst.executeUpdate();
		 * DbUtil.closeConnection();
		 */

	}

	public Attendence findById(String id) throws Exception {
		String sql = "select * from attendence where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Attendence attendence = null;
		if (rs.next()) {
			attendence = new Attendence();
			attendence.setId(rs.getString("aid"));
			attendence.setEmpId(rs.getString("aempid"));
			attendence.setTrueName(rs.getString("atruename"));
			attendence.setDept(rs.getString("adept"));
			attendence.setYear(rs.getString("ayear"));
			attendence.setMonth(rs.getString("amonth"));
			attendence.setLateCome(rs.getInt("alatecome"));
			attendence.setEarlyLeave(rs.getInt("aearlyleave"));
			attendence.setLeave(rs.getInt("aleave"));
			attendence.setOvertime(rs.getInt("aovertime"));
			attendence.setNegletwork(rs.getInt("anegletwork"));
		}
		DbUtil.closeConnection();
		return attendence;
	}

	public void update(Attendence attendence) throws Exception {
		String sql = "update attendence set alatecome=?,aearlyleave=?,"
				+ "aleave=? ,aovertime=?,anegletwork=?  where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, attendence.getLateCome());
		pst.setInt(2, attendence.getEarlyLeave());
		pst.setInt(3, attendence.getLeave());
		pst.setInt(4, attendence.getOvertime());
		pst.setInt(5, attendence.getNegletwork());
		pst.setString(6, attendence.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();

	}

	public void deleteById(String id) throws Exception {
		String sql = "delete from attendence where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();

	}

	/*public List<Attendence> findAttendence(int page, int pageSize, Attendence attendence) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from attendence where 1=1");
		if (!attendence.getDept().equals("ALL")) {
			sql.append(" and adept = '" + attendence.getDept() + "'");
		}
		if (attendence.getEmpId() != null && !attendence.getEmpId().equals("")) {
			sql.append(" and aempid like'%" + attendence.getEmpId() + "%'");
		}
		if (attendence.getTrueName() != null && !attendence.getTrueName().equals("")) {
			sql.append(" and atruename like'%" + attendence.getTrueName() + "%'");
		}
		sql.append(" and ayear like'%" + attendence.getYear() + "%'");
		sql.append(" and amonth like'%" + attendence.getMonth() + "%'");
		sql.append(" limit ?,?");
		String str = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(str);
		int begin = (page - 1) * pageSize;
		pst.setInt(1, begin);
		pst.setInt(2, pageSize);
		ResultSet rs = pst.executeQuery();
		Attendence a = null;
		List<Attendence> attendences = new ArrayList<Attendence>();
		while (rs.next()) {
			a = new Attendence();
			a.setId(rs.getString("aid"));
			a.setEmpId(rs.getString("aempid"));
			a.setDept(rs.getString("adept"));
			a.setTrueName(rs.getString("atruename"));
			a.setYear(rs.getString("ayear"));
			a.setMonth(rs.getString("amonth"));
			a.setLateCome(rs.getInt("alatecome"));
			a.setEarlyLeave(rs.getInt("aearlyleave"));
			a.setLeave(rs.getInt("aleave"));
			a.setOvertime(rs.getInt("aovertime"));
			a.setNegletwork(rs.getInt("anegletwork"));
			attendences.add(a);
		}
		return attendences;
	}*/

	public List<Attendence> showAttendence() throws Exception {
		/*
		 * String sql="select  * from attendence"; Connection conn =
		 * DbUtil.getConnection(); Statement stmt=conn.createStatement(); ResultSet
		 * rs=stmt.executeQuery(sql); List<Attendence> list = new
		 * ArrayList<Attendence>(); while(rs.next()){ Attendence attendence = new
		 * Attendence(); attendence.setEarlyLeave(rs.getInt("earlyleave"));
		 * attendence.setEmpId(rs.getString("empid"));
		 * attendence.setId(rs.getString("id"));
		 * attendence.setLateCome(rs.getInt("latecome"));
		 * attendence.setLeaveDays(rs.getInt("leavedays"));
		 * attendence.setMonth(rs.getString("month"));
		 * attendence.setWorkHour(rs.getInt("workhour"));
		 * attendence.setYear(rs.getString("year"));
		 * attendence.setTrueName(rs.getString("truename")); list.add(attendence); }
		 * DbUtil.closeConnection();
		 */
		return null;
	}

	public AttendenceSet findAttendenceSet(String dept) throws Exception {
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select * from attendenceset where 1=1");
		if (!dept.equals("super")) {
			sqlbuf.append(" and cdept='" + dept +"'");
		}
		sqlbuf.append(" order by cdept");
		String sql = sqlbuf.toString();
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		AttendenceSet attendenceSet = null;
		if (rs.next()) {
			attendenceSet = new AttendenceSet();
			attendenceSet.setDept(rs.getString("cdept"));
			attendenceSet.setEarlyLeave(rs.getDouble("cearlyleave"));
			attendenceSet.setLateCome(rs.getDouble("clatecome"));
			attendenceSet.setLeave(rs.getDouble("cleave"));
			attendenceSet.setOvertime(rs.getDouble("covertime"));
			attendenceSet.setNegletwork(rs.getDouble("cnegletwork"));
		}
		return attendenceSet;
	}

	public void updateSet(AttendenceSet attendenceSet) throws Exception {
		String sql = "update attendenceset set cearlyleave=?,clatecome=?, "
				+ "cleave=?,covertime=?,cnegletwork=?  where cdept=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, attendenceSet.getEarlyLeave());
		pst.setDouble(2, attendenceSet.getLateCome());
		pst.setDouble(3, attendenceSet.getLeave());
		pst.setDouble(4, attendenceSet.getOvertime());
		pst.setDouble(5, attendenceSet.getNegletwork());
		pst.setString(6, attendenceSet.getDept());
		pst.executeUpdate();
	}

	public List<Attendence> generateByMonth(int page, int pageSize, String dept, String year, String month) throws Exception {
		// ��ѯ������Ϣ,��������
		StringBuffer sqlbuffer = new StringBuffer();
		sqlbuffer.append("select * from attendence where 1=1");
		if(!dept.equals("ALL")) {
			sqlbuffer.append(" and adept='" + dept + "'");
		}
		sqlbuffer.append(" and ayear=? and amonth=?");
		String sqlA = sqlbuffer.toString();	
		Connection conn = DbUtil.getConnection();	
		PreparedStatement pstA = conn.prepareStatement(sqlA);
		pstA.setString(1, year);
		pstA.setString(2, month);
		ResultSet rsA = pstA.executeQuery();
		List<Attendence> attendencesA = new ArrayList<Attendence>();
		Attendence attendenceA = null;
		while (rsA.next()) {
			attendenceA = new Attendence();
			attendenceA.setId(rsA.getString("aid"));
			attendenceA.setEmpId(rsA.getString("aempid"));
			attendenceA.setTrueName(rsA.getString("atruename"));
			/*attendenceA.setDept(rsA.getString("adept"));*/
			attendenceA.setYear(rsA.getString("ayear"));
			attendenceA.setMonth(rsA.getString("amonth"));
			attendenceA.setLateCome(rsA.getInt("alatecome"));
			attendenceA.setEarlyLeave(rsA.getInt("aearlyleave"));
			attendenceA.setLeave(rsA.getInt("aleave"));
			attendenceA.setOvertime(rsA.getInt("aovertime"));
			attendenceA.setNegletwork(rsA.getInt("anegletwork"));
			attendencesA.add(attendenceA);
		}

		// ɾ��������Ϣ
		StringBuffer sqlbufDel = new StringBuffer();
		sqlbufDel.append("delete from attendence where 1=1");
		if(!dept.equals("ALL")) {
			sqlbufDel.append(" and adept='" + dept + "'");
		}
		sqlbufDel.append(" and ayear=? and amonth=?");
		String sqlDel = sqlbufDel.toString();	
		PreparedStatement pstDel = conn.prepareStatement(sqlDel);
		pstDel.setString(1, year);
		pstDel.setString(2, month);
		pstDel.executeUpdate();

		// ��ѯɾ��������Ա��
		StringBuffer sqlbufEmp = new StringBuffer();
		sqlbufEmp.append("select * from emp where 1=1");
		if(!dept.equals("ALL")) {
			sqlbufEmp.append(" and deptname='" + dept + "'");
		}
		String sqlEmpId = sqlbufEmp.toString();	

		DbUtil.startTransaction();
		PreparedStatement pst = conn.prepareStatement(sqlEmpId);
		ResultSet rs = pst.executeQuery();
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp = null;
		while (rs.next()) {
			emp = new Emp();
			emp.setId(rs.getString("uid"));
			emp.setEmpId(rs.getString("uempid"));
			emp.setTrueName(rs.getString("utruename"));
			emp.setDeptName(rs.getString("deptname"));
			emps.add(emp);
		}

		// ���뵱��Ĭ�ϵĿ�����Ϣ
		String sqlAdd = "insert into attendence(aid,aempid,adept,ayear,amonth,atruename,uid) values(?,?,?,?,?,?,?)";
		PreparedStatement pstAdd = conn.prepareStatement(sqlAdd);
		for (int i = 0; i < emps.size(); i++) {
			Emp e = emps.get(i);
			UUID id = UUID.randomUUID();
			pstAdd.setString(1, id.toString());
			pstAdd.setString(2, e.getEmpId());
			pstAdd.setString(3, e.getDeptName());
			pstAdd.setString(4, year);
			pstAdd.setString(5, month);
			pstAdd.setString(6, e.getTrueName());
			pstAdd.setString(7, e.getId());
			pstAdd.executeUpdate();
		}
		DbUtil.commit();
		DbUtil.closeConnection();
		conn = DbUtil.getConnection();

		// ��ԭ�������ݻ�ԭ
		if (attendencesA != null) {
			String sqlUpdate = "update attendence set atruename=? ,"
					+ "alatecome=?,aearlyleave=?,aleave=? ,aovertime=?,"
					+ "anegletwork=?  where aempid=? and ayear=? and amonth=?";
//		conn = DbUtil.getConnection();
			PreparedStatement pstU = conn.prepareStatement(sqlUpdate);
			for (int i = 0; i < attendencesA.size(); i++) {
				Attendence attendence = attendencesA.get(i);

				pstU.setString(1, attendence.getTrueName());
				pstU.setInt(2, attendence.getLateCome());
				pstU.setInt(3, attendence.getEarlyLeave());
				pstU.setInt(4, attendence.getLeave());
				pstU.setInt(5, attendence.getOvertime());
				pstU.setInt(6, attendence.getNegletwork());
				pstU.setString(7, attendence.getEmpId());
				pstU.setString(8, attendence.getYear());
				pstU.setString(9, attendence.getMonth());
				pstU.executeUpdate();
			}
		}

		// ��ѯ������Ϣ
		StringBuffer sqlAttenbuf = new StringBuffer();
		sqlAttenbuf.append("select * from attendence where 1=1");
		if(!dept.equals("ALL")) {
			sqlAttenbuf.append(" and adept='" + dept + "'");
		}
		sqlAttenbuf.append(" and ayear=? and amonth=? order by aempid limit ?,?");
		String sqlAttendence = sqlAttenbuf.toString();
		
		PreparedStatement pstAttendence = conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		// ���÷�ҳ��ѯ����
		int begin = (page - 1) * pageSize;
		pstAttendence.setInt(3, begin);// ����ץȡ����ʼ��(��0��ʼ)
		pstAttendence.setInt(4, pageSize);// �������ץȡ��¼��
		ResultSet rsAttendence = pstAttendence.executeQuery();
		List<Attendence> attendences = new ArrayList<Attendence>();
		Attendence attendence = null;
		while (rsAttendence.next()) {
			attendence = new Attendence();
			attendence.setId(rsAttendence.getString("aid"));
			attendence.setEmpId(rsAttendence.getString("aempid"));
			attendence.setTrueName(rsAttendence.getString("atruename"));
			attendence.setDept(rsAttendence.getString("adept"));
			attendence.setYear(rsAttendence.getString("ayear"));
			attendence.setMonth(rsAttendence.getString("amonth"));
			attendence.setLateCome(rsAttendence.getInt("alatecome"));
			attendence.setEarlyLeave(rsAttendence.getInt("aearlyleave"));
			attendence.setLeave(rsAttendence.getInt("aleave"));
			attendence.setOvertime(rsAttendence.getInt("aovertime"));
			attendence.setNegletwork(rsAttendence.getInt("anegletwork"));
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}

	public boolean checkMonth(String year, String month) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
