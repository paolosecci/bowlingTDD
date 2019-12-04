package tdd.example.bowling;

public class Frame {
    private int firstRoll;
    private int secondRoll;
    private int extraPoints;
    private int frameScore;
    private boolean isStrike;
    private boolean isSpare;
    private boolean wasStrike;
    private boolean wasSpare;
    private boolean firstRollDone;
    private boolean secondRollDone;
    private String display;

    public Frame(){
        firstRoll = 0;
        secondRoll = 0;
        extraPoints = 0;
        frameScore = 0;
        isStrike = false;
        isSpare = false;
        wasStrike = false;
        wasSpare = false;
        firstRollDone = false;
        secondRollDone = false;
        display = "-";
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getExtraPoints(){
        return extraPoints;
    }

    public void setExtraPoints(int extraPoints){
        this.extraPoints = extraPoints;
    }

    public void updateFrameScore(){
        this.frameScore = this.firstRoll + this.secondRoll + this.extraPoints;
    }

    public int getFrameScore() {
        updateFrameScore();
        return this.frameScore;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public boolean isFirstRollDone() {
        return firstRollDone;
    }

    public void setFirstRollDone(boolean firstRollDone) {
        this.firstRollDone = firstRollDone;
    }

    public boolean isSecondRollDone() {
        return secondRollDone;
    }

    public void setSecondRollDone(boolean secondRollDone) {
        this.secondRollDone = secondRollDone;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public boolean wasStrike() {
        return wasStrike;
    }

    public void wasStrike(boolean wasStrike) {
        this.wasStrike = wasStrike;
    }

    public boolean wasSpare() {
        return wasSpare;
    }

    public void wasSpare(boolean wasSpare) {
        this.wasSpare = wasSpare;
    }
}
