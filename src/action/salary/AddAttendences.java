package action.salary;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import util.Factory;
import dao.AttendenceDao;
import dao.DeptDao;
import entity.Attendence;

public class AddAttendences {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private List<Attendence> attendences;
	private int pageSize = 3;
	private Attendence attendence;
	private String dept;
	private Integer idbegin;
	private List<String> deptList;
	private Integer month;
	private Integer year;
	private List monthList;

	public String execute() {
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");
			dept = attendence.getDept();
			String empid = "";
			String truename = "";
			// 获取当前页需要的记录
			month = Integer.parseInt(attendence.getMonth());
			year = Integer.parseInt(attendence.getYear());
			//序号起始
			idbegin = (page - 1) * pageSize;
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			attendences = attendenceDao.generateByMonth(page, pageSize, dept, attendence.getYear(), attendence.getMonth());
			// 计算总页数
			totalPages = attendenceDao.countTotalPage(pageSize,empid, truename,dept,attendence.getYear(), attendence.getMonth());
			if (nowdept.equals("super")) {
				deptList = deptDao.showName2();
			}else {
				deptList = deptDao.showName(dept);
			}
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

	public List<Attendence> getAttendences() {
		return attendences;
	}

	public void setAttendences(List<Attendence> attendences) {
		this.attendences = attendences;
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

	public Attendence getAttendence() {
		return attendence;
	}

	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
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
