package com.hstn.rest.entity;


import lombok.Data;

@Data
public class Pupil {


  private String firstName;
  private String lastName;

  public Pupil() {
    System.out.println("Pupil Constructor");
  }

  public Pupil(String firstName, String lastName) {
    System.out.println("Pupil Constructor");
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
