package com.example.junit5.springbootapp.service;

import com.example.junit5.springbootapp.model.BirthdayResponse;
import com.example.junit5.springbootapp.model.StarSignResponse;
import com.example.junit5.springbootapp.model.ZodiacResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BirthdayServiceImpl implements BirthdayService {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate getValidBirthday(String birthdayString) {

        if (birthdayString == null)
            throw new RuntimeException("Must include birthday");

        try {

            return LocalDate.parse(birthdayString, formatter);
        } catch (Exception e) {

            throw new RuntimeException("Must include valid birthday in yyyy-MM-dd format");
        }
    }

    @Override
    public BirthdayResponse getBirthDOW(LocalDate birthday) {

        BirthdayResponse response = new BirthdayResponse();
        response.setDayOfWeek(birthday.getDayOfWeek().toString());

        return response;
    }

    @Override
    public ZodiacResponse getChineseZodiac(LocalDate birthday) {

        ZodiacResponse response = new ZodiacResponse();

        int year = birthday.getYear();
        switch (year % 12) {

            case 0:
                response.setZodiac("Monkey");
                return response;
            case 1:
                response.setZodiac("Rooster");
                return response;
            case 2:
                response.setZodiac("Dog");
                return response;
            case 3:
                response.setZodiac("Pig");
                return response;
            case 4:
                response.setZodiac("Rat");
                return response;
            case 5:
                response.setZodiac("Ox");
                return response;
            case 6:
                response.setZodiac("Tiger");
                return response;
            case 7:
                response.setZodiac("Rabbit");
                return response;
            case 8:
                response.setZodiac("Dragon");
                return response;
            case 9:
                response.setZodiac("Snake");
                return response;
            case 10:
                response.setZodiac("Horse");
                return response;
            case 11:
                response.setZodiac("Sheep");
                return response;

            default: response.setZodiac("");
        }

        return response;
    }

    @Override
    public StarSignResponse getStarSign(LocalDate birthday) {

        StarSignResponse response = new StarSignResponse();

        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();

        if (month == 12 && day >= 22 || month == 1 && day < 20) {

            response.setStarSign("Capricorn");
            return response;
        } else if (month == 1 && day >= 20 || month == 2 && day < 19) {

            response.setStarSign("Aquarius");
            return response;
        } else if (month == 2 && day >= 19 || month == 3 && day < 21) {

            response.setStarSign("Pisces");
            return response;
        } else if (month == 3 && day >= 21 || month == 4 && day < 20) {

            response.setStarSign("Aries");
            return response;
        } else if (month == 4 && day >= 20 || month == 5 && day < 21) {

            response.setStarSign("Taurus");
            return response;
        } else if (month == 5 && day >= 21 || month == 6 && day < 21) {

            response.setStarSign("Geminis");
            return response;
        } else if (month == 6 && day >= 21 || month == 7 && day < 23) {

            response.setStarSign("Cancer");
            return response;
        } else if (month == 7 && day >= 23 || month == 8 && day < 23) {

            response.setStarSign("Leo");
            return response;
        } else if (month == 8 && day >= 23 || month == 9 && day < 23) {

            response.setStarSign("Virgo");
            return response;
        } else if (month == 9 && day >= 23 || month == 10 && day < 23) {

            response.setStarSign("Libra");
            return response;
        } else if (month == 10 && day >= 23 || month == 11 && day < 22) {

            response.setStarSign("Scorpio");
            return response;
        } else if (month == 11 && day >= 22 || month == 12 && day < 22) {

            response.setStarSign("Sagittarius");
            return response;
        }
        return response;
    }
}