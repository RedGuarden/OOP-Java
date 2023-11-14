package com.example.myormdemo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phones")
@EntityListeners(AuditingEntityListener.class)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "phone_name", nullable = false)
    private String phoneName;

    @Column(name = "os", nullable = false)
    private String os;

    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private List<Phone_model> phoneModelList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public List<Phone_model> getPhoneModelList() {
        return phoneModelList;
    }

    public void setPhoneModelList(List<Phone_model> phoneModelList) {
        this.phoneModelList = phoneModelList;
    }
}