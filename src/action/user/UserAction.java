package action.user;

import java.util.ArrayList;
import java.util.List;

import action.BaseAction;
import dao.DeptDao;
import dao.UserDao;
import util.Factory;
import entity.User;

public class UserAction extends BaseAction{
	private String username;
	private String id;
	private User user;
	private String password2;
	private List<String> deptList;
	private List<String> rightList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public List<String> getDeptList(){
		return deptList;
	}
	
	public void setDeptList(List<String> deptList) {
		this.deptList = deptList;
	}
	
	public List<String> getRightList(){
		return rightList;
	}
	
	public void setRightList(List<String> rightList) {
		this.rightList = rightList;
	}
	
	public String addUser() {
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			deptList = deptDao.showName2();
			deptList.set(0, "super");
			rightList = new ArrayList<String>();
			rightList.add("super");
			rightList.add("emp");
			rightList.add("salary");
			rightList.add("attendence");
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	public String add() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			if (user.getUsername().equals("")) {
				request.put("username_error", "用户名不可为空");
				deptList = deptDao.showName2();
				deptList.set(0, "super");
				rightList = new ArrayList<String>();
				rightList.add("super");
				rightList.add("emp");
				rightList.add("salary");
				rightList.add("attendence");
				return "username_error";
			}
			else if (userDao.findById(user.getUsername()) != null) {
				request.put("username_error", "用户名已存在");
				deptList = deptDao.showName2();
				deptList.set(0, "super");
				rightList = new ArrayList<String>();
				rightList.add("super");
				rightList.add("emp");
				rightList.add("salary");
				rightList.add("attendence");
				return "username_error";
			}
			else if (!user.getPassword().equals(password2)) {
				request.put("password_error", "两次密码不一致");
				deptList = deptDao.showName2();
				deptList.set(0, "super");
				rightList = new ArrayList<String>();
				rightList.add("super");
				rightList.add("emp");
				rightList.add("salary");
				rightList.add("attendence");
				return "password_error";
			} else {
				userDao.save(user);
				return "list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public String load() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
		try {
			user = userDao.findById(user.getUsername());
			deptList = deptDao.showName2();
			deptList.set(0, "super");
			rightList = new ArrayList<String>();
			rightList.add("super");
			rightList.add("emp");
			rightList.add("salary");
			rightList.add("attendence");
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	public String delete() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			userDao.deleteById(user.getUsername());
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	public String update() {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			userDao.update(user);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
