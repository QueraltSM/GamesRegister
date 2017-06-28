public class Game implements Comparable <Game> {
    private String title, developer, platform;
    private int age;

    public Game(String title, String developer, String platform , int age) {
        this.title = title;
        this.developer = developer;
        this.platform = platform;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public boolean equals(Game g) {
        return g.getTitle().equals(getTitle()) && g.getPlatform().equals(getPlatform());
    }

    public String toString() {
        return title + " | " + developer + " | " + platform + " | +" + age;
    }

    public int compareTo(Game g) {
        if (RegisteredGames.getOrder() == 0) {
            if (g.getTitle().compareTo(getTitle())<0) {
                return 1;
            } else if (g.getTitle().compareTo(getTitle())>0) {
                return -1;
            }

            if (g.getPlatform().compareTo(getPlatform())<0) {
                return 1;
            } else if (g.getPlatform().compareTo(getPlatform())>0) {
                return -1;
            }
            return 0;

        } else if (RegisteredGames.getOrder() == 1) {

            if (g.getAge()<getAge()) {
                return 1;
            } else if (g.getAge()>getAge()) {
                return -1;
            }

            if (g.getTitle().compareTo(getTitle())<0) {
                return 1;
            } else if (g.getTitle().compareTo(getTitle())>0) {
                return -1;
            }

            if (g.getPlatform().compareTo(getPlatform())<0) {
                return 1;
            } else if (g.getPlatform().compareTo(getPlatform())>0) {
                return -1;
            }
            return 0;

        } else if (RegisteredGames.getOrder() == 2) {

            if (g.getPlatform().compareTo(getPlatform())<0) {
                return 1;
            } else if (g.getPlatform().compareTo(getPlatform())>0) {
                return -1;
            }

            if (g.getTitle().compareTo(getTitle())<0) {
                return 1;
            } else if (g.getTitle().compareTo(getTitle())>0) {
                return -1;
            }

            return 0;

        }
        return -2;
    }

}
