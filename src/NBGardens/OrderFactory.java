package NBGardens;

import java.util.ArrayList;

public class OrderFactory {
	
	public String printOrderDetails(ArrayList<InventorySystem> inventoryList, ArrayList<OrderLine> orderList, ArrayList<PersonLine> personsList, int id){
		
		OrderLine tempOrder = new OrderLine();
		String orderDetailsOutput = "";
		
		if (orderList.get(id).getOrder() instanceof CustomerOrder)
		{
			CustomerOrder tempCustomer = (CustomerOrder) orderList.get(id).getOrder();
			orderDetailsOutput = tempOrder.printOrderDetails(inventoryList, tempCustomer, personsList, id);
		}
		else if (orderList.get(id).getOrder() instanceof PurchaseOrder) 
		{
			PurchaseOrder tempPurchase = (PurchaseOrder) orderList.get(id).getOrder();
			orderDetailsOutput = tempOrder.printOrderDetails(inventoryList, tempPurchase, personsList, id);
		}
		
		return orderDetailsOutput;
	}
	
	public void updateOrder(int id, ArrayList<OrderLine> orderList, int status)
	{
		
	if (orderList.get(id).getOrder() instanceof CustomerOrder)
	{
		CustomerOrder tempCustomer = (CustomerOrder) orderList.get(id).getOrder();
		tempCustomer = tempCustomer.updateStatus(tempCustomer, status);
		orderList.get(id).setOrder(tempCustomer);
	}
	else if (orderList.get(id).getOrder() instanceof PurchaseOrder) 
	{
		PurchaseOrder tempPurchase = (PurchaseOrder) orderList.get(id).getOrder();
		tempPurchase = tempPurchase.updateStatus(tempPurchase, status);
	}
	
	}
	
	
	public CustomerOrder returnCusOrder(Object object){
		CustomerOrder tempCustOrder = (CustomerOrder) object;
		return tempCustOrder;
	}
	
	public PurchaseOrder returnPurOrder(Object object){
		PurchaseOrder tempPurOrder = (PurchaseOrder) object;
		return tempPurOrder;
	}

}
