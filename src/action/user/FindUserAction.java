package action.user;

import java.util.List;

import dao.UserDao;
import entity.User;
import util.Factory;

public class FindUserAction {
	private int page = 1;// 当前显示的页数
	private int totalPages;// 总页数
	private int pageSize = 3;
	/*private User user;*/
	private List<User> users;
	private Integer idbegin; // 页面序号始点
	private String username;

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
	
	/*public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}*/

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getIdBegin() {
		return idbegin;
	}

	public void setIdBegin(Integer idbegin) {
		this.idbegin = idbegin;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String execute() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			// 获取当前页需要的记录
			users = userDao.findAll(page, pageSize, username);
			// 计算总页数
			totalPages = userDao.countTotalPage(pageSize, username);
			// 计算记录数给序号
			idbegin = (page - 1) * pageSize;
			return "find";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
