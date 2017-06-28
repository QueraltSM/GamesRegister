import java.util.*;

public class RegisteredGames {
    private ArrayList<Game> games = new ArrayList<>();
    private static int order;

    public RegisteredGames(){}

    public boolean add(Game g) {
        for (Game i : games) {
            if (i.equals(g)) return false;
        }
        games.add(g);
        return true;
    }

    public static int getOrder() {
        return order;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public List<Game> getList() {
        Collections.sort(games);
        return games;
    }


    public Set<String> getListPlatforms() {
        SortedSet<String> result = new TreeSet<>();
        setOrder(2);
        Collections.sort(games);

        Map<String, Integer> map = new TreeMap<>();
        for (Game i : games) {
            if (map.get(i.getPlatform()) == null) {
                map.put(i.getPlatform(), 1);
            } else {
                map.put(i.getPlatform(), map.get(i.getPlatform()) +1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getKey() + ":" + entry.getValue());
        }

        return result;

    }
}
