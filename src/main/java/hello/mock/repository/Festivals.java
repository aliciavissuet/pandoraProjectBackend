package hello.mock.repository;

import hello.models.Festival;

import java.util.ArrayList;

public class Festivals {
    private  ArrayList<Festival> festivals;

    public Festivals() {
        this.festivals=new ArrayList<>();
    }

    public ArrayList<Festival> getFestivals() {
        return festivals;
    }


}


