package edu.neu.csye7374;
import java.util.*;
/**
 * DoorDash model:
 * 
 * 100 TOTAL POINTS
 *  
 * USE AND COMPLETE CODING THIS SINGLE (partially coded) CLASS (add inner classes)
 * to Model Door Dash service demonstrating the correct use of all following design patterns:
 * 
 * Adapter, Builder, Bridge, Composite, Decorator, Singleton, Factory Method, Strategy
 * 
 * Demonstrate Point of Sale (POS) by displaying (on console stdout) 
 * ALL orders, totaled with all discounts as follows:
 * 	
 * 	Show ALL Orders NormalDiscount (0% decrease applied to each item price and Total), 
 * 	Show ALL Orders	MemberDiscount (10% decrease applied to each item price and Total), 
 * 	Show ALL Orders	SpecialDiscount (20% decrease applied to each item price and Total), 
 * 	Show ALL Orders	SuperBowlDiscount (20% increase applied to each item price and Total), 
 * 
 * 
 * 20 POINTS
 * 1. Create following food items using the following design patterns: 
 *    Builder, 
 *    Decorator,
 *    Singleton Factory (Eager, Lazy and Enum implementations)
 *    AND with the following attributes:
 * 
 * $ 0.99 French Fries
 * $ 1.29 Medium Drink
 * $ 3.49 Hamburger
 * $ 1.49 Hot Dog
 * $ 3.79 Cheeseburger
 * $ 4.49 Buffalo Wings
 * $ 2.49 Salad
 * $ 5.49 Pizza ($1 OPTIONS: cheese, mushrooms, onions, pepperoni, sausage)
 * 
 * 
 * 30 POINTS
 * 2. Create the following customer orders using the following design patterns: 
 *    Builder, 
 *    Singleton Factory (Eager, Lazy and Enum implementations)
 *    AND with the following attributes:
 *    
 * 	Dan's Customer Door Dash Order ID #1 Hamburger, Medium Drink
 * 	Pam's Customer Door Dash Order ID #2 HotDogCombo (HotDog, French Fries, Medium Drink)
 * 	Jim's Customer Door Dash Order ID #3 BurgerCombo (Hamburger, French Fries, Medium Drink)
 * 	Jen's Customer Door Dash Order ID #4 Cheeseburger, French Fries
 * 	Len's Customer Door Dash Order ID #5 WingCombo (Buffalo Wings, Medium Drink, Salad)
 * 	Sam's Customer Door Dash Order ID #6 PizzaCombo (Buffalo Wings, French Fries, Salad, Medium Drink, Pizza)
 * 
 * 
 * 40 POINTS
 * 3. Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices): 
 * 	NormalDiscount (0% decrease), 
 * 	MemberDiscount (10% decrease), 
 * 	SpecialDiscount (20% decrease), 
 * 	SuperBowlDiscount (20% increase)
 * 
 * MUST DEVELOPE APIs (PosAPI and CalculatorAPI) IN TWO PHASES (NOTE: all names with 1 & 2) 
 * using Bridge design pattern:
 * 
 * PosAPI Point of Sale API (PosAPI1 & PosAPI2)
 * 
 * 	Phase I 	class Pos1 and interface PosAPI1 with methods:
 * 		double sumTotal(List<Double> itemList); // add customer total
 * 		void setStrategy(PriceStrategyAPI s);	// set strategy for price adjustments
 *		double getSum();	// return sum total
 *		String toStringSumTotal();	// return String representation of sum total
 *
 * 	Phase II 	class Pos2 and interface PosAPI2 with methods:
 * 		double getChange(double cash);		// accept cash, return change
 *		String toStringCash();		// return String representation of customer cash submitted
 *		String toStringChange();	// return String representation of customer change received
 *
 * Calculator API (CalculatorAPI1 & CalculatorAPI2)
 * 
 *  PHASE I		class Calculator1 and interface CalculatorAPI1 with method:
 *      double add(double a, double b);
 *  
 *  PHASE II	class Calculator2 and interface CalculatorAPI2 with methods:
 *  	double sub(double a, double b);
 *  	double mult(double a, double b);
 *  	double div(double a, double b);
 *  
 *  
 * 10 POINTS
 *  4. Develop class OrderAdapter using Adapter design pattern, 
 *  to adapt Order to use an ItemAPI object
 *   
 * @author dpeters
 *
 */
public class DoorDash {
	/**
	 * static initialization block REQUIRED FOR DevelopmentLogEnum
	 * executed only once
	 */
	static {
		/**
		 * Set outer class (replace Driver)
		 */
		DevelopmentLogEnum.LOG.setOuterClass(DoorDash.class);
	}
	/**
	 * object initialization block REQUIRED FOR DevelopmentLogEnum
	 * executed with each constructor
	 */
	{
		/**
		 * Set outer class (use DevelopmentLogEnum defined below)
		 */
		DevelopmentLogEnum.LOG.setOuterClass(this.getClass());
	}
	
	/**
	 * DevelopmentLogEnum manages development log entries for this class
	 * 
	 * @author dgpeters
	 *
	 */
	public static enum DevelopmentLogEnum {
		LOG;
		
		private static final int MAJOR_REVISION;
		private static final int MINOR_REVISION;
		private static final String REVISION;
		private final static List<String> DEVELOPMENT_LOG_ENTRY_LIST;
		private Class outerClass = null;
		
		/**
		 * static initialization block
		 * executed once for this class
		 */
		static {
			MAJOR_REVISION = 1;
			MINOR_REVISION = 0;
			REVISION = Integer.valueOf(MAJOR_REVISION) + "." + Integer.valueOf(MINOR_REVISION);
			/**
			 * Detailed development log for this class
			 * 
			 * NOTE:	Everything here is contained in the specification of this enum 
			 * 				DevelopmentLogEnum
			 * 			and is compiled to be initialized BEFORE any code execution
			 * 			EVERYTHING IN THIS LOG IS CODE TO BE COMPILED AND NEVER EXECUTES
			 * 			EXCEPT TO DISPLAY 
			 * 				DEVELOPMENT_LOG_ENTRY_LIST
			 * 			Strings AND
			 * 				REVISION
			 * 	 		ON THE CONSOLE (STDOUT) OUTPUT.
			 * 
			 * 
			 * FOR EACH CHANGE to this class during development 
			 * (e.g., bug fixes or new features, inner classes or inner interfaces),
			 * add a detailed descriptive Literal String (with trailing comma) to this list
			 * BEFORE " **End of Log Entry List **" String
			 * e.g. 
			 * 
			 * "1.2: made changes to blah blah to fix bug blah",
			 * " **End of Log Entry List **"
			 * 
			 * OR
			 * 
			 * "3.7: created new inner class blah to add new blah blah feature",
			 * " **End of Log Entry List **"
			 * 
			 */
			DEVELOPMENT_LOG_ENTRY_LIST = new ArrayList<>(Arrays.asList(
					"1.0: initial version of class created",
					"1.1: Created skeleton inner interfaces PosAPI1, PosAPI2, CalculatorAPI1, CalculatorAPI2 and inner classes Pos1, Pos2, Calculator1 and Calculator2",
					"1.2: Created skeleton inner class OrderAdapter that implements ItemAPI and extends Order",
					"1.3: Created Item class that implements ItemAPI and developed ItemBuilder class within it to set values to an item obj",
					"1.4: Using Composite and Builder design pattern, developed inner classes: Order, IndividualOrder, IndividualOrderBuilder, ComboOrder and ComboOrderBuilder",
					"1.5: Created all the factory pattern inner classes",
					"1.6: Bug Fix - replaced OrderComponent with Order in all mentions while creating factory design patter nclasses",
					"1.7: Using Strategy design pattern created Discount strategy classes",
					"1.8: Completed developing Bridge design patterns classes",
					"1.9: Tested the demo classes implementation",
					"2.0: Debugged the Pos1, Pos2, Calculator1 & Calculator 2 classes to successfully execute the demo method",
					"2.1: Built all the Items and Orders using the Builder, Factory(Enum, Lazy & Eager), Decorator design patterns in DataSetup() method",
					"2.2: Got output of all Orders total costs using pos1 & Pos2",
					"** End of Log Entry List **"
			));
		} // end static block

