package action.salary;

import java.util.ArrayList;
import java.util.List;
import dao.DeptDao;
import dao.TaxDao;
import entity.Tax;
import util.Factory;

public class FindTaxAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	private Tax tax;
	private List<Tax> taxs;	
	private String empid;
	private String truename;
	private String dept;
	private Integer idbegin;
	private List<String> deptList;	
	private Integer month;
	private Integer year;	
	private List monthList;
		

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

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public List<Tax> getTaxs() {
		return taxs;
	}

	public void setTaxs(List<Tax> taxs) {
		this.taxs = taxs;
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
		TaxDao taxDao = (TaxDao) Factory.getInstance("TaxDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			dept = tax.getDept();
			month = Integer.parseInt(tax.getMonth());
			year = Integer.parseInt(tax.getYear());
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			//获取当前页需要的记录
			taxs = taxDao.findAll(page,pageSize,empid,truename,dept,tax.getYear(),tax.getMonth());
			//序号起始
			idbegin = (page - 1) * pageSize;
			//计算总页数
			totalPages = taxDao.countTotalPage(pageSize, empid, truename, dept, tax.getYear(), tax.getMonth());
			deptList = deptDao.showName2();
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
