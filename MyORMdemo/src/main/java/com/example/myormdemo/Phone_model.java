package com.example.myormdemo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Phone_model")
@EntityListeners(AuditingEntityListener.class)
public class Phone_model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Create_company", nullable = false)
    private String createCompany;

    @ManyToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateCompany() {
        return createCompany;
    }

    public void setCreateCompany(String createCompany) {
        this.createCompany = createCompany;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}