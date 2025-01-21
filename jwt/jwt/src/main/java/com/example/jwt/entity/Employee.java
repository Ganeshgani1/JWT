package com.example.jwt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empID;
    @Nonnull
    private String empName;
    private String pwd;
    @Nonnull
    private Integer age;
    @Nonnull
    private String email;
    private String role;
    private boolean recordDeleted=false;

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    @Nonnull
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(@Nonnull String empName) {
        this.empName = empName;
    }

    @Nonnull
    public Integer getAge() {
        return age;
    }

    public void setAge(@Nonnull Integer age) {
        this.age = age;
    }

    @Nonnull
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    public boolean isRecordDeleted() {
        return recordDeleted;
    }

    public void setRecordDeleted(boolean recordDeleted) {
        this.recordDeleted = recordDeleted;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}