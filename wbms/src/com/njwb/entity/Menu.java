package com.njwb.entity;

import java.util.List;

 
public class Menu {
	Integer menuId;
	String menuName;
	String menuHrefUrl;
	List<Menu> sonMenu;
	Integer parentId;
	 
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuHrefUrl() {
		return menuHrefUrl;
	}

	public void setMenuHrefUrl(String menuHrefUrl) {
		this.menuHrefUrl = menuHrefUrl;
	}

	public List<Menu> getSonMenu() {
		return sonMenu;
	}

	public void setSonMenu(List<Menu> sonMenu) {
		this.sonMenu = sonMenu;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Menu [menuHrefUrl=" + menuHrefUrl + ", menuId=" + menuId
				+ ", menuName=" + menuName + ", parentId=" + parentId
				+ ", sonMenu=" + sonMenu + "]";
	} 
	 
}
