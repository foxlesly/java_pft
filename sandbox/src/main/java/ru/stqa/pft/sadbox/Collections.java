package ru.stqa.pft.sadbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#","Python", "PHP"};

    List<String> languages = new ArrayList<>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");

    List<String> lan = Arrays.asList("Java", "C#","Python", "PHP");

    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }

    for (String la : languages) {
      System.out.println("Я хочу выучить " + la);
    }

    for (String l2 : lan) {
      System.out.println("Я хочу выучить " + l2);
    }

    for (int i = 0; i < lan.size(); i++) {
      System.out.println("Я хочу выучить " + lan.get(i));
    }
  }
}
