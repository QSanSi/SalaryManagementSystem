package entity;

public class Attendence {
	private String id;
	private String empId; // 工号
	private String dept;  //部门
	private String trueName;
	private String year;
	private String month;
	private int lateCome; // 迟到次数
	private int earlyLeave; // 早退次数
	private int leave; // 请假天数
	private int overtime; // 加班时数
	private int negletwork; // 旷工时数

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getLateCome() {
		return lateCome;
	}

	public void setLateCome(int lateCome) {
		this.lateCome = lateCome;
	}

	public int getEarlyLeave() {
		return earlyLeave;
	}

	public void setEarlyLeave(int earlyLeave) {
		this.earlyLeave = earlyLeave;
	}

	public int getLeave() {
		return leave;
	}

	public void setLeave(int leave) {
		this.leave = leave;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public int getNegletwork() {
		return negletwork;
	}

	public void setNegletwork(int negletwork) {
		this.negletwork = negletwork;
	}
}
