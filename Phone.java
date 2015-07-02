
/**
 * A class to represent a phone. 
 * 7th October 2013 Version
 * 
 **/
public class Phone {
  
  // Instance variables of the phone -- these represent property's of the phone
  private String brand;
  private String model;
  private String color;
  private String serviceProvider;
  private double numMinsCalled;
  private double numMinsReceived;
  private int numSMSSent;
  private int numSMSReceived;
    
  public static final int SMS_MSG_LEN = 140;
  
  // A default constructor for the Phone class
  public Phone() {
    brand = "Generic";
    model = "Generic";
    color = "No color";
    serviceProvider = "None";
    numMinsCalled = 0;
    numMinsReceived = 0;
    numSMSSent = 0;
    numSMSReceived = 0;
  }

  // Another constructor for the phone class
  public Phone(String phonesBrand, String phonesModel, String phonesColor, String phonesProvider){
    brand = phonesBrand;
    model = phonesModel;
    color = phonesColor;
    serviceProvider = phonesProvider;
    numMinsCalled = 0;
    numMinsReceived = 0;
    numSMSSent = 0;
    numSMSReceived = 0;
  }
  
  // A method to list information about the phone.
  // Note that this is an *instance* method and not a static method
  // That means it must be invoked on an instance of the class
  // (see the test program for an example of this)
  public void listInfo() {
    System.out.println("Here are the phone details:");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Color: " + color);
    System.out.println("Provider: " + serviceProvider);
    System.out.println("Called min: " + numMinsCalled);
    System.out.println("Received mins: " + numMinsReceived);
    System.out.println("SMS sent: " + numSMSSent);
    System.out.println("SMS received: " + numSMSReceived);
  }
  
  // An accessor method for brand
  public String getBrand(){
    return brand;
  }
  
  // An accessor method for model
  public String getModel(){
    return model;
  }
  
  // An accessor method for color
  public String getColor(){
    return color;
  }
  
  // A mutator method for color
  public void setColor(String newColor){
    color = newColor;
  }
 
  // An accessor method for numMinsCalled
  public double getNumMinsCalled(){
    return numMinsCalled;
  }
  
  // A method to simulate making a call
  public void makeCall(double duration){
    numMinsCalled += duration;
  }
  
  // A method to simulate receiving a call
  public void receiveCall(double duration){
    numMinsReceived += duration;
  }
  
  // A method to simulate sending an SMS
  public void sendSMS(int numChars){
    numSMSSent += ( (numChars-1)/SMS_MSG_LEN + 1);
  }
  
  // A method to compare one phone to another
  public boolean equals(Phone otherPhone) {
    if (this.model.equals(otherPhone.model) &&
        this.brand.equals(otherPhone.brand) &&
        this.color.equals(otherPhone.color) &&
        this.serviceProvider.equals(otherPhone.serviceProvider) &&
        this.numMinsCalled == otherPhone.numMinsCalled &&
        this.numMinsReceived == otherPhone.numMinsReceived &&
        this.numSMSSent == otherPhone.numSMSSent &&
        this.numSMSReceived == otherPhone.numSMSReceived){
      return true;
    }
    else {
      return false;
    }
  }
  
}