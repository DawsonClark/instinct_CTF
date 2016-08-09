// Skeleton Code Copied from DummyPlayer then modified for question.

public class Chaser extends Player{
  
     @Override
     public void update(Field field){}
     
     @Override
     public void play(Field field){
          // Update the player's speed based on their proximity to the target
         double oppX;
         double oppY;
         Entity oppPlayer;
         if (this.getTeam().equals("reds")){ // Red Team, chase a blue player
              oppPlayer = field.getTeam1().get(0);
         } else { // Blue Team chase a red player
              oppPlayer = field.getTeam2().get(0);
         }
          oppX = oppPlayer.getX();
          oppY = oppPlayer.getY();
          double distX = (oppX - this.x); // X distance to travel
          double distY = (oppY - this.y); // Y Distance to travel
          double totalDist =Math.pow(Math.pow(distX,2) + Math.pow(distY,2),0.5);
          
          // Because We know our MAX allowed speed is 10 use some trigonometry to determine the max
          // X and Y components of velocity
          
          this.speedX =  ((1*distX)/totalDist); //Determine Speed Ratio based off of 'Cross Multiply and Divide' 
          this.speedY =  ((1*distY)/totalDist); //Slowed down here for reasonable speed
          
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
  public Chaser(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = -1 + Math.random()*(4-2);
    this.speedY = -1 + Math.random()*(4-2);
  }

}