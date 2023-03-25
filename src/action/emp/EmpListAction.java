package action.emp;

import java.util.List;

import dao.DeptDao;
import dao.EmpDao;
import util.Factory;
import entity.Emp;

public class EmpListAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private List<Emp> emps;
	private int pageSize = 3;
	private String empid;
	private String truename;
	private String dept;
	private Integer idbegin; // ҳ�����ʼ��
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

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	public String showlist() {
		EmpDao empDao = (EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			emps = empDao.findAll(page, pageSize, empid, truename, dept);
			// ������ҳ��
			totalPages = empDao.countTotalPage(pageSize, empid, truename, dept);
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String Selectpage() {
		EmpDao empDao = (EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			//������ҳ��
			totalPages = empDao.countTotalPage(pageSize, empid, truename, dept);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			//��ȡѡ��ҳ�ļ�¼
			emps = empDao.findAll(page, pageSize, empid, truename, dept);
			// �����ʼ
			idbegin = (page - 1) * pageSize;
			deptList = deptDao.showName2();
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
