package khoa.vip.duan2.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import khoa.vip.duan2.DAO.impl.UserDaoImpl;
import khoa.vip.duan2.Entity.DonHang;
import khoa.vip.duan2.Entity.User;
import khoa.vip.duan2.Service.UserService;
import khoa.vip.duan2.model.UserDto;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDaoImpl daoImpl;

	@Override
	public UserDto selectById(int id) {
		// TODO Auto-generated method stub
		User user = daoImpl.selectById(id);
		
		if (user!=null) {
		
		List<Integer>Dh_id = new ArrayList<Integer>();
//		for (DonHang a: user.getDonhangs()) {
//			Dh_id.add(a.getId());
//		};
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFullname(user.getFullname());
		userDto.setAge(user.getAge());
		userDto.setUsername(user.getUsername());
		userDto.setPassWord(user.getPassWord());
		userDto.setGmail(user.getGmail());
		//userDto.setDonhangDtos_id(Dh_id);
		userDto.setAdmin(user.getAdmin());
		return userDto;} else return null;
	}

	@Override
	public UserDto selectByUserName(String s) {
		// TODO Auto-generated method stub
		User user = daoImpl.selectByUserName(s);
		if (user!=null) {
		List<Integer>Dh_id = new ArrayList<Integer>();
	
//		for (DonHang a: user.getDonhangs()) {
//			Dh_id.add(a.getId());
//		};
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFullname(user.getFullname());
		userDto.setAge(user.getAge());
		userDto.setUsername(user.getUsername());
		userDto.setPassWord(user.getPassWord());
		userDto.setGmail(user.getGmail());
		
//		userDto.setDonhangDtos_id(Dh_id);
		userDto.setAdmin(user.getAdmin());
		return userDto;} else return null;
	}

	@Override
	public UserDto selectByGmail(String s) {
		// TODO Auto-generated method stub
		User user = daoImpl.selectByGmail(s);
		if (user!=null) {
		List<Integer>Dh_id = new ArrayList<Integer>();
		
//		for (DonHang a: user.getDonhangs()) {
//			Dh_id.add(a.getId());
//		};
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFullname(user.getFullname());
		userDto.setAge(user.getAge());
		userDto.setUsername(user.getUsername());
		userDto.setPassWord(user.getPassWord());
		userDto.setGmail(user.getGmail());
//		userDto.setDonhangDtos_id(Dh_id);
		userDto.setAdmin(user.getAdmin());
		
		return userDto;} else return null;
	}

	@Override
	public List<UserDto> selectByname(String s) {
		// TODO Auto-generated method stub
		List<UserDto>userDtos = new ArrayList<UserDto>();
		if (userDtos!=null) {
		List<User>users = daoImpl.selectByName(s);
		for (User user:users) {
			UserDto userDto = new UserDto();
			List<Integer>Dh_id = new ArrayList<Integer>();
//			for (DonHang a: user.getDonhangs()) {
//				Dh_id.add(a.getId());
//			};
			userDto.setId(user.getId());
			userDto.setFullname(user.getFullname());
			userDto.setAge(user.getAge());
			userDto.setUsername(user.getUsername());
			userDto.setPassWord(user.getPassWord());
			userDto.setGmail(user.getGmail());
//			userDto.setDonhangDtos_id(Dh_id);
			userDto.setAdmin(user.getAdmin());
			userDtos.add(userDto);
		}
		return userDtos;} else return null;
	}

	@Override
	public List<UserDto> SelectAll() {
		// TODO Auto-generated method stub
		List<UserDto>userDtos = new ArrayList<UserDto>();
		List<User>users = daoImpl.SelectAll();
		if (users!=null) {
		for (User user:users) {
			UserDto userDto = new UserDto();
			List<Integer>Dh_id = new ArrayList<Integer>();
//			for (DonHang a: user.getDonhangs()) {
//				Dh_id.add(a.getId());
//			};
			userDto.setId(user.getId());
			userDto.setFullname(user.getFullname());
			userDto.setAge(user.getAge());
			userDto.setUsername(user.getUsername());
			userDto.setPassWord(user.getPassWord());
			userDto.setGmail(user.getGmail());
//			userDto.setDonhangDtos_id(Dh_id);
			userDto.setAdmin(user.getAdmin());
			userDtos.add(userDto);
		}
		return userDtos;
		}
		else return null;
	}

	@Override
	public void insert(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(userDto.getId());
		user.setFullname(userDto.getFullname());
		user.setAge(userDto.getAge());
		user.setUsername(userDto.getUsername());
		user.setPassWord(userDto.getPassWord());
		user.setGmail(userDto.getGmail());
//		user.setDonhangs(null);
		user.setAdmin(0);
		daoImpl.insert(user);
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		daoImpl.delete(id);
	}

	@Override
	public List<UserDto> SelectByAdmin(int admin) {
		List<UserDto>userDtos = new ArrayList<UserDto>();
		if (userDtos!=null) {
		List<User>users = daoImpl.finByAdmin(admin);
		for (User user:users) {
			UserDto userDto = new UserDto();
			List<Integer>Dh_id = new ArrayList<Integer>();
//			for (DonHang a: user.getDonhangs()) {
//				Dh_id.add(a.getId());
//			};
			userDto.setId(user.getId());
			userDto.setFullname(user.getFullname());
			userDto.setAge(user.getAge());
			userDto.setUsername(user.getUsername());
			userDto.setPassWord(user.getPassWord());
			userDto.setGmail(user.getGmail());
//			userDto.setDonhangDtos_id(Dh_id);
			userDto.setAdmin(user.getAdmin());
			userDtos.add(userDto);
		}
		return userDtos;} else return null;
	}

	

}
