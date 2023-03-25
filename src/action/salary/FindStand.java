package action.salary;

import java.util.List;
import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import entity.SalaryStandard;

public class FindStand {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private SalaryStandard salaryStandard;
	private List<SalaryStandard> salaryStandards;
	private String empid;
	private String truename;
	private String dept;
	private Integer idbegin;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public SalaryStandard getSalaryStandard() {
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard) {
		this.salaryStandard = salaryStandard;
	}

	public List<SalaryStandard> getSalaryStandards() {
		return salaryStandards;
	}

	public void setSalaryStandards(List<SalaryStandard> salaryStandards) {
		this.salaryStandards = salaryStandards;
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

	public String execute() {		
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			dept = salaryStandard.getDept();
			salaryStandards = salaryDao.findStandAll(page,pageSize,empid,truename,dept);
			//序号起始
			idbegin = (page - 1) * pageSize;
			//计算总页数
			totalPages = salaryDao.countTotalPage2(pageSize, empid, truename, dept);
			deptList = deptDao.showName2();
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
