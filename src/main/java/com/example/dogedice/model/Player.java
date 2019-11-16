package com.example.dogedice.model;

import javafx.collections.ModifiableObservableListBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Comparable<Player> {
  private String name;
  private int score;
  private List<Die> dice;
  private List<Modifier> modifiers;
  private Image image;

  public Player(String name) {
    this.name = name;
    this.score = 0;
    this.image = image;
    this.dice = new ArrayList<>();
    this.modifiers = new ArrayList<>();
  }

  public abstract boolean isBot();

  public void addDie(Die die) {
    this.dice.add(die);
  }

  public void addModifier(Modifier modifier) {
    this.modifiers.add(modifier);
  }

  public List<Die> getDice() {
    return this.dice;
  }

  public List<Modifier> getModifiers() {
    return this.modifiers;
  }

  public int getScore() {
    return this.score;
  }

  public String getName() {
    return this.name;
  }

  public Image getImage() {return this.image;}

  public int rollAllDice() {
    int sum = 0;
    for (Die die : this.dice) {
      int outcome = die.roll();
      sum += outcome;
    }
    score += sum;
    return sum;
  }

  public int sumAllModifiers() {
    int sum = 0;
    for (Modifier modifier : this.modifiers) {
      sum += modifier.getValue();
    }
    sum *= this.dice.size();
    this.score += sum;
    return sum;
  }

  public int compareTo(Player comparePlayer){
    int compareScore = ((Player) comparePlayer).getScore();

    return compareScore - this.score;
  }
}
