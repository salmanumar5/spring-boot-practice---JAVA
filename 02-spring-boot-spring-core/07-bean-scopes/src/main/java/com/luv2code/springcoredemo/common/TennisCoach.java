package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("in Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do you Tennis practice with tennis ball";
    }
}
