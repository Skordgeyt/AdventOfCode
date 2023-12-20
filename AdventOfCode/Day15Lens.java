public class Day15Lens {
   public String label;
   public int strength; 

   public Day15Lens(String label, int strength){
        this.label = label;
        this.strength = strength;
   }
   public String getLabel(){
        return this.label;
   }
   public int getStrength(){
        return this.strength;
   }
   public String toString(){
        return this.label+": "+this.strength;
   }
}