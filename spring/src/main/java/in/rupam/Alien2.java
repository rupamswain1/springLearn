package in.rupam;

public class Alien2 {
    private int lines;
    private Computer com;

    public int getLines() {
        return lines;
    }

    public Computer getLaptop() {
        return com;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

//    @ConstructorProperties({"line","computer"})
//    public Alien(int lines, Computer com) {
//        this.lines = lines;
//        this.com = com;
//    }

    public void coding(){
        System.out.println("Alien2 Coding...");
        com.compile();
    }
}
