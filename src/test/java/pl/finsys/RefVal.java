package pl.finsys;

/**
 * (c) 2013 finsys.pl
 * User: jarek
 * Date: 28.04.13
 * Time: 19:45
 */
public class RefVal {
    private class Dog {
        public String name;

        public Dog(String name) {
            this.name = name;
        }
    }


    public void foo(Dog d) {
        d.name.equals("Max"); // true
        d = new Dog("Fifi");
        d.name.equals("Fifi"); // true
    }

    public static void main(String[] args) {
        RefVal rf = new RefVal();
        rf.go();
    }

    private void go() {
        Dog aDog = new Dog("Max");
        foo(aDog);
        aDog.name.equals("Max"); // true
    }



}
