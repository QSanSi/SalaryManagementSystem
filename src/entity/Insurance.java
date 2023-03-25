package entity;

public class Insurance {
	private String id;
	private int old; // 养老保险
	private int unemployment; // 失业保险
	private int medical; // 医疗保险
	private int bear; // 生育保险
	private int injury; // 工伤保险
	private int house; // 公积金

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public int getUnemployment() {
		return unemployment;
	}

	public void setUnemployment(int unemployment) {
		this.unemployment = unemployment;
	}

	public int getMedical() {
		return medical;
	}

	public void setMedical(int medical) {
		this.medical = medical;
	}

	public int getBear() {
		return bear;
	}

	public void setBear(int bear) {
		this.bear = bear;
	}

	public int getInjury() {
		return injury;
	}

	public void setInjury(int injury) {
		this.injury = injury;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
