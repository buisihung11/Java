package menu;
import java.util.HashMap;
import java.util.Map;
import util.GetInput;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> optionList = new ArrayList<String>();
    private String title;
    private Map<Integer,Menu> subMenuList = new HashMap<>();

    public Menu(String title) {
        this.title = title;
    }

    public void addOption(String option){
        optionList.add(option);
    }

    public void addSubMenu(int option,String title){
        subMenuList.put(option,new Menu(title));
    }

    public void addSubMenuOption(int option,String str){
        subMenuList.get(option).addOption(str);
    }

    public Menu getSubmenu(int option){
        return subMenuList.get(option);
    }

    public void printMenu(){
        if(optionList.isEmpty()){
            System.out.println("There is nothing in menu. Please add option.");
            return;
        }
        System.out.println("");
        System.out.println(title);
        for (String option : optionList) {
            System.out.println(option);
        }
    }

    public int getOption(){
        int max = this.optionList.size();
        String inputStr = "Nhap mot so tu " + 1 + " " + max;
        String errorStr = "Please Nhap mot so tu " + 1 + " " + max;
        return GetInput.getInteger(inputStr,errorStr, 1, max);
    }

}
