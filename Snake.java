public class Snake implements GameContents {

    private int bodyParts = 1;
    static  int x[] = new int[GAME_UNITS];
    static  int y[] = new int[GAME_UNITS];

    public Snake(){
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(int length){
        bodyParts=length;
    }

    public int getX(int index){
        return x[index];
    }

    public void changeX(int index , int value){
        x[index]=value;
    }

    public void changeY(int index , int value){
         y[index]=value;
    }

    public int getY(int index){
        return y[index];
    }

    public void increaseBoodyParts(){
        bodyParts++;
    }

}

