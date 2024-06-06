package J8;

public class ClassPractice {
    interface HelloWorld{
        public void greet(String someone);
    }

    /**
     * static Inner Class
     */
    public static class SpanishGreeting implements HelloWorld{
        String name;
        @Override
        public void greet(String someone) {
            name = someone;
            System.out.println("Hello " + name);
        }
    }

    /**
     * nested Inner Class
     */
    public class ItalianGreeting implements HelloWorld{
        String name;
        @Override
        public void greet(String someone) {
            name = someone;
            System.out.println("Hello " + name);
        }
    }
    /**
     * this is an instance method
     */
    public void sayHello() {
        /**
         * Local Inner Class
         */
        class EnglishGreeting implements HelloWorld {
            String name;

            @Override
            public void greet(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
        //end of the local inner class

        /*
         * use the implement to create the object
         */
        HelloWorld englishGreeting = new EnglishGreeting();

        /**
         * Anonymous Inner Class
         */
        //use the implement to create the object
        //we new the HelloWorld, and after it, we give the details of the class in the
        HelloWorld frenchGreeting = new HelloWorld() {
            String name;

            //this is the detail of the class
            @Override
            public void greet(String someone) {
                name = someone;
                System.out.println("hello " + name);
            }

        };
        /*
         * new the Static Inner Class
         */
        HelloWorld spanishGreeting = new SpanishGreeting();
        /*
         * new the nested inner class
         * should use this.new
         */
        HelloWorld ItalianGreeting = this.new ItalianGreeting();

        englishGreeting.greet("English");
        frenchGreeting.greet("French");
        spanishGreeting.greet("Spanish");
        ItalianGreeting.greet("Italian");

    }

    public static void main(String[] args) {
        ClassPractice helloWorld = new ClassPractice();
        helloWorld.sayHello();
    }
}
