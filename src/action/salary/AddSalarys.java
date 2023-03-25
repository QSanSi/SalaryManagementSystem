package action.salary;

import java.util.ArrayList;
import java.util.List;
import dao.DeptDao;
import dao.SalaryDao;
import entity.Salary;
import util.Factory;

public class AddSalarys {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private List<Salary> salarys;
	private String dept;
	private Integer idbegin;
	private List<String> deptList;
	private Integer month;
	private Integer year;
	private List monthList;
	private Salary salary;

	public String execute() {
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			dept = salary.getDept();
			String empid = "";
			String truename = "";
			month = Integer.parseInt(salary.getMonth());
			year = Integer.parseInt(salary.getYear());
			//序号起始
			idbegin = (page - 1) * pageSize;
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			// 获取当前页需要的记录
			salarys = salaryDao.saveSalarysByMonth(page, pageSize, salary.getDept(), salary.getYear(), salary.getMonth());
			// 计算总页数
			totalPages = salaryDao.countTotalPage(pageSize, empid, truename, salary.getDept(), salary.getYear(), salary.getMonth());
			deptList = deptDao.showName2();
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

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

	public List getMonthList() {
		return monthList;
	}

	public void setMonthList(List monthList) {
		this.monthList = monthList;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
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
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public List<String> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<String> deptList) {
		this.deptList = deptList;
	}
}
