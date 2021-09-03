import database.Point;
import database.PointDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectPoint {
    public static void main(String[] args) {
        System.out.println("生徒IDを入力");
        Scanner scan = new Scanner(System.in);
        int id = Integer.valueOf(scan.nextLine());
        System.out.println("学年を入力");
        int grade = Integer.valueOf(scan.nextLine());
        System.out.println("時期を入力");
        String season = scan.nextLine();

        try {
            PointDAO dao = new PointDAO();
            List<Point> points = dao.selectPreExams(id,grade,season);
            for (Point point : points){
                point.print();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
