package model;

public class Teacher {

    private String teacherID;
    private String name;
    private String dob;
    private String tel;

    public Teacher(String teacherID, String name, String dob, String tel) {
        this.teacherID = teacherID;
        this.name = name;
        this.dob = dob;
        this.tel = tel;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
