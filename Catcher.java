// Skeleton Code Copied from DummyPlayer then modified for question.

public class Catcher extends Player{
  
     @Override
     public void update(Field field){}
     
     @Override
     public void play(Field field){
          // Update the player's speed based on their proximity to the target
         double oppX;
         double oppY;
         Entity oppPlayer = null;
         if (this.getTeam().equals("reds")){ // Red Team(2), chase a blue Team Member(1)
              for(Entity e:field.getTeam1()){
                   if(e.speedX !=0 && e.speedY !=0){
                    oppPlayer =  e;
                   } 
              }
         } else { // Blue Team chase a red player
              for(Entity e:field.getTeam2()){
                   if(e.speedX !=0 && e.speedY !=0){
                        oppPlayer = e;
                   }
              }
         }
         if (oppPlayer != null){
         // Chase and catch opposing player
          oppX = oppPlayer.getX();
          oppY = oppPlayer.getY();
          double distX = (oppX - this.x); // X distance to travel
          double distY = (oppY - this.y); // Y Distance to travel
          double totalDist =Math.pow(Math.pow(distX,2) + Math.pow(distY,2),0.5);
          
          // Because We know our MAX allowed speed is 10 use some trigonometry to determine the max
          // X and Y components of velocity
          
          this.speedX =  ((2*distX)/totalDist); //Determine Speed Ratio based off of 'Cross Multiply and Divide' 
          this.speedY =  ((2*distY)/totalDist); //Slowed down here for reasonable speed
          
          // Check if we've caught the player
          field.catchOpponent(this,(Player) oppPlayer);
               // Things?
  
         } else { // oppPLayer is null, bounce around like a random walker
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
  public Catcher(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = -1 + Math.random()*(4-2);
    this.speedY = -1 + Math.random()*(4-2);
  }

}