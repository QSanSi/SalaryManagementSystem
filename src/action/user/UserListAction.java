package action.user;

import java.util.List;
import dao.UserDao;
import util.Factory;
import entity.User;

public class UserListAction {
	private int page = 1;// ��ǰ��ʾ��ҳ��
	private int totalPages;// ��ҳ��
	private List<User> users;
	private int pageSize = 3;
	private Integer idbegin; // ҳ�����ʼ��
	private String userName;

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
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String showlist() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			users = userDao.findAll(page, pageSize, userName);
			// ������ҳ��
			totalPages = userDao.countTotalPage(pageSize, userName);
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String SelectPage() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			// ������ҳ��
			totalPages = userDao.countTotalPage(pageSize, userName);
			if (page < 1) {
				page = 1;
			}
			if (page > totalPages) {
				page = totalPages;
			}
			// ��ȡ��ǰҳ��Ҫ�ļ�¼
			users = userDao.findAll(page, pageSize, userName);		
			// �����¼�������
			idbegin = (page - 1) * pageSize;
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}	
}
