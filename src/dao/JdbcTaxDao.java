package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import entity.Tax;
import util.DbUtil;

public class JdbcTaxDao implements TaxDao{
	public List<Tax> findAll(int page, int pageSize, String empid,String truename, String dept, String year, String month) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from tax where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and tempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and ttruename like'%" + truename + "%'");
		}
		if(dept != null && !dept.equals("ALL")) {
			sql.append(" and tdept='" + dept +"'");
		}
		sql.append(" and tyear=? and tmonth=? order by tempid limit ?,?");
		String sqlTax = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sqlTax);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pst.setString(1, year);
		pst.setString(2, month);
		pst.setInt(3, begin);// 设置抓取的起始点(从0开始)
		pst.setInt(4, pageSize);// 设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Tax> list = new ArrayList<Tax>();
		Tax tax = null;
		while (rs.next()) {
			tax = new Tax();
			tax.setId(rs.getString("tid"));
			tax.setEmpId(rs.getString("tempid"));
			tax.setTrueName(rs.getString("ttruename"));
			tax.setSex(rs.getString("tsex"));
			tax.setIdnum(rs.getString("tidnum"));
			tax.setDept(rs.getString("tdept"));
			tax.setYear(rs.getString("tyear"));
			tax.setMonth(rs.getString("tmonth"));
			tax.setFinalSalary(rs.getDouble("tfinalsalary"));
			tax.setTaxSalary(rs.getDouble("taxsalary"));
			tax.setTax(rs.getDouble("tax"));			
			list.add(tax);
		}
		DbUtil.closeConnection();
		return list;
	}	
	
	public int countTotalPage(int pageSize, String dept, String empid, String truename, String year, String month) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from tax where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and tempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and ttruename like'%" + truename + "%'");
		}
		if(dept != null && !dept.equals("ALL")) {
			sql.append(" and tdept='" + dept +"'");
		}
		sql.append(" and tyear=? and tmonth=?");
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
	
	public List<Tax> saveTaxByMonth(int page, int pageSize, String dept, String year, String month) throws Exception {		
		StringBuffer sqlbuffer = new StringBuffer();
		sqlbuffer.append("select e.*,s.* from emp e join salary s on e.uempid=s.sempid where 1=1");
		if(!dept.equals("ALL")) {
			sqlbuffer.append(" and e.deptname='" + dept + "'");
		}
		sqlbuffer.append(" and s.syear=? and s.smonth=?");
		String sql = sqlbuffer.toString();
		Connection conn = DbUtil.getConnection();
		DbUtil.startTransaction();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, year);
		pst.setString(2, month);
		ResultSet rs = pst.executeQuery();
		List<Tax> taxs = new ArrayList<Tax>();
		Tax tax = null;
		while (rs.next()) {
			tax = new Tax();
			tax.setUid(rs.getString("uid"));
			tax.setEmpId(rs.getString("uempid"));
			tax.setTrueName(rs.getString("utruename"));
			tax.setSex(rs.getString("sex"));
			tax.setIdnum(rs.getString("idnum"));
			tax.setDept(rs.getString("deptname"));
			tax.setYear(year);
			tax.setMonth(month);
			tax.setTaxSalary(rs.getDouble("staxsalary"));
			tax.setTax(rs.getDouble("stax"));
			tax.setFinalSalary(rs.getDouble("sfinalsalary"));
			taxs.add(tax);
		}
		
		StringBuffer sqlDelbuf = new StringBuffer();
		sqlDelbuf.append("delete from tax where 1=1");
		if(!dept.equals("ALL")) {
			sqlDelbuf.append(" and tdept='" + dept + "'");
		}
		sqlDelbuf.append(" and tyear=? and tmonth=?");
		String sqlDel = sqlDelbuf.toString();
		PreparedStatement pstDel = conn.prepareStatement(sqlDel);
		pstDel.setString(1, year);
		pstDel.setString(2, month);
		pstDel.executeUpdate();
		
		String sql3 = "insert into tax(tid,uid,tempid,tdept,ttruename,tsex,tidnum,tyear,tmonth,tfinalsalary,taxsalary,tax)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst3 = conn.prepareStatement(sql3);
		for (int i = 0; i < taxs.size(); i++) {
			tax = taxs.get(i);
			UUID id = UUID.randomUUID();
			pst3.setString(1, id.toString());
			pst3.setString(2, tax.getUid());
			pst3.setString(3, tax.getEmpId());
			pst3.setString(4, tax.getDept());
			pst3.setString(5, tax.getTrueName());
			pst3.setString(6, tax.getSex());
			pst3.setString(7, tax.getIdnum());
			pst3.setString(8, tax.getYear());
			pst3.setString(9, tax.getMonth());
			pst3.setDouble(10, tax.getFinalSalary());
			pst3.setDouble(11, tax.getTaxSalary());
			pst3.setDouble(12, tax.getTax());
			pst3.executeUpdate();
		}
		DbUtil.commit();
		DbUtil.closeConnection();

		conn = DbUtil.getConnection();

		StringBuffer sqltaxbuf = new StringBuffer();
		sqltaxbuf.append("select * from tax where 1=1");
		if(!dept.equals("ALL")) {
			sqltaxbuf.append(" and tdept='" + dept + "'");
		}
		sqltaxbuf.append(" and tyear=? and tmonth=? order by tempid limit ?,?");
		String sqltax = sqltaxbuf.toString();
		PreparedStatement psttax = conn.prepareStatement(sqltax);
		psttax.setString(1, year);
		psttax.setString(2, month);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		psttax.setInt(3, begin);// 设置抓取的起始点(从0开始)
		psttax.setInt(4, pageSize);// 设置最多抓取记录数
		ResultSet rstax = psttax.executeQuery();
		List<Tax> taxs2 = new ArrayList<Tax>();
		Tax tax2 = null;
		while (rstax.next()) {
			tax2 = new Tax();
			tax2.setEmpId(rstax.getString("tempid"));
			tax2.setTrueName(rstax.getString("ttruename"));
			tax2.setIdnum(rstax.getString("tidnum"));
			tax2.setDept(rstax.getString("tdept"));
			tax2.setYear(rstax.getString("tyear"));
			tax2.setMonth(rstax.getString("tmonth"));
			tax2.setSex(rstax.getString("tsex"));
			tax2.setFinalSalary(rstax.getDouble("tfinalsalary"));
			tax2.setTaxSalary(rstax.getDouble("taxsalary"));
			tax2.setTax(rstax.getDouble("tax"));
			taxs2.add(tax2);
		}
		DbUtil.closeConnection();
		return taxs2;
	}
}
