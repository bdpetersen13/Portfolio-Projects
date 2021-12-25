public class Monkey extends RescueAnimal {
//Instance Variable
  private double tailLength;
  private double height;
  private double bodyLength;
  private double toroso;
  private double skull;
  private double neck;
  private String species;

//Constructor
  public Monkey() {

//Accessor Methods
    public double getTailLength {
      return tailLength();
    }
    public double getheight {
      return height();
    }
    public double getBodyLength {
      return bodyLength();
    }
    public double getTorso {
      return toroso();
    }
    public double getSkull {
      return skull();
    }
    public double getNeck {
      return neck();
    }
    public String getSpecies {
      return species();
    }

//Mutator methods
    public void setTailLength(double monkeyTail) {
      tailLength = monkeyTail;
    }
    public void setHeight(double monkeyHeight) {
      height = monkeyHeight;
    }
    public void setBodyLength(double monkeyBodyLength) {
      bodyLength = monkeyBodyLength;
    }
    public void setTorso(double monkeyTorso) {
      torso = monkeyTorso;
    }
    public void setNeck(double monkeyNeck) {
      neck = monkeyNeck;
    }
    public void setSpecies(String monkeySpecies) {
      species = monkeySpecies;
    }
  }
}
