package OI;

import Model.subjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteReadSubjects {
    static String url = "Subjects2.txt";

    public static void write(List<subjects> SaveSubjects) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(SaveSubjects);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("loi");
        }


    }

    public static List<subjects> read() {

        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<subjects>) objectInputStream.readObject();

        } catch (Exception e) {
            System.out.println("loi");
            return new ArrayList<>();
        }
    }
}
