package khoa.vip.duan2.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import khoa.vip.duan2.Service.DonHangService;
import khoa.vip.duan2.Service.SanPhamService;
import khoa.vip.duan2.Service.UserService;
import khoa.vip.duan2.model.DonhangDto;
import khoa.vip.duan2.model.SanPhamDto;
import khoa.vip.duan2.model.UserDto;


@Controller
public class Admin {
	@Autowired
	UserService service;
	@Autowired
	SanPhamService service2;
	
	@Autowired
	DonHangService service3;
	
	@RequestMapping("/QuanLyNguoiDung")
	public String QuanLyNguoiDung(HttpSession session,HttpServletRequest request,Model model) {
	
		List<UserDto> userDtos = service.SelectAll();
		model.addAttribute("ListUser", userDtos);
		return "Admin/Home1.html";
	}
	@RequestMapping("/XoaNguoiDung")
	public String XoaNguoiDung(HttpSession session,Model model,@RequestParam("idm") int id) {
		if (service.selectById(id).getAdmin()!=1) {
		List<DonhangDto>donhangDtos = service3.selectByuser_id(id);
		if (donhangDtos!=null)
		for (DonhangDto don:donhangDtos) {
			service3.delete(don.getId());
		};
		service.deleteByid(id);
		}
		List<UserDto> userDtos = service.SelectAll();
		model.addAttribute("ListUser", userDtos);
		return "Admin/Home1.html";
	}
	@RequestMapping("/BuocDemSuaNguoiDung")
	public String BuocDemSuaNguoiDung(Model model,@RequestParam("idm")int id) {
		model.addAttribute("idm",id);
		if (service.selectById(id).getAdmin()!=1)
		return "Admin/SuaThongTin.html"; else return "redirect:/QuanLyNguoiDung";
	}

	@RequestMapping("/XLSuaNguoiDung")
	public String XLSuaNguoiDunng(HttpServletRequest request,Model model,
			@RequestParam("idm")int id,
			@RequestParam("password")String password,
			@RequestParam("fullname") String fullname,
			@RequestParam("agee")int age)
			 {
		UserDto dto = service.selectById(id);
		dto.setAge(age);
		dto.setFullname(fullname);
		dto.setPassWord(password);
		service.insert(dto);
		return "redirect:/QuanLyNguoiDung";
	}
	@RequestMapping("/TimKiemNguoiDung")
	public String TimKiemNguoiDung(HttpServletRequest request,Model model,
			@RequestParam("search")String name) {
		List<UserDto> userDtos = service.selectByname(name);	
		model.addAttribute("ListUser", userDtos);
		return "Admin/Home1.html";
	}
	
	@RequestMapping("/BuocDemThemSanPham")
	public String BuocDemThemSanPham() {
		return "Admin/ThemSanPham.html";
	}



	@RequestMapping("/XLThemSanPham")
	public String XLThemSanPham(HttpServletRequest request,Model model,HttpServletResponse response,HttpSession session,
			@RequestParam("name")String name,
			@RequestParam("photo") MultipartFile file,
			@RequestParam("mota") String mota,
			@RequestParam("price") int gia,
			@RequestParam("soluong") int soluong,
			@RequestParam("theloai") String theloai) throws IllegalStateException, IOException  {
			SanPhamDto dto = new SanPhamDto();
		
			final String UPLOAD_FOLDER = "C:\\Users\\Vu Tri Khoa\\OneDrive\\Desktop\\html\\duan2\\"
					+ "src\\main\\resources\\static\\img\\SanPham\\";

			String filename =System.currentTimeMillis()+ file.getOriginalFilename();
			File newFile = new File(UPLOAD_FOLDER + filename);

			file.transferTo(newFile);

			dto.setId(0);
			dto.setName(name);
			dto.setLinkAnh(filename);
			dto.setMota(mota);
			dto.setLuotxem(0);
			dto.setTheloai(theloai);
			dto.setSoluong(soluong);
			dto.setGia(gia);
			dto.setDate(new Date(System.currentTimeMillis()));
		
			service2.insert(dto);
		
			return "redirect:/download";
		
	
	}
	
	@RequestMapping("/download")
	public String download(HttpServletResponse response,Model model,HttpSession session,HttpServletRequest request) {
		final String UPLOAD_FOLDER = "C:\\Users\\Vu Tri Khoa\\OneDrive\\Desktop\\html\\duan2\\"
				+ "src\\main\\resources\\static\\img\\SanPham\\";
		String filename=(String) session.getAttribute("filename");
		File file = new File(UPLOAD_FOLDER + filename);

		try {
			Files.copy(file.toPath(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/QuanLySanPham";
	}
	@RequestMapping("/XoaSanPham")
	public String XoaSanPham(Model model,@RequestParam("idsp") int id) {
		List<DonhangDto> donhangDtos = service3.selectBySP_id(id);
		if (donhangDtos!=null)
		for(DonhangDto dto:donhangDtos) {
			service3.delete(dto.getId());
		};
		service2.deleteByid(id);
		return "redirect:/QuanLySanPham";
	}
	@RequestMapping("/SelectforAdmin")
	public String SelectforAdmin(Model model) {
	List<UserDto> userDtos = service.SelectByAdmin(1);	
	model.addAttribute("ListUser", userDtos);
	return "Admin/Home1.html";
	}
	@RequestMapping("/SelectforUser")
	public String SelectforUser(Model model) {
	List<UserDto> userDtos = service.SelectByAdmin(0);	
	model.addAttribute("ListUser", userDtos);
	return "Admin/Home1.html";
	}
	@RequestMapping("/QuanLySanPham")
	public String QuanLySannPham(HttpServletResponse response,Model model) {
		   List<SanPhamDto> phamDtos = service2.selectAll();
		    model.addAttribute("Listsp", phamDtos);
		    return "Admin/Home.html";
	
	}
	@RequestMapping("/SelectSPbyTheLoai")
	public String SelectSPbyTheLoai(HttpServletResponse response,Model model,
			@RequestParam("tloai") String tl) {
		   List<SanPhamDto> phamDtos = service2.selectByTheloai(tl);
		    model.addAttribute("Listsp", phamDtos);
		    return "Admin/Home.html";
	
	}
	@RequestMapping("/SearchSanPham")
	public String SearchSanPham(HttpServletResponse response,Model model,
			@RequestParam("moithu") String tl) {
		   List<SanPhamDto> phamDtos = service2.selectByName(tl);
		    model.addAttribute("Listsp", phamDtos);
		    return "Admin/Home.html";
	}
}
