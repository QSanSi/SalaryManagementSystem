package action.user;

import java.util.List;

import dao.UserDao;
import entity.User;
import util.Factory;

public class FindUserAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private int pageSize = 3;
	/*private User user;*/
	private List<User> users;
	private Integer idbegin; // ҳ�����ʼ��
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
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			users = userDao.findAll(page, pageSize, username);
			// ������ҳ��
			totalPages = userDao.countTotalPage(pageSize, username);
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			return "find";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
