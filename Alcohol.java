
public class Alcohol extends Beverage {

	private boolean isWeekend;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
		
	}
	

	public boolean isWeekend() {
		return isWeekend;
	}
	
	@Override
	public double calcPrice() {
		double basePrice = super.addSizePrice();
		
		if (isWeekend) {
			basePrice += 0.6;
		}
	
		return basePrice;
	}
	
	
	@Override
	public String toString() {
		return "bevName=" + getBevName() + ", type=" + getType() + ", size=" + getSize() + ", isWeekend=" + isWeekend() + " ,price=" + calcPrice();
		
	}
	
	public boolean equals(Object o) {
		
		Alcohol a  = (Alcohol) o; 
		
		if (a == null) {
			return false;
		}
		return (super.equals(a) && 
				this.isWeekend == a.isWeekend() &&
				this.getBasePrice() == a.getBasePrice());
			
	}
	

}
