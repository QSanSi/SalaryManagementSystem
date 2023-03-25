package dao;

import java.util.List;
import entity.Dept;

public interface DeptDao {
	public List<Dept> findAll(int page,int pageSize,String deptname,String manager)throws Exception;
	public int countTotalPage(int pageSize,String deptname,String manager) throws Exception;
	public void save(Dept dept)throws Exception;
	public Dept findById(String id)throws Exception;
	public void update(Dept dept)throws Exception;
	public void deleteById(String id)throws Exception;
	/*public List<Dept> findDept(String name,String manager)throws Exception;*/
	public List<Dept> showDept() throws Exception;
	public List<Dept> showDept2(String dept) throws Exception;
	public List<String> showName(String dept) throws Exception;
	public List<String> showName2() throws Exception;
}
