package com.sound.kiosk.menu;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MenuMapper {
	ArrayList<MenuDTO> getTotalMenus();

}