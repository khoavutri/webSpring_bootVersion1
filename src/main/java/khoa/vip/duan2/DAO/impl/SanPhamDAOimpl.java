package khoa.vip.duan2.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import khoa.vip.duan2.DAO.SanPhamDAO;
import khoa.vip.duan2.Entity.SanPham;

@Component
public class SanPhamDAOimpl {
	@Autowired
	SanPhamDAO dao;
	
	public void insert(SanPham pham) {
		dao.save(pham);
	}
	public void deleteByid(int id) {
		dao.deleteById(id);
	}
	public SanPham selectByid(int id) {
		return dao.findById(id).orElse(null);
	}
	public List<SanPham> selectAll(){
		return dao.findAll();
	}
	public List<SanPham>selectByName(String name){
		return dao.searchByName("%"+name+"%");
	}
	
	public List<SanPham>selectByTheloai(String theloai){
		return dao.searchByTheloai(theloai);
	}
}
