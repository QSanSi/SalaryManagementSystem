package action.salary;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.BaseAction;
import util.Factory;
import dao.AttendenceDao;
import dao.DeptDao;
import entity.AttendenceSet;
import entity.Dept;

public class AttendenceSetAction extends BaseAction {
	private AttendenceSet attendenceSet;
	private List<Dept> deptList;

	public AttendenceSet getAttendenceSet() {
		return attendenceSet;
	}

	public void setAttendenceSet(AttendenceSet attendenceSet) {
		this.attendenceSet = attendenceSet;
	}
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}
	
	public String find() {
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");		
			// 获取当前页需要的记录
			attendenceSet = attendenceDao.findAttendenceSet(attendenceSet.getDept());
			if(nowdept.equals("super")) {
				deptList = deptDao.showDept();
			}else {
				deptList = deptDao.showDept2(nowdept);
			}
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	public String load() {
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");
			attendenceSet = attendenceDao.findAttendenceSet(nowdept);
			if(nowdept.equals("super")) {
				deptList = deptDao.showDept();
			}else {
				deptList = deptDao.showDept2(nowdept);
			}
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	public String updateSet() {
		AttendenceDao attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			String nowdept = (String) ActionContext.getContext().getSession().get("userdept");
			attendenceDao.updateSet(attendenceSet);
			if(nowdept.equals("super")) {
				deptList = deptDao.showDept();
			}else {
				deptList = deptDao.showDept2(nowdept);
			}
			request.put("message", "修改成功");
			return "message";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
