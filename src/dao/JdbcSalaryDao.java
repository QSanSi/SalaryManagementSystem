package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import util.DbUtil;
import entity.AttendenceSet;
import entity.Insurance;
import entity.QueryInfomation;
import entity.Salary;
import entity.SalaryStandard;

public class JdbcSalaryDao implements SalaryDao {
	public List<Salary> findAll(int page, int pageSize, String empid, String truename, String dept, String year,
			String month) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from salary where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and sempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and struename like'%" + truename + "%'");
		}
		if (dept != null && !dept.equals("ALL")) {
			sql.append(" and sdept='" + dept + "'");
		}
		sql.append(" and syear=? and smonth=? order by sempid limit ?,?");
		String sqlSalary = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sqlSalary);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pst.setString(1, year);
		pst.setString(2, month);
		pst.setInt(3, begin);// 设置抓取的起始点(从0开始)
		pst.setInt(4, pageSize);// 设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary = null;
		while (rs.next()) {
			salary = new Salary();
			salary.setId(rs.getString("sid"));
			salary.setEmpId(rs.getString("sempid"));
			salary.setTrueName(rs.getString("struename"));
			salary.setDept(rs.getString("sdept"));
			salary.setYear(rs.getString("syear"));
			salary.setMonth(rs.getString("smonth"));
			salary.setBaseSalary(rs.getDouble("sbasesalary"));
			salary.setFinalSalary(rs.getDouble("sfinalsalary"));
			salary.setLateCome(rs.getDouble("slatecome"));
			salary.setEarlyLeave(rs.getDouble("searlyleave"));
			salary.setLeave(rs.getDouble("sleave"));
			salary.setOvertime(rs.getDouble("sovertime"));
			salary.setNegletwork(rs.getDouble("snegletwork"));
			salary.setOld(rs.getDouble("sold"));
			salary.setUnemployment(rs.getDouble("sunemployment"));
			salary.setInjury(rs.getDouble("sinjury"));
			salary.setBear(rs.getDouble("sbear"));
			salary.setMedical(rs.getDouble("smedical"));
			salary.setHouse(rs.getDouble("shouse"));
			list.add(salary);
		}
		DbUtil.closeConnection();
		return list;
	}

	public int countTotalPage(int pageSize, String empid, String truename, String dept, String year, String month)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from salary where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and sempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and struename like'%" + truename + "%'");
		}
		if (dept != null && !dept.equals("ALL")) {
			sql.append(" and sdept = '" + dept + "'");
		}
		sql.append(" and syear=? and smonth=?");
		String str = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(str);
		pst.setString(1, year);
		pst.setString(2, month);
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

	public int countTotalPage2(int pageSize, String empid, String truename, String dept) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from salarystandard where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and dempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and dtruename like'%" + truename + "%'");
		}
		if (dept != null && !dept.equals("ALL")) {
			sql.append(" and ddept = '" + dept + "'");
		}

		String str = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(str);
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

	public void saveSalarys(List<Salary> salarys) throws Exception {
		/*
		 * String
		 * Sql="select b.*,c.* from user a left join salary b on a.empid=b.empid ";
		 * String attendenceSetSql="select * from attendenceset"; Connection
		 * conn=DbUtil.getConnection(); PreparedStatement
		 * pst=conn.prepareStatement(attendenceSetSql); ResultSet rs=pst.executeQuery();
		 * AttendenceSet attendenceSet=null; if(rs.next()){ attendenceSet=new
		 * AttendenceSet(); attendenceSet.setId(rs.getString("id"));
		 * attendenceSet.setLateCome(rs.getDouble("latecome"));
		 * attendenceSet.setEarlyLeave(rs.getDouble("earlyleave"));
		 * attendenceSet.setAffairLeave(rs.getDouble("affairleave"));
		 * attendenceSet.setSickLeave(rs.getDouble("sickleave")); }
		 */
	}

	public void save(Salary salary) throws Exception {
		/*
		 * String sql =
		 * "insert into salary(id,empid,truename,year,month,basesalary,finalsalary," +
		 * "insurance,attendencefee) values(?,?,?,?,?,?,?,?,?)";
		 * 
		 * String attendenceSql="select  * from attendence"; String
		 * attendenceSetSql="select * from attendenceset";
		 * 
		 * Connection conn = DbUtil.getConnection(); PreparedStatement pst =
		 * conn.prepareStatement(sql); UUID id=UUID.randomUUID();
		 * pst.setString(1,id.toString()); pst.setString(2, salary.getEmpId());
		 * pst.setString(3, salary.getTrueName()); pst.setString(4, salary.getYear());
		 * pst.setString(5, salary.getMonth()); pst.setDouble(6,
		 * salary.getBaseSalary()); pst.setDouble(7, salary.getFinalSalary());
		 * pst.setDouble(8, salary.getInsurance()); pst.setDouble(9,
		 * salary.getAttendenceFee()); pst.executeUpdate(); DbUtil.closeConnection();
		 */
	}

	// 查看详细信息
	public Salary findById(String id) throws Exception {
		String sql = "select * from salary where sid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Salary salary = null;
		if (rs.next()) {
			salary = new Salary();
			salary.setId(rs.getString("sid"));
			salary.setEmpId(rs.getString("sempid"));
			salary.setDept(rs.getString("sdept"));
			salary.setTrueName(rs.getString("struename"));
			salary.setYear(rs.getString("syear"));
			salary.setMonth(rs.getString("smonth"));
			salary.setBaseSalary(rs.getDouble("sbasesalary"));
			salary.setFinalSalary(rs.getDouble("sfinalsalary"));
			salary.setLateCome(rs.getDouble("slatecome"));
			salary.setEarlyLeave(rs.getDouble("searlyleave"));
			salary.setLeave(rs.getDouble("sleave"));
			salary.setOvertime(rs.getDouble("sovertime"));
			salary.setNegletwork(rs.getDouble("snegletwork"));
			salary.setOld(rs.getDouble("sold"));
			salary.setUnemployment(rs.getDouble("sunemployment"));
			salary.setInjury(rs.getDouble("sinjury"));
			salary.setBear(rs.getDouble("sbear"));
			salary.setMedical(rs.getDouble("smedical"));
			salary.setHouse(rs.getDouble("shouse"));
			salary.setTaxSalary(rs.getDouble("staxsalary"));
			salary.setTax(rs.getDouble("stax"));
		}
		DbUtil.closeConnection();
		return salary;

	}

	public void update(Salary salary) throws Exception {
		/*
		 * String sql =
		 * "update salary set sempid=?,struename=?,syear=?,smonth=?,sbasesalary=?," +
		 * "sfinalsalary=?,slatecome=?,searlyleave=?,sleva=?,sovertime=?,snegletwork=?,"
		 * + "sold=?,sunemployment=?,sinjury=?,sbear=?,smedical=?,shouse=? where sid=?";
		 * Connection conn = DbUtil.getConnection(); PreparedStatement pst =
		 * conn.prepareStatement(sql); UUID id=UUID.randomUUID();
		 * pst.setString(1,id.toString()); pst.setString(2, salary.getEmpId());
		 * pst.setString(3, salary.getTrueName()); pst.setString(4, salary.getYear());
		 * pst.setString(5, salary.getMonth()); pst.setDouble(6,
		 * salary.getBaseSalary()); pst.setDouble(7, salary.getFinalSalary());
		 * pst.setDouble(8, salary.getLateCome()); pst.setDouble(9,
		 * salary.getEarlyLeave()); pst.setDouble(10,salary.getOvertime());
		 * pst.setDouble(11,salary.getNegletwork()); pst.setDouble(12,salary.getOld());
		 * pst.setDouble(13,salary.getUnemployment());
		 * pst.setDouble(14,salary.getInjury()); pst.setDouble(15,salary.getBear());
		 * pst.setDouble(16,salary.getMedical()); pst.setDouble(17,salary.getHouse());
		 * pst.executeUpdate(); DbUtil.closeConnection();
		 */
	}

	public void deleteById(String id) throws Exception {
		/*
		 * String sql="delete from salary where id=?"; Connection
		 * conn=DbUtil.getConnection(); PreparedStatement
		 * pst=conn.prepareStatement(sql); pst.setString(1, id); pst.executeUpdate();
		 * DbUtil.closeConnection();
		 */
	}

	public List<Salary> showSalary() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 生成工资表
	public List<Salary> saveSalarysByMonth(int page, int pageSize, String dept, String year, String month)
			throws Exception {
		// 查询所有员工的考勤信息、工资标准、考勤奖罚信息、对应的attendenceset
		StringBuffer sqlbuffer = new StringBuffer();
		sqlbuffer.append("SELECT c.*,d.* from attendenceset c join (select a.dbasesalary,"
				+ "b.* from salarystandard a join attendence b on a.dempid=b.aempid " + "where 1=1");
		if (!dept.equals("ALL")) {
			sqlbuffer.append(" and b.adept='" + dept + "'");
		}
		sqlbuffer.append(" and b.ayear=? and b.amonth=?) d on c.cdept=d.adept");
		String sql = sqlbuffer.toString();
		Connection conn = DbUtil.getConnection();
		DbUtil.startTransaction();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, year);
		pst.setString(2, month);
		ResultSet rs = pst.executeQuery();
		List<QueryInfomation> infos = new ArrayList<QueryInfomation>();
		QueryInfomation info = null;
		while (rs.next()) {
			info = new QueryInfomation();
			info.setEmpId(rs.getString("aempid"));
			info.setTrueName(rs.getString("atruename"));
			info.setDept(rs.getString("adept"));
			info.setYear(rs.getString("ayear"));
			info.setMonth(rs.getString("amonth"));
			info.setBaseSalary(rs.getDouble("dbasesalary"));
			info.setLateCome(rs.getInt("alatecome"));
			info.setEarlyLeave(rs.getInt("aearlyleave"));
			info.setLeave(rs.getInt("aleave"));
			info.setOvertime(rs.getInt("aovertime"));
			info.setNegletwork(rs.getInt("anegletwork"));
			info.setClateCome(rs.getDouble("clatecome"));
			info.setCearlyLeave(rs.getDouble("cearlyleave"));
			info.setCleave(rs.getDouble("cleave"));
			info.setCovertime(rs.getDouble("covertime"));
			info.setCnegletwork(rs.getDouble("cnegletwork"));
			info.setUid(rs.getString("uid"));
			infos.add(info);
		}

		/*
		 * String sql2 = "select * from attendenceset where cdept=?"; PreparedStatement
		 * pst2 = conn.prepareStatement(sql2); pst2.setString(1, dept); ResultSet rs2 =
		 * pst2.executeQuery(); AttendenceSet attendenceSet = null; if (rs2.next()) {
		 * attendenceSet = new AttendenceSet();
		 * attendenceSet.setEarlyLeave(rs2.getDouble("cearlyleave"));
		 * attendenceSet.setLateCome(rs2.getDouble("clatecome"));
		 * attendenceSet.setLeave(rs2.getDouble("cleave"));
		 * attendenceSet.setNegletwork(rs2.getDouble("cnegletwork"));
		 * attendenceSet.setOvertime(rs2.getDouble("covertime")); }
		 */

		StringBuffer sqlDelbuf = new StringBuffer();
		sqlDelbuf.append("delete from salary where 1=1");
		if (!dept.equals("ALL")) {
			sqlDelbuf.append(" and sdept='" + dept + "'");
		}
		sqlDelbuf.append(" and syear=? and smonth=?");
		String sqlDel = sqlDelbuf.toString();
		PreparedStatement pstDel = conn.prepareStatement(sqlDel);
		pstDel.setString(1, year);
		pstDel.setString(2, month);
		pstDel.executeUpdate();

		String sqlIn = "select  * from insurance";
		conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rsIn = stmt.executeQuery(sqlIn);
		Insurance insurance = null;
		if (rsIn.next()) {
			insurance = new Insurance();
			insurance.setId(rsIn.getString("id"));
			insurance.setBear(rsIn.getInt("bear"));
			insurance.setHouse(rsIn.getInt("house"));
			insurance.setInjury(rsIn.getInt("injury"));
			insurance.setMedical(rsIn.getInt("medical"));
			insurance.setOld(rsIn.getInt("old"));
			insurance.setUnemployment(rsIn.getInt("unemployment"));
		}

		// 插入当月的考勤信息
		String sql3 = "insert into salary(sid,sempid,sdept,struename,syear,smonth,sbasesalary,staxsalary,stax,sfinalsalary,slatecome,"
				+ "searlyleave,sleave,sovertime,snegletwork,sold,sunemployment,sinjury,sbear,smedical,shouse,uid) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst3 = conn.prepareStatement(sql3);
		for (int i = 0; i < infos.size(); i++) {
			info = infos.get(i);

			double finalSalary = info.getBaseSalary() - info.getLateCome() * info.getClateCome()
					- info.getEarlyLeave() * info.getCearlyLeave() - info.getLeave() * info.getCleave()
					+ info.getOvertime() * info.getCovertime() - info.getNegletwork() * info.getCnegletwork();

			double finalSal = info.getBaseSalary() - finalSalary * insurance.getOld() / 100
					- finalSalary * insurance.getUnemployment() / 100 - finalSalary * insurance.getInjury() / 100
					- finalSalary * insurance.getBear() / 100 - finalSalary * insurance.getMedical() / 100
					- finalSalary * insurance.getHouse() / 100;

			int tax = 0;
			double taxSal = 0;
			if (finalSal - 5000 < 0) {
				taxSal = 0;
			} else {
				taxSal = finalSal - 5000;
			}
			int s = (int) (taxSal);
			if (taxSal - 12000 > 12000) {
				taxSal = taxSal - 12000;
				tax = (int) (taxSal * 0.2 + 990);
			} else if (taxSal - 3000 > 3000) {
				taxSal = taxSal - 3000;
				tax = (int) (taxSal * 0.1 + 90);
			} else {
				tax = (int) (taxSal * 0.03);
			}

			int fs = (int) (finalSal - tax);
			UUID id = UUID.randomUUID();
			pst3.setString(1, id.toString());
			pst3.setString(2, info.getEmpId());
			pst3.setString(3, info.getDept());
			pst3.setString(4, info.getTrueName());
			pst3.setString(5, info.getYear());
			pst3.setString(6, info.getMonth());
			pst3.setDouble(7, info.getBaseSalary());
			pst3.setDouble(8, s);
			pst3.setDouble(9, tax);
			pst3.setDouble(10, fs);
			pst3.setDouble(11, info.getLateCome() * info.getClateCome());
			pst3.setDouble(12, info.getEarlyLeave() * info.getCearlyLeave());
			pst3.setDouble(13, info.getLeave() * info.getCleave());
			pst3.setDouble(14, info.getOvertime() * info.getCovertime());
			pst3.setDouble(15, info.getNegletwork() * info.getCnegletwork());
			pst3.setDouble(16, finalSalary * insurance.getOld() / 100);
			pst3.setDouble(17, finalSalary * insurance.getUnemployment() / 100);
			pst3.setDouble(18, finalSalary * insurance.getInjury() / 100);
			pst3.setDouble(19, finalSalary * insurance.getBear() / 100);
			pst3.setDouble(20, finalSalary * insurance.getMedical() / 100);
			pst3.setDouble(21, finalSalary * insurance.getHouse() / 100);
			pst3.setString(22, info.getUid());
			pst3.executeUpdate();
		}

		DbUtil.commit();
		DbUtil.closeConnection();

		conn = DbUtil.getConnection();

		// 查询工资信息
		StringBuffer sqlSalarybuf = new StringBuffer();
		sqlSalarybuf.append("select * from salary where 1=1");
		if (!dept.equals("ALL")) {
			sqlSalarybuf.append(" and sdept='" + dept + "'");
		}
		sqlSalarybuf.append(" and syear=? and smonth=? order by sempid limit ?,?");
		String sqlSalary = sqlSalarybuf.toString();
		PreparedStatement pstSalary = conn.prepareStatement(sqlSalary);
		pstSalary.setString(1, year);
		pstSalary.setString(2, month);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pstSalary.setInt(3, begin);// 设置抓取的起始点(从0开始)
		pstSalary.setInt(4, pageSize);// 设置最多抓取记录数
		ResultSet rsSalary = pstSalary.executeQuery();
		List<Salary> salarys = new ArrayList<Salary>();
		Salary salary = null;
		while (rsSalary.next()) {
			salary = new Salary();
			salary.setId(rsSalary.getString("sid"));
			salary.setEmpId(rsSalary.getString("sempid"));
			salary.setTrueName(rsSalary.getString("struename"));
			salary.setDept(rsSalary.getString("sdept"));
			salary.setYear(rsSalary.getString("syear"));
			salary.setMonth(rsSalary.getString("smonth"));
			salary.setBaseSalary(rsSalary.getDouble("sbasesalary"));
			salary.setFinalSalary(rsSalary.getDouble("sfinalsalary"));
			salary.setLateCome(rsSalary.getDouble("slatecome"));
			salary.setEarlyLeave(rsSalary.getDouble("searlyleave"));
			salary.setLeave(rsSalary.getDouble("sleave"));
			salary.setOvertime(rsSalary.getDouble("sovertime"));
			salary.setNegletwork(rsSalary.getDouble("snegletwork"));
			salary.setOld(rsSalary.getDouble("sold"));
			salary.setUnemployment(rsSalary.getDouble("sunemployment"));
			salary.setInjury(rsSalary.getDouble("sinjury"));
			salary.setBear(rsSalary.getDouble("sbear"));
			salary.setMedical(rsSalary.getDouble("smedical"));
			salary.setHouse(rsSalary.getDouble("shouse"));
			salary.setTaxSalary(rsSalary.getDouble("staxsalary"));
			salary.setTax(rsSalary.getDouble("stax"));
			salarys.add(salary);
		}
		DbUtil.closeConnection();
		return salarys;
	}

	/*
	 * public List<SalaryStandard> findStand(SalaryStandard salaryStand) throws
	 * Exception { StringBuffer sql = new StringBuffer();
	 * sql.append("select * from salarystandard where 1=1"); if
	 * (salaryStand.getEmpId() != null && !salaryStand.getEmpId().equals("")) {
	 * sql.append(" and dempid like'%" + salaryStand.getEmpId() + "%'"); } if
	 * (salaryStand.getTrueName() != null && !salaryStand.getTrueName().equals(""))
	 * { sql.append(" and dtruename like'%" + salaryStand.getTrueName() + "%'"); }
	 * Connection conn = DbUtil.getConnection(); Statement stmt =
	 * conn.createStatement(); String str = sql.toString(); ResultSet rs =
	 * stmt.executeQuery(str); List<SalaryStandard> list = new
	 * ArrayList<SalaryStandard>(); SalaryStandard salaryStandard = null; while
	 * (rs.next()) { salaryStandard = new SalaryStandard();
	 * salaryStandard.setBaseSalary(rs.getDouble("dbasesalary"));
	 * salaryStandard.setEmpId(rs.getString("dempid"));
	 * salaryStandard.setId(rs.getString("did"));
	 * salaryStandard.setTrueName(rs.getString("dtruename"));
	 * list.add(salaryStandard); } DbUtil.closeConnection(); return list; }
	 */

	public SalaryStandard loadStand(String id) throws Exception {
		String sql = "select * from salarystandard where did=?";

		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		SalaryStandard salaryStandard = null;
		if (rs.next()) {
			salaryStandard = new SalaryStandard();
			salaryStandard.setBaseSalary(rs.getDouble("dbasesalary"));
			salaryStandard.setEmpId(rs.getString("dempid"));
			salaryStandard.setId(rs.getString("did"));
			salaryStandard.setTrueName(rs.getString("dtruename"));
			salaryStandard.setDept(rs.getString("ddept"));
		}
		return salaryStandard;
	}

	public void updateStand(SalaryStandard salaryStandard) throws Exception {
		String sql = "update salarystandard set dbasesalary=? where did=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setDouble(1, salaryStandard.getBaseSalary());
		pst.setString(2, salaryStandard.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	/*
	 * public List<Salary> findSalary(int page, int pageSize, Salary salary) throws
	 * Exception { StringBuffer sql = new StringBuffer();
	 * sql.append("select * from salary where 1=1"); if (salary.getEmpId() != null
	 * && !salary.getEmpId().equals("")) { sql.append(" and sempid like'%" +
	 * salary.getEmpId() + "%'"); } if (salary.getTrueName() != null &&
	 * !salary.getTrueName().equals("")) { sql.append(" and struename like'%" +
	 * salary.getTrueName() + "%'"); } if (!salary.getDept().equals("ALL")) {
	 * sql.append(" and sdept='" + salary.getDept() + "'"); }
	 * sql.append(" and syear like'%" + salary.getYear() + "%'");
	 * sql.append(" and smonth like'%" + salary.getMonth() + "%'");
	 * sql.append(" limit ?,?"); String str = sql.toString(); Connection conn =
	 * DbUtil.getConnection(); PreparedStatement pst = conn.prepareStatement(str);
	 * int begin = (page - 1) * pageSize; pst.setInt(1, begin); pst.setInt(2,
	 * pageSize); ResultSet rs = pst.executeQuery(); Salary s = null; List<Salary>
	 * salarys = new ArrayList<Salary>(); while (rs.next()) { s = new Salary();
	 * s.setId(rs.getString("sid")); s.setEmpId(rs.getString("sempid"));
	 * s.setTrueName(rs.getString("struename")); s.setDept(rs.getString("sdept"));
	 * s.setYear(rs.getString("syear")); s.setMonth(rs.getString("smonth"));
	 * s.setBaseSalary(rs.getDouble("sbasesalary"));
	 * s.setFinalSalary(rs.getDouble("sfinalsalary"));
	 * s.setLateCome(rs.getDouble("slatecome"));
	 * s.setEarlyLeave(rs.getDouble("searlyleave"));
	 * s.setLeave(rs.getDouble("sleave")); s.setOvertime(rs.getDouble("sovertime"));
	 * s.setNegletwork(rs.getDouble("snegletwork")); s.setOld(rs.getDouble("sold"));
	 * s.setUnemployment(rs.getDouble("sunemployment"));
	 * s.setInjury(rs.getDouble("sinjury")); s.setBear(rs.getDouble("sbear"));
	 * s.setMedical(rs.getDouble("smedical")); s.setHouse(rs.getDouble("shouse"));
	 * salarys.add(s); } return salarys; }
	 */

	public List<SalaryStandard> findStandAll(int page, int pageSize, String empid, String truename, String dept)
			throws Exception {
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select * from salarystandard where 1=1");
		if (empid != null && !empid.equals("")) {
			sqlbuf.append(" and dempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sqlbuf.append(" and dtruename like'%" + truename + "%'");
		}
		if (dept != null && !dept.equals("ALL")) {
			sqlbuf.append(" and ddept='" + dept + "'");
		}
		sqlbuf.append(" order by dempid limit ?,?");
		String sql = sqlbuf.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pst.setInt(1, begin);// 设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);// 设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<SalaryStandard> list = new ArrayList<SalaryStandard>();
		SalaryStandard salaryStandard = null;
		while (rs.next()) {
			salaryStandard = new SalaryStandard();
			salaryStandard.setBaseSalary(rs.getDouble("dbasesalary"));
			salaryStandard.setEmpId(rs.getString("dempid"));
			salaryStandard.setId(rs.getString("did"));
			salaryStandard.setTrueName(rs.getString("dtruename"));
			salaryStandard.setDept(rs.getString("ddept"));
			list.add(salaryStandard);
		}
		DbUtil.closeConnection();
		return list;
	}

	public Insurance findInsurance() throws Exception {
		String sql = "select  * from insurance";
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Insurance insurance = null;
		if (rs.next()) {
			insurance = new Insurance();
			insurance.setId(rs.getString("id"));
			insurance.setBear(rs.getInt("bear"));
			insurance.setHouse(rs.getInt("house"));
			insurance.setInjury(rs.getInt("injury"));
			insurance.setMedical(rs.getInt("medical"));
			insurance.setOld(rs.getInt("old"));
			insurance.setUnemployment(rs.getInt("unemployment"));
		}
		return insurance;
	}

	public void updateInsurance(Insurance insurance) throws Exception {
		String sql = "update insurance set bear=?,house=?, " + "injury=?,medical=?,old=?,unemployment=? where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, insurance.getBear());
		pst.setInt(2, insurance.getHouse());
		pst.setInt(3, insurance.getInjury());
		pst.setInt(4, insurance.getMedical());
		pst.setInt(5, insurance.getOld());
		pst.setInt(6, insurance.getUnemployment());
		pst.setString(7, insurance.getId());
		pst.executeUpdate();

	}
}
