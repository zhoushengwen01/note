package com.zhou.service.impl.sys;

import com.zhou.dao.MenuDao;
import com.zhou.dao.RoleDao;
import com.zhou.model.sys.MenuEntity;
import com.zhou.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<MenuEntity> menuList(int id) {
		List<String> idList = roleDao.getModulesById(id);
		
		String idstemp = "";
		for (String idtemp : idList) {
			idstemp = idstemp + idtemp;
		}
		String[] ids = idstemp.split(";");
		List<MenuEntity> parentMenuList = menuDao.getParentMenuListById(ids);
		List<MenuEntity> childrenMenuList = menuDao.getMenuListById(ids);
		List<MenuEntity> menuList = new ArrayList<MenuEntity>();

		for (MenuEntity parentMenu : parentMenuList) {
			List<MenuEntity> menuListTemp = new ArrayList<MenuEntity>();
			for (MenuEntity childrenMenu : childrenMenuList) {
				if (parentMenu.getId() == childrenMenu.getParentId()) {
					menuListTemp.add(childrenMenu);
				}
			}
			parentMenu.setChildren(menuListTemp);
			menuList.add(parentMenu);
		}

		return menuList;
	}

	@Override
	public List<MenuEntity> menusList(int pageSize, int start, String menuId) {
		return menuDao.menusList(pageSize, start, menuId);
	}

	@Override
	public Integer menusSize(int pageSize, int start, String menuId) {
		return menuDao.menusSize(pageSize, start, menuId);
	}

	@Override
	public void insertMenu(MenuEntity menuEntity) {
		menuDao.insertMenu(menuEntity);
	}

	@Override
	public void updateMenu(MenuEntity menuEntity) {
		menuDao.updateMenu(menuEntity);
	}

	@Override
	public void deleteMenus(List<String> groupId) {
		menuDao.deleteMenus(groupId);
	}

	@Override
	public List<MenuEntity> menusByParentId(int parentId) {
		return menuDao.menusByParentId(parentId);
	}

	@Override
	public List<MenuEntity> getSubmenus() {
		return menuDao.getSubmenus();
	}

}
