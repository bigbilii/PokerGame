/*
 * Created by bigbilii on 17-3-13.
 */
public class Poker implements Comparable<Poker> {

    private String color;
    private String value;
    public static String valueNum[] = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    public static String colorNum[] = {"黑桃", "红桃", "梅花", "方块"};

    public Poker(String value, String color) {
        this.color = color;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Poker) {
            Poker poker = (Poker) obj;
            if(this.color.equals(poker.color) && this.value.equals(poker.value)) {
                return true;
            } else {
                return false;
            }
        }
        return super.equals(obj);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Poker{" + color + " " + value + '}';
    }

    @Override
    public int compareTo(Poker o) {
        if(compareToValue(this.value, o.value) > 0) {
            return 1;
        }
        if(compareToValue(this.value, o.value) < 0) {
            return -1;
        }
        if(compareToColor(this.color, o.color) > 0) {
            return 1;
        }
        if(Poker.compareToColor(this.color, o.color) > 0) {
            return -1;
        }
        return 0;
    }

    public static int compareToColor(String s1, String s2) {
        int a1 = 0, a2 = 0;
        for(int i = 0; i < colorNum.length; i++) {
            if(s1.equals(colorNum[i])) {
                a1 = i;
            }
            if(s2.equals(colorNum[i])) {
                a2 = i;
            }
        }
        if(a1 > a2) {
            return 1;
        }
        if(a1 < a2) {
            return -1;
        }
        return 0;
    }

    public static int compareToValue(String s1, String s2) {
        int a1 = 0, a2 = 0;
        for(int i = 0; i < valueNum.length; i++) {
            if(s1.equals(valueNum[i])) {
                a1 = i;
            }
            if(s2.equals(valueNum[i])) {
                a2 = i;
            }
        }
        if(a1 > a2) {
            return 1;
        }
        if(a1 < a2) {
            return -1;
        }
        return 0;
    }
}
