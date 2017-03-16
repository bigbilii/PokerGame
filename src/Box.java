import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Created by bigbilii on 17-3-13.
 */
public class Box {

    private List<Poker> list;

    public Box() {
        this.list = new ArrayList<Poker>();

    }

    public void initBox() {
        for(int i = 0; i < Poker.colorNum.length; i++) {
            for(int j = 0; j < Poker.valueNum.length; j++) {
                list.add(new Poker(Poker.valueNum[j], Poker.colorNum[i]));
            }
        }
    }

    public void washBox() {
        Collections.shuffle(list);
    }

    public Poker sendPoker() {
        Poker poker = list.get(1);
        list.remove(1);
        return poker;
    }
}
