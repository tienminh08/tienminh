package Manage;

import Model.subjects;
import Main.MainStudent;
import OI.WriteReadStudent;
import Model.Student;
import Sort.SortNameStundent;

import java.util.*;

import static java.lang.System.*;

public class ManageStudent {
    static Scanner scanner = new Scanner(in);
    static ArrayList<Student> SaveStudent = (ArrayList<Student>) WriteReadStudent.read();
    static int studentID = -1;
    static ManageStudent manageStudent = new ManageStudent();
    static MainStudent mainStudent = new MainStudent();


    public void register_Student() {
        while (true) {
            System.out.println("Nhap Account name");
            String AccountName = scanner.nextLine();
            if (!checkname_Student(AccountName)) {
                do {
                    System.out.println("Nhap Password");
                    String Password = scanner.nextLine();
                    if (Password.length() > 3 && Password.length() < 9) {
                        System.out.println("Nhap ten sinh vien");
                        String Name = scanner.nextLine();
                        do {
                            try {
                                System.out.println("Nhap tuoi");
                                int age = Integer.parseInt(scanner.nextLine());
                                if (check_age_Student(age)) {
                                    System.out.println("nhap ma sinh vien");
                                    String Idstudent = scanner.nextLine();
                                    System.out.println("Sinh vien lop?");
                                    String ClassStudent = scanner.nextLine();
                                    List<subjects> save1 = new ArrayList<>();
                                    List<Integer> save2 = new ArrayList<>();
                                    int sumtuion=0;
                                    Student student = new Student(AccountName, Password, Name, age, Idstudent, ClassStudent, save1,save2,sumtuion);
                                    SaveStudent.add(student);
                                    WriteReadStudent.write(SaveStudent);
                                    System.out.println("Dang ki thanh cong");
                                    break;
                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println("hay nhap so");

                            }
                        } while (true);
                        break;
                    } else {
                        System.out.println("mat khau phai co do dai >3&&<9");
                    }
                } while (true);
                break;

            } else {
                System.out.println("Tai khoan da ton tai");
            }
            break;
        }


    }


    public boolean checkname_Student(String AccountName) {
        for (int i = 0; i < SaveStudent.size(); i++) {
            if (AccountName.equals(SaveStudent.get(i).getAccountName())) {
                studentID = i;
                return true;
            }
        }
        return false;
    }

    public boolean checkPass_Student(String Password) {
        for (int i = 0; i < SaveStudent.size(); i++) {
            if (Password.equals(SaveStudent.get(i).getPassword())) {
                return true;
            }

        }
        return false;
    }

    public int ckeck_i_studnet(String AccountName) {
        for (int i = 0; i < SaveStudent.size(); i++) {
            if (AccountName.equals(SaveStudent.get(i).getAccountName())) {
                return i;
            }

        }
        return -1;
    }




    public void login_Student() {
        System.out.println("nhap AccountName");
        String AccountName = scanner.nextLine();
        if (checkname_Student(AccountName)) {
            System.out.println("Nhap Password");
            String Password = scanner.nextLine();
            if (checkPass_Student(Password)) {
                System.out.println("Dang nhap thanh cong");
                mainStudent.showMain_Student();
            } else {
                System.out.println("Mat khau khong dung");
            }
        } else {
            System.out.println("Tai Khoan Khong dung");
        }

    }

    public void delete_Student() {
        System.out.println("nhap AccountName muon xoa");
        String AccountName = scanner.nextLine();
        int index = manageStudent.ckeck_i_studnet(AccountName);
        if (index == -1) {
            System.out.println("Tai khoan muon xoa khong ton tai");
        } else {
            System.out.println("Are you sure?");
            System.out.println("[1].sure");
            System.out.println("[2].exit");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    SaveStudent.remove(index);
                    WriteReadStudent.write(SaveStudent);
                    System.out.println("Da xoa thanh cong");
                    break;
                case 2:
                    return;
            }
        }
    }

    public void show_SaveStudent() {
        for (int i = 0; i < SaveStudent.size(); i++) {
            System.out.println(SaveStudent.get(i).toString());

        }
    }

    public boolean check_age_Student(int age1) {
        if (age1 > 0 && age1 < 100) {

            return true;
        } else {
            System.out.println("tuoi phai lon hon 0 && nho hon 100");

            return false;
        }

    }

