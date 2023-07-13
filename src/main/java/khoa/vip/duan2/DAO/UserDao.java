package khoa.vip.duan2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import khoa.vip.duan2.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	public List<User> findByFullname(String s);
	public User findByGmail(String s);
	public User findByUsername(String s);
	 @Query("SELECT u FROM User u WHERE u.fullname LIKE :s")
	    List<User> searchByName(@Param("s") String s);
	public List<User> findByAdmin(int admin);
}
