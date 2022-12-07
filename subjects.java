package Model;

import Manage.ManageSubjects;

import java.io.Serializable;

public  class subjects  implements Serializable {
    private String NameSubjects;
    private String StartTime;
    private int numberOfSignal;
    private int Tuition;


    public subjects() {
    }

    public subjects(String nameSubjects, String startTime, int numberOfSignal, int tuition) {
        NameSubjects = nameSubjects;
        StartTime = startTime;
        this.numberOfSignal = numberOfSignal;
        Tuition = tuition;
    }

    public String getNameSubjects() {
        return NameSubjects;
    }

    public void setNameSubjects(String nameSubjects) {
        NameSubjects = nameSubjects;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public int getNumberOfSignal() {
        return numberOfSignal;
    }

    public void setNumberOfSignal(int numberOfSignal) {
        this.numberOfSignal = numberOfSignal;
    }

    public int getTuition() {
        return Tuition;
    }

    public void setTuition(int tuition) {
        Tuition = tuition;
    }

    @Override
    public String toString() {
        return "subjects{" +
                "NameSubjects='" + NameSubjects + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", numberOfSignal=" + numberOfSignal +
                ", Tuition=" + Tuition +
                '}';
    }
}
