package khoa.vip.duan2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import khoa.vip.duan2.Entity.DonHang;
import khoa.vip.duan2.Entity.SanPham;
import khoa.vip.duan2.Entity.User;


public interface DonHangDAO extends JpaRepository<DonHang, Integer> {
	List<DonHang> findByUser(User user);
	void deleteAllByUser(User user);
	List<DonHang> findBySanPham(SanPham sanPham);
}
