package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.controller.MenuItemController;
import com.cognizant.truyum.model.MenuItem;

@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

    @Override
    public List<MenuItem> getMenuItemListAdmin() {
        LOGGER.info("Start of getMenuItemListAdmin()");
        List<MenuItem> lst = new ArrayList<>();
        try {
            Connection conn = ConnectionHandler.getConnection();
            String sql = "select me_id,me_name,me_price,me_active,me_dol,me_category,me_freedelivery from menu_item";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	long id = rs.getLong("me_id");
				String name = rs.getString("me_name");
				float price = rs.getFloat("me_price");
				String active = rs.getString("me_active");
				Date dateOfLaunch = rs.getDate("me_dol");
				String category = rs.getString("me_category");
				String freeDelivery = rs.getString("me_freedelivery");
				
				boolean a = false;
				boolean d = false;
				if(active.equals("yes")) {
					a=true;
				}
				if(freeDelivery.equals("yes")) {
					d=true;
				}
				
				MenuItem m= new MenuItem(id,name,price,a, dateOfLaunch, category,d);
				lst.add(m);
            }
            stmt.clearParameters();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LOGGER.info("End of getMenuItemListAdmin()");
        return lst;
    }

    @Override
    public List<MenuItem> getMenuItemListCustomer() {
        LOGGER.info("Start of getMenuItemListCustomer()");
        List<MenuItem> lst = new ArrayList<>();
        try {
            Connection conn = ConnectionHandler.getConnection();
            String sql = "select * from menu_item where me_active = TRUE and me_dol < now()";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            stmt.clearParameters();
            while (rs.next()) {
            	long id = rs.getLong("me_id");
				String name = rs.getString("me_name");
				float price = rs.getFloat("me_price");
				String active = rs.getString("me_active");
				Date dateOfLaunch = rs.getDate("me_dol");
				String category = rs.getString("me_category");
				String freeDelivery = rs.getString("me_freedelivery");
				
				boolean a = false;
				boolean d = false;
				if(active.equals("yes")) {
					a=true;
				}
				if(freeDelivery.equals("yes")) {
					d=true;
				}
				
				MenuItem m= new MenuItem(id,name,price,a, dateOfLaunch, category,d);
				lst.add(m);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LOGGER.info("End of getMenuItemListCustomer()");
        return lst;
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem) {
        LOGGER.info("Start of modifyMenuItem()");

        try {
            Connection conn = ConnectionHandler.getConnection();
            String sql = "update menu_item set me_name=?, me_price=?, me_active=?, me_dol=?, me_category=?, me_freedelivery=? where me_id=?";

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.clearParameters();
            stmt.setString(1, menuItem.getName());
            stmt.setFloat(2, menuItem.getPrice());
            stmt.setBoolean(3, menuItem.isActive());
            stmt.setString(4, format.format(menuItem.getDateOfLaunch()));
            stmt.setString(5, menuItem.getCategory());
            stmt.setBoolean(6, menuItem.isFreeDelivery());
            stmt.setLong(7, menuItem.getId());

            stmt.clearParameters();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("Start of modifyMenuItem()");

    }

    @Override
    public MenuItem getMenuItem(long menuItemId) {
        LOGGER.info("Start of getMenuItem()");
        MenuItem menuItem = null;
        try {
            Connection conn = ConnectionHandler.getConnection();
            String sql = "select me_id,me_name,me_price,me_active,me_dol,me_category,me_freedelivery from menu_item where me_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, menuItemId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	long id = rs.getLong("me_id");
				String name = rs.getString("me_name");
				float price = rs.getFloat("me_price");
				String active = rs.getString("me_active");
				Date dateOfLaunch = rs.getDate("me_dol");
				String category = rs.getString("me_category");
				String freeDelivery = rs.getString("me_freedelivery");
				
				boolean a = false;
				boolean d = false;
				if(active.equals("yes")) {
					a=true;
				}
				if(freeDelivery.equals("yes")) {
					d=true;
				}
				
				menuItem= new MenuItem(id,name,price,a, dateOfLaunch, category,d);
            }
            stmt.clearParameters();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        LOGGER.info("Start of getMenuItem()");
        return menuItem;
    }

}
