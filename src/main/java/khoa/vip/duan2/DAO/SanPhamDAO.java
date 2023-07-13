package khoa.vip.duan2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import khoa.vip.duan2.Entity.SanPham;


public interface SanPhamDAO extends JpaRepository<SanPham, Integer>{
	 @Query("SELECT u FROM SanPham u WHERE u.name LIKE :s")
	    List<SanPham> searchByName(@Param("s") String s);
	 @Query("SELECT u FROM SanPham u WHERE u.theloai LIKE :s")
	    List<SanPham> searchByTheloai(@Param("s") String s);
	 
}
