package org.ljb.mapper.sys;

import java.util.List;

import org.ljb.entity.sys.Menu;

public interface MenuMapper {

	public void addMenuItem(Menu item);
	public List<Menu> getMenuByUser(int userId);
}
