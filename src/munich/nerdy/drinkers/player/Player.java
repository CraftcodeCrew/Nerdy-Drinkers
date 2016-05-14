package munich.nerdy.drinkers.player;

import com.sun.istack.internal.NotNull;

/**
 * Created by leong on 14.05.2016.
 */
public class Player {

    @NotNull
    private int id;
    private String name;
    private int failed;

    public Player() {
    }

    public Player(int id, String name, int failed) {
        this.id = id;
        this.name = name;
        this.failed = failed;
    }

    public void incrementFailed() {
        setFailed(failed++);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }
}
