package action.salary;

import java.util.List;
import dao.BankDao;
import dao.DeptDao;
import entity.Bank;
import util.Factory;

public class FindBankAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private Bank bank;
	private List<Bank> banks;	
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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
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
		BankDao bankDao = (BankDao) Factory.getInstance("BankDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			dept = bank.getDept();
			//获取当前页需要的记录
			banks = bankDao.findAll(page,pageSize,empid,truename,dept);
			//序号起始
			idbegin = (page - 1) * pageSize;
			//计算总页数
			totalPages = bankDao.countTotalPage(pageSize, dept, empid, truename);
			deptList = deptDao.showName2();
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
