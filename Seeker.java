// Skeleton Code Copied from DummyPlayer then modified for question.

public class Seeker extends Player{
  
     @Override
     public void update(Field field){}
     
     @Override
     public void play(Field field){
          if (this.pickUpFlag(field) == false){
          // Compute the required x and y speed to move straight to the flag
          if (this.getTeam().equals("reds")){ // Entity is on red team and should look for blue flag
               double flagX = field.getFlag1Position()[0];
               double flagY = field.getFlag1Position()[1];    
               double distX = (flagX - this.x); // X distance to travel
               double distY = (flagY - this.y); // Y Distance to travel
               double totalDist =Math.pow(Math.pow(distX,2) + Math.pow(distY,2),0.5);
                    
               
               this.speedX =  ((MAX_SPEED*distX)/totalDist); //Determine Speed Ratio based off of 'Cross Multiply and Divide' 
               this.speedY =  ((MAX_SPEED*distY)/totalDist); 
               
               // Max Speed   X/Y Speed
               // --------- = ----------
               //  TotalDist   X/Y Dist  
               
          } else { // Entity is on blue team and should look for red flag
               
               double flagX = field.getFlag2Position()[0];
               double flagY = field.getFlag2Position()[1];    
               double distX = (flagX - this.x); // X distance to travel
               double distY = (flagY - this.y); // Y Distance to travel
               double totalDist =Math.pow(Math.pow(distX,2) + Math.pow(distY,2),0.5);
               
               this.speedX =  ((MAX_SPEED*distX)/totalDist); //Determine Speed Ratio based off of 'Cross Multiply and Divide' 
               this.speedY =  ((MAX_SPEED*distY)/totalDist); 
               
               // Max Speed   X/Y Speed
               // --------- = ----------
               //  TotalDist   X/Y Dist  

          }
          } else{
           this.speedX = 0;
           this.speedY = 0;
          }
          

// Update the player's speed based on their proximity to the border of the field          
         if ((this.x >= (field.maxX-16)) || (this.x <= (field.minX-16)) || (this.y >= (field.maxY-16)) || (this.y <= (field.minY-16))){
           this.speedX = -this.speedX;
           this.speedY = -this.speedY;
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
  public Seeker(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = -1 + Math.random()*(4-2);
    this.speedY = -1 + Math.random()*(4-2);
  }

}