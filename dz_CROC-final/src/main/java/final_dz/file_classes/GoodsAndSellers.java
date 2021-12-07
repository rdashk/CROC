package final_dz.file_classes;

public class GoodsAndSellers {

    private int id_seller;
    private int id_goods;
    private double price;
    private int amount;

    public GoodsAndSellers(int id_seller, int id_goods, double price, int amount) {
        this.id_seller = id_seller;
        this.id_goods = id_goods;
        this.price = price;
        this.amount = amount;
    }

    public int getId_seller() {
        return id_seller;
    }

    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }

    public int getId_goods() {
        return id_goods;
    }

    public void setId_goods(int id_goods) {
        this.id_goods = id_goods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
