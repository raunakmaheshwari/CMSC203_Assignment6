import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable{
	private int orderTime;
	private int orderNo;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;
	
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.setOrderTime(orderTime);
		this.orderDay = orderDay;
		this.setCust(cust);
		beverages = new ArrayList<>();
		orderNo = generateOrder();
	
	}
	
	public int generateOrder() {
		Random rand = new Random();
		
		orderNo = rand.nextInt(10000, 90001);
		return orderNo;
		
	}

	@Override
	public boolean isWeekend() {
		// TODO Auto-generated method stub
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		try {
			return beverages.get(itemNo);
		} catch (IndexOutOfBoundsException e){
			return null;
		}
	}

	public Day getOrderDay() {
		return orderDay;
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		
	}

	@Override
	public int findNumOfBevType(Type type) {
		int bevCount = 0;
		for (int i = 0; i < beverages.size(); i++) {
			if (beverages.get(i).getType() == type) {
				bevCount += 1;
			}
		}
		
		return bevCount;
	}
	
	@Override
	public double calcOrderTotal() {
		double orderTotal = 0.0;
		for (int i = 0; i < beverages.size(); i++) {
			orderTotal += (beverages.get(i).calcPrice());
		}
		
		return orderTotal;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderNo() {
		return orderNo;
	}


	public Customer getCust() {
		return new Customer(cust);
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public int compareTo(Order anotherOrder) {
		// TODO Auto-generated method stub
		if (this.orderNo == anotherOrder.orderNo) {
			return 0;
		} else if (this.orderNo > anotherOrder.orderNo) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public int getTotal() {
		return beverages.size();
	}

	@Override
	public String toString() {
		return "orderTime=" + orderTime + ", orderDay=" + orderDay + ", name=" + cust.getName() + ", age=" + cust.getAge() +
				", beverages=" + beverages;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
