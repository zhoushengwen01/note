package com.zhou.service.impl.sys;

import com.zhou.dao.RoleDao;
import com.zhou.model.sys.RoleEntity;
import com.zhou.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<RoleEntity> rolesList(int pageSize, int start) {
		return roleDao.rolesList(pageSize, start);
	}

	@Override
	public Integer rolesSize(int pageSize, int start) {
		return roleDao.rolesSize(pageSize, start);
	}

	@Override
	public void insertRole(RoleEntity roleEntity) {
		roleDao.insertRole(roleEntity);
	}

	@Override
	public void updateRole(RoleEntity roleEntity) {
		roleDao.updateRole(roleEntity);
	}

	@Override
	public void deleteRoles(List<String> groupId) {
		roleDao.deleteRoles(groupId);
	}

	@Override
	public List<RoleEntity> allRoles() {
		return roleDao.allRoles();
	}

}
