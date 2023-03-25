package action.emp;

import java.util.List;
import util.Factory;
import dao.DeptDao;
import dao.EmpDao;
import entity.Emp;

public class FindEmpAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private Emp emp;
	private List<Emp> emps;
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
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
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

	public String execute() {
		EmpDao empDao = (EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			dept = emp.getDeptName();
			emps = empDao.findAll(page,pageSize,empid,truename,dept);
			//序号起始
			idbegin = (page - 1) * pageSize;
			//计算总页数
			totalPages = empDao.countTotalPage(pageSize, empid, truename, dept);
			deptList = deptDao.showName2();
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
