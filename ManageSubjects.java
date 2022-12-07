package Manage;

import OI.WriteReadStudent;
import OI.WriteReadSubjects;
import Model.subjects;
import Sort.SortByNumberOfSinginah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageSubjects {

    static Scanner scanner = new Scanner(System.in);
    static ManageSubjects manageSubjects = new ManageSubjects();
    static ArrayList<subjects> SaveSubjects = (ArrayList<subjects>) WriteReadSubjects.read();


    public void create_subjects() {

        System.out.println("nhap mon hoc");
        String NameSubjects = scanner.nextLine();
        System.out.println("nhap thoi gian bat dau");
        String StartTime = scanner.nextLine();
        System.out.println(" nhap so tin chi");
        int numberOfSignal = Integer.parseInt(scanner.nextLine());
        int tuition = numberOfSignal * 370;
        subjects subjects = new subjects(NameSubjects, StartTime, numberOfSignal, tuition);
        SaveSubjects.add(subjects);
        WriteReadSubjects.write(SaveSubjects);
    }

    public void show() {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            System.out.println(SaveSubjects.get(i).toString());

        }
    }

    public int chekibyIndex(int index) {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            if ((index - 1) == i) {
                return i;
            }

        }
        return -1;

    }

    public void RegisterSubjects() {
        show();
        System.out.println("chon mon hoc muon dang ki");
        int index = Integer.parseInt(scanner.nextLine());
        if (index == -1) {
            System.out.println("mon hoc khong ton tai");
        } else {
            if (!cheknamebysave(index)) {
                int indexbyi = chekibyIndex(index);
                SaveSubjects.get(indexbyi);

                ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().add(SaveSubjects.get(indexbyi));
                WriteReadStudent.write(ManageStudent.SaveStudent);

                System.out.println("thanh cong");
            } else {
                System.out.println("mon hoc nay ban da dang ki");
            }
        }
    }


    public void showsave() {
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().size(); i++) {
            System.out.println(ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().get(i).toString());
        }
    }


    public int check_i_NameSub(String newNameSubjects) {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            if (newNameSubjects.equals(SaveSubjects.get(i).getNameSubjects())) {
                return i;
            }

        }
        return -1;

    }

    public int check_i_Time(String newStartTime) {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            if (newStartTime.equals(SaveSubjects.get(i).getStartTime())) {
                return i;
            }

        }
        return -1;

    }


    public void edit_subjects() {
        System.out.println(" nhap ten mon hoc muon sua");
        String nameSubjects = scanner.nextLine();
        if (check_i_NameSub(nameSubjects) == -1) {
            System.out.println("mon hoc muon sua khong ton tai ");
        } else {
            int index = check_i_NameSub(nameSubjects);
            System.out.println("ban muon sua gi?");
            System.out.println("[1].Sua ten mon Hoc");
            System.out.println("[2].Sua thoi gian bat dau");
            System.out.println("[3].Sua so tin chi");
            System.out.println("[4].thoat ");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    System.out.println("nhap ten muon thay doi");
                    String newNameSubjects = scanner.nextLine();
                    System.out.println("are you sure?");
                    System.out.println("[1].sure");
                    System.out.println("[2].exit");
                    Number = Integer.parseInt(scanner.nextLine());
                    switch (Number) {
                        case 1:
                            SaveSubjects.get(index).setNameSubjects(newNameSubjects);
                            WriteReadSubjects.write(SaveSubjects);
                            System.out.println("thanh cong");
                            break;
                        case 2:
                            return;
                    }
                    break;
                case 2:
                    System.out.println("nhap thoi gian muon thay doi");
                    String newStarttime = scanner.nextLine();
                    System.out.println("are you sure?");
                    System.out.println("[1].sure");
                    System.out.println("[2].exit");
                    Number = Integer.parseInt(scanner.nextLine());
                    switch (Number) {
                        case 1:
                            SaveSubjects.get(index).setStartTime(newStarttime);
                            WriteReadSubjects.write(SaveSubjects);
                            System.out.println("thanh cong");
                            break;
                        case 2:
                            return;
                    }
                    break;
                case 3:
                    System.out.println("nhap so tin chi muon thay doi?");
                    int newNumberOfSignal = Integer.parseInt(scanner.nextLine());
                    System.out.println("are you sure?");
                    System.out.println("[1].sure");
                    System.out.println("[2].exit");
                    Number = Integer.parseInt(scanner.nextLine());
                    switch (Number) {
                        case 1:
                            SaveSubjects.get(index).setNumberOfSignal(newNumberOfSignal);
                            WriteReadSubjects.write(SaveSubjects);
                            System.out.println("thanh cong");
                            break;
                        case 2:
                            return;
                    }
                    break;
                case 4:
                    return;

            }

        }

    }

    public void delete() {
        System.out.println(" nhap mon hoc ban muon xoa");
        String NameSubjects = scanner.nextLine();
        int index = manageSubjects.check_i_NameSub(NameSubjects);
        if (index == -1) {
            System.out.println("mon hoc khong ton tai");

        } else {
            System.out.println("are you sure?");
            System.out.println("[1].sure");
            System.out.println("[2].exit");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    SaveSubjects.remove(index);
                    WriteReadSubjects.write(SaveSubjects);
                    System.out.println("Da xoa thanh cong");
                    break;
                case 2:
                    return;

            }
        }

    }


    public void SortbyNumber() {
        Collections.sort(SaveSubjects, new SortByNumberOfSinginah());
        for (int i = 0; i < SaveSubjects.size(); i++) {
            System.out.println(SaveSubjects.get(i).toString());
        }
    }

    public int chekishowmang(int index) {
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).save.size(); i++) {
            if ((index - 1) == i) {
                return i;
            }

        }
        return -1;
    }

    public void deletesubj() {
        showsave();
        System.out.println("Chon mon hoc muon xoa");
        int index = Integer.parseInt(scanner.nextLine());
        int idexbyi = chekishowmang(index);
        if (idexbyi == -1) {
            System.out.println("mon hoc khong ton tai");
        } else {
            System.out.println("are you sure?");
            System.out.println("[1].sure");
            System.out.println("[2].exit");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    ManageStudent.SaveStudent.get(ManageStudent.studentID).save.remove(idexbyi);
                    WriteReadStudent.write(ManageStudent.SaveStudent);
                    System.out.println("Da xoa thanh cong");
                    break;
                case 2:
                    return;

            }

        }
    }


    public boolean cheknamebysave(int index) {
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().size(); i++) {
            if (SaveSubjects.get((index - 1)).getNameSubjects().equals(ManageStudent.SaveStudent
                    .get(ManageStudent.studentID).getSave().get(i).getNameSubjects())) {
                return true;
            }


        }
        return false;
    }


//
//    public void Sumtuition() {
//        int sum = 0;
//        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).save1.size(); i++) {
//            sum += ManageStudent.SaveStudent.get(ManageStudent.studentID).save1.get(i);
//
//            System.out.println(sum);
//
//
//        }
//        ManageStudent.SaveStudent.get(ManageStudent.studentID).save1.clear();
//
//
//
//    }

    public void SumTuition() {
        int sum = 0;
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).save.size(); i++) {
            sum += ManageStudent.SaveStudent.get(ManageStudent.studentID).save.get(i).getTuition();

            ManageStudent.SaveStudent.get(ManageStudent.studentID).setSumtuition(sum);

        }
        System.out.println("sinh vien" + '\'' + ManageStudent.SaveStudent.get(ManageStudent.studentID).getName()
                + '\'' + "co hoc phi la" + '\'' + ManageStudent.SaveStudent.get(ManageStudent.studentID).getSumtuition() + '\'' + "VND");


    }


}
