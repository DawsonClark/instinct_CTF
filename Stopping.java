// Skeleton Code Copied from DummyPlayer then modified for question.

public class Stopping extends Player{
  
     @Override
     public void update(Field field){}
     
     @Override
     public void play(Field field){
          // Update the player's speed based on their proximity to the border of the field
          if (this.x >= (field.maxX-16)){  //right
           this.speedX = 0;
           this.speedY = 0;
           this.setX(field.maxX-16 ,id);
          }else if (this.x <= (field.minX)){ //left
               this.speedX = 0;
               this.speedY = 0;
               this.setX(field.minX,id);
          }else if(this.y >= (field.maxY-16)){ //bottom
               this.speedX = 0;
               this.speedY = 0;
               this.setX(field.maxY-50,id);
          } else if (this.y <= (field.minY)){ //top
               this.speedX = 0;
               this.speedY = 0;
               this.setX(field.minY+50,id);
          }
          // This logic slows down players that are too close to the wall
          if (this.x >= (field.maxX+48)){  
               this.speedX = this.speedX/this.speedX;
               this.speedY = this.speedY/this.speedY;
          }else if (this.x <= (field.minX-48)){
               this.speedX = this.speedX/this.speedX;
               this.speedY = this.speedY/this.speedY;
          }else if(this.y >= (field.maxY+48)){
               this.speedX = this.speedX/this.speedX;
               this.speedY = this.speedY/this.speedY;
          } else if (this.y <= (field.minY-48)){
               this.speedX = this.speedX/this.speedX;
               this.speedY = this.speedY/this.speedY;
          }

     }
    
     
     /** create a player that has some random motion 
       * <p>
       * the player starts in a random direction
       *
       * @param f is the field the player will be playing on
       * @param side is the side of the field the player will play on
       * @param name is this player's name 
       * @param number is this player's number
       * @param team is this player's team's name
       * @param symbol is a character representation of this player
       * @param x is the initial x position of this player
       * @param y is the initial y position of this player
       */
  public Stopping(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = -160 + Math.random()*(320);
    this.speedY = -160 + Math.random()*(320);
  }

}