    public void edit_Student() {

        System.out.println("Nhap Account name");
        String AccountName = scanner.nextLine();

        if (checkname_Student(AccountName) ) {
            do {
                System.out.println("ban muon thay doi thong tin gi?");
                System.out.println("[1].Thay doi ten");
                System.out.println("[2].thay doi tuoi");
                System.out.println("[3].thay doi ma Sinh vien");
                System.out.println("[4].thay doi lop hoc ");
                System.out.println("[5].thoat");
                int Number = Integer.parseInt(scanner.nextLine());
                int index = manageStudent.ckeck_i_studnet(AccountName);
                switch (Number) {
                    case 1:
                        System.out.println("nhap ten muon thay doi?");
                        String newName = scanner.nextLine();
                        System.out.println("are you sure?");
                        System.out.println("[1].sure");
                        System.out.println("[2].exit");
                        Number = Integer.parseInt(scanner.nextLine());
                        switch (Number) {
                            case 1:
                                SaveStudent.get(index).setName(newName);
                                WriteReadStudent.write(SaveStudent);
                                System.out.println("thay doi thanh cong");
                                break;
                            case 2:
                                return;
                        }
                        break;
                    case 2:
                        while (true) {
                            try {
                                System.out.println("nhap tuoi muon thay doi?");
                                int new_age = Integer.parseInt(scanner.nextLine());
                                if (check_age_Student(new_age)) {
                                    System.out.println("are you sure?");
                                    System.out.println("[1].sure");
                                    System.out.println("[2].exit");
                                    Number = Integer.parseInt(scanner.nextLine());
                                    if (Number == 1) {

                                        SaveStudent.get(index).setAge(new_age);
                                        WriteReadStudent.write(SaveStudent);
                                        System.out.println("thay doi thanh cong");
                                        return;
                                    } else if (Number == 2) {
                                        return;
                                    } else {
                                        System.out.println("nhap lai");
                                    }

                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println("hay nhap so");
                            }
                        }

                    case 3:
                        System.out.println("Moi nhap ma Sinh vien muon thay doi");
                        String newIdStudent = scanner.nextLine();
                        System.out.println("are you sure?");
                        System.out.println("[1].sure");
                        System.out.println("[2].exit");
                        Number = Integer.parseInt(scanner.nextLine());
                        switch (Number) {
                            case 1:
                                SaveStudent.get(index).setIdStudent(newIdStudent);
                                WriteReadStudent.write(SaveStudent);
                                System.out.println("thay doi thanh cong");
                                break;
                            case 2:
                                return;
                        }
                        break;
                    case 4:
                        System.out.println("Nhap Lop muon thay doi");
                        String newClassStudent = scanner.nextLine();
                        System.out.println("are you sure?");
                        System.out.println("[1].sure");
                        System.out.println("[2].exit");
                        Number = Integer.parseInt(scanner.nextLine());
                        switch (Number) {
                            case 1:
                                SaveStudent.get(index).setClassStudent(newClassStudent);
                                WriteReadStudent.write(SaveStudent);
                                System.out.println("thay doi thanh cong");
                                break;
                            case 2:
                                return;
                        }
                        break;
                    case 5:
                        return;

                }

            } while (true);
        } else {
            System.out.println("dang nhap khong thanh cong");
        }


    }

    public void find_Studnet() {
        System.out.println("nhap Tai khoan muon tim");
        String AccountName = scanner.nextLine();
        int index = manageStudent.ckeck_i_studnet(AccountName);
        if (index == -1) {
            System.out.println("Tai khoan khong ton tai");
        } else {
            System.out.println(SaveStudent.get(index).toString());

        }
    }


    public void fixPass_Student() {
        System.out.println("nhap Account name");
        String AccountName = scanner.nextLine();
        if (checkname_Student(AccountName)) {
            int index = manageStudent.ckeck_i_studnet(AccountName);
            if (index == -1) {
                System.out.println("Tai khoan khong ton tai");

            } else {
                System.out.println("Nhap Password cu");
                String Password = scanner.nextLine();
                if (checkPass_Student(Password)) {
                    System.out.println("nhap pass moi");
                    String newPassword = scanner.nextLine();
                    SaveStudent.get(index).setPassword(newPassword);
                    WriteReadStudent.write(SaveStudent);
                    System.out.println("doi mat khau thanh cong");
                } else {
                    System.out.println("doi mat khau khong thanh cong");
                }
            }
        } else {
            System.out.println("Tai khoan khong ton tai");
        }
    }

    public void sortName() {
        Collections.sort(SaveStudent, new SortNameStundent());
        show_SaveStudent();
    }


}
