package ro.dbts.model;

public class Order {
	
	private double order_id;
	private float value;
	
	public double getOrder_id() {
		return order_id;
	}
	public void setOrder_id(double order_id) {
		this.order_id = order_id;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	public Order(double order_id, float value) {
		super();
		this.order_id = order_id;
		this.value = value;
	}
	
	public Order() {
		super();
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", value=" + value + "]";
	}
	
}
