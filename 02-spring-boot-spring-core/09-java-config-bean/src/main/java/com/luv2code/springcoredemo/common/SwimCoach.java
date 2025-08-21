package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In contructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim a 100m for warmup";
    }
}
