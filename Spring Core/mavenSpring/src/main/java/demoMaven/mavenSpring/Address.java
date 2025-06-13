package demoMaven.mavenSpring;

public class Address {
    private int hno;
    private String city;
    private String pcode;

    public Address() {
        System.out.println("Address constructor called.");
    }

    public Address(int hno, String city, String pcode) {
        this.hno = hno;
        this.city = city;
        this.pcode = pcode;
    }

    // Getters and setters
    public int getHno() {
        return hno;
    }

    public void setHno(int hno) {
        this.hno = hno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    @Override
    public String toString() {
        return "Address [hno=" + hno + ", city=" + city + ", pcode=" + pcode + "]";
    }
}
