package entity;

public class QueryInfomation {
	private String empId; // 工号
	private String trueName;
	private String year;
	private String month;
	private String dept;
	private int lateCome; // 迟到次数
	private int earlyLeave; // 早退次数
	private int leave; // 请假天数
	private int overtime; // 加班时数
	private int negletwork; // 旷工时数
	private double baseSalary; //基础工资
	private double clateCome; //迟到扣款
	private double cearlyLeave; // 早退扣款
	private double cleave; // 请假扣款
	private double covertime; // 加班奖金
	private double cnegletwork; // 旷工扣款
	private String uid;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public double getClateCome() {
		return clateCome;
	}

	public void setClateCome(double clateCome) {
		this.clateCome = clateCome;
	}

	public double getCearlyLeave() {
		return cearlyLeave;
	}

	public void setCearlyLeave(double cearlyLeave) {
		this.cearlyLeave = cearlyLeave;
	}

	public double getCleave() {
		return cleave;
	}

	public void setCleave(double cleave) {
		this.cleave = cleave;
	}

	public double getCovertime() {
		return covertime;
	}

	public void setCovertime(double covertime) {
		this.covertime = covertime;
	}

	public double getCnegletwork() {
		return cnegletwork;
	}

	public void setCnegletwork(double cnegletwork) {
		this.cnegletwork = cnegletwork;
	}
}
