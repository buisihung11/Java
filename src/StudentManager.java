import data.Student;
import database.StudentDB;
import menu.Menu;
import util.GetInput;

import java.util.ArrayList;

public class StudentManager {
    public static Menu menuMain = new Menu("Student Manager");
    public static String[] courseList = new String[]{"Java",".Net","C/C++"};
    //database
    public static StudentDB database1 = new StudentDB();

    public static void createStu(){

        String id,name;
        int semester;
        id = GetInput.getSpecificString("^S[E|A][\\d]{4}$","Input Student ID with [SE|SA]XXXX format", "Please enter valid format");
        if(database1.searchStuByID(id)!=null){
            System.out.println("Sorry that student is in database");
            return;
        }

        name = GetInput.getString("Enter Name: ","Please enter name");
        Student newStu = new Student(id,name);
        database1.addStudent(newStu);
        String cont;
        do{
            int choice;

            semester = GetInput.getPositiveInteger("Semester: ", "Please enter number");
            System.out.println("Availavle courses: ");
            for (int i=0 ; i<courseList.length; i++){
                System.out.printf("%d. %-10s\n",i+1,courseList[i]);
            }

            choice = GetInput.getInteger("Your choice","Enter again",1,courseList.length);
            newStu.getCourseList().put(semester,courseList[choice-1]);

            cont = GetInput.getSpecificString("[Y|y|N|n]","Do you want to add more course (y/n) ","Enter y|n");
        }while (cont.toLowerCase().contains("y"));
        // hoi nguoi dung co them student khong khi database co it hon 10 student
        if(database1.getStuDB().size() <=10){

            cont = GetInput.getSpecificString("[Y|y|N|n]","Do you want to add more student (y/n) ","Enter y|n");
            if(cont.toLowerCase().contains("y"))
                createStu();
        }


    }
    public static void updateMenu() {
        int userChoice;
        String id;

        id = GetInput.getSpecificString("^S[E|A][\\d]{4}$","Input Student ID with [SE|SA]XXXX format", "Please enter valid format");
        Student stu = database1.searchStuByID(id);
        if(stu != null){
            stu.showDetail();
            menuMain.getSubmenu(3).getSubmenu(1).printMenu();
            userChoice = menuMain.getSubmenu(3).getSubmenu(1).getOption();
        }else{
            System.out.println("Sorry that student is not in database");
            return;
        }


        switch (userChoice){
            case 1:
                String newName;
                newName = GetInput.getString("Enter a name: ","Please enter name");
                database1.updateName(id,newName);
                break;
            case 2:
                int semester;
                int choice2;
                stu.showCourse();
                semester = GetInput.getPositiveInteger("Enter semester: ","Please enter number");
                if(stu.getCourseList().containsKey(semester)){
                    System.out.println("Sorry that semester has a course.");
                }else{

                    System.out.println("Availavle courses: ");
                    for (int i=0 ; i<courseList.length; i++){
                        System.out.printf("%d. %-10s\n",i+1,courseList[i]);
                    }
                    choice2 = GetInput.getInteger("Your choice","Enter again",1,courseList.length);

                    stu.getCourseList().put(semester,courseList[choice2-1]);
                }
                break;
            case 3:


                int choice3;
                stu.showCourse();
                choice3 = GetInput.getPositiveInteger("Please enter the semester: ","Please enter number");
                if (stu.getCourseList().containsKey(choice3)){
                    stu.getCourseList().remove(choice3);
                    System.out.println("That courese was deleted");
                }else{
                    System.out.println("Sorry that course doesn't exist");
                }
                break;
            case 4:
                int choice4;
                stu.getCourseList().forEach((k,v)->{
                    System.out.printf("%d - %s\n",k,v);
                });
                choice4 = GetInput.getPositiveInteger("Please enter the semester: ","Please enter number");
                if (stu.getCourseList().containsKey(choice4)){
                    int courseNB;
                    System.out.println("Availavle courses: ");
                    for (int i=0 ; i<courseList.length; i++){
                        System.out.printf("%d. %-10s\n",i+1,courseList[i]);
                    }
                    courseNB = GetInput.getInteger("Your choice","Enter again",1,courseList.length);
                    stu.getCourseList().replace(choice4,courseList[courseNB - 1]);
                }else{
                    System.out.println("Sorry that course doesn't exist");
                }
        }
    }

    public static void deleteMenu(){
        int userChoice;
        String id;

        id = GetInput.getSpecificString("^S[E|A][\\d]{4}$","Input Student ID with [SE|SA]XXXX format", "Please enter valid format");
        Student stu = database1.searchStuByID(id);
        if(stu != null){
            database1.getStuDB().remove(stu.getStuID());
            System.out.println("The course was removed");
        }else{
            System.out.println("Sorry that student is not in database");
            return;
        }
    }

    public static void findInforStudent(){
        int userChoice;
        String id;

        id = GetInput.getSpecificString("^S[E|A][\\d]{4}$","Input Student ID with [SE|SA]XXXX format", "Please enter valid format");
        Student stu = database1.searchStuByID(id);
        if(stu != null){
            System.out.println("ID: " + stu.getStuID());
            System.out.println("Name: " + stu.getStuName());
            stu.showCourse();
        }else{
            System.out.println("Sorry that student is not in database");
            return;
        }
    }
    
    public static void main(String[] args) {

        menuMain.addOption("1. Create");
        menuMain.addOption("2. Find and Sort");
        menuMain.addOption("3. Update/Delete");
        menuMain.addOption("4. Report");
        menuMain.addOption("5. Exit");

        //SubMenu
        menuMain.addSubMenu(3,"Update - delete a student");
        menuMain.addSubMenuOption(3,"1.Update student");
        menuMain.addSubMenuOption(3,"2.Delete student");
        menuMain.addSubMenuOption(3,"3.Back to main menu ");
        //submenu_2
        menuMain.getSubmenu(3).addSubMenu(1,"Update a Student Info");
        menuMain.getSubmenu(3).addSubMenuOption(1,"1.Update Name");
        menuMain.getSubmenu(3).addSubMenuOption(1,"2.Add a new Course");
        menuMain.getSubmenu(3).addSubMenuOption(1,"3.Remove a Course");
        menuMain.getSubmenu(3).addSubMenuOption(1,"4.Update a Course");
        menuMain.getSubmenu(3).addSubMenuOption(1,"5.Go back");

        int userChoice = 0;
        do{
            menuMain.printMenu();
            userChoice = menuMain.getOption();
            switch (userChoice){
                case 1:
                    createStu();
                    break;
                case 2:
                    findInforStudent();
                    break;
                case 3:
                    menuMain.getSubmenu(3).printMenu();
                    userChoice = menuMain.getSubmenu(3).getOption();
                    switch (userChoice){
                        case 1: updateMenu(); break;
                        case 2: deleteMenu(); break;
                    }

                    break;
                case 4:
                    database1.displayDB();
                    break;
                case 5:
                    System.out.println("Goodbye. See you again!");
            }
        }while(userChoice != 5);
    }
}
