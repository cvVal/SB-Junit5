package com.example.junit5.springbootapp.service;

import com.example.junit5.springbootapp.model.BirthdayResponse;
import com.example.junit5.springbootapp.model.StarSignResponse;
import com.example.junit5.springbootapp.model.ZodiacResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayServiceImplTest {

    private BirthdayServiceImpl birthdayService = new BirthdayServiceImpl();

    @Test
    void getValidBirthday() {
    }

    @Test
    void getBirthDOW() {

        BirthdayResponse dow;

        dow = birthdayService.getBirthDOW(LocalDate.of(1979, 7, 14));
        assertEquals("SATURDAY", dow.getDayOfWeek());
        dow = birthdayService.getBirthDOW(LocalDate.of(2018, 1, 23));
        assertEquals("TUESDAY", dow.getDayOfWeek());
        dow = birthdayService.getBirthDOW(LocalDate.of(1972, 3, 17));
        assertEquals("FRIDAY", dow.getDayOfWeek());
        dow = birthdayService.getBirthDOW(LocalDate.of(1945, 12, 2));
        assertEquals("SUNDAY", dow.getDayOfWeek());
        dow = birthdayService.getBirthDOW(LocalDate.of(2003, 8, 4));
        assertEquals("MONDAY", dow.getDayOfWeek());
    }

    @Test
    void getChineseZodiac() {

        ZodiacResponse dow;

        dow = birthdayService.getChineseZodiac(LocalDate.of(1979, 7, 14));
        assertEquals("Sheep", dow.getZodiac());
        dow = birthdayService.getChineseZodiac(LocalDate.of(2018, 1, 23));
        assertEquals("Dog", dow.getZodiac());
        dow = birthdayService.getChineseZodiac(LocalDate.of(1972, 3, 17));
        assertEquals("Rat", dow.getZodiac());
        dow = birthdayService.getChineseZodiac(LocalDate.of(1945, 12, 2));
        assertEquals("Rooster", dow.getZodiac());
        dow = birthdayService.getChineseZodiac(LocalDate.of(2003, 8, 4));
        assertEquals("Sheep", dow.getZodiac());
    }

    @Test
    void getStarSign() {

        StarSignResponse dow;

        dow = birthdayService.getStarSign(LocalDate.of(1979, 7, 14));
        assertEquals("Cancer", dow.getStarSign());
        dow = birthdayService.getStarSign(LocalDate.of(2018, 1, 23));
        assertEquals("Aquarius", dow.getStarSign());
        dow = birthdayService.getStarSign(LocalDate.of(1972, 3, 17));
        assertEquals("Pisces", dow.getStarSign());
        dow = birthdayService.getStarSign(LocalDate.of(1945, 12, 2));
        assertEquals("Sagittarius", dow.getStarSign());
        dow = birthdayService.getStarSign(LocalDate.of(2003, 8, 4));
        assertEquals("Leo", dow.getStarSign());
    }
}