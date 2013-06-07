
package at.edu.hti.shop.domain;

import at.edu.hti.shop.domain.cathegory.ICathegory;

public class Product {
  private String name;
  private long id;
  private double prize;
  private int weight;
  private int deliveryTime;
  private ICathegory myCathegory;

  public Product(long id, String name, double prize, ICathegory myCathegory, int weight, int deliveryTime) {
    super();
    this.name = name;
    this.id = id;
    this.prize = prize;
    this.myCathegory = myCathegory;
    this.weight = weight;
    this.deliveryTime = deliveryTime;
  }

  public String getName() {
    return name;
  }

  public long getId() {
    return id;
  }

  public double getPrize() {
    return prize;
  }

  @Override
  public String toString() {
    return "Product [" + name + ", " + id + ", " + prize + "]";
  }

  public int getWeight() {
    return weight;
  }

  public int getDeliveryTime() {
    return deliveryTime;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setDeliveryTime(int deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public ICathegory getMyCathegory() {
    return myCathegory;
  }

}
