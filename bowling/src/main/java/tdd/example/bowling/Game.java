package tdd.example.bowling;

public class Game {
    private static final int numFramesInGame = 10;
    private Frame[] frames = new Frame[numFramesInGame];
    private int totalScore;
    private int currentFrame;
    private boolean endSpare;
    private boolean endStrike;

    public Game(){
        for (int i = 0; i < numFramesInGame; i++) {
            frames[i] = new Frame();
        }

        totalScore = 0;
        currentFrame = 0;
        endSpare = false;
        endStrike = false;
    }

    public void roll(int pins){
        if (currentFrame == 10) {
            if(endStrike){
                frames[9].setExtraPoints(frames[9].getExtraPoints() + pins);
                if(frames[9].wasStrike()){
                    frames[8].setExtraPoints(frames[8].getExtraPoints() + pins);
                }
            }else if(endSpare){
                frames[9].setExtraPoints(frames[9].getExtraPoints() + pins);
                System.out.println("Game Over: " + getTotalScore());
            }
            currentFrame++;
            return;
        }
        if(currentFrame == 11){
            if(endStrike){
                frames[9].setExtraPoints(frames[9].getExtraPoints() + pins);
            }
            System.out.println("Game Over: " + getTotalScore());
            currentFrame++;
            return;
        }
        if(currentFrame > 11){
            System.out.println("Game Over: " + getTotalScore());
            return;
        }

        Frame cf = this.frames[currentFrame];
        if(!cf.isFirstRollDone()){
            //FIRST ROLL
            if (pins == 10) {
                System.out.println("Strike!");
                if(cf.wasStrike()){
                    this.frames[currentFrame-1].setExtraPoints(pins);
                    if (this.frames[currentFrame-1].wasStrike()) {
                        this.frames[currentFrame-2].setExtraPoints(this.frames[currentFrame-2].getExtraPoints() + pins);
                    }
                }
                cf.setStrike(true);
                if(this.currentFrame == 9){
                    endStrike = true;
                    if(cf.wasStrike()){
                        endSpare = true;
                    }
                }else {
                    this.frames[currentFrame + 1].wasStrike(true);
                }
                cf.setDisplay("X");
                cf.setFirstRoll(pins);
                cf.setFirstRollDone(true);
                cf.setSecondRoll(0);
                cf.setSecondRollDone(true);
                currentFrame++;
                return;
            }else if(cf.wasStrike()){
                this.frames[currentFrame-1].setExtraPoints(pins);
                if (this.frames[currentFrame-1].wasStrike()) {
                    this.frames[currentFrame-2].setExtraPoints(this.frames[currentFrame-2].getExtraPoints() + pins);
                }
            }else if(cf.wasSpare()) {
                this.frames[currentFrame-1].setExtraPoints(pins);
            }
            cf.setFirstRoll(pins);
            cf.setFirstRollDone(true);
        }else if(!cf.isSecondRollDone()){
            //SECOND ROLL
            if(cf.wasStrike()){
                this.frames[currentFrame-1].setExtraPoints(this.frames[currentFrame-1].getExtraPoints() + pins);
            }
            if(pins + cf.getFirstRoll() == 10){
                System.out.println("Spare!");
                if(currentFrame == 9){
                    endSpare = true;
                }else {
                    frames[currentFrame + 1].wasSpare(true);
                }
                cf.setDisplay(cf.getFirstRoll() + "/");
            }
            cf.setSecondRoll(pins);
            cf.setSecondRollDone(true);
            this.currentFrame++;
            return;
        }
        return;
    }

    public void updateScore(){
        this.totalScore = 0;
        for(Frame f: frames) {
            this.totalScore += f.getFrameScore();
        }
    }

    public int getTotalScore(){
        updateScore();
        return this.totalScore;
    }
}
