package com.mall.dao;

import com.mall.config.DBConfig;
import com.mall.entity.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单数据访问对象
 * 负责订单相关的数据库操作
 */
public class OrderDAO {

    /**
     * 添加订单
     */
    public boolean addOrder(Order order) {
        String sql = "INSERT INTO orders(user_id, product_id, quantity, total_price, status, created_time, updated_time) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getProductId());
            stmt.setInt(3, order.getQuantity());
            stmt.setBigDecimal(4, order.getTotalPrice());
            stmt.setInt(5, order.getStatus());
            stmt.setLong(6, System.currentTimeMillis());
            stmt.setLong(7, System.currentTimeMillis());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据订单ID查询订单
     */
    public Order findById(Integer orderId) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapOrder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户ID查询订单
     */
    public List<Order> findByUserId(Integer userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY created_time DESC";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * 获取所有订单
     */
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders ORDER BY created_time DESC";
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(mapOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * 更新订单状态
     */
    public boolean updateStatus(Integer orderId, Integer status) {
        String sql = "UPDATE orders SET status = ?, updated_time = ? WHERE order_id = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, status);
            stmt.setLong(2, System.currentTimeMillis());
            stmt.setInt(3, orderId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将ResultSet映射为Order对象
     */
    private Order mapOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setUserId(rs.getInt("user_id"));
        order.setProductId(rs.getInt("product_id"));
        order.setQuantity(rs.getInt("quantity"));
        order.setTotalPrice(rs.getBigDecimal("total_price"));
        order.setStatus(rs.getInt("status"));
        order.setCreatedTime(rs.getLong("created_time"));
        order.setUpdatedTime(rs.getLong("updated_time"));
        return order;
    }
}
