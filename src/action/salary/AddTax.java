package action.salary;

import java.util.ArrayList;
import java.util.List;
import dao.DeptDao;
import dao.TaxDao;
import entity.Tax;
import util.Factory;

public class AddTax {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private int pageSize = 3;
	private Tax tax;
	private List<Tax> taxs;	
	private String dept;
	private Integer idbegin;
	private List<String> deptList;	
	private Integer month;
	private Integer year;	
	private List monthList;
		
	public String execute() {
		TaxDao taxDao = (TaxDao) Factory.getInstance("TaxDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			dept = tax.getDept();
			String empid = "";
			String truename = "";
			month = Integer.parseInt(tax.getMonth());
			year = Integer.parseInt(tax.getYear());
			//�����ʼ
			idbegin = (page - 1) * pageSize;
			monthList = new ArrayList();
			for (int i = 1; i <= 12; i++) {
				monthList.add(i);
			}
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			taxs = taxDao.saveTaxByMonth(page, pageSize, tax.getDept(), tax.getYear(), tax.getMonth());
			// ������ҳ��
			totalPages = taxDao.countTotalPage(pageSize, empid, truename, tax.getDept(), tax.getYear(), tax.getMonth());
			deptList = deptDao.showName2();
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
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
}
