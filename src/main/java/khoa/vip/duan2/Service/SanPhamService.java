package khoa.vip.duan2.Service;

import java.util.List;

import khoa.vip.duan2.model.SanPhamDto;

public interface SanPhamService {
	public void insert(SanPhamDto pham);
	public void deleteByid(int id);
	public SanPhamDto selectByid(int id) ;
	public List<SanPhamDto> selectAll();

	public List<SanPhamDto>selectByName(String name);
	
	public List<SanPhamDto>selectByTheloai(String theloai);
	
}
