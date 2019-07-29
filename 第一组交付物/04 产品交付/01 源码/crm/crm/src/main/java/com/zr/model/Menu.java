package com.zr.model;
/**
 * 菜单的数据模型
 * @author wwj
 *
 */
public class Menu {

	private int id;
	private String text;
	private String menuPath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	
	
}
