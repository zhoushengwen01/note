package com.zhou.controller.sys;

import com.zhou.model.sys.PageResult;
import com.zhou.model.sys.RoleEntity;
import com.zhou.service.sys.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {

	private Logger log = LoggerFactory.getLogger(RoleController.class);

	@Resource(name = "roleServiceImpl")
	private RoleService roleService;

	/**
	 * 获取role表数据
	 * 
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/roles")
	public PageResult rolesList(String loginName, int pageSize, int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(roleService.rolesList(pageSize, page * pageSize));
		pageResult.setTotalCount(roleService.rolesSize(pageSize, page * pageSize));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 新建角色信息
	 * 
	 * @param roleEntity
	 * @return
	 */
	@PostMapping("/roles/role")
	public RoleEntity insertRole(@RequestBody RoleEntity roleEntity) {
		roleService.insertRole(roleEntity);
		log.debug("The method is ending");
		return roleEntity;
	}

	/**
	 * 更新角色信息
	 * 
	 * @param roleEntity
	 * @param id
	 * @return
	 */
	@PutMapping("/roles/{id}")
	public RoleEntity updateRole(@RequestBody RoleEntity roleEntity, @PathVariable int id) {
		if (roleEntity.getId() == id) {
			roleService.updateRole(roleEntity);
		}
		log.debug("The method is ending");
		return roleEntity;
	}

	/**
	 * 删除角色信息
	 * 
	 * @param groupId
	 * @return
	 */
	@DeleteMapping("/roles")
	public List<String> deleteRoles(@RequestBody List<String> groupId) {
		roleService.deleteRoles(groupId);
		return groupId;
	}
	
	/**
	 * 得到角色全部数据
	 * @return
	 */
	@GetMapping("/roles/all")
	public List<RoleEntity> allRoles(){
		return roleService.allRoles();
	}
}
