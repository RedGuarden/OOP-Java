package com.example.myormdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneModelRepository extends JpaRepository<Phone, Long> {
}
