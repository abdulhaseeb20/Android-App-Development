package com.example.firebaseassignment;

public class StudentRecords {
    String Name, Dept, Reg_no, Cgpa, Email;

    public StudentRecords(String name, String dept, String reg_no, String cgpa, String email) {
        Name = name;
        Dept = dept;
        Reg_no = reg_no;
        Cgpa = cgpa;
        Email = email;
    }

    public StudentRecords() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public String getReg_no() {
        return Reg_no;
    }

    public void setReg_no(String reg_no) {
        Reg_no = reg_no;
    }

    public String getCgpa() {
        return Cgpa;
    }

    public void setCgpa(String cgpa) {
        Cgpa = cgpa;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
