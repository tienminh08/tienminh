package Main;

import Manage.ManageAdmin;
import Manage.ManageStudent;

import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManageAdmin manage_acount = new ManageAdmin();

    static ManageStudent manage_student1 = new ManageStudent();


    public static void main(String[] args) {

        while (true) {
           try {
               System.out.println("---Mennu---");
               System.out.println("[1].Dang nhap Admin");
               System.out.println("[2].Dang nhap Student ");
               System.out.println("[3].Thoat");
               int Number = Integer.parseInt(scanner.nextLine());
               switch (Number) {
                   case 1:
                       manage_acount.Create_Admin();
                       manage_acount.loginAdmin();
                       break;
                   case 2:
                       manage_student1.login_Student();
                       break;
                   case 3:
                       System.exit(4);
                       break;



               }
           }catch (NumberFormatException e){


           }
        }
    }
}
