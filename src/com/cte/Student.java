package com.cte;

//Student class would be the entity to write to a database
public class Student {
    private String name;
    private long SSN;

    private Recordbook recordbook;

 //   public Student() {
 //       this.name = "";
 //       this.SSN = 0;
 //       this.recordbook = new Recordbook(0);
 //   }
    public Student(String name, long SSN, int grade) {
        this.name = name;
        this.SSN = SSN;
        this.recordbook = new Recordbook(grade);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getSSN() {
        return SSN;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }


    public Recordbook getRecordbook() {
        return recordbook;
    }

//    public void setRecordbook(Recordbook recordbook) {
//        this.recordbook = recordbook;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", SSN=" + SSN +
                ", recordbook=" + recordbook +
                '}';
    }
}
