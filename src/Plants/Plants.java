package Plants;

public class Plants {
    private String name;
    private int sun;
    private int cooldown;
    private int health;

    public void addSun(int suns){
        suns += this.sun;
    }
}
