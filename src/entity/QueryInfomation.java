package entity;

public class QueryInfomation {
	private String empId; // ����
	private String trueName;
	private String year;
	private String month;
	private String dept;
	private int lateCome; // �ٵ�����
	private int earlyLeave; // ���˴���
	private int leave; // �������
	private int overtime; // �Ӱ�ʱ��
	private int negletwork; // ����ʱ��
	private double baseSalary; //��������
	private double clateCome; //�ٵ��ۿ�
	private double cearlyLeave; // ���˿ۿ�
	private double cleave; // ��ٿۿ�
	private double covertime; // �Ӱཱ��
	private double cnegletwork; // �����ۿ�
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
