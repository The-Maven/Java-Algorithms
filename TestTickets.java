public class TestTickets
{
  public static void main(String[] args){                   
    Tickets cinema = new Tickets(10.00, 50);             // instantiating objects of Tickets class
    
    System.out.println(" Starting ticket price = " + cinema.getTicketPrice()+ " cedis");   // display ticket price
    System.out.println(" Tickets available now = " + cinema.getAvailableTickets());        // display number of tickets
    
    cinema.setTicketPrice(6.50);                                                           // setting new ticket price
    
    cinema.sellTickets(30);                                                                // selling 30 tickets
    
    System.out.println("Total Sales = " + cinema.getTotalSales() + " cedis");              // calculating total sales
    
    System.out.println("Sold Tickets = " + cinema.getTicketsSold());                       // getting tickets sold
    
    System.out.println("Tickets available = " + cinema.getAvailableTickets());             // getting tickets available
    
    System.out.println("The tickes were sold for " + cinema.getTicketPrice() + " cedis each" );
    
    cinema.sellTickets(50);                                                                // trying to sell excess tickets
    
    
    
    
    
  }
}
