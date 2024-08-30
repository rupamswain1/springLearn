package in.rupam;

public class Alien {
    private int lines;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    private Laptop laptop;
    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }


    public void coding(){
        System.out.println("Coding...");
        laptop.compile();
    }
}
