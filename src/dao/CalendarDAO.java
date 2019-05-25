package dao;

import entity.Calendar;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CalendarDAO {
    public void add(Calendar calendar) {
        String sql = "insert into calendar values(null, ?,?,?,?,?,?,?,?,?)";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, calendar.getSection());
            ps.setString(2, calendar.getMonday());
            ps.setString(3,calendar.getTuesday());
            ps.setString(4, calendar.getWednesday());
            ps.setString(5, calendar.getThursday());
            ps.setString(6, calendar.getFriday());
            ps.setString(7, calendar.getSaturday());
            ps.setString(8, calendar.getSunday());
            ps.setString(9, calendar.getWeek());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                calendar.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将课程添加到日程表
     * @param calendar 日程表对象
     * @param week 更新哪一周
     * @param name 日程内容
     */
    public void update(Calendar calendar, String week, String name) {
        String sql = "update calendar set " + week + "= '" + name +"' where section = ? and week = ? ";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, calendar.getMonday());

            ps.setString(1, calendar.getSection());
            ps.setString(2, calendar.getWeek());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将输入的安排添加到课程表
     */
    public void update(Calendar calendar, String week) {

    }

    /**
     * 返回一周的日程表
     * @return
     */
    public List<Calendar> listByWeek(String week) {
        List<Calendar> calendars = new ArrayList<>();
        String sql = "select * from calendar where week = ?";
        try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, week);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Calendar calendar = new Calendar();
                calendar.setId(rs.getInt(1));
                calendar.setSection(rs.getString(2));
                calendar.setMonday(rs.getString(3));
                calendar.setTuesday(rs.getString(4));
                calendar.setWednesday(rs.getString(5));
                calendar.setThursday(rs.getString(6));
                calendar.setFriday(rs.getString(7));
                calendar.setSaturday(rs.getString(8));
                calendar.setSunday(rs.getString(9));
                calendar.setWeek(week);
                calendars.add(calendar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calendars;
    }



}
