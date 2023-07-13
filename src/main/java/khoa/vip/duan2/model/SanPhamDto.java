package khoa.vip.duan2.model;

import java.util.Date;

import lombok.Data;


@Data
public class SanPhamDto {

	private int id;
	
	private String name;
	private String LinkAnh;
	private String mota;
	private int luotxem;
	private int gia;
	private String theloai;
	private int soluong;
	private Date date;
}
