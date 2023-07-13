package khoa.vip.duan2.Service;


import java.util.List;
import khoa.vip.duan2.model.DonhangDto;
import khoa.vip.duan2.model.UserDto;

public interface DonHangService {
	public void insert(DonhangDto dto);
	public void delete(int id);
	public DonhangDto SelectByid(int id);
	public List<DonhangDto> selectall();
	public List<DonhangDto> selectByuser_id(int id);
	public void deleteallByUser(int id );
	public List<DonhangDto>selectBySP_id(int id);
}
