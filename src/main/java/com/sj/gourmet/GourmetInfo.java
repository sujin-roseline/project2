package com.sj.gourmet;

public class GourmetInfo {
	private String id;
	private String name; // �긽�샇紐�
	private String tel; // �쟾�솕踰덊샇
	private String menu; // 硫붾돱
	private String addr; // 二쇱냼
	private String img;
		
	public GourmetInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public GourmetInfo(String id, String name, String tel, String menu, String addr, String img) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.menu = menu;
		this.addr = addr;
		this.img = img;
	}
	
	}
	