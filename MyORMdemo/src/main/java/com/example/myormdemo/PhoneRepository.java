package com.example.myormdemo;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}