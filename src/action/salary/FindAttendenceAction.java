package action.salary;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import util.Factory;
import dao.AttendenceDao;
import dao.DeptDao;
import entity.Attendence;

public class FindAttendenceAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private Attendence attendence;
	private List<Attendence> attendences;
	private Integer month;
	private Integer year;
	private List monthList;
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

	public Attendence getAttendence() {
		return attendence;
	}

	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
	}

	public List<Attendence> getAttendences() {
		return attendences;
	}

	public void setAttendences(List<Attendence> attendences) {
		this.attendences = attendences;
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

	public List getMonthList() {
		return monthList;
	}

	public void setMonthList(List monthList) {
		this.monthList = monthList;
	}
	
	public List<String> getDeptList(){
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
	
	public Integer getIdBegin() {
		return idbegin;
	}

	public void setIdBegin(Integer idbegin) {
		this.idbegin = idbegin;
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
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");		
			dept = attendence.getDept();
			month = Integer.parseInt(attendence.getMonth());
			year = Integer.parseInt(attendence.getYear());
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			// 获取当前页需要的记录
			attendences = attendenceDao.findAll(page,pageSize,empid,truename,dept,attendence.getYear(),attendence.getMonth());
			//序号起始
			idbegin = (page - 1) * pageSize;
			// 计算总页数
			totalPages = attendenceDao.countTotalPage(pageSize, empid,truename,dept,attendence.getYear(),attendence.getMonth());
			if(nowdept.equals("super")) {
				deptList = deptDao.showName2();
			}else {
				deptList = deptDao.showName(dept);
			}
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}			
}
