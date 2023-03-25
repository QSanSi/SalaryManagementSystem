package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import action.BaseAction;
import util.Factory;
import dao.AttendenceDao;
import dao.DeptDao;
import entity.Attendence;

public class AttendenceListAction extends BaseAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private int pageSize = 3;
	private Attendence attendence;
	private List<Attendence> attendences;
	private String empid;
	private String truename;
	private Integer month; // ҳ���·�
	private Integer year; // ҳ�����
	private List<String> deptList;
	private List monthList;
	private String dept;
	private Integer idbegin; // ҳ�����ʼ��
	private String syear; //��ҳ���
	private String smonth; //��ҳ�·�	

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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getSyear() {
		return syear;
	}

	public void setSyear(String syear) {
		this.syear = syear;
	}
	
	public String getSmonth() {
		return smonth;
	}

	public void setSmonth(String smonth) {
		this.smonth = smonth;
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
	
	public Integer getIdBegin() {
		return idbegin;
	}

	public void setIdBegin(Integer idbegin) {
		this.idbegin = idbegin;
	}

	public String showlist() {
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			Calendar c = Calendar.getInstance();
			month = c.get(Calendar.MONTH) + 1;
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			String m = month.toString();
			year = c.get(Calendar.YEAR);
			String y = year.toString();
			attendences = attendenceDao.findAll(page, pageSize, empid, truename, nowdept, y, m);
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			// ������ҳ��
			totalPages = attendenceDao.countTotalPage(pageSize, empid, truename, nowdept, y, m);
			if(nowdept.equals("super")) {
				deptList = deptDao.showName2();
			}else {
				deptList = deptDao.showName(nowdept);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String Selectpage() {
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");
			month = Integer.parseInt(smonth);
			year = Integer.parseInt(syear);
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			// ������ҳ��
			totalPages = attendenceDao.countTotalPage(pageSize, empid, truename, dept, syear, smonth);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			attendences = attendenceDao.findAll(page, pageSize, empid, truename, dept, syear, smonth);
			// �����¼�������
			idbegin = (page - 1) * pageSize;		
			if(nowdept.equals("super")) {
				deptList = deptDao.showName2();
			}else {
				deptList = deptDao.showName(dept);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
