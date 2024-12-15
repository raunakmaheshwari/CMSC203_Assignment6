
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
		
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}	
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	@Override
	public double calcPrice() {
		double basePrice = super.addSizePrice();
		
		basePrice += (getNumOfFruits() * 0.50);
		
		if (addProtein) {
			basePrice += 1.50;
		}
		
		
		return basePrice;
	}
	
	public boolean equals(Smoothie s) {
			
			if (s == null) {
				return false;
			}
		
			return (super.equals(s) && 
				this.numOfFruits == s.getNumOfFruits() &&
				this.addProtein == s.getAddProtein());
		
	
	}
	
	@Override
	public String toString() {
		return "bevName=" + getBevName() + ", type=" + getType() + ", size=" + getSize() + ", numOfFruits=" + numOfFruits + ", addProtein=" + addProtein + " ,price=" + calcPrice();
	}
	
	
	
	
	
}
