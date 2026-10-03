class Calculator1 {
    static int count = 0;
    int add(int a, int b) {
        count++;
        return a + b;
    }
    double add(double a, double b) {
        count++;
        return a + b;
    }
    static void display() {
        System.out.println("Total Calculations: " + count);
    }
    public static void main(String[] args) {
        Calculator1 c = new Calculator1();
        System.out.println("Integer Addition: " + c.add(10, 20));
        System.out.println("Decimal Addition: " + c.add(10.5, 20.7));
        System.out.println("Integer Addition: " + c.add(15, 25));
        Calculator1.display();
    }
}




