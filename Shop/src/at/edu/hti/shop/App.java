
package at.edu.hti.shop;

import at.edu.hti.shop.domain.IPriceStrategy;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.SimplePricingWithMinimumCosts;
import at.edu.hti.shop.domain.cathegory.Chemical;
import at.edu.hti.shop.domain.cathegory.Food;
import at.edu.hti.shop.domain.cathegory.ICathegory;
import at.edu.hti.shop.domain.cathegory.Tool;

public class App {
  public static void main(String[] args) {

    ICathegory tool = new Tool();
    ICathegory food = new Food();
    ICathegory chemical = new Chemical();
    IPriceStrategy pricing = new SimplePricingWithMinimumCosts();
    Order shopOrder = new Order(pricing);

    OrderLine line1 = new OrderLine(new Product(1, "Äpfel", 1.2, food, 1, 2), 4);
    OrderLine line2 = new OrderLine(new Product(2, "Birnen", 1.5, food, 1, 2), 2);

    OrderLine line3 = new OrderLine(new Product(3, "Pfirsich", 2.2, food, 1, 2), 5);
    OrderLine line4 = new OrderLine(new Product(4, "Kiwi", 3.5, food, 1, 3), 6);
    OrderLine line5 = new OrderLine(new Product(5, "Zange", 3.5, tool, 2, 3), 6);
    OrderLine line6 = new OrderLine(new Product(6, "Putzmittel", 3.5, chemical, 1, 4), 6);

    shopOrder.add(line1);
    shopOrder.add(line2);
    System.out.println(shopOrder.getLineAmount());
    System.out.println(shopOrder);

    //shopOrder.get(0).setAmount(8);
    shopOrder.changeAmount("Äpfel", 8);
    System.out.println(shopOrder.getLineAmount());
    System.out.println(shopOrder);

    //shopOrder.get(1).setAmount(0);
    //shopOrder.changeAmount("Birnen", 0);
    System.out.println(shopOrder.getLineAmount());
    System.out.println(shopOrder);

    shopOrder.add(line3);
    shopOrder.add(line4);

    shopOrder.add(line5);
    shopOrder.add(line6);
    System.out.println(shopOrder);
    shopOrder.createShipments();
    System.out.println(shopOrder.printShipments());
  }
}
