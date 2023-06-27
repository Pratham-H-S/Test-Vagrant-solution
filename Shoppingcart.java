import java.util.*;

class Item {
    String name;
    double price;
    double gst;
    double qty;
    double prodGst;
    double finalPrice;
    double mrpprice;

    Item(String n, double price, double gst, double qty) {
        this.name = n;
        this.price = price;
        this.gst = gst;
        this.qty = qty;
        this.prodGst = (gst / 100) * price;
        this.finalPrice = price + prodGst;
    }
}

public class Shoppingcart {

    public static void main(String[] args) {
        List<Item> pInfo = new ArrayList<Item>();
        Item prod1 = new Item("Leather wallet", 1100, 18, 1);
        pInfo.add(prod1);
        Item prod2 = new Item("Umbrella", 900, 12, 4);
        pInfo.add(prod2);
        Item prod3 = new Item("Cigarette", 200, 28, 3);
        pInfo.add(prod3);
        Item prod4 = new Item("Honey", 100, 0, 2); 
        pInfo.add(prod4);       

        invoice(pInfo);

    }

    public static void invoice(List<Item> plst) {
        
        double total = 0;
        double maxgst = 0;
        double discount = 0;
        double finalAmount = 0;
        String max_gst_name = "";

        for (Item i : plst) {
            total += i.finalPrice * i.qty;
            maxgst = Math.max(maxgst, (i.prodGst) * i.qty);
            if (maxgst == (i.prodGst) * i.qty) {
                max_gst_name = i.name;
            }
        }
        if (total > 500) {
            discount = 0.05 * total;
        }
        finalAmount = total - discount;
        System.out.println("Final amount to be paid after discount = " + finalAmount);
        System.out.println("The product for which we paid maximum GST amount : " + max_gst_name);
    }
}

