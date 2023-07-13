package khoa.vip.duan2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import khoa.vip.duan2.Entity.User;
import khoa.vip.duan2.Service.UserService;
import khoa.vip.duan2.model.UserDto;

@Controller
public class DangNhap {
	@Autowired
	UserService service;
	@RequestMapping("/FormDangNhap")
	public String danggnhap() {
		return "DangNhap.html"; 
	}
	@RequestMapping("/XuLyDangNhap")
	public String XLDangNhap(HttpServletRequest request,
			@RequestParam(name="uname") String username,
			@RequestParam(name="psw") String pass,
			HttpSession session) {
		UserDto dto = service.selectByUserName(username);
		if (dto==null) {
			request.setAttribute("loi", "Tên đăng nhập hoặc mật khẩu sai!");
			return "DangNhap.html";
		}
		if (pass.equals(dto.getPassWord())) {
			session.setAttribute("admin", dto.getAdmin());
			session.setAttribute("id", dto.getId());
			return "redirect:/home";
		}
		request.setAttribute("loi", "Tên đăng nhập hoặc mật khẩu sai!");
		return "DangNhap.html";
	}
	@RequestMapping("/home")
	public String home(HttpSession session,Model model) {
		model.addAttribute("id",session.getAttribute("id"));
		model.addAttribute("admin",session.getAttribute("admin"));
		if ((int) session.getAttribute("admin")==1) return "redirect:/QuanLySanPham";
		return 
			"redirect:/UsQuanLySanPham";	
	}
	@RequestMapping("/DangXuat")
	public String DangXuat(HttpSession session) {
		 if (session != null) {
		        session.invalidate();
		    }
		return "redirect:/FormDangNhap";
	}
}
