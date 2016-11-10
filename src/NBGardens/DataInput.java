package NBGardens;

import java.util.ArrayList;

public class DataInput {
	
	public void addData(ArrayList<InventorySystem> inventoryList, ArrayList<OrderLine> orderList, ArrayList<PersonLine> personList, ArrayList<Location> locationList) {
	
	OrderLine order = new OrderLine();
	int orders[] = {2,3,1};
	int porusware[] = {2};
	
	order.addOrder(new CustomerOrder(orders, 8, porusware, 1), orderList);
	order.addOrder(new CustomerOrder(orders, 9, porusware, 1), orderList);
	order.addOrder(new CustomerOrder(orders, porusware, 3), orderList);
	order.addOrder(new CustomerOrder(orders, porusware, 1), orderList);	
	order.addOrder(new CustomerOrder(orders, porusware, 2), orderList);
	order.addOrder(new CustomerOrder(orders, 9, porusware, 3), orderList);
	order.addOrder(new CustomerOrder(orders, 8, porusware, 1), orderList);
	order.addOrder(new CustomerOrder(orders, porusware, 3), orderList);
	order.addOrder(new CustomerOrder(orders, porusware, 1), orderList);	
	order.addOrder(new CustomerOrder(orders, porusware, 2), orderList);
	
	order.addOrder(new PurchaseOrder(orders, 8, 5), orderList);
	order.addOrder(new PurchaseOrder(orders, 7, 4), orderList);	
	order.addOrder(new PurchaseOrder(orders, 8, 4), orderList); 
	
	InventorySystem inventory = new InventorySystem();
	
	inventory.AddNewItem("Garden Gnome", 8,"B2","Gnome", 5, 9.99);
	inventory.AddNewItem("Ray Smithy Gnome", 10,"B1","Gnome", 4, 10.99);
	inventory.AddNewItem("Deck Chair", 15,"C1","Garden Furniture", 10, 7.99);
	inventory.AddNewItem("Garden Gnome Hat", 25,"A3","Gnome Accessories", 17, 2.99);
	
	PersonLine person = new PersonLine();
	
	person.addPersonnel(new Customer("Terry Tibs", "1 Terry Way", "tibs@terry.com", 014561), personList);
	person.addPersonnel(new Customer("Barry Scott", "1 Cilit Bang Drive", "cilit@bang.com", 01455654), personList);
	person.addPersonnel(new Customer("Richard Hammond", "1 Maple Road", "r.hammond@aol.com", 014561), personList);
	
	
	person.addPersonnel(new Supplier("Gnomes R Us", "1 Gnome Way", "gnome@rus.com", 015612351L), personList);
	person.addPersonnel(new Supplier("B&Q", "B&Q Drive", "admin@bandq.com", 0174514L), personList);
	person.addPersonnel(new Supplier("Focus", "1 Focus Road", "info@focus.com", 015612351L), personList);
	
	person.addPersonnel(new WarehouseOperative("Ray Smithy Jr"), personList);
	person.addPersonnel(new WarehouseOperative("Trevor McDonald"), personList);
	person.addPersonnel(new WarehouseOperative("Nicolas Cage"), personList);
	
	Location loc = new Location();
	
	loc.addLocation(new Location("A1", 150, 50), locationList);
	loc.addLocation(new Location("A2", 168, 351), locationList);
	loc.addLocation(new Location("A3", 302, 173), locationList);
	loc.addLocation(new Location("A4", 188, 399), locationList);
	
	loc.addLocation(new Location("B1", 238, 262), locationList);
	loc.addLocation(new Location("B2", 321, 308), locationList);
	loc.addLocation(new Location("B3", 286, 12), locationList);
	loc.addLocation(new Location("B4", 61, 380), locationList);
	
	loc.addLocation(new Location("C1", 394, 46), locationList);
	loc.addLocation(new Location("C2", 161, 259), locationList);
	loc.addLocation(new Location("C3", 66, 281), locationList);
	loc.addLocation(new Location("C4", 47, 285), locationList);
	}

}
