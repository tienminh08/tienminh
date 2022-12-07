package Main;

import Manage.ManageStudent;
import Manage.ManageSubjects;

import java.util.Scanner;

public class Mainadmin {
    static Scanner scanner = new Scanner(System.in);
    static ManageStudent manage_student = new ManageStudent();
    static ManageSubjects manage_subjects= new ManageSubjects();

    public void showMain_Admin() {
        while (true) {

            System.out.println("      ----Mennu---- ");
            System.out.println("[1].Them Tai khoan Student");
            System.out.println("[2].Sua thong tin Student");
            System.out.println("[3].Tim tai khoan Student ");
            System.out.println("[4].Hien thi cac tai khoan Student");
            System.out.println("[5].Xap xep tai khoan");
            System.out.println("[6].Xoa tai khoan");
            System.out.println("   ------------------------  ");
            System.out.println("[7].them mon hoc");
            System.out.println("[8].sua mon hoc");
            System.out.println("[9].xoa mon hoc");
            System.out.println("[10].sap xep mon hoc");
            System.out.println("[11].dang xuat");

            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {

                case 1:
                    manage_student.register_Student();
                    break;
                case 2:
                    manage_student.edit_Student();
                    break;
                case 3:
                    manage_student.find_Studnet();
                    break;
                case 4:
                    manage_student.show_SaveStudent();
                    break;
                case 5:
                    manage_student.sortName();
                    break;
                case 6:
                    manage_student.delete_Student();
                    break;
                case 7:
                    manage_subjects.create_subjects();
                    break;
                case 8:
                    manage_subjects.edit_subjects();
                    break;
                case 9:
                    manage_subjects.delete();
                    break;
                case 10:
                    manage_subjects.SortbyNumber();
                    break;
                case 11:
                    return;

            }
        }


    }
}
