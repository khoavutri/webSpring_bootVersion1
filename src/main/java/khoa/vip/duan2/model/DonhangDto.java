package khoa.vip.duan2.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonhangDto {
	
	private int id;
	
	
	private int SanPhamDto_id;
	
	private int SoLuong;
	


	private Date CreatAt;

	private Date UpDateLast;

	private int userDto_id;
	
}
