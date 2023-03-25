package action.salary;

import dao.BankDao;
import entity.Bank;
import util.Factory;

public class BankAction {
	private Bank bank;
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public String load() {
		BankDao bankDao = (BankDao) Factory.getInstance("BankDao");
		try {
			bank = bankDao.findById(bank.getId());
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update() {
		BankDao bankDao = (BankDao) Factory.getInstance("BankDao");
		try {
			bankDao.update(bank);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
