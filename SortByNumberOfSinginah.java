package Sort;

import Model.subjects;

import java.util.Comparator;

public class SortByNumberOfSinginah implements Comparator<subjects> {


    @Override
    public int compare(subjects o1, subjects o2) {
       if (o1.getNumberOfSignal()>o2.getNumberOfSignal()){
           return 1;

       }else if (o1.getNumberOfSignal()<o2.getNumberOfSignal()){
           return -1;
       }else {
           return 0;
       }
    }
}
