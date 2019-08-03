package com.example.junit5.springbootapp.service;

import com.example.junit5.springbootapp.model.BirthdayResponse;
import com.example.junit5.springbootapp.model.StarSignResponse;
import com.example.junit5.springbootapp.model.ZodiacResponse;

import java.time.LocalDate;

public interface BirthdayService {

    LocalDate getValidBirthday(String birthdayString);
    BirthdayResponse getBirthDOW(LocalDate birthday);
    ZodiacResponse getChineseZodiac(LocalDate birthday);
    StarSignResponse getStarSign(LocalDate birthday);
}
