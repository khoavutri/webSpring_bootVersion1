package khoa.vip.duan2.Service;

import java.util.List;


import khoa.vip.duan2.model.UserDto;

public interface UserService {
	public UserDto selectById(int id);
	public UserDto selectByUserName (String s);
	public UserDto selectByGmail (String s);
	public List<UserDto> selectByname(String s);
	public List<UserDto>SelectAll();
	public void insert(UserDto userDto);
	public void deleteByid(int id);
	public List<UserDto>SelectByAdmin(int admin);
}
