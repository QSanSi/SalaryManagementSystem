package dao;

import java.util.List;
import entity.User;

public interface UserDao {
	public User findByUsername(String username)throws Exception;
	public void save(User user)throws Exception;
	public List<User> findAll(int page,int pageSize,String username)throws Exception;
	public int countTotalPage(int pageSize,String username) throws Exception;
	public User findById(String username)throws Exception;
	public void update(User user)throws Exception;
	public void deleteById(String username)throws Exception;
}
