package com.cognizant.truyum.dao;

import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImplTest {

    private static MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();

    public static void main(String[] args) {

        System.out.println("For admin");
        testGetMenuItemListAdmin();
        System.out.println("For Customer");
        testGetMenuItemListCustomer();
        System.out.println("Modified");
        testModifyMenuItem();
        testGetMenuItemListAdmin();
        System.out.println("Get Menu Item");
        testGetMenuItem();
    }

    public static void testGetMenuItemListAdmin() {
    	MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItems = menuItemDao.getMenuItemListAdmin();
		for(MenuItem m:menuItems) {
			System.out.println(m.toString());
		}
    }

    public static void testGetMenuItemListCustomer() {
    	MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItems = menuItemDao.getMenuItemListCustomer();
		for(MenuItem m:menuItems) {
			System.out.println(m.toString());
		}
    }

    public static void testModifyMenuItem() {
        MenuItem menuItem = new MenuItem(1, "Sandwich", 90.0f, true, new Date(), "Main Course", true);
        menuItemDao.modifyMenuItem(menuItem);
    }

    public static void testGetMenuItem() {
        MenuItem menuItem = menuItemDao.getMenuItem(2);
        if (menuItem == null) {
            System.out.println("No item");
            return;
        }
        System.out.println(menuItem);
    }
}

