
/*
 * DO ADD PRICE FUNCTION
 * */
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private double basePrice = 2.0;
	private final double SIZE_PRICE = 0.5;
	
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getBevName() {
		return bevName;
	}
	
	public Size getSize() {
		return size;
	}
	
	
	public double addSizePrice() {
		
		if (size == Size.MEDIUM) {
			basePrice += SIZE_PRICE;
		} else if (size == Size.LARGE) {
			basePrice += (SIZE_PRICE * 2);
		}
	
	
		return basePrice;
		
	}
	
	public abstract double calcPrice();
	
	
	@Override
	public String toString() {
		return "bevName=" + bevName + ", type=" + type + ", size=" + size;
	}
	
	
	public boolean equals(Beverage b) {
		
		return (this.bevName.equals(b.getBevName()) && this.type == b.getType() && this.size == b.getSize());
	
	}
	
	
	
	
	
	
	
}
