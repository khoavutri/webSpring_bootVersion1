package khoa.vip.duan2.model;

import java.util.List;

import lombok.Data;
import javax.validation.constraints.Size;



@Data
public class UserDto {
	
	private int id;
	
	private String fullname;
	private int age;
	private String username;
	
	@Size(min=6,max=12)
	private String passWord;
	
	private String gmail;
	private int admin;
//	private List<Integer> donhangDtos_id;
}
