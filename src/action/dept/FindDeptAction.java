package action.dept;

import java.util.List;

import util.Factory;
import dao.DeptDao;

import entity.Dept;

public class FindDeptAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private Integer idbegin; // 页面序号始点
	private String deptname;
	private String manager;
	private List<Dept> depts;

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
	
	public String getDeptName() {
		return deptname;
	}

	public void setDeptName(String deptName) {
		this.deptname = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public String findDept() {
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			depts = deptDao.findAll(page, pageSize,deptname,manager);
			idbegin = (page - 1) * pageSize;
			// 计算总页数
			totalPages = deptDao.countTotalPage(pageSize,deptname,manager);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
