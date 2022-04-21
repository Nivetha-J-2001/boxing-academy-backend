package com.examly.springapp.model.ModelStudentTableView;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "StudentTableView")
@JsonIgnoreProperties(value = { "viewId" }, ignoreUnknown = true)
public class StudentTableView {

    @Id
    @Column(name = "view_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long viewId;

    public long getViewId() {
        return viewId;
    }

    public void setViewId(long viewId) {
        this.viewId = viewId;
    }

    @Column
    private long userId;

    @Column
    private long courseId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String enrolledCourseName;

    @Column
    private String mobileNumber;

    public StudentTableView() {

    }

    public StudentTableView(long userId, long courseId, String firstName, String lastName, String enrolledCourseName,
            String mobileNumber) {
        this.userId = userId;
        this.courseId = courseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolledCourseName = enrolledCourseName;
        this.mobileNumber = mobileNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnrolledCourseName() {
        return enrolledCourseName;
    }

    public void setEnrolledCourseName(String enrolledCourseName) {
        this.enrolledCourseName = enrolledCourseName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return userId + "\t" + enrolledCourseName;
    }

}
