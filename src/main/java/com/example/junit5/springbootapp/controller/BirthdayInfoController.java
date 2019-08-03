package com.example.junit5.springbootapp.controller;

import com.example.junit5.springbootapp.model.BirthdayRequest;
import com.example.junit5.springbootapp.model.BirthdayResponse;
import com.example.junit5.springbootapp.model.StarSignResponse;
import com.example.junit5.springbootapp.model.ZodiacResponse;
import com.example.junit5.springbootapp.service.BirthdayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/birthday", produces = MediaType.APPLICATION_JSON_VALUE)
public class BirthdayInfoController {

    private final BirthdayService birthdayService;

    public BirthdayInfoController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @PostMapping("/dayOfWeek")
    public BirthdayResponse getDayOfWeek(@RequestBody BirthdayRequest birthdayString) {

        LocalDate birthday = birthdayService.getValidBirthday(birthdayString.getBirthday());

        return birthdayService.getBirthDOW(birthday);
    }

    @PostMapping("/chineseZodiac")
    public ZodiacResponse getChineseZodiac(@RequestBody BirthdayRequest birthdayString) {

        LocalDate birthday = birthdayService.getValidBirthday(birthdayString.getBirthday());

        return birthdayService.getChineseZodiac(birthday);
    }

    @PostMapping("/starSign")
    public StarSignResponse getStarSign(@RequestBody BirthdayRequest birthdayString) {

        LocalDate birthday = birthdayService.getValidBirthday(birthdayString.getBirthday());

        return birthdayService.getStarSign(birthday);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {

        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
