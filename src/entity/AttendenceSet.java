package entity;

public class AttendenceSet {
	private String dept;
	private double lateCome;   //迟到罚款
	private double earlyLeave;  //早退罚款
	private double leave;   //请假罚款
	private double overtime;   //加班奖金
	private double negletwork;  //旷工罚金
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getLateCome() {
		return lateCome;
	}
	public void setLateCome(double lateCome) {
		this.lateCome = lateCome;
	}
	public double getEarlyLeave() {
		return earlyLeave;
	}
	public void setEarlyLeave(double earlyLeave) {
		this.earlyLeave = earlyLeave;
	}
	public double getLeave() {
		return leave;
	}
	public void setLeave(double leave) {
		this.leave = leave;
	}
	public double getOvertime() {
		return overtime;
	}
	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	public double getNegletwork() {
		return negletwork;
	}
	public void setNegletwork(double negletwork) {
		this.negletwork = negletwork;
	}
}
