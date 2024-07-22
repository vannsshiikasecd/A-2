import java.util.ArrayList;


class PCComponent {
    private String name;
    private double price;

    public PCComponent(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


class CPU extends PCComponent {
    public CPU(String name, double price) {
        super(name, price);
    }
}


class GPU extends PCComponent {
    public GPU(String name, double price) {
        super(name, price);
    }
}


class RAM extends PCComponent {
    public RAM(String name, double price) {
        super(name, price);
    }
}


class Storage extends PCComponent {
    public Storage(String name, double price) {
        super(name, price);
    }
}


class PCSetup {
    private ArrayList<PCComponent> components;
    private String caseSize;
    private boolean rgbLighting;
    private boolean liquidCooling;

    public PCSetup(String caseSize, boolean rgbLighting, boolean liquidCooling) {
        this.components = new ArrayList<>();
        this.caseSize = caseSize;
        this.rgbLighting = rgbLighting;
        this.liquidCooling = liquidCooling;
    }

    public void addComponent(PCComponent component) {
        components.add(component);
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        
        for (PCComponent component : components) {
            totalCost += component.getPrice();
        }

        
        switch (caseSize.toLowerCase()) {
            case "small":
                totalCost += 50;
                break;
            case "medium":
                totalCost += 70;
                break;
            case "large":
                totalCost += 100;
                break;
        }

        
        if (rgbLighting) {
            totalCost += 30;
        }
        if (liquidCooling) {
            totalCost += 150;
        }

        return totalCost;
    }

    public void displaySetup() {
        System.out.println("PC Setup:");
        for (PCComponent component : components) {
            System.out.println("- " + component.getName() + ": $" + component.getPrice());
        }
        System.out.println("Case Size: " + caseSize);
        System.out.println("RGB Lighting: " + (rgbLighting ? "Yes" : "No"));
        System.out.println("Liquid Cooling: " + (liquidCooling ? "Yes" : "No"));
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
}


public class a2 {
    public static void main(String[] args) {
        
        PCSetup setup1 = new PCSetup("Medium", true, false);
        setup1.addComponent(new CPU("Intel i9", 500));
        setup1.addComponent(new GPU("NVIDIA RTX 3080", 700));
        setup1.addComponent(new RAM("16GB DDR4", 100));
        setup1.addComponent(new Storage("1TB SSD", 150));
        setup1.displaySetup();
        System.out.println();

        
        PCSetup setup2 = new PCSetup("Large", false, true);
        setup2.addComponent(new CPU("AMD Ryzen 9", 450));
        setup2.addComponent(new GPU("AMD Radeon RX 6800", 600));
        setup2.addComponent(new RAM("32GB DDR4", 200));
        setup2.addComponent(new Storage("2TB HDD", 100));
        setup2.displaySetup();
    }
}
