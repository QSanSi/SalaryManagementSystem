package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.BankDao;
import dao.DeptDao;
import entity.Bank;
import util.Factory;

public class BankListAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private int pageSize = 3;
	private List<Bank> banks;
	private String empid;
	private String truename;
	private Integer month; // ҳ���·�
	private Integer year; // ҳ�����
	private String dept;
	private Integer idbegin; // ҳ�����ʼ��
	private List monthList;
	private String syear; //��ҳ���
	private String smonth; //��ҳ�·�
	private List<String> deptList;	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getIdBegin() {
		return idbegin;
	}

	public void setIdBegin(Integer idbegin) {
		this.idbegin = idbegin;
	}

	public List getMonthList() {
		return monthList;
	}

	public void setMonthList(List monthList) {
		this.monthList = monthList;
	}

	public String getSyear() {
		return syear;
	}

	public void setSyear(String syear) {
		this.syear = syear;
	}

	public String getSmonth() {
		return smonth;
	}

	public void setSmonth(String smonth) {
		this.smonth = smonth;
	}
	
	public List<String> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<String> deptList) {
		this.deptList = deptList;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getEmpId() {
		return empid;
	}
	
	public void setEmpId(String empid) {
		this.empid = empid;
	}
	
	public String getTrueName() {
		return truename;
	}
	
	public void setTrueName(String truename) {
		this.truename = truename;
	}
	
	public String showlist() {
		BankDao bankDao = (BankDao) Factory.getInstance("BankDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {			
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			banks = bankDao.findAll(page, pageSize, empid, truename, dept);
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			// ������ҳ��
			totalPages = bankDao.countTotalPage(pageSize,dept, empid, truename);
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String Selectpage() {
		BankDao bankDao = (BankDao) Factory.getInstance("BankDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			// ������ҳ��
			totalPages = bankDao.countTotalPage(pageSize, dept, empid, truename);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			// �����ʼ
			idbegin = (page - 1) * pageSize;
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			banks = bankDao.findAll(page, pageSize, empid, truename, dept);
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
