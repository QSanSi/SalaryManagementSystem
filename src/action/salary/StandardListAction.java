package action.salary;

import java.util.ArrayList;
import java.util.List;

import dao.DeptDao;
import dao.SalaryDao;
import util.Factory;
import entity.SalaryStandard;

public class StandardListAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private List<SalaryStandard> salaryStandards;
	private String empid;
	private String truename;
	private String dept;
	private Integer idbegin; // 页面序号始点
	private List<String> deptList;	

	public List<SalaryStandard> getSalaryStandards() {
		return salaryStandards;
	}

	public void setSalaryStandards(List<SalaryStandard> salaryStandards) {
		this.salaryStandards = salaryStandards;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getIdBegin() {
		return idbegin;
	}

	public void setIdBegin(Integer idbegin) {
		this.idbegin = idbegin;
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
			// 获取当前页需要的记录
			salaryStandards = salaryDao.findStandAll(page, pageSize, empid, truename, dept);
			// 计算记录数给序号
			idbegin = (page - 1) * pageSize;
			// 计算总页数
			totalPages = salaryDao.countTotalPage2(pageSize, empid, truename,dept);
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
			// 计算总页数
			totalPages = salaryDao.countTotalPage2(pageSize, empid, truename,dept);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			// 序号起始
			idbegin = (page - 1) * pageSize;
			// 获取当前页需要的记录
			salaryStandards = salaryDao.findStandAll(page, pageSize, empid, truename, dept);
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
