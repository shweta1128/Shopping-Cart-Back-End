package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks ;
    private int possibleMarks;
    private String submitterName;

    public int getEarnedMarks(){
        return this.earnedMarks;
    }
    public void setEarnedMarks(int earned){
        this.earnedMarks = earned;

    }
    public int getPossibleMarks() {
        return this.possibleMarks;
    }
    public String getSubmitterName() {
        return this.submitterName;
    }
     public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
     }
     public String getLetterGrade(){
        double percentageOfMarks = ((double )earnedMarks / possibleMarks) * 100;
        if (percentageOfMarks >= 90){
            return "A";

        } else if (percentageOfMarks >= 80 ){
            return "B";

        }else if (percentageOfMarks >= 70){
            return "C";

        }else if (percentageOfMarks >= 60){
            return "D";
        }
        return "F";
     }


}
    //getters
    //public int getHour() {
       // return this.hour;
  //  } //setters
//    public void setHour(int hour) {
//        this.hour = hour;