		public void setOuterClass(Class outerClass) {
			this.outerClass = outerClass;
		}
		public Class getOuterClass() {
			return outerClass;
		}

		public String getRevision() {
			return DevelopmentLogEnum.REVISION + "." + DevelopmentLogEnum.DEVELOPMENT_LOG_ENTRY_LIST.size();
		}
		/**
		 * revisionLog shows all the entries in the development log made during the development of this class
		 * @return
		 */
		public String getDevelopmentLog() {
			StringBuilder sb = new StringBuilder(outerClass.getSimpleName());

			sb.append(" Development Log ").append(this.getRevision()).append("\n");
			DevelopmentLogEnum.DEVELOPMENT_LOG_ENTRY_LIST.forEach((e) -> sb.append(e).append("\n"));

			return sb.toString();
		}
	} // end of enum DevelopmentLogEnum


	/**
	 * ItemAPI implemented by all Item objects for sale
	 *
	 * @author dpeters
	 */
	private interface ItemAPI {
		double getPrice();
		String getName();
	}
	/**
	 * OrderAPI implemented by all Order objects for customer orders
	 *
	 * @author dpeters
	 */
	private interface OrderAPI {
		int getId();
		double getPrice();
		String getName();
		String getDescription();
	}


	/**
	 * Student ToDO:
	 * Adapter Design Pattern:
	 *
	 * 4. Develop inner class OrderAdapter using Adapter design pattern,
	 * to adapt Order to use an ItemAPI object
	 */

	public static class OrderAdapter implements ItemAPI{

		private Order order;
		private List<ItemAPI> itemList = new ArrayList();

		public OrderAdapter(Order order, ItemAPI... items) {
			this.order = order;
			for(ItemAPI item: items){
			addItem(item);
			}
		}

		public void setPrice(){
			double totalCost = 0.0;
			for (ItemAPI item : this.getItems()) {
				totalCost += item.getPrice();
			}
			order.price = totalCost;
		}

		public void setDescription(){
			StringBuilder totalDesc = new StringBuilder();
			for (ItemAPI item : this.getItems()) {
				totalDesc.append(item.getName()).append(", ");
			}
			totalDesc.delete(totalDesc.length() - 2, totalDesc.length()); // To remove final comma and space
			order.description = totalDesc.toString();
		}
		public void addItem(ItemAPI singleItem) {
			this.itemList.add(singleItem);
		}

		public List<ItemAPI> getItems() {
			return this.itemList;
		}

		@Override
		public double getPrice() {
			return this.order.getPrice();
		}

		@Override
		public String getName() {
			return this.order.getName();
		}
	}

	/**
	 * Student ToDO:
	 * Builder Design Pattern:
	 *
	 * Using Builder design pattern, develop inner class ItemBuilder
	 * to custom configure an Item object
	 */

	public static class Item implements ItemAPI{

		private String name;
		private double price;

		public Item(ItemBuilder iBuilder){
			this.name = iBuilder.name;
			this.price = iBuilder.price;
		}

		public Item() {
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public String toString() {
			return "ItemDetails- ItemName: "+this.getName()+" ItemPrice: "+this.getPrice()+"\n";
		}

		public static class ItemBuilder{

			private String name;
			private double price;

			public ItemBuilder() {
				this.name = "";
				this.price = 0.0;
			}


			public ItemBuilder setName(String name) {
				this.name = name;
				return this;
			}

			public ItemBuilder setPrice(double price) {
				this.price = price;
				return this;
			}

			public Item build(){
				return new Item(this);
			}
		}
	}

	/**
	 * Student ToDO:
	 * Composite Design Pattern:
	 *
	 * Using Composite and Builder design pattern,
	 * develop inner classes:
	 *
	 *  Order, IndividualOrder, IndividualOrderBuilder,
	 * ComboOrder and ComboOrderBuilder
	 *
	 */

	public interface OrderBuilderAPI{

		public OrderBuilderAPI setName(String orderName);


		public OrderBuilderAPI setPrice();

		public OrderBuilderAPI setId(int orderId);

		public OrderBuilderAPI setDescription();

		public OrderAPI build();

		public OrderBuilderAPI addItemToList(ItemAPI item);

	}
	public static class Order implements OrderAPI{

		private int id;
		private double price;
		private String name;
		private String description;
		private List<ItemAPI> itemList = new ArrayList<>();

