package com.example.project2.bdd.runners;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.project2.Project2Application;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes=Project2Application.class)

public class CucumberConfig {

}
