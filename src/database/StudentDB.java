package database;

import data.Student;

import java.util.Map;
import java.util.TreeMap;

public class StudentDB {
    public static int count = 0;
    //stuID -> student
    private Map<String, Student> stuDB = new TreeMap<>();
    //private String usrName;
    //private String password;

    //add Student
    public void addStudent(Student stu){
        if(searchStuByID(stu.getStuID())!=null){
            System.out.println("Sorry that student is in DB");
            return;
        }
        stuDB.put(stu.getStuID(),stu);
        System.out.println("Student was added!");
        count++;
    }

    public void displayDB(){
        if(stuDB.isEmpty()){
            System.out.println("There is no student in database");
            return;
        }
        System.out.printf("%-10s|%-10s|%-20s|%-15s|\n","ID","Name","Course","TotalCourse");
        stuDB.forEach((k,v)->{
            v.showDetail();
        });
    }
    //change the course data of student
    //delete course
    public void updateCourse(String stuID, int semester){
        stuDB.get(stuID).getCourseList().remove(semester);
    }
    //add new course
    public void updateCourse(String stuID, int semester,String courseName){
        stuDB.get(stuID).getCourseList().put(semester,courseName);
    }
    //update a course
    public void updateCourse(String stuID, int oldSemester,int newSemester,String courseName){
        stuDB.get(stuID).getCourseList().remove(oldSemester);
        stuDB.get(stuID).getCourseList().put(newSemester,courseName);
    }

    public void updateName(String stuID, String newName){
        stuDB.get(stuID).setStuName(newName);
    }
    public Student searchStuByID(String id){
        Student stu = null;
        if (stuDB.containsKey(id)){
            stu = stuDB.get(id);
        }
        return stu;
    }

    public Map<String, Student> getStuDB() {
        return stuDB;
    }
}
