package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Bank;
import util.DbUtil;

public class JdbcBankDao implements BankDao{

	@Override
	public List<Bank> findAll(int page, int pageSize, String empid, String truename, String dept) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from bank where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and bempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and btruename like'%" + truename + "%'");
		}
		if(dept != null && !dept.equals("ALL")) {
			sql.append(" and bdept='" + dept +"'");
		}
		sql.append(" order by bempid limit ?,?");
		String sqlBank = sql.toString();
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sqlBank);
		// 设置分页查询参数
		int begin = (page - 1) * pageSize;
		pst.setInt(1, begin);// 设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);// 设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Bank> list = new ArrayList<Bank>();
		Bank bank = null;
		while (rs.next()) {
			bank = new Bank();
			bank.setId(rs.getString("bid"));
			bank.setEmpId(rs.getString("bempid"));
			bank.setTrueName(rs.getString("btruename"));
			bank.setSex(rs.getString("bsex"));
			bank.setDept(rs.getString("bdept"));
			bank.setCardId(rs.getString("cardid"));
			bank.setOwner(rs.getString("cardowner"));
			bank.setTel(rs.getString("btel"));	
			bank.setBank(rs.getString("bank"));
			list.add(bank);
		}
		DbUtil.closeConnection();
		return list;
	}

	@Override
	public int countTotalPage(int pageSize, String dept, String empid, String truename)throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from bank where 1=1");
		if (empid != null && !empid.equals("")) {
			sql.append(" and bempid like'%" + empid + "%'");
		}
		if (truename != null && !truename.equals("")) {
			sql.append(" and btruename like'%" + truename + "%'");
		}
		if(dept != null && !dept.equals("ALL")) {
			sql.append(" and bdept='" + dept +"'");
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

	@Override
	public Bank findById(String id) throws Exception {
		String sql = "select * from bank where bid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		if (rs.next()) {
			bank = new Bank();
			bank.setId(rs.getString("bid"));
			bank.setEmpId(rs.getString("bempid"));
			bank.setTrueName(rs.getString("btruename"));
			bank.setSex(rs.getString("bsex"));
			bank.setDept(rs.getString("bdept"));
			bank.setCardId(rs.getString("cardid"));
			bank.setOwner(rs.getString("cardowner"));
			bank.setTel(rs.getString("btel"));
			bank.setBank(rs.getString("bank"));
		}
		DbUtil.closeConnection();
		return bank;
	}

	@Override
	public void update(Bank bank) throws Exception {
		String sql = "update bank set cardid=?,cardowner=?,btel=?,bank=? where bid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, bank.getCardId());
		pst.setString(2, bank.getOwner());
		pst.setString(3, bank.getTel());
		pst.setString(4, bank.getBank());
		pst.setString(5, bank.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();
	}
}
