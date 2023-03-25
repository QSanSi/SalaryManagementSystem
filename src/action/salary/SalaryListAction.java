package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import entity.Salary;

public class SalaryListAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	/*private Salary salary;*/
	private List<Salary> salarys;
	private String empid;
	private String truename;
	private Integer month; // 页面月份
	private Integer year; // 页面年份
	private String dept;
	private Integer idbegin; // 页面序号始点
	private List monthList;
	private String syear; //跳页年份
	private String smonth; //跳页月份
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

	public List<Salary> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<Salary> salarys) {
		this.salarys = salarys;
	}

	/*public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}*/

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
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {			
			Calendar c = Calendar.getInstance();
			month = c.get(Calendar.MONTH) + 1;
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}				
			String m = month.toString();
			year = c.get(Calendar.YEAR);		
			String y = year.toString();
			// 获取当前页需要的记录
			salarys = salaryDao.findAll(page, pageSize, empid, truename, dept, y, m);
			// 计算记录数给序号
			idbegin = (page - 1) * pageSize;
			// 计算总页数
			totalPages = salaryDao.countTotalPage(pageSize, empid, truename, dept, y, m);
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String Selectpage() {
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			month = Integer.parseInt(smonth);
			year = Integer.parseInt(syear);
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			// 计算总页数
			totalPages = salaryDao.countTotalPage(pageSize, empid, truename, dept, syear, smonth);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			// 序号起始
			idbegin = (page - 1) * pageSize;
			// 获取当前页需要的记录
			salarys = salaryDao.findAll(page, pageSize, empid, truename, dept,syear, smonth);
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
