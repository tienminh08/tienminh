package Main;

import Manage.ManageStudent;
import Manage.ManageSubjects;

import java.util.Scanner;

public class MainStudent {
    static Scanner scanner = new Scanner(System.in);
    static ManageStudent manageStudent = new ManageStudent();
    static ManageSubjects manageSubjects = new ManageSubjects();

    public void showMain_Student() {
        while (true) {
            System.out.println("---Mennu---");
            System.out.println("[1].Thay doi mat khau");
            System.out.println("   ------------------------  ");
            System.out.println("[2].Dang ki mon hoc ");
            System.out.println("[3].Xoa mon hoc da dang ki ");
            System.out.println("[4].Xem thoi khoa bieu ");
            System.out.println("[5].Xem hoc phi ");
            System.out.println("   ------------------------  ");
            System.out.println("[6].Dang xuat ");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    manageStudent.fixPass_Student();
                    break;
                case 2:
                    manageSubjects.RegisterSubjects();
                    break;
                case 3:

                    manageSubjects.deletesubj();
                    break;
                case 4:
                    manageSubjects.showsave();

                    break;
                case 5:
                    manageSubjects.SumTuition();
                    break;
                case 6:

                    return;

            }


        }
    }
}
