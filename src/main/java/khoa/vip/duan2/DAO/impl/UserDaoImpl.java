package khoa.vip.duan2.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import khoa.vip.duan2.DAO.UserDao;
import khoa.vip.duan2.Entity.User;

@Component
public class UserDaoImpl {
	@Autowired
	UserDao dao;
	
	public User selectById(int id) {
		return dao.findById(id).orElse(null);
	}
	public User selectByUserName (String s) {
		return dao.findByUsername(s);
	}
	public User selectByGmail (String s) {
		return dao.findByGmail(s);
	}
	
	public List<User> selectByName(String s){
		
		return dao.searchByName("%"+s+"%");
	}
	public List<User>SelectAll(){
		
		return dao.findAll();
	}
	@Transactional
	public void insert(User user) {
		dao.save(user);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	public List<User> finByAdmin(int admin) {
		return dao.findByAdmin(admin);
	}
	
}
