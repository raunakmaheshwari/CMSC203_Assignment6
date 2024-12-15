import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private int numOfAlcoholDrink;
	private ArrayList<Order> orders;
	private int orderIndex = -1;
	
	public BevShop() {
		numOfAlcoholDrink = 0;
		orders = new ArrayList<>();
	}
	@Override
	public boolean isValidTime(int time) {
		// TODO Auto-generated method stub
		if (time >= 8 && time <= 23) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getMaxNumOfFruits() {
		// TODO Auto-generated method stub
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		// TODO Auto-generated method stub
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		// TODO Auto-generated method stub
		if (numOfFruits >= getMaxNumOfFruits()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol() {
		// TODO Auto-generated method stub
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		// TODO Auto-generated method stub
		if (numOfAlcoholDrink < getMaxOrderForAlcohol()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getNumOfAlcoholDrink() {
		// TODO Auto-generated method stub
		return numOfAlcoholDrink;
	}

	@Override
	public boolean isValidAge(int age) {
		// TODO Auto-generated method stub
		if (age >= getMinAgeForAlcohol()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		// TODO Auto-generated method stub
		orderIndex += 1;
		Order order = new Order(time, day, new Customer(customerName, customerAge));
		orders.add(order);

		
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		Order order = orders.get(orderIndex);
		order.addNewBeverage(bevName, size, extraShot, extraSyrup);
		orders.set(orderIndex, order);
		
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		// TODO Auto-generated method stub
		Order order = orders.get(orderIndex);
		order.addNewBeverage(bevName, size);
		orders.set(orderIndex, order);
		numOfAlcoholDrink += 1;

		
	}
	


	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		// TODO Auto-generated method stub
		Order order = orders.get(orderIndex);
		order.addNewBeverage(bevName, size, numOfFruits, addProtein);
		orders.set(orderIndex, order);
		
		
	}

	@Override
	public int findOrder(int orderNo) {
		// TODO Auto-generated method stub
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		// TODO Auto-generated method stub
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return orders.get(i).getTotal();
			}
		}
		
		return -1;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		// TODO Auto-generated method stub
		for (int i = 0; i < orders.size(); i++) {
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		// TODO Auto-generated method stub
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		// TODO Auto-generated method stub
		
		return orders.get(orderIndex);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		// TODO Auto-generated method stub
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		// TODO Auto-generated method stub
		int swappedIndex = 0;
		Order swappedOrder = null;
		boolean swap;
		
		for (int i = 0; i < orders.size(); i++) {
			int startNo = orders.get(i).getOrderNo();
			int index = i;
			Order order = orders.get(i);
			swap = false;
			for (int j = i; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < startNo) {
					swappedOrder = orders.get(j);
					swappedIndex = j;
					swap = true;
				}
			}
			if (swap) {
				orders.set(index, swappedOrder);
				orders.set(swappedIndex, order);
			}
			
			
		}
		
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i).getOrderNo());
		}
		
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < orders.size(); i++) {
			s += (orders.get(i).toString() + "\n");
			
		}
		
		s += ("Total Monthly Sale: " + totalMonthlySale());
		
		return s;
	}
	
	
}
