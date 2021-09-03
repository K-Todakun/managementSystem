package database;

public class Point {
    /*private int id;
    private int grade;
    private String season;*/
    private String subject;
    private int point;

    public Point(String subject, int point) {
        this.subject = subject;
        this.point = point;
    }

    public void print(){
        System.out.println(subject + "は" + point + "点");
    }
/*
    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public String getSeason() {
        return season;
    }*/

    public String getSubject() {
        return subject;
    }

    public int getPoint() {
        return point;
    }
}
