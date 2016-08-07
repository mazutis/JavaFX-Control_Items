package JavaFX;

public class ClassB {
    ClassB1 object1 = new ClassB1();
    private String x =  "Public String x from ClassB";
    public String y =  x;
    public String z = object1.x;


    public void met1() {
        System.out.println("Inside Class B method 1");
    }
    void met2 () {
        System.out.println("Inside Class B method 2");
    }

    public void met3(int x) {
        int z;
        z = x * 2;
        System.out.println("Double x: " + z);
    }

     int met4(int x) {
        int z,y;
        z = x *2;
        return z;
    }

    private class ClassB1 {
        private String x = "Private var x in private inner ClassC";
        public String y = "Public var y in private inner ClassC";

    }
}