		@Override
		public int getId() {
			return this.id;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setItemList(List<ItemAPI> itemList) {
			this.itemList = itemList;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public String getDescription() {
			return this.description ;
		}


		public List<ItemAPI> getItemList(){
			return this.itemList;
		}

	}

	public static class IndividualOrder extends Order{

		private double price;
		private String name;
		private int id;
		private String description;
		private List<ItemAPI> itemList = new ArrayList<>();


		public IndividualOrder(IndividualOrderBuilder iOrderBuilder){
			setId(iOrderBuilder.id);
			setName(iOrderBuilder.name);
			setItemList(iOrderBuilder.individualItemList);
			setPrice(iOrderBuilder.price);
			setDescription(iOrderBuilder.description);
		}

		public IndividualOrder() {
		}

		public static class IndividualOrderBuilder implements OrderBuilderAPI{
			private int id;
			private double price;
			private String name;
			private String description;
			private List<ItemAPI> individualItemList = new ArrayList<ItemAPI>();

			@Override
			public  OrderBuilderAPI setName(String orderName){
				this.name = orderName;
				return this;
			}

			@Override
			public  OrderBuilderAPI setPrice(){
				double totalCost = 0;
				for (ItemAPI items : individualItemList) {
					totalCost += items.getPrice();
				}
				this.price = totalCost;
				return this;
			}

			@Override
			public  OrderBuilderAPI setId(int orderId){
				this.id = orderId;
				return this;
			}

			@Override
			public  OrderBuilderAPI setDescription(){
				String currDesc = "\t";
				for (ItemAPI item: individualItemList) {
					currDesc += item.getName();
					currDesc += "\t";
				}
				this.description = currDesc;
				return this;
			}

			@Override
			public OrderBuilderAPI addItemToList(ItemAPI currItem) {
				this.individualItemList.add(currItem);
				return this;
			}

			public IndividualOrder build(){
				return new IndividualOrder(this);
			}
		}
	}

	public static class ComboOrder extends Order{

		private double price;
		private String name;
		private int id;
		private String description;
		private List<ItemAPI> itemList = new ArrayList<>();


		public ComboOrder(ComboOrderBuilder cOrderBuilder){
			setId(cOrderBuilder.id);
			setName(cOrderBuilder.name);
			setItemList(cOrderBuilder.comboItemList);
			setPrice(cOrderBuilder.price);
			setDescription(cOrderBuilder.description);
		}

		public ComboOrder() {
		}

		public static class ComboOrderBuilder implements OrderBuilderAPI{
			private int id;
			private double price;
			private String name;
			private String description;
			private List<ItemAPI> comboItemList = new ArrayList<ItemAPI>();


			@Override
			public  OrderBuilderAPI setName(String orderName){
				this.name = orderName;
				return this;
			}

			@Override
			public  OrderBuilderAPI setPrice(){
				double totalCost = 0;
				for (ItemAPI items : comboItemList) {
					totalCost += items.getPrice();
				}
				this.price = totalCost;
				return this;
			}

			@Override
			public  OrderBuilderAPI setId(int orderId){
				this.id = orderId;
				return this;
			}

			@Override
			public  OrderBuilderAPI setDescription(){
				String currDesc = "( ";
				for (ItemAPI item: comboItemList) {
					currDesc += item.getName();
					currDesc += " , ";
				}
				currDesc += " )";
				this.description = currDesc;
				return this;
			}

			@Override
			public OrderBuilderAPI addItemToList(ItemAPI currItem) {
				this.comboItemList.add(currItem);
				return this;
			}

			public ComboOrder build(){
				return new ComboOrder(this);
			}

		}
	}


	/**
	 * Student ToDO:
	 * Decorator Design Pattern:
	 *
	 * Using Decorator design pattern,
	 * develop inner classes:
	 *
	 *  ItemDecoratorAPI, and others as needed for all ItemAPI options
	 *
	 */

	public interface ItemDecoratorAPI extends ItemAPI {
		// This interface extends ItemAPI and adds an extra method to get the description of the decorated item
		String getDescription();
	}

	public static class PizzaDecorator implements ItemDecoratorAPI {

		protected ItemAPI pizza;

		public PizzaDecorator(ItemAPI pizza) {
			this.pizza = pizza;
		}

		@Override
		public double getPrice() {
			return pizza.getPrice();
		}

		@Override
		public String getName() {
			return pizza.getName();
		}

		@Override
		public String getDescription() {
			return "\nPizza with: ";
		}
	}

	public static class ExtraCheeseDecorator extends PizzaDecorator {

		public ExtraCheeseDecorator(ItemAPI pizza) {
			super(pizza);
		}

		@Override
		public double getPrice() {
			return super.getPrice() + 1;
		}

		@Override
		public String getName() {
			return super.getName() + " Extra Cheese";
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", Extra Cheese";
		}
	}

	public static class PepperoniDecorator extends PizzaDecorator {

		public PepperoniDecorator(ItemAPI pizza) {
			super(pizza);
		}

		@Override
		public double getPrice() {
			return super.getPrice() + 1;
		}

		@Override
		public String getName() {
			return super.getName() + " Pepperoni";
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", Pepperoni";
		}
	}

	public static class SausageDecorator extends PizzaDecorator {

		public SausageDecorator(ItemAPI pizza) {
			super(pizza);
		}

		@Override
		public double getPrice() {
			return super.getPrice() + 1;
		}

		@Override
		public String getName() {
			return super.getName() + " Sausage";
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", Sausage";
		}
	}

	public static class MushroomsDecorator extends PizzaDecorator {

		public MushroomsDecorator(ItemAPI pizza) {
			super(pizza);
		}

		@Override
		public double getPrice() {
			return super.getPrice() + 1;
		}

		@Override
		public String getName() {
			return super.getName() + " Mushrooms";
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", Mushrooms";
		}
	}

	public static class OnionDecorator extends PizzaDecorator {

		public OnionDecorator(ItemAPI pizza) {
			super(pizza);
		}

		@Override
		public double getPrice() {
			return super.getPrice() + 1;
		}

		@Override
		public String getName() {
			return super.getName() + " Onions";
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", Onions";
		}
	}


	/**
	 * ToDO:
	 * Factory Design Pattern:
	 *
	 * Using Factory design pattern and supplied ItemFactoryAPI,
	 * develop inner classes:
	 *
	 * ItemFactory, ItemFactoryEnumSingleton,
	 * ItemFactoryEagerSingleton and ItemFactoryLazySingleton
	 *
	 * Using Factory design pattern and supplied OrderComponentFactoryAPI,
	 * develop inner classes:
	 *
	 * IndividualOrderComponentFactory, IndividualOrderComponentFactoryEnumSingleton,
	 * IndividualOrderComponentFactoryEagerSingleton and IndividualOrderComponentFactoryLazySingleton
	 *
	 * ComboOrderComponentFactory, ComboOrderComponentFactoryEnumSingleton,
	 * ComboOrderComponentFactoryEagerSingleton and ComboOrderComponentFactoryLazySingleton
	 *
	 */

	public static class Factory {

		/**
		 * ItemFactoryAPI for Factory method design pattern
		 *
		 * @author dpeters
		 */
		private interface ItemFactoryAPI {
			ItemAPI getObject();

			ItemAPI getObject(Item.ItemBuilder b);
		}

		/**
		 * OrderComponentFactoryAPI for Factory method design pattern
		 *
		 * @author dpeters
		 */

		private interface OrderFactoryAPI {
			OrderAPI getObject();

			OrderAPI getObject(OrderBuilderAPI b);
		}

		/**
		 * ItemFactory using the Factory Method pattern
		 */
		private static class ItemFactory implements ItemFactoryAPI {

			@Override
			public ItemAPI getObject() {
				return new Item();
			}

			@Override
			public ItemAPI getObject(Item.ItemBuilder b) {
				return new Item(b);
			}
		}

		/**
		 * ItemFactoryEnumSingleton using the Factory Method pattern and the Singleton pattern with an enum
		 */
		private enum ItemFactoryEnumSingleton implements ItemFactoryAPI {
			;
			public static ItemFactoryEagerSingleton instance;

			@Override
			public ItemAPI getObject() {
				return null;
			}

			@Override
			public ItemAPI getObject(Item.ItemBuilder b) {
				return null;
			}
		}

		/**
		 * ItemFactoryEagerSingleton using the Factory Method pattern and the Singleton pattern with eager initialization
		 */
		private static class ItemFactoryEagerSingleton implements ItemFactoryAPI {
			private static final ItemFactoryEagerSingleton instance = new ItemFactoryEagerSingleton();

			private static ItemFactoryEagerSingleton getInstance() {
				return instance;
			}

			@Override
			public ItemAPI getObject() {
				return new Item();
			}

			@Override
			public ItemAPI getObject(Item.ItemBuilder b) {
				return new Item(b);
			}
		}

		/**
		 * ItemFactoryLazySingleton using the Factory Method pattern and the Singleton pattern with lazy initialization
		 */
		private static class ItemFactoryLazySingleton implements ItemFactoryAPI {
			private static ItemFactoryLazySingleton instance;

			private ItemFactoryLazySingleton() {
			}

			public static synchronized ItemFactoryLazySingleton getInstance() {
				if (instance == null) {
					instance = new ItemFactoryLazySingleton();
				}
				return instance;
			}

			@Override
			public ItemAPI getObject() {
				return new Item();
			}

			@Override
			public ItemAPI getObject(Item.ItemBuilder b) {
				return new Item(b);
			}
		}

		/**
		 * IndividualOrderFactory using the Factory Method pattern
		 */
		private static class IndividualOrderFactory implements OrderFactoryAPI {
			@Override
			public OrderAPI getObject() {
				return new IndividualOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new IndividualOrder((IndividualOrder.IndividualOrderBuilder) b);
			}
		}

		/**
		 * IndividualOrderFactoryEnumSingleton using the Factory Method pattern
		 */
		private static class IndividualOrderFactoryEnumSingleton implements OrderFactoryAPI{

			private IndividualOrderFactoryEnumSingleton instance;

			@Override
			public OrderAPI getObject() {
				return new IndividualOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new IndividualOrder((IndividualOrder.IndividualOrderBuilder) b);
			}
		}

		/**
		 * IndividualOrderFactoryEagerSingleton using the Factory Method pattern
		 */
		private static class IndividualOrderFactoryEagerSingleton implements OrderFactoryAPI{

			private static IndividualOrderFactoryEagerSingleton instance = new IndividualOrderFactoryEagerSingleton();

			public static IndividualOrderFactoryEagerSingleton getInstance(){
				return instance;
			}

			@Override
			public OrderAPI getObject() {
				return new IndividualOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new IndividualOrder((IndividualOrder.IndividualOrderBuilder) b);
			}
		}

		/**
		 * IndividualOrderFactoryLazySingleton using the Factory Method pattern
		 */
		private static class IndividualOrderFactoryLazySingleton implements OrderFactoryAPI{

			private static IndividualOrderFactoryLazySingleton instance;

			public static synchronized IndividualOrderFactoryLazySingleton getInstance(){
				if (instance == null) {
					instance = new IndividualOrderFactoryLazySingleton();
				}
				return instance;
			}

			@Override
			public OrderAPI getObject() {
				return new IndividualOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new IndividualOrder((IndividualOrder.IndividualOrderBuilder) b);
			}
		}



		/**
		 * ComboOrderFactory using the Factory Method pattern
		 */
		private static class ComboOrderFactory implements OrderFactoryAPI {
			@Override
			public OrderAPI getObject() {
				return new ComboOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new ComboOrder((ComboOrder.ComboOrderBuilder) b);
			}
		}

		/**
		 * ComboOrderFactoryEnumSingleton using the Factory Method pattern
		 */
		private static class ComboOrderFactoryEnumSingleton implements OrderFactoryAPI{

			private ComboOrderFactoryEnumSingleton instance;

			@Override
			public OrderAPI getObject() {
				return new ComboOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new ComboOrder((ComboOrder.ComboOrderBuilder) b);
			}
		}

		/**
		 * ComboOrderFactoryEagerSingleton using the Factory Method pattern
		 */
		private static class ComboOrderFactoryEagerSingleton implements OrderFactoryAPI{

			private static ComboOrderFactoryEagerSingleton instance = new ComboOrderFactoryEagerSingleton();

			public static ComboOrderFactoryEagerSingleton getInstance(){
				return instance;
			}

			@Override
			public OrderAPI getObject() {
				return new ComboOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new ComboOrder((ComboOrder.ComboOrderBuilder) b);
			}
		}

		/**
		 * ComboOrderFactoryLazySingleton using the Factory Method pattern
		 */
		private static class ComboOrderFactoryLazySingleton implements OrderFactoryAPI{

			private ComboOrderFactoryLazySingleton instance;

			public synchronized ComboOrderFactoryLazySingleton getInstance(){
				if (instance == null) {
					instance = new ComboOrderFactoryLazySingleton();
				}
				return instance;
			}

			@Override
			public OrderAPI getObject() {
				return new ComboOrder();
			}

			@Override
			public OrderAPI getObject(OrderBuilderAPI b) {
				return new ComboOrder((ComboOrder.ComboOrderBuilder) b);
			}
		}
	}

	/**
	 * Student ToDO:
	 * Strategy Design Pattern:
	 *
	 * Using Strategy design pattern to change retail prices:
	 * NormalDiscount (0% decrease), MemberDiscount (10% decrease),
	 * SpecialDiscount (20% discount), SuperBowlDiscount (20% increase)
	 */

	public interface DiscountStrategy {
		double applyDiscount(double price);
	}

	public static class NormalDiscount implements DiscountStrategy {
		@Override
		public double applyDiscount(double price) {
			return price;
		}

		@Override
		public String toString(){
			return "Normal Discount \n";
		}
	}

	public static class MemberDiscount implements DiscountStrategy {
		@Override
		public double applyDiscount(double price) {
			return price * 0.9;
		}
	}

	public static class SpecialDiscount implements DiscountStrategy {
		@Override
		public double applyDiscount(double price) {
			return price * 0.8;
		}
	}

	public static class SuperBowlDiscount implements DiscountStrategy {
		@Override
		public double applyDiscount(double price) {
			return price * 1.2;
		}
	}

	/**
	 * Student ToDO:
	 * Bridge Design Pattern:
	 *
	 * Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices):
	 * Using Bridge design pattern to in TWO design phases
	 * developing inner interfaces PosAPI1, PosAPI2, CalculatorAPI1, CalculatorAPI2 and
	 * developing inner classes Pos1, Pos2, Calculator1 and Calculator2
	 *
	 */


	// Phase 1: Define the interfaces for the Point of Sale and Calculator APIs
	private interface PosAPI1 {
		void sumTotal(List<Double> asList);

		void setStrategy(DiscountStrategy discountStrategy);
	}

	private interface PosAPI2 {
		void sumTotal(List<Double> asList);

		void setStrategy(DiscountStrategy discountStrategy);

		void getChange(double v);
	}

	private interface CalculatorAPI1 {
		double calculatePrice(DiscountStrategy discountStrategy, double price);

		void add(double a, double b);
	}

	private interface CalculatorAPI2 {
		double calculatePrice(DiscountStrategy discountStrategy, double price);

		void div(double a, double b);

		void mult(double a, double b);

		void add(double a, double b);

		void sub(double a, double b);
	}

	// Phase 2: Implement the inner classes for the Point of Sale and Calculator APIs
	private static class Pos1 implements PosAPI1 {
		private CalculatorAPI1 calculator;
		private DiscountStrategy strategy;
		private double totalPrice;

		public Pos1(CalculatorAPI1 currCalculator) {
			this.calculator = currCalculator;
		}


		public void sumTotal(List<Double> asList) {
			totalPrice = 0.0;

			for (Double price : asList) {
				totalPrice += this.calculator.calculatePrice(this.strategy, price);
			}

			System.out.println("Sum of order: " + totalPrice);
		}

		@Override
		public void setStrategy(DiscountStrategy discountStrategy) {
			this.strategy = discountStrategy;
		}


	}

	private static class Pos2 implements PosAPI2 {
		private CalculatorAPI2 calculator;
		private DiscountStrategy strategy;
		private double totalPrice;

		public Pos2(CalculatorAPI2 currCalculator) {
			this.calculator = currCalculator;
		}

		public void sumTotal(List<Double> asList) {
			totalPrice = 0.0;

			for (Double price : asList) {
				totalPrice += this.calculator.calculatePrice(this.strategy, price);
			}
			System.out.println("Sum of order: " + totalPrice);
		}

		@Override
		public void setStrategy(DiscountStrategy discountStrategy) {
			this.strategy = discountStrategy;
		}

		@Override
		public void getChange(double v) {
			double change = v - totalPrice;
			System.out.println("Change: " + change);
		}

	}

	private static class Calculator1 implements CalculatorAPI1 {

		double a,b,price,result;
		@Override
		public double calculatePrice(DiscountStrategy discountStrategy, double p) {
			if (discountStrategy != null){
				this.price = discountStrategy.applyDiscount(p);
				return this.price;
			}
			return p;
		}

		@Override
		public void add(double a, double b) {
			this.a = a;
			this.b = b;
			this.result = a+b;
		}

		@Override
		public String toString(){
			return "Addition of " + a + " and " + b + " is " + result;
		}
	}

	private static class Calculator2 implements CalculatorAPI2 {
		double A,B,res,price;
		@Override
		public double calculatePrice(DiscountStrategy discountStrategy, double p) {
			if (discountStrategy != null){
				this.price = discountStrategy.applyDiscount(p);
				return this.price;
			}
			return p;
		}

		@Override
		public void div(double a, double b) {
			this.A = a;
			this.B = b;
			this.res = a / b;
			System.out.println("Division of " + a + " and " + b + " is: ");
		}

		@Override
		public void mult(double a, double b) {
			this.A = a;
			this.B = b;
			this.res = a * b;
			System.out.println("Multiplication of " + a + " and " + b + " is: ");
		}

		@Override
		public void add(double a, double b) {
			this.A = a;
			this.B = b;
			this.res = a + b;
			System.out.println("Addition of " + a + " and " + b + " is: ");
		}

		@Override
		public void sub(double a, double b) {
			this.A = a;
			this.B = b;
			this.res = a - b;
			System.out.println("Subtraction of " + b + " from " + a + " is: ");
		}

		@Override
		public String toString(){
			return res+ "\t";
		}
	}


	/**
	 * Testing Code for DoorDash class
	 */


	/**
	 * test Point of Sale (POS) Bridge Abstraction Phase I Pos1 (Calculator1) and Phase II Pos2 (Calculator2)
	 */
	public static void demoPos(Double... a) {
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoPos()...");
		{
			System.out.println("TESTING Pos1 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");
			Pos1 obj = new Pos1(new Calculator1());

			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 0% Normal Discount");
			obj.setStrategy(new NormalDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 10% Member Discount");
			obj.setStrategy(new MemberDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 20% Special Discount");
			obj.setStrategy(new SpecialDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 20% SuperBowl MarkUp");
			obj.setStrategy(new SuperBowlDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
		}
		{
			System.out.println("TESTING Pos2 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");

			Pos2 obj = new Pos2(new Calculator2());

			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 10% Normal Discount");
			obj.setStrategy(new NormalDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 10% Member Discount");
			obj.setStrategy(new MemberDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 20% Special Discount");
			obj.setStrategy(new SpecialDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 20% SuperBowl MarkUp");
			obj.setStrategy(new SuperBowlDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
		}
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoPos()... done!");
	}

	/**
	 * test the Point of Sale (POS) Bridge Abstraction
	 */
	public static void testPos() {
		System.out.println("\n\t" + DoorDash.class.getName() + ".testPos()...");

		/*
		 * Using:	1.1,2.2,3.1
		 * Test Pos1: sumTotal
		 * Test Pos2: getChange
		 */
		Double array[] = { 1.1, 2.2, 3.3 };

		DoorDash.demoPos(array);

		System.out.println("\n\t" + DoorDash.class.getName() + ".testPos()... done!");
	}

	/**
	 * test Point of Sale (POS) Bridge Implementor
	 */
	public static void testCalculator() {
		System.out.println("\n\t" + DoorDash.class.getName() + ".testCalculator()...");

		/*
		 * Using:	a = 4.2, b = 2.1
		 * Test Calculator1: add
		 * Test Calculator2: sub, mult, div
		 */
		double a = 4.2;
		double b = 2.1;
		DoorDash.demoCalculator(a, b);

		System.out.println("\n\t" + DoorDash.class.getName() + ".testCalculator()... done!");
	}

	/**
	 * test Point of Sale Bridge (POS) Implementor Phase I Calculator1 and Phase II Calculator2
	 */
	public static void demoCalculator(double a, double b) {
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculator()...");
		{
			System.out.println("TESTING Calculator1 (add " + a + "," + b + "):...");
			Calculator1 obj = new Calculator1();
			obj.add(a, b);
			System.out.println(obj);
		}
		{
			System.out.println("TESTING Calculator2 (add,sub,mult,div " + a + "," + b + "):...");
			Calculator2 obj = new Calculator2();
			obj.add(a, b);
			System.out.println(obj);
			obj.sub(a, b);
			System.out.println(obj);
			obj.mult(a, b);
			System.out.println(obj);
			obj.div(a, b);
			System.out.println(obj);
		}
		System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculator()... done!");
	}

	/**
	 * Final method to consolidate total value of all Orders using Pos1 and Pos2 API
	 */
	public static void demoCalculateAllOrders() {

		System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculateAllOrders()");


		Pos1 pos1Obj = new Pos1(new Calculator1());
		Pos2 pos2Obj = new Pos2(new Calculator2());
		List<OrderAPI> orderList = DoorDash.DataSetup();


		System.out.println("\n\n**********************Generating Order totals with Pos1*************************\n");

		for (OrderAPI order: orderList) {
			double a = order.getPrice();
			System.out.println("\n"+order.getName()+" - "+order.getDescription()+"\n");

			pos1Obj.sumTotal(Arrays.asList(a));

			System.out.println("applying 0% Normal Discount");
			pos1Obj.setStrategy(new NormalDiscount());
			pos1Obj.sumTotal(Arrays.asList(a));

			System.out.println("applying 10% Member Discount");
			pos1Obj.setStrategy(new MemberDiscount());
			pos1Obj.sumTotal(Arrays.asList(a));

			System.out.println("applying 20% Special Discount");
			pos1Obj.setStrategy(new SpecialDiscount());
			pos1Obj.sumTotal(Arrays.asList(a));

			System.out.println("applying 20% SuperBowl MarkUp");
			pos1Obj.setStrategy(new SuperBowlDiscount());
			pos1Obj.sumTotal(Arrays.asList(a));
		}

		System.out.println("\n\n**********************Generating Order totals with Pos2*************************\n");

		for (OrderAPI order: orderList) {
			double a = order.getPrice();
			System.out.println("\n"+order.getName()+" - "+order.getDescription()+"\n");

			pos2Obj.sumTotal(Arrays.asList(a));

			System.out.println("applying 0% Normal Discount");
			pos2Obj.setStrategy(new NormalDiscount());
			pos2Obj.sumTotal(Arrays.asList(a));
			pos2Obj.getChange(25.0d);

			System.out.println("applying 10% Member Discount");
			pos2Obj.setStrategy(new MemberDiscount());
			pos2Obj.sumTotal(Arrays.asList(a));
			pos2Obj.getChange(25.0d);

			System.out.println("applying 20% Special Discount");
			pos2Obj.setStrategy(new SpecialDiscount());
			pos2Obj.sumTotal(Arrays.asList(a));
			pos2Obj.getChange(25.0d);

			System.out.println("applying 20% SuperBowl MarkUp");
			pos2Obj.setStrategy(new SuperBowlDiscount());
			pos2Obj.sumTotal(Arrays.asList(a));
			pos2Obj.getChange(30.0d);
		}

		System.out.println("\n\t" + DoorDash.class.getName() + ".demoCalculateAllOrders()... done!");


	}

	/**
	 * Method to setup all Item and Order data using Builder, Factory (Enum, Eager & Lazy) & Decorator design patterns.
	 * Items:
	 * 	$ 0.99 French Fries
	 * 	$ 1.29 Medium Drink
	 * 	$ 3.49 Hamburger
	 * 	$ 1.49 Hot Dog
	 * 	$ 3.79 Cheeseburger
	 * 	$ 4.49 Buffalo Wings
	 * 	$ 2.49 Salad
	 * 	$ 5.49 Pizza ($1 OPTIONS: cheese, mushrooms, onions, pepperoni, sausage)
	 *
	 * 	Orders:
	 * 	 Dan's Customer Door Dash Order ID #1 Hamburger, Medium Drink
	 * 	 Pam's Customer Door Dash Order ID #2 HotDogCombo (HotDog, French Fries, Medium Drink)
	 * 	 Jim's Customer Door Dash Order ID #3 BurgerCombo (Hamburger, French Fries, Medium Drink)
	 * 	 Jen's Customer Door Dash Order ID #4 Cheeseburger, French Fries
	 * 	 Len's Customer Door Dash Order ID #5 WingCombo (Buffalo Wings, Medium Drink, Salad)
	 * 	 Sam's Customer Door Dash Order ID #6 PizzaCombo (Buffalo Wings, French Fries, Salad, Medium Drink, Pizza)

	 */

	public static List<OrderAPI> DataSetup() {

		System.out.println("\n\t" + DoorDash.class.getName() + "DataSetup()...");

		List<OrderAPI> orderList = new ArrayList<OrderAPI>();
		ItemAPI cheeseBurger = Factory.ItemFactoryEagerSingleton.getInstance().getObject(new Item.ItemBuilder().setName("Cheeseburger").setPrice(3.79));
		ItemAPI hamBurger = Factory.ItemFactoryEagerSingleton.getInstance().getObject(new Item.ItemBuilder().setName("Hamburger").setPrice(3.49));
		ItemAPI hotDog = Factory.ItemFactoryEagerSingleton.getInstance().getObject(new Item.ItemBuilder().setName("Hot Dog").setPrice(1.49));
		ItemAPI salad = Factory.ItemFactoryEagerSingleton.getInstance().getObject(new Item.ItemBuilder().setName("Salad").setPrice(2.49));
		ItemAPI frenchFries = Factory.ItemFactoryLazySingleton.getInstance().getObject(new Item.ItemBuilder().setName("French Fries").setPrice(0.99));
		ItemAPI mediumDrink = Factory.ItemFactoryLazySingleton.getInstance().getObject(new Item.ItemBuilder().setName("Medium Drink").setPrice(1.29));
		ItemAPI buffaloWings = Factory.ItemFactoryLazySingleton.getInstance().getObject(new Item.ItemBuilder().setName("Buffalo Wings").setPrice(4.49));
		ItemAPI pizza = new OnionDecorator(new SausageDecorator(new PepperoniDecorator(new MushroomsDecorator(new ExtraCheeseDecorator(new PizzaDecorator(new Item.ItemBuilder().setName("Pizza with: ").setPrice(5.49).build()))))));

		//Dan's Order
		OrderBuilderAPI danBuilder = new IndividualOrder.IndividualOrderBuilder().setId(1).setName("Dan's Door Dash Individual Order").addItemToList(hamBurger).addItemToList(mediumDrink).setDescription().setPrice();
		OrderAPI dansOrder = Factory.IndividualOrderFactoryEagerSingleton.getInstance().getObject(danBuilder);
		// Alternatively, dansOrder can be built with the Builder design patter like this:
		// OrderAPI dansOrder = danBuilder.build();
		orderList.add(dansOrder);
		//Pam's Order
		OrderBuilderAPI pamBuilder = new ComboOrder.ComboOrderBuilder().setId(2).setName("Pam's Door Dash Combo Order: HotDogCombo").addItemToList(hotDog).addItemToList(frenchFries).addItemToList(mediumDrink).setDescription().setPrice();
		OrderAPI pamsOrder = Factory.ComboOrderFactoryEagerSingleton.getInstance().getObject(pamBuilder);
		orderList.add(pamsOrder);

		//Jim's Order
		OrderBuilderAPI jimBuilder = new ComboOrder.ComboOrderBuilder().setId(3).setName("Jim's Door Dash Combo Order: BurgerCombo").addItemToList(hamBurger).addItemToList(frenchFries).addItemToList(mediumDrink).setDescription().setPrice();
		OrderAPI jimsOrder = Factory.ComboOrderFactoryEagerSingleton.getInstance().getObject(jimBuilder);
		orderList.add(jimsOrder);

		//Jen's Order
		OrderBuilderAPI jenBuilder = new IndividualOrder.IndividualOrderBuilder().setId(4).setName("Jen's Door Dash Individual Order").addItemToList(cheeseBurger).addItemToList(frenchFries).setDescription().setPrice();
		OrderAPI jensOrder = Factory.IndividualOrderFactoryLazySingleton.getInstance().getObject(jenBuilder);
		orderList.add(jensOrder);

		//Len's Order
		OrderBuilderAPI lenBuilder = new ComboOrder.ComboOrderBuilder().setId(5).setName("Len's Door Dash Combo Order: WingsCombo").addItemToList(buffaloWings).addItemToList(salad).addItemToList(mediumDrink).setDescription().setPrice();
		OrderAPI lensOrder = Factory.ComboOrderFactoryEagerSingleton.getInstance().getObject(lenBuilder);
		orderList.add(lensOrder);

		//Sam's Order
		OrderBuilderAPI samBuilder = new ComboOrder.ComboOrderBuilder().setId(6).setName("Sam's Door Dash Combo Order: PizzaCombo").addItemToList(buffaloWings).addItemToList(frenchFries).addItemToList(salad).addItemToList(mediumDrink).addItemToList(pizza).setDescription().setPrice();
		OrderAPI samsOrder = Factory.ComboOrderFactoryEagerSingleton.getInstance().getObject(samBuilder);
		orderList.add(samsOrder);

		System.out.println("\n\t" + DoorDash.class.getName() + "DataSetup()... done!");

		return orderList;

	}

	/**
	 * demonstrate the use of class DoorDash
	 */
	public static void demo() {

		System.out.println("\n\t" + DoorDash.class.getName() + "demo()...");
		System.out.println(DevelopmentLogEnum.LOG.getDevelopmentLog());

		/**
		 * test Calculator
		 */
		DoorDash.testCalculator();

		/**
		 * test Point of Sale (PoS)
		 */
		DoorDash.testPos();

		/**
		 * Student ToDO:
		 * use Point of Sale (PoS) to total all orders with all discounts
		 */
		DoorDash.demoCalculateAllOrders();


		System.out.println("\n\t" + DoorDash.class.getName() + "demo()... done!");
	}


	/**
	 * Code Output start
	 */
//============Main Execution Start===================
//
//
//
//			edu.neu.csye7374.DoorDashdemo()...
//	DoorDash Development Log 1.0.14
//			1.0: initial version of class created
//1.1: Created skeleton inner interfaces PosAPI1, PosAPI2, CalculatorAPI1, CalculatorAPI2 and inner classes Pos1, Pos2, Calculator1 and Calculator2
//1.2: Created skeleton inner class OrderAdapter that implements ItemAPI and extends Order
//1.3: Created Item class that implements ItemAPI and developed ItemBuilder class within it to set values to an item obj
//1.4: Using Composite and Builder design pattern, developed inner classes: Order, IndividualOrder, IndividualOrderBuilder, ComboOrder and ComboOrderBuilder
//1.5: Created all the factory pattern inner classes
//1.6: Bug Fix - replaced OrderComponent with Order in all mentions while creating factory design patter nclasses
//1.7: Using Strategy design pattern created Discount strategy classes
//1.8: Completed developing Bridge design patterns classes
//1.9: Tested the demo classes implementation
//2.0: Debugged the Pos1, Pos2, Calculator1 & Calculator 2 classes to successfully execute the demo method
//2.1: Built all the Items and Orders using the Builder, Factory(Enum, Lazy & Eager), Decorator design patterns in DataSetup() method
//2.2: Got output of all Orders total costs using pos1 & Pos2
//** End of Log Entry List **
//
//
//			edu.neu.csye7374.DoorDash.testCalculator()...
//
//			edu.neu.csye7374.DoorDash.demoCalculator()...
//	TESTING Calculator1 (add 4.2,2.1):...
//	Addition of 4.2 and 2.1 is 6.300000000000001
//	TESTING Calculator2 (add,sub,mult,div 4.2,2.1):...
//	Addition of 4.2 and 2.1 is:
//			6.300000000000001
//	Subtraction of 2.1 from 4.2 is:
//			2.1
//	Multiplication of 4.2 and 2.1 is:
//			8.82
//	Division of 4.2 and 2.1 is:
//			2.0
//
//			edu.neu.csye7374.DoorDash.demoCalculator()... done!
//
//			edu.neu.csye7374.DoorDash.testCalculator()... done!
//
//			edu.neu.csye7374.DoorDash.testPos()...
//
//			edu.neu.csye7374.DoorDash.demoPos()...
//	TESTING Pos1 (sumTotal(1.1, 2.2, 3.3):...
//	Sum of order: 6.6
//	edu.neu.csye7374.DoorDash$Pos1@34c45dca
//	applying 0% Normal Discount
//	Sum of order: 6.6
//	edu.neu.csye7374.DoorDash$Pos1@34c45dca
//	applying 10% Member Discount
//	Sum of order: 5.9399999999999995
//	edu.neu.csye7374.DoorDash$Pos1@34c45dca
//	applying 20% Special Discount
//	Sum of order: 5.280000000000001
//	edu.neu.csye7374.DoorDash$Pos1@34c45dca
//	applying 20% SuperBowl MarkUp
//	Sum of order: 7.92
//	edu.neu.csye7374.DoorDash$Pos1@34c45dca
//	TESTING Pos2 (sumTotal(1.1, 2.2, 3.3):...
//	Sum of order: 6.6
//	Change: 13.4
//	edu.neu.csye7374.DoorDash$Pos2@506e1b77
//	applying 10% Normal Discount
//	Sum of order: 6.6
//	Change: 13.4
//	edu.neu.csye7374.DoorDash$Pos2@506e1b77
//	applying 10% Member Discount
//	Sum of order: 5.9399999999999995
//	Change: 14.06
//	edu.neu.csye7374.DoorDash$Pos2@506e1b77
//	applying 20% Special Discount
//	Sum of order: 5.280000000000001
//	Change: 14.719999999999999
//	edu.neu.csye7374.DoorDash$Pos2@506e1b77
//	applying 20% SuperBowl MarkUp
//	Sum of order: 7.92
//	Change: 12.08
//	edu.neu.csye7374.DoorDash$Pos2@506e1b77
//
//	edu.neu.csye7374.DoorDash.demoPos()... done!
//
//			edu.neu.csye7374.DoorDash.testPos()... done!
//
//			edu.neu.csye7374.DoorDash.demoCalculateAllOrders()
//
//			edu.neu.csye7374.DoorDashDataSetup()...
//
//			edu.neu.csye7374.DoorDashDataSetup()... done!
//
//
//			**********************Generating Order totals with Pos1*************************
//
//
//	Dan's Door Dash Individual Order - 	Hamburger	Medium Drink
//
//	Sum of order: 4.78
//	applying 0% Normal Discount
//	Sum of order: 4.78
//	applying 10% Member Discount
//	Sum of order: 4.3020000000000005
//	applying 20% Special Discount
//	Sum of order: 3.8240000000000003
//	applying 20% SuperBowl MarkUp
//	Sum of order: 5.736
//
//	Pam's Door Dash Combo Order: HotDogCombo - ( Hot Dog , French Fries , Medium Drink ,  )
//
//	Sum of order: 4.524
//	applying 0% Normal Discount
//	Sum of order: 3.77
//	applying 10% Member Discount
//	Sum of order: 3.3930000000000002
//	applying 20% Special Discount
//	Sum of order: 3.016
//	applying 20% SuperBowl MarkUp
//	Sum of order: 4.524
//
//	Jim's Door Dash Combo Order: BurgerCombo - ( Hamburger , French Fries , Medium Drink ,  )
//
//	Sum of order: 6.924
//	applying 0% Normal Discount
//	Sum of order: 5.7700000000000005
//	applying 10% Member Discount
//	Sum of order: 5.1930000000000005
//	applying 20% Special Discount
//	Sum of order: 4.6160000000000005
//	applying 20% SuperBowl MarkUp
//	Sum of order: 6.924
//
//	Jen's Door Dash Individual Order - 	Cheeseburger	French Fries
//
//	Sum of order: 5.736
//	applying 0% Normal Discount
//	Sum of order: 4.78
//	applying 10% Member Discount
//	Sum of order: 4.3020000000000005
//	applying 20% Special Discount
//	Sum of order: 3.8240000000000003
//	applying 20% SuperBowl MarkUp
//	Sum of order: 5.736
//
//	Len's Door Dash Combo Order: WingsCombo - ( Buffalo Wings , Salad , Medium Drink ,  )
//
//	Sum of order: 9.924
//	applying 0% Normal Discount
//	Sum of order: 8.27
//	applying 10% Member Discount
//	Sum of order: 7.443
//	applying 20% Special Discount
//	Sum of order: 6.616
//	applying 20% SuperBowl MarkUp
//	Sum of order: 9.924
//
//	Sam's Door Dash Combo Order: PizzaCombo - ( Buffalo Wings , French Fries , Salad , Medium Drink , Pizza with:  Extra Cheese Mushrooms Pepperoni Sausage Onions ,  )
//
//	Sum of order: 23.7
//	applying 0% Normal Discount
//	Sum of order: 19.75
//	applying 10% Member Discount
//	Sum of order: 17.775000000000002
//	applying 20% Special Discount
//	Sum of order: 15.8
//	applying 20% SuperBowl MarkUp
//	Sum of order: 23.7
//
//
//			**********************Generating Order totals with Pos2*************************
//
//
//	Dan's Door Dash Individual Order - 	Hamburger	Medium Drink
//
//	Sum of order: 4.78
//	applying 0% Normal Discount
//	Sum of order: 4.78
//	Change: 20.22
//	applying 10% Member Discount
//	Sum of order: 4.3020000000000005
//	Change: 20.698
//	applying 20% Special Discount
//	Sum of order: 3.8240000000000003
//	Change: 21.176
//	applying 20% SuperBowl MarkUp
//	Sum of order: 5.736
//	Change: 24.264
//
//	Pam's Door Dash Combo Order: HotDogCombo - ( Hot Dog , French Fries , Medium Drink ,  )
//
//	Sum of order: 4.524
//	applying 0% Normal Discount
//	Sum of order: 3.77
//	Change: 21.23
//	applying 10% Member Discount
//	Sum of order: 3.3930000000000002
//	Change: 21.607
//	applying 20% Special Discount
//	Sum of order: 3.016
//	Change: 21.984
//	applying 20% SuperBowl MarkUp
//	Sum of order: 4.524
//	Change: 25.476
//
//	Jim's Door Dash Combo Order: BurgerCombo - ( Hamburger , French Fries , Medium Drink ,  )
//
//	Sum of order: 6.924
//	applying 0% Normal Discount
//	Sum of order: 5.7700000000000005
//	Change: 19.23
//	applying 10% Member Discount
//	Sum of order: 5.1930000000000005
//	Change: 19.807
//	applying 20% Special Discount
//	Sum of order: 4.6160000000000005
//	Change: 20.384
//	applying 20% SuperBowl MarkUp
//	Sum of order: 6.924
//	Change: 23.076
//
//	Jen's Door Dash Individual Order - 	Cheeseburger	French Fries
//
//	Sum of order: 5.736
//	applying 0% Normal Discount
//	Sum of order: 4.78
//	Change: 20.22
//	applying 10% Member Discount
//	Sum of order: 4.3020000000000005
//	Change: 20.698
//	applying 20% Special Discount
//	Sum of order: 3.8240000000000003
//	Change: 21.176
//	applying 20% SuperBowl MarkUp
//	Sum of order: 5.736
//	Change: 24.264
//
//	Len's Door Dash Combo Order: WingsCombo - ( Buffalo Wings , Salad , Medium Drink ,  )
//
//	Sum of order: 9.924
//	applying 0% Normal Discount
//	Sum of order: 8.27
//	Change: 16.73
//	applying 10% Member Discount
//	Sum of order: 7.443
//	Change: 17.557000000000002
//	applying 20% Special Discount
//	Sum of order: 6.616
//	Change: 18.384
//	applying 20% SuperBowl MarkUp
//	Sum of order: 9.924
//	Change: 20.076
//
//	Sam's Door Dash Combo Order: PizzaCombo - ( Buffalo Wings , French Fries , Salad , Medium Drink , Pizza with:  Extra Cheese Mushrooms Pepperoni Sausage Onions ,  )
//
//	Sum of order: 23.7
//	applying 0% Normal Discount
//	Sum of order: 19.75
//	Change: 5.25
//	applying 10% Member Discount
//	Sum of order: 17.775000000000002
//	Change: 7.224999999999998
//	applying 20% Special Discount
//	Sum of order: 15.8
//	Change: 9.2
//	applying 20% SuperBowl MarkUp
//	Sum of order: 23.7
//	Change: 6.300000000000001
//
//			edu.neu.csye7374.DoorDash.demoCalculateAllOrders()... done!
//
//			edu.neu.csye7374.DoorDashdemo()... done!
//
//
//			============Main Execution End===================
//
//	Process finished with exit code 0

	/**
	 * Code Output End
	 */


}
