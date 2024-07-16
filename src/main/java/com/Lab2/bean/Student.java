package com.Lab2.bean;

import jdk.jfr.DataAmount;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String name;
    boolean gender = false;
    Double marks = 0.0;
    Contact contact;
    List<String> subject;
}
