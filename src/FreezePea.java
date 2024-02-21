import java.awt.*;

public class FreezePea extends Pea {
	
    private static int totalZombiesKilled = 0;


    public FreezePea(GamePanel parent, int lane, int startX) {
        super(parent, lane, startX);
    }

    @Override
    public void advance() {
        Rectangle pRect = new Rectangle(getPosX(), 130 + getMyLane() * 120, 28, 28);

        for (int i = 0; i < gp.getLaneZombies().get(getMyLane()).size(); i++) {
            Zombie z = gp.getLaneZombies().get(getMyLane()).get(i);
            Rectangle zRect = new Rectangle(z.getPosX(), 109 + getMyLane() * 120, 400, 120);

            if (pRect.intersects(zRect)) {
                if (z.getPosX() > getPosX()) {
                    z.setHealth(z.getHealth() - 10000);
                    z.slow();
                    boolean exit = false;

                    if (z.getHealth() < 0) {
                        System.out.println("ZOMBIE DIE");
                        GamePanel.setProgress(10);
                        gp.getLaneZombies().get(getMyLane()).remove(i);
                        totalZombiesKilled++; 
                        gp.zombieDied();  // Call the method to update total zombie count
// Increment the total count

                        exit = true;
                    }

                    gp.getLanePeas().get(getMyLane()).remove(this);
                    if (exit) break;
                }
            }
        }

        setPosX(getPosX() + 15);
    }
    public static int getTotalZombiesKilled() {
        return totalZombiesKilled;
    }
}
