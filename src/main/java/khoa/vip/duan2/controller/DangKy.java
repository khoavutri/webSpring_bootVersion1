package khoa.vip.duan2.controller;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import khoa.vip.duan2.DAO.UserDao;
import khoa.vip.duan2.Service.UserService;
import khoa.vip.duan2.model.UserDto;

@Controller
public class DangKy {
	@Autowired
	UserService service;
	

	@RequestMapping("/FormDangKy")
	public String Form() {
		return "DangKy.html";
	}
	//username password gmail fullname agee
	@RequestMapping("/XLDangKy")
	public String Xuly(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("gmail") String gmail,
			@RequestParam("fullname") String fullname,
			@RequestParam("agee") int age) {
			UserDto userDto = new UserDto();
		userDto.setId(0);
		userDto.setFullname(fullname);
		userDto.setAge(age);
		userDto.setUsername(username);
		userDto.setPassWord(password);
		userDto.setGmail(gmail);

		if (service.selectByGmail(gmail)!=null || service.selectByUserName(username)!=null) {
			request.setAttribute("loi", "Tên đăng nhập hoặc gmail đã tồn tại");
			return "DangKy.html";
		}
		service.insert(userDto);
		return "redirect:/FormDangNhap";
	}
}
