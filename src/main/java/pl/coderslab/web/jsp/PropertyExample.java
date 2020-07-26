package pl.coderslab.web.jsp;

public class PropertyExample {
//    public String pole;
    private String lastName;

    public String getName() { // name
        return lastName;
    }

    public PropertyExample setName(String name) { // name
        this.lastName = name.toUpperCase();
        return this;
    }

    public static void main(String[] args) {
        PropertyExample zmienna = new PropertyExample();
    }
}
