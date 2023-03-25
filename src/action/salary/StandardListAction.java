package action.salary;

import java.util.ArrayList;
import java.util.List;

import dao.DeptDao;
import dao.SalaryDao;
import util.Factory;
import entity.SalaryStandard;

public class StandardListAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private int pageSize = 3;
	private List<SalaryStandard> salaryStandards;
	private String empid;
	private String truename;
	private String dept;
	private Integer idbegin; // ҳ�����ʼ��
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
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			salaryStandards = salaryDao.findStandAll(page, pageSize, empid, truename, dept);
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			// ������ҳ��
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
			// ������ҳ��
			totalPages = salaryDao.countTotalPage2(pageSize, empid, truename,dept);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			// �����ʼ
			idbegin = (page - 1) * pageSize;
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			salaryStandards = salaryDao.findStandAll(page, pageSize, empid, truename, dept);
			deptList = deptDao.showName2();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
