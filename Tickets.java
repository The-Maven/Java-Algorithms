public class Tickets
{
  private int availableTickets;                                   // defining instance variables
  private int ticketsSold;
  private double ticketPrice;
  private double totalSales;
  
  
  public Tickets(double pricePerTicket, int ticketsAvailable)      // A constructor for this class
  {
    availableTickets = ticketsAvailable;
    ticketPrice = pricePerTicket;
    ticketsSold = 0;
    totalSales = 0;
  }
  
  public int getAvailableTickets()                                // accessor methods for the variables
  {
    return availableTickets;
  }
  public int getTicketsSold()
  {
    return ticketsSold;
  }
  public double getTicketPrice()
  {
    return ticketPrice;
  }
  public double getTotalSales()
  {
    return totalSales;
  }
  
  public void setTicketPrice(double pricePerTicket)               // a mutator method for the ticket price variable
  {
    ticketPrice = pricePerTicket;
  }
  
  public boolean sellTickets(int ticketsToBeSold)                 // method to sell tickets
  {
    
    if(availableTickets >= ticketsToBeSold)                       // condition to sell tickets
    {
      availableTickets = availableTickets - ticketsToBeSold;      // changing vaiables accordingly
      totalSales = totalSales + (ticketsToBeSold * ticketPrice);
      ticketsSold = ticketsSold + ticketsToBeSold;
      return true;
    }
    else if 
      
      (availableTickets < ticketsToBeSold)
    {
      System.out.println("There aren't enough tickets to sell");   // dislpay this if tickets are not enough to sell
      return false;
      
    }
    
    else return false;
    
  }
  
}


