package dao;

import java.util.List;
import entity.Tax;

public interface TaxDao {
	public List<Tax> findAll(int page,int pageSize, String empid,String truename, String dept, String year,String month)throws Exception;
	public int countTotalPage(int pageSize, String dept, String empid, String truename, String year, String month) throws Exception;
	public List<Tax> saveTaxByMonth(int page, int pageSize, String dept, String year,String month)throws Exception;
}
