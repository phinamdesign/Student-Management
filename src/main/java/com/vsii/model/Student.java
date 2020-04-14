package com.vsii.model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long age;

    @ManyToOne
    @JoinColumn(name = "sexId")
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "schoolId")
    private School school;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "classRId")
    private ClassR classR;

    @ManyToOne
    @JoinColumn(name = "rankerId")
    private Ranker ranker;

    @ManyToOne
    @JoinColumn(name = "conductId")
    private Conduct conduct;

    public Student() {
    }

    public Student(String name, Long age, Sex sex, Address address, School school, Department department, ClassR classR, Ranker ranker, Conduct conduct) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.school = school;
        this.department = department;
        this.classR = classR;
        this.ranker = ranker;
        this.conduct = conduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ClassR getClassR() {
        return classR;
    }

    public void setClassR(ClassR classR) {
        this.classR = classR;
    }

    public Ranker getRanker() {
        return ranker;
    }

    public void setRanker(Ranker ranker) {
        this.ranker = ranker;
    }

    public Conduct getConduct() {
        return conduct;
    }

    public void setConduct(Conduct conduct) {
        this.conduct = conduct;
    }
}
