package dao;

import entity.Course;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void add(Course course) {
        String sql = "insert into course values(null, ?, ?, ?, ?)";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, course.getName());
            ps.setString(2,course.getCount());
            ps.setString(3, course.getWeek());
            ps.setString(4,course.getSection());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                course.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int get(Course course) {
        int id = 0;
        String sql = "select * from course where week = ? and section = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, course.getWeek());
            ps.setString(2, course.getSection());

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public List<Course> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Course> list(int start, int count) {
        List<Course> courses = new ArrayList<>();

        String sql = "select * from course order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString(2));
                course.setCount(rs.getString(3));
                course.setWeek(rs.getString(4));
                course.setSection(rs.getString(5));
                courses.add(course);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return courses;
    }
}
