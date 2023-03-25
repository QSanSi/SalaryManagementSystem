package dao;

import java.util.List;
import entity.Insurance;
import entity.Salary;
import entity.SalaryStandard;

public interface SalaryDao {
	public void save(Salary salary)throws Exception;
	public Salary findById(String id)throws Exception;
	public void update(Salary salary)throws Exception;
	public void deleteById(String id)throws Exception;
	public List<Salary> showSalary() throws Exception;
	public void saveSalarys(List<Salary> salarys) throws Exception;
	
	public List<Salary> findAll(int page,int pageSize, String empid,String truename, String dept, String year,String month)throws Exception;
	public int countTotalPage2(int pageSize, String empid, String truename, String dept) throws Exception;	
	public int countTotalPage(int pageSize, String dept, String empid, String truename, String year, String month) throws Exception;	
	public List<Salary> saveSalarysByMonth(int page, int pageSize, String dept, String year,String month)throws Exception;
	
	/*public List<SalaryStandard> findStand(SalaryStandard salaryStandard)throws Exception;*/
	public List<SalaryStandard> findStandAll(int page,int pageSize, String empid,String truename, String dept)throws Exception;
	
	public SalaryStandard loadStand(String id)throws Exception;
	public void updateStand(SalaryStandard salaryStandard)throws Exception;
	
	public Insurance findInsurance()throws Exception;
	public void updateInsurance(Insurance insurance)throws Exception;
}
