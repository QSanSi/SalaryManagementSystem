package action.dept;

import java.util.List;
import util.Factory;
import dao.DeptDao;
import entity.Dept;

public class DeptListAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private List<Dept> depts;
	private int pageSize = 3;
	private String deptname;
	private String manager;
	private Integer idbegin; // ҳ�����ʼ��

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

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getDeptName() {
		return deptname;
	}
	
	public void setDeptName(String deptname) {
		this.deptname = deptname;
	}
	
	public String getManager() {
		return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public Integer getIdBegin() {
		return idbegin;
	}

	public void setIdBegin(Integer idbegin) {
		this.idbegin = idbegin;
	}

	public String showlist() {
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			depts = deptDao.findAll(page, pageSize,deptname,manager);
			idbegin = (page - 1) * pageSize;
			// ������ҳ��
			totalPages = deptDao.countTotalPage(pageSize,deptname,manager);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String Selectpage() {
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			//������ҳ��
			totalPages = deptDao.countTotalPage(pageSize,deptname,manager);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			//��ȡѡ��ҳ�ļ�¼
			depts = deptDao.findAll(page, pageSize,deptname,manager);
			idbegin = (page - 1) * pageSize;
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
