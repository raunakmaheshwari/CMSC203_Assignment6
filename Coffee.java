
public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double additionalCost = 0.5;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
		
	}

	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	

	@Override
	public double calcPrice() {
		double basePrice = super.addSizePrice();
		if (extraShot) {
			basePrice += additionalCost;
		}
		
		if (extraSyrup) {
			basePrice += additionalCost;
		}
		
		return basePrice;
		
	}	
	
	
	@Override
	public String toString() {
		return "bevName=" + getBevName() + ", type=" + getType() + ", size=" + getSize() + "extraShot=" + extraShot + ", extraSyrup=" + extraSyrup + " ,price=" + calcPrice();
	}
	
	
	public boolean equals(Coffee c) {
		
		if (c == null) {
			return false;
		}
		
		return (
			super.equals(c) &&
			this.extraShot == c.getExtraShot() &&
			this.extraSyrup == c.getExtraSyrup()
		);

	}
	
	
}
