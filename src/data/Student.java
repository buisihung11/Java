package data;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Student implements Comparable<Student>{
    private String stuID;
    private String stuName;
    //moi mot semester se co mot course
    //dung tree map sort theo semester
    private Map<Integer,String> courseList = new TreeMap<>();
//    private String stuPhone;
//    private String stuAdd;


    public void showDetail(){
        String courseName = "";
        for (String course: courseList.values()) {
            courseName = courseName.concat(course).concat(" ");
        }
//        courseList.forEach((k,v)->{
//
//        });
        System.out.printf("%-10s|%-10s|%-20s|%-15d|\n",stuID,stuName,courseName,courseList.size());
    }

    @Override
    public int compareTo(Student other) {
        return this.getStuName().compareToIgnoreCase(other.getStuName());
    }

    public Student(String stuID, String stuName) {
        this.stuID = stuID;
        this.stuName = stuName;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void showCourse(){
        System.out.println("The courses that were taken: ");
        this.getCourseList().forEach((k,v)->{
            System.out.printf("%d - %s\n",k,v);
        });
    }
    public Map<Integer, String> getCourseList() {
        return courseList;
    }



}
