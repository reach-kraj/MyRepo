package advancejava;

public class NestedClass {
    private String outerField = "Outer field";

    // Static nested class
    public static class StaticNestedClass {
        public void display() {
            System.out.println("Inside static nested class");
            // Cannot access non-static members of the outer class
            // System.out.println(outerField); // This would cause a compile-time error
        }
    }

    // Inner class
    public class InnerClass {
        public void display() {
            System.out.println("Inside inner class");
            // Can access non-static members of the outer class
            System.out.println(outerField);
        }
    }

    public void outerMethod() {
        // Local class (method-local inner class)
        class LocalClass {
            public void display() {
                System.out.println("Inside local class");
                // Can access non-static members of the outer class
                System.out.println(outerField);
            }
        }

        LocalClass local = new LocalClass();
        local.display();
    }

    public static void main(String[] args) {
        // Creating an instance of the static nested class
        NestedClass.StaticNestedClass staticNested = new NestedClass.StaticNestedClass();
        staticNested.display();

        // Creating an instance of the inner class
        NestedClass outer = new NestedClass();
        NestedClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // Calling the method that uses the local class
        outer.outerMethod();
    }
}
