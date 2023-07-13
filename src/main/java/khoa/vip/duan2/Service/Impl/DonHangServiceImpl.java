package khoa.vip.duan2.Service.Impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import khoa.vip.duan2.DAO.impl.DonHangDAOimpl;
import khoa.vip.duan2.DAO.impl.SanPhamDAOimpl;
import khoa.vip.duan2.DAO.impl.UserDaoImpl;
import khoa.vip.duan2.Entity.DonHang;
import khoa.vip.duan2.Entity.SanPham;
import khoa.vip.duan2.Entity.User;
import khoa.vip.duan2.Service.DonHangService;
import khoa.vip.duan2.model.DonhangDto;
import khoa.vip.duan2.model.UserDto;


@Service
public class DonHangServiceImpl implements DonHangService{

	@Autowired
	SanPhamDAOimpl dao;
	@Autowired
	UserDaoImpl dao2;
	@Autowired
	DonHangDAOimpl daoo;
	
	@Override
	public void insert(DonhangDto dto) {
		DonHang don = new DonHang();
		don.setId(dto.getId());
		int idsp = dto.getSanPhamDto_id();
		SanPham pham = dao.selectByid(idsp);
		don.setSanPham(pham);
		don.setSoLuong(dto.getSoLuong());
		don.setCreatAt(dto.getCreatAt());
		don.setUpDateLast(dto.getUpDateLast());
		int idus=dto.getUserDto_id();
		User user = dao2.selectById(idus);
		don.setUser(user);
		daoo.insert(don);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		daoo.delete(id);
		
	}

	@Override
	public DonhangDto SelectByid(int id) {
		// TODO Auto-generated method stub
		DonHang donHang = daoo.selectByid(id);
		if (donHang!=null) {
		DonhangDto dto = new DonhangDto();
		dto.setId(donHang.getId());
		dto.setSanPhamDto_id(donHang.getSanPham().getId());
		dto.setSoLuong(donHang.getSoLuong());
		dto.setCreatAt(donHang.getCreatAt());
		dto.setUpDateLast(donHang.getUpDateLast());
		dto.setUserDto_id(donHang.getUser().getId());
		return dto;
		} else return null;
	}

	@Override
	public List<DonhangDto> selectall() {
		// TODO Auto-generated method stub
		List<DonHang> donhangs = daoo.selectall();
		List<DonhangDto>lists = new ArrayList<DonhangDto>();
		if (donhangs!=null) {
			for (DonHang donHang:donhangs) {
				DonhangDto dto = new DonhangDto();
				dto.setId(donHang.getId());
				dto.setSanPhamDto_id(donHang.getSanPham().getId());
				dto.setSoLuong(donHang.getSoLuong());
				dto.setCreatAt(donHang.getCreatAt());
				dto.setUpDateLast(donHang.getUpDateLast());
				dto.setUserDto_id(donHang.getUser().getId());
				lists.add(dto);
		
			}
			return lists;
		} else
		return null;
	}

	@Override
	public List<DonhangDto> selectByuser_id(int id) {
		// TODO Auto-generated method stub
		User mul = dao2.selectById(id);
		
		List<DonHang> donhangs = daoo.selectByUser(mul);
		List<DonhangDto>lists = new ArrayList<DonhangDto>();
		if (donhangs!=null) {
			for (DonHang donHang:donhangs) {
				DonhangDto dto = new DonhangDto();
				dto.setId(donHang.getId());
				dto.setSanPhamDto_id(donHang.getSanPham().getId());
				dto.setSoLuong(donHang.getSoLuong());
				dto.setCreatAt(donHang.getCreatAt());
				dto.setUpDateLast(donHang.getUpDateLast());
				dto.setUserDto_id(donHang.getUser().getId());
				lists.add(dto);
		
			}
			return lists;
		} else
		return null;
	}

	@Override
	public void deleteallByUser(int id) {
		// TODO Auto-generated method stub
		User user = dao2.selectById(id);
		
		daoo.deleteByuser(user);
	}

	@Override
	public List<DonhangDto> selectBySP_id(int id) {
		// TODO Auto-generated method stub
	SanPham mul = dao.selectByid(id);
		
		List<DonHang> donhangs = daoo.selectBySanPhams(mul);
		List<DonhangDto>lists = new ArrayList<DonhangDto>();
		if (donhangs!=null) {
			for (DonHang donHang:donhangs) {
				DonhangDto dto = new DonhangDto();
				dto.setId(donHang.getId());
				dto.setSanPhamDto_id(donHang.getSanPham().getId());
				dto.setSoLuong(donHang.getSoLuong());
				dto.setCreatAt(donHang.getCreatAt());
				dto.setUpDateLast(donHang.getUpDateLast());
				dto.setUserDto_id(donHang.getUser().getId());
				lists.add(dto);
		
			}
			return lists;
		} else
		return null;
	}

}
