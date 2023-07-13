package khoa.vip.duan2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import khoa.vip.duan2.DAO.impl.DonHangDAOimpl;
import khoa.vip.duan2.DAO.impl.SanPhamDAOimpl;
import khoa.vip.duan2.DAO.impl.UserDaoImpl;
import khoa.vip.duan2.Entity.DonHang;
import khoa.vip.duan2.Entity.SanPham;
import khoa.vip.duan2.Service.DonHangService;
import khoa.vip.duan2.Service.SanPhamService;
import khoa.vip.duan2.Service.UserService;
import khoa.vip.duan2.model.DonhangDto;
import khoa.vip.duan2.model.SanPhamDto;
import khoa.vip.duan2.model.UserDto;
import khoa.vip.duan2.model.xemdeu;

@Controller
public class User {
	@Autowired
	UserService service;
	@Autowired
	SanPhamService service2;
	@Autowired
	DonHangService service3;
	
	@RequestMapping("/UsQuanLySanPham")
	public String QuanLySannPham(HttpServletResponse response,Model model,
			HttpSession session,HttpServletRequest request) {
		   List<SanPhamDto> phamDtos = service2.selectAll();
		    model.addAttribute("Listsp", phamDtos);
		    model.addAttribute(session.getAttribute("id"));
		 
		    return "User/Home.html";
	
	}
	@RequestMapping("/UsSelectSPbyTheLoai")
	public String SelectSPbyTheLoai(HttpServletResponse response,Model model,HttpSession session,
			@RequestParam("tloai") String tl) {
		   List<SanPhamDto> phamDtos = service2.selectByTheloai(tl);
		    model.addAttribute("Listsp", phamDtos);
		    model.addAttribute(session.getAttribute("id"));
		    return "User/Home.html";
	
	}
	@RequestMapping("/UsSearchSanPham")
	public String SearchSanPham(HttpServletResponse response,Model model,HttpSession session,
			@RequestParam("moithu") String tl) {
		   List<SanPhamDto> phamDtos = service2.selectByName(tl);
		    model.addAttribute("Listsp", phamDtos);
		    model.addAttribute(session.getAttribute("id"));
		    return "User/Home.html";
	}
	
	@RequestMapping("/BDSuaThongTin")
	public String BDSuaThongTin(HttpSession session,Model model) {
		model.addAttribute("idm",session.getAttribute("idm"));
		return "User/KtMatKhaustt.html";
	}
	@RequestMapping("/BDSuaThongTin2")
	public String BDSuaThongTin2(HttpSession session,@RequestParam("password")String passString,Model model) {
		if (service.selectById( (int) session.getAttribute("id")).getPassWord().equals(passString)) {
		return "User/SuaThongTin.html";
	} else { 
		model.addAttribute("loi","Nhập mật khẩu sai!");
		return "User/KtMatKhaustt.html";
		
		}
	}
	
	@RequestMapping("/UsXlSuaThongTin")
	public String UsXlSuaThongTin(HttpSession session,Model model,
			@RequestParam("fullname") String fullname,
			@RequestParam("agee") int age) {
		UserDto dto = service.selectById((int)session.getAttribute("id"));
		dto.setFullname(fullname);
		dto.setAge(age);
		service.insert(dto);
		return "redirect:/UsQuanLySanPham";
	}
	@RequestMapping("/UsXemDanhsachdh")
	public String UsXemDanhsachdh() {
		return "miuler.html";
	}
	@RequestMapping("/UsBuocDemDoiMatKhau")
	public String UsBuocDemDoiMatKhau() {
		return "User/KtMatKhauDMK.html";
	}
	@RequestMapping("/UsBuocDemDoiMatKhau2")
	public String UsBuocDemDoiMatKhau2(HttpSession session,@RequestParam("password") String pass,
			HttpServletRequest request) {
		if (service.selectById((int)session.getAttribute("id")).getPassWord().equals(pass))
		return "User/DMKMatKhauMoi.html"; else {
			request.setAttribute("loi", "Mật Khẩu sai!");
			return "User/KtMatKhauDMK.html";
		}
	}
	@RequestMapping("/XLUSdmatkhau")
	public String XLUSdmatkhau(HttpSession session,HttpServletRequest request,
			@RequestParam("password") String pass1,
			@RequestParam("password1") String pass2) {
		if (pass1.equals(pass2)) {
			UserDto dto = service.selectById((int)session.getAttribute("id"));
			dto.setPassWord(pass2);
			service.insert(dto);
			return "redirect:/UsQuanLySanPham";
		} else {
			request.setAttribute("loi", "nhập lại mật khẩu không giống");
			return "User/DMKMatKhauMoi.html";
		}
		
	}
	@RequestMapping("/UserMuaHang")
	public String UserMuaHang(Model model,@RequestParam("idsp") int id) {
		model.addAttribute("tientien",service2.selectByid(id).getGia());
		return "User/MuaLe.html";
	}
	 //id;sanPham; SoLuong;CreatAt;UpDateLast;user;
	@RequestMapping("/UserThemGioHang")
	public String UserThemGioHang(HttpSession session,@RequestParam("idsp")int idsp,
			Model model) {
		int iduser =(int) session.getAttribute("id");
	
		DonhangDto donhangDto = new DonhangDto(0,idsp,1,
				new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis()),iduser);
	
		service3.insert(donhangDto);
		return "redirect:/UsQuanLySanPham";
	}
	
	@RequestMapping("/UserXemGioHang")
	public String UserXemGioHang(HttpSession session,Model model,HttpServletRequest request) {
		int iduser = (int) session.getAttribute("id");
		UserDto userDto = service.selectById(iduser);
		List<DonhangDto> phamDtos = service3.selectByuser_id(iduser);
		List<xemdeu> lists = new ArrayList<xemdeu>();
		if (phamDtos!=null) {
		for (DonhangDto donhang:phamDtos) {
			xemdeu x = new xemdeu();
			SanPhamDto dto = service2.selectByid(donhang.getSanPhamDto_id());
			x.setId(donhang.getId());
			x.setName(dto.getName());
			x.setGia(dto.getGia());
			x.setSoluong(dto.getSoluong());
			x.setLink(dto.getLinkAnh());
			x.setTheloai(dto.getTheloai());
			x.setMota(dto.getMota());
			lists.add(x);
			}
		}
		
		model.addAttribute("lists",lists);
		return "User/GioHang.html";
	}
	@RequestMapping("/UserXLXoaDonHang")
	public String UserXLXoaDonHang(HttpSession session,@RequestParam("iddh")int iddh) {
		service3.delete(iddh);
		return "redirect:/UserXemGioHang";
	}
	@RequestMapping("/UsThanhToanDonHang")
	public String UsThanhToanDonHang(HttpSession session,Model model) {
		int idd = (int)session.getAttribute("id");
		List<DonhangDto>donhangDtos = service3.selectByuser_id(idd);
		int tong =0;
		for(DonhangDto dto:donhangDtos) {
			tong += service2.selectByid(dto.getSanPhamDto_id()).getGia()*dto.getSoLuong();
			service3.delete(dto.getId());
		}
		model.addAttribute("tientien",tong);
		return "User/MuaLe.html";
	}
}
