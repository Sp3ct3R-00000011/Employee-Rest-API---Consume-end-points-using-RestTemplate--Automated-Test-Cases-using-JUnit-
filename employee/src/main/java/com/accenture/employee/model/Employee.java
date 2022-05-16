package com.accenture.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    private String empID;
    private String name;
    private String designation;
    private int career_lvl;
    private long salary;
    private String primary_skill;
    private String project_assigned;

    private String skill_proficiency;

    private String location;


    public Employee() {

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrimary_skill() {
        return primary_skill;
    }

    public void setPrimary_skill(String primary_skill) {
        this.primary_skill = primary_skill;
    }

    public String getProject_assigned() {
        return project_assigned;
    }

    public void setProject_assigned(String project_assigned) {
        this.project_assigned = project_assigned;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill_proficiency() {
        return skill_proficiency;
    }

    public void setSkill_proficiency(String skill_proficiency) {
        this.skill_proficiency = skill_proficiency;
    }

    public long getSalary() {
        return salary;
    }


    public String getEmpID() {
        return empID;
    }

    public String getDesignation() {
        return designation;
    }

    public int getCareer_lvl() {
        return career_lvl;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setCareer_lvl(int career_lvl) {
        this.career_lvl = career_lvl;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(String empID, String name, String designation, int career_lvl, long salary, String primary_skill, String project_assigned, String skill_proficiency, String location) {
        this.empID = empID;
        this.name = name;
        this.designation = designation;
        this.career_lvl = career_lvl;
        this.salary = salary;
        this.primary_skill = primary_skill;
        this.project_assigned = project_assigned;
        this.skill_proficiency = skill_proficiency;
        this.location = location;
    }
}
