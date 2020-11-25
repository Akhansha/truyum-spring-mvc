package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.controller.CartController;

@Component
public class CartDaoSqlImpl implements CartDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("Start of addCartItem()");
		try {
			Connection conn = ConnectionHandler.getConnection();
			String sql= "insert into cart(ct_user_id,ct_menu_id) values(?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.execute();
			stmt.clearParameters();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("End of addCartItem()");
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		// TODO Auto-generated method stub
		LOGGER.info("Start of getAllCartItems()");
		List<MenuItem> lst= new ArrayList<MenuItem>();
		Cart C = new Cart(lst,0);
		double value = 0;
		try {
			Connection conn = ConnectionHandler.getConnection();
			String sql = "select m.me_id,m.me_name,m.me_price,m.me_active,m.me_dol,m.me_category,m.me_freedelivery from menu_item m Join cart c On m.me_id=c.ct_menu_id where c.ct_user_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			stmt.clearParameters();
			int count = 0;
			while(rs.next()) {
				count += 1;
				long id = rs.getLong("me_id");
				String name = rs.getString("me_name");
				float price = rs.getFloat("me_price");
				value = value+price;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		C.setMenuItemList(lst);
        C.setTotal(value);
        LOGGER.info("End of getAllCartItems()");		
		return lst;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("Start of removeCartItem()");
		try {
			Connection conn = ConnectionHandler.getConnection();
			String sql = "delete from cart where ct_user_id=? and ct_menu_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
			stmt.clearParameters();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("End of removeCartItem()");
	}

	
}
