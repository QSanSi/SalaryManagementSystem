package dao;

import java.util.List;
import entity.Emp;

public interface EmpDao {
	public List<Emp> findAll(int page, int pageSize, String empid,String truename, String dept) throws Exception;
	public int countTotalPage(int pageSize,String empid,String truename, String dept) throws Exception;
	public void save(Emp emp) throws Exception;
	public Emp findById(String id) throws Exception;
	public void update(Emp emp) throws Exception;
	public void deleteById(String id) throws Exception;
	/*public List<Emp> findEmp(Emp emp) throws Exception;*/
}
