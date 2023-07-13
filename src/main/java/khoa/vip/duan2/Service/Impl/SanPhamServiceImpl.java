package khoa.vip.duan2.Service.Impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import khoa.vip.duan2.DAO.impl.SanPhamDAOimpl;
import khoa.vip.duan2.Entity.SanPham;
import khoa.vip.duan2.Service.SanPhamService;
import khoa.vip.duan2.model.SanPhamDto;

@Service
public class SanPhamServiceImpl implements SanPhamService {
	@Autowired
	SanPhamDAOimpl daOimpl;

	@Override
	public void insert(SanPhamDto pham) {
		// TODO Auto-generated method stub
		SanPham sanPham = new SanPham();
		sanPham.setId(0);
		sanPham.setName(pham.getName());
		sanPham.setLinkAnh(pham.getLinkAnh());
		sanPham.setMota(pham.getMota());
		sanPham.setLuotxem(pham.getLuotxem());
		sanPham.setGia(pham.getGia());
		sanPham.setTheloai(pham.getTheloai());
		sanPham.setSoluong(pham.getSoluong());
		sanPham.setDate(pham.getDate());
	
		daOimpl.insert(sanPham);
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		daOimpl.deleteByid(id);
		
	}

		@Override
	public SanPhamDto selectByid(int id) {
		// TODO Auto-generated method stub
		SanPham sanPham = daOimpl.selectByid(id);
		
		if(sanPham==null)
		return null;
		
		SanPhamDto dto = new SanPhamDto();
		dto.setId(sanPham.getId());
		dto.setName(sanPham.getName());
		dto.setLinkAnh(sanPham.getLinkAnh());
		dto.setMota(sanPham.getMota());
		dto.setLuotxem(sanPham.getLuotxem());
		dto.setGia(sanPham.getGia());
		dto.setTheloai(sanPham.getTheloai());
		dto.setSoluong(sanPham.getSoluong());
		dto.setDate(sanPham.getDate());
		
		return dto;
	}

		@Override
	public List<SanPhamDto> selectAll() {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams = daOimpl.selectAll();
		if(sanPhams==null)
		return null;
		
		List<SanPhamDto> lists = new ArrayList<SanPhamDto>();
		for (SanPham sanPham:sanPhams) {
			SanPhamDto dto = new SanPhamDto();
			dto.setId(sanPham.getId());
			dto.setName(sanPham.getName());
			dto.setLinkAnh(sanPham.getLinkAnh());
			dto.setMota(sanPham.getMota());
			dto.setLuotxem(sanPham.getLuotxem());
			dto.setGia(sanPham.getGia());
			dto.setTheloai(sanPham.getTheloai());
			dto.setSoluong(sanPham.getSoluong());
			dto.setDate(sanPham.getDate());
			lists.add(dto);
		}
		return lists;
	}

	@Override
	public List<SanPhamDto> selectByName(String name) {
		List<SanPham> sanPhams = daOimpl.selectByName(name);
		if(sanPhams==null)
		return null;
		
		List<SanPhamDto> lists = new ArrayList<SanPhamDto>();
		for (SanPham sanPham:sanPhams) {
			SanPhamDto dto = new SanPhamDto();
			dto.setId(sanPham.getId());
			dto.setName(sanPham.getName());
			dto.setLinkAnh(sanPham.getLinkAnh());
			dto.setMota(sanPham.getMota());
			dto.setLuotxem(sanPham.getLuotxem());
			dto.setGia(sanPham.getGia());
			dto.setTheloai(sanPham.getTheloai());
			dto.setSoluong(sanPham.getSoluong());
			dto.setDate(sanPham.getDate());
			lists.add(dto);
		}
		return lists;
	}

	@Override
	public List<SanPhamDto> selectByTheloai(String theloai) {
		List<SanPham> sanPhams = daOimpl.selectByTheloai(theloai);
		if(sanPhams==null)
		return null;
		
		List<SanPhamDto> lists = new ArrayList<SanPhamDto>();
		for (SanPham sanPham:sanPhams) {
			SanPhamDto dto = new SanPhamDto();
			dto.setId(sanPham.getId());
			dto.setName(sanPham.getName());
			dto.setLinkAnh(sanPham.getLinkAnh());
			dto.setMota(sanPham.getMota());
			dto.setLuotxem(sanPham.getLuotxem());
			dto.setGia(sanPham.getGia());
			dto.setTheloai(sanPham.getTheloai());
			dto.setSoluong(sanPham.getSoluong());
			dto.setDate(sanPham.getDate());
			lists.add(dto);
		}
		return lists;
	}

}
