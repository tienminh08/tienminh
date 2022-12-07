package Manage;

import Model.Admin;
import Main.Mainadmin;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageAdmin {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Admin> SaveAcount = new ArrayList<>();
    static Mainadmin mainadmin = new Mainadmin();


    public void Create_Admin() {
        String AccountName = "admin";
        String Password = "123";
        Admin admin = new Admin(AccountName, Password);
        SaveAcount.add(admin);

    }

    public boolean checkName(String AccountName) {
        for (int i = 0; i < SaveAcount.size(); i++) {
            if (AccountName.equals(SaveAcount.get(i).getAccountName())) {
                return true;
            }

        }
        return false;

    }

    public boolean checkpass(String Password) {
        for (int i = 0; i < SaveAcount.size(); i++) {
            if (Password.equals(SaveAcount.get(i).getPassword())) {
                return true;
            }

        }
        return false;

    }


    public void loginAdmin() {
        System.out.println("nhap AccountName");
        String AccountName = scanner.nextLine();
        if (checkName(AccountName)) {
            System.out.println("Nhap Password");
            String Password = scanner.nextLine();
            if (checkpass(Password)) {
                System.out.println("Dang nhap thanh cong");
                mainadmin.showMain_Admin();
            } else {
                System.out.println("Mat khau khong dung");
            }
        } else {
            System.out.println("Tai Khoan Khong dung");
        }

    }


}
