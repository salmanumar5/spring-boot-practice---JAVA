package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("in Constructor: " + getClass().getSimpleName());
    }

    //define out init method
    @PostConstruct
    public void doMyStuff(){
        System.out.println("In doMyStuff(): " + getClass().getSimpleName());
    }

    // defin out destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins";
    }
}
