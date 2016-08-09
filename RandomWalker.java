// Skeleton Code Copied from DummyPlayer then modified for question.

public class RandomWalker extends Player{
  
     @Override
     public void update(Field field){}
     
     @Override
     public void play(Field field){
          // Update the player's speed based on their proximity to the border of the field
          if (this.x >= (field.maxX-16)){ // player has reached the max Length of the Field
               this.speedX = this.speedX * -1;
          } else if (this.x <= (field.minX+1)){ // Player has reached the visual min Length of the Field
               this.speedX = this.speedX * -1;
          } else if (this.y >= (field.maxY-16)) { // Player has reached the max Width of the Field
               this.speedY = this.speedY * -1;
          } else if (this.y <= (field.minY+1)){ // Player has reached the Visual min Width of the Field    
               this.speedY = this.speedY * -1;
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
  public RandomWalker(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = -2 + Math.random()*(4-2);
    this.speedY = -2 + Math.random()*(4-2);
  }

}