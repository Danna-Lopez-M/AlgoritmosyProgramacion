package model;

public class Level{

    private String num;
    private int necScore;
    
    public Level(String num, int necScore){
        this.num = num;
        this.necScore = necScore;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getNecScore() {
        return this.necScore;
    }

    public void setNecScore(int necScore) {
        this.necScore = necScore;
    }

    public String toString() {
        return "\nLevel information:"
        + "\n Name: " + this.num
        + "\n Necessary score: " + this.necScore;
    }
}