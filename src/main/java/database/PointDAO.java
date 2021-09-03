package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PointDAO {
    private static final String URL = "jdbc:h2:~/h2db/dbe;AUTO_SERVER=TRUE;MODE=PostgreSQL";
    private static final String USER_NAME = "b2191560";
    private static final String USER_PASS = "b2191560";

    public int insertGrade(int id,int grade,String season,String subject,int point) throws SQLException{
        String sql = "insert into 得点表 values (?, ?, ?, ?, ?)";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setInt(1,id);
        stmt.setInt(2,grade);
        stmt.setString(3,season);
        stmt.setString(4,subject);
        stmt.setInt(5,point);
        n = stmt.executeUpdate();
        }
        return n;
    }

    public int deletePreExam(int id,int grade,String season,String subject) throws SQLException {
        String sql = "delete from 得点表 where 生徒ID = ? and 学年 = ? and 時期 = ? and 科目 = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2,grade);
            stmt.setString(3,season);
            stmt.setString(4,subject);
            n = stmt.executeUpdate();
        }
        return n;
    }

    public int updateGrade(int id,int grade,String season,String subject,int point) throws SQLException{
        String sql = "update 得点表 set 点数 = ? where 生徒ID = ? and 学年 = ? and 時期 = ? and 科目 = ?";
        int n = 0;
        try (Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,point);
            stmt.setInt(2, id);
            stmt.setInt(3,grade);
            stmt.setString(4,season);
            stmt.setString(5,subject);
            n = stmt.executeUpdate();
        }
        return n;
    }
    public List<Point> selectPreExams(int id,int grade,String season) throws SQLException{
        List<Point> returning = new ArrayList<Point>();
        String sql = "select 科目,点数 from 得点表 where 生徒ID = ? and 学年 = ? and 時期 = ?";

        try(Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.setInt(2,grade);
            stmt.setString(3,season);
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                String col1 = results.getString("科目");
                int col2 = results.getInt("点数");
                Point point = new Point(col1, col2);
                returning.add(point);
            }
        }
        return returning;
    }

}
