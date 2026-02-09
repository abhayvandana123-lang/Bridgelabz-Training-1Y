class ProductDescription {
    StringBuilder sb = new StringBuilder();

    void addTitle(String title, String sku) {
        sb.append("<h1>").append(title).append("</h1>");
        sb.append("<p>SKU: ").append(sku).append("</p>");
    }

    void addBasicInfo(String category, String brand, String model) {
        sb.append("<p>Category: ").append(category).append("</p>");
        sb.append("<p>Brand: ").append(brand).append("</p>");
        sb.append("<p>Model: ").append(model).append("</p>");
    }

    void addSpecs(String[] specs) {
        sb.append("<h2>Specifications</h2><ul>");
        for (String s : specs) sb.append("<li>").append(s).append("</li>");
        sb.append("</ul>");
    }

    void addFeatures(String[] features) {
        sb.append("<h2>Features</h2><ul>");
        for (String f : features) sb.append("<li>").append(f).append("</li>");
        sb.append("</ul>");
    }

    void addRating(String rating) {
        sb.append("<p>Customer Rating: ").append(rating).append("</p>");
    }

    void addPricing(double original, double discount) {
        double finalPrice = original - discount;
        sb.append("<p>Original Price: ").append(original).append("</p>");
        sb.append("<p>Discount: ").append(discount).append("</p>");
        sb.append("<p>Final Price: ").append(finalPrice).append("</p>");
    }

    void addAvailability(String status) {
        sb.append("<p>Availability: ").append(status).append("</p>");
    }

    void addBanner(String text) {
        sb.append("<h3>").append(text).append("</h3>");
    }

    String build() {
        String result = sb.toString().replace("cheap", "affordable");
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        ProductDescription p1 = new ProductDescription();
        p1.addTitle("Gaming Laptop", "LTP12345");
        p1.addBanner("Limited Time Offer");
        p1.addBasicInfo("Electronics", "TechBrand", "X15");
        p1.addSpecs(new String[]{"16GB RAM","512GB SSD","RTX 4060","15.6 inch","cheap power usage"});
        p1.addFeatures(new String[]{"High performance","RGB Keyboard","Lightweight","Fast charging"});
        p1.addRating("4.5/5");
        p1.addPricing(1200, 200);
        p1.addAvailability("In Stock");

        ProductDescription p2 = new ProductDescription();
        p2.addTitle("Winter Jacket", "JCK56789");
        p2.addBanner("Buy 1 Get 1");
        p2.addBasicInfo("Clothing", "FashionCo", "Arctic");
        p2.addSpecs(new String[]{"Wool blend","Waterproof","Hooded","cheap fabric feel","Thermal lining"});
        p2.addFeatures(new String[]{"Warm","Stylish","Durable","Comfort fit"});
        p2.addRating("4.2/5");
        p2.addPricing(150, 30);
        p2.addAvailability("Limited Stock");

        ProductDescription p3 = new ProductDescription();
        p3.addTitle("Coffee Maker", "CFM24680");
        p3.addBanner("Festive Sale");
        p3.addBasicInfo("Home Appliances", "HomeBrew", "BrewMax");
        p3.addSpecs(new String[]{"1.5L capacity","Auto shutoff","LED display","cheap maintenance","Fast brew"});
        p3.addFeatures(new String[]{"Energy efficient","Compact","Easy cleaning","Programmable"});
        p3.addRating("4.6/5");
        p3.addPricing(200, 50);
        p3.addAvailability("Available");

        String d1 = p1.build();
        String d2 = p2.build();
        String d3 = p3.build();

        System.out.println(d1);
        System.out.println("Length: " + d1.length());
        System.out.println(new StringBuilder("LTP12345").reverse());

        System.out.println(d2);
        System.out.println("Length: " + d2.length());
        System.out.println(new StringBuilder("JCK56789").reverse());

        System.out.println(d3);
        System.out.println("Length: " + d3.length());
        System.out.println(new StringBuilder("CFM24680").reverse());

        int words = (d1 + d2 + d3).split("\\s+").length;
        System.out.println("Reading Time: " + (words / 200.0));
    }
}
