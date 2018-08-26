package org.westos.collection.test.demo4;

public class Student {
    private String name;
    private double chineseScore;
    private double mathScore;
    private double englishScore;

    public Student() {
    }

    public Student(String name, double chineseScore, double mathScore, double englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(double chineseScore) {
        this.chineseScore = chineseScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }
    //提供计算总分的方法
    public double getTotalScore(){
        return this.chineseScore+this.englishScore+this.mathScore;
    }
}
