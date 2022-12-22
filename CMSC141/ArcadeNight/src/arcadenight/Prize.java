package arcadenight;

public class Prize {
	
	//Fields
	private String prizeName;
	private int ticketPrice;
	private int remainingPrizes;
	
	//Constructor
	public Prize (String prizeName, int ticketPrice, int remainingPrizes) {
		 this.prizeName       = prizeName;
		 this.ticketPrice     = ticketPrice;
		 this.remainingPrizes = remainingPrizes;
	 }
	
	//Getters
	public String getPrizeName() {
        return prizeName;
	}
	public int getTicketPrice() {
        return ticketPrice;
	}
	public int getRemainingPrizes() {
        return remainingPrizes;
	}
	
	//Setters
	public void setPrizeName(String p) {
        this.prizeName = p;
	}
	public void setRemainingPrizes(int r) {
        this.remainingPrizes = r;
	}
	
}
