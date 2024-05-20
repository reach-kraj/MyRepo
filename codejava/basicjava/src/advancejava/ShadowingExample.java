package advancejava;

public class ShadowingExample {
    private int x = 0; // Outer class variable

    class InnerClass {
        private int x = 1; // Inner class variable that shadows the outer class variable

        void display() {
            int x = 2; // Local variable that shadows the inner class variable
            System.out.println("Local variable x = " + x); // Prints 2
            System.out.println("Inner class variable x = " + this.x); // Prints 1
            System.out.println("Outer class variable x = " + ShadowingExample.this.x); // Prints 0
        }
    }

    public static void main(String[] args) {
        ShadowingExample outer = new ShadowingExample();
        ShadowingExample.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
