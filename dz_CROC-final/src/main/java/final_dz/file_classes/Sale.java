package final_dz.file_classes;

public class Sale {

    private int id_sale;
    private int id_seller;
    private int id_good;
    private int amount;
    private String date;

    public Sale(int id_sale, int id_seller, int id_goods, int amount, String date) {
        this.id_sale = id_sale;
        this.id_seller = id_seller;
        this.id_good = id_goods;
        this.amount = amount;
        this.date = date;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public int getId_seller() {
        return id_seller;
    }

    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }

    public int getId_good() {
        return id_good;
    }

    public void setId_good(int id_good) {
        this.id_good = id_good;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
