package khoa.vip.duan2.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import khoa.vip.duan2.DAO.DonHangDAO;
import khoa.vip.duan2.Entity.DonHang;
import khoa.vip.duan2.Entity.SanPham;
import khoa.vip.duan2.Entity.User;

@Component
public class DonHangDAOimpl {
	@Autowired
	DonHangDAO dao;
	public DonHang selectByid(int id) {
		return dao.findById(id).orElse(null);
	}
	
	public List<DonHang> selectByUser(User user ) {
		return dao.findByUser(user);
	}
	
	public List<DonHang>selectall(){
		return dao.findAll();
	}
	
	public void insert(DonHang donHang) {
		dao.save(donHang);
	}
	public void delete(int id) {
		dao.deleteById(id);
	}
	public void deleteByuser(User user) {
		dao.deleteAllByUser(user);
	}
	
	public List<DonHang> selectBySanPhams(SanPham sanPham){
		return dao.findBySanPham(sanPham);
	}
}
