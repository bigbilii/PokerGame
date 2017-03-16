import java.util.*;

/*
 * Created by bigbilii on 17-3-15.
 */

/*
 * 扑克比大小游戏
 * 规则: 一副扑克，出去大小王一共62张，默认为固定顺序。游戏一共两名玩家，游戏开始时，进行一次洗牌，并将牌顶依次发牌，每名玩家两张牌
 * 胜负为手牌中最大的点数比大小，默认34...JQKA2从小到大，数值相同比较花色，从小到大黑红梅方。
 * 主要练习Java集合框架的一些东西
 */
public class Player {

    String name;
    List<Poker> pokers;


    public Player(String name) {
        this.name = name;
        pokers = new ArrayList<Poker>();
    }

    public static int copare(Player player1, Player player2) {
        Collections.sort(player1.pokers);
        Collections.sort(player2.pokers);
        Poker MaxPoker1 = player1.pokers.get(1);
        Poker MaxPoker2 = player2.pokers.get(1);
        return MaxPoker1.compareTo(MaxPoker2);
    }

    public static void print(Player player) {
        System.out.print(player.name + " ");
        for(Poker s : player.pokers) {
            System.out.print(" ," + s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box box = new Box();

        while(true) {
            System.out.print("start game (y/n)");
            String chose = scanner.next();
            if(chose.equals("n")) {
                break;
            }

            System.out.print("输入用户1 id：");
            Player player1 = new Player(scanner.next());
            System.out.print("输入用户2 id：");
            Player player2 = new Player(scanner.next());
            System.out.println("****************************************************");

            box.initBox();
            box.washBox();
            System.out.println("洗牌成功");
            System.out.println("发牌开始");
            player1.pokers.add(box.sendPoker());
            player2.pokers.add(box.sendPoker());
            player1.pokers.add(box.sendPoker());
            player2.pokers.add(box.sendPoker());
            if(copare(player1, player2) > 0) {
                System.out.println(player1.name + "   WIN!");
            } else if(copare(player1, player2) < 0) {
                System.out.println(player2.name + "   WIN!");
            } else {
                System.out.println("平局");
            }
            System.out.println("发牌情况：");
            print(player1);
            print(player2);
        }
        System.out.println("end game");
    }
}
