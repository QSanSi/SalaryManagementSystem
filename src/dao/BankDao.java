package dao;

import java.util.List;
import entity.Bank;

public interface BankDao {
	public List<Bank> findAll(int page,int pageSize, String empid,String truename, String dept)throws Exception;
	public int countTotalPage(int pageSize, String dept, String empid, String truename) throws Exception;
	public Bank findById(String id)throws Exception;
	public void update(Bank bank)throws Exception;
}
