package com.company;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SELECT {

    public static final String TEXT_RESET = "\u001B[0m";

    public static final String TEXT_BLACK = "\u001B[30m";

    public static final String TEXT_BG_PURPLE = "\u001B[45m";

    public static final String TEXT_BRIGHT_BG_BLACK = "\u001B[100m";
    public static final String TEXT_BRIGHT_BG_RED = "\u001B[101m";
    public static final String TEXT_BRIGHT_BG_GREEN = "\u001B[102m";
    public static final String TEXT_BRIGHT_BG_YELLOW = "\u001B[103m";
    public static final String TEXT_BRIGHT_BG_BLUE = "\u001B[104m";

    private static ArrayList<String> mapTimes = new ArrayList<>();

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\convi\\Desktop\\Speedrun Leaderboard\\run.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectAll(String map, String input) {
        String sql = "";
        if (input.equals("all")) {
            sql = "SELECT name, time, platform FROM sr WHERE map = '" + map + "' ORDER BY time;";
        } else if (input.equals("Touch")){
            sql = "SELECT name, time, platform FROM sr WHERE map = '" + map + "' AND platform = 'Touch' ORDER BY time;";
        } else if (input.equals("Controller")){
            sql = "SELECT name, time, platform FROM sr WHERE map = '" + map + "' AND platform = 'Controller' ORDER BY time;";
        } else {
            sql = "SELECT name, time, platform FROM sr WHERE map = '" + map + "' AND platform = 'KBM' ORDER BY time;";
        }
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                String current = (rs.getString("name") + ":" +
                        rs.getString("platform") + ":" +
                        rs.getDouble("time"));
                mapTimes.add(current);
                //System.out.println(current);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectRuns(String player, int[] has, double stadium, double venice, double prison, double pinball, double music, double oriental, double picnic, double station) {
        String[] nameInput = player.split(":");
        String sql = "SELECT time, platform, map FROM sr WHERE name = '" + nameInput[0] + "' AND platform = '" + nameInput[1] + "' ORDER BY map;";
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            String spacing = "%-10s";
            while (rs.next()) {
                System.out.print(TEXT_RESET);
                System.out.print(TEXT_BLACK);
                if (rs.getString("map").equals("Music")) {
                    double newWr = Double.parseDouble(String.format("%.1f", music));
                    if (newWr > music) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    System.out.print(TEXT_RESET);
                    System.out.print(TEXT_BLACK);
                    continue;
                } else {
                    if (has[0] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[0] = 1;
                    }
                }

                if (rs.getString("map").equals("Oriental")) {
                    double newWr = Double.parseDouble(String.format("%.1f", oriental));
                    if (newWr > oriental) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    continue;
                } else {
                    if (has[1] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[1] = 1;
                    }
                }

                if (rs.getString("map").equals("Picnic")) {
                    double newWr = Double.parseDouble(String.format("%.1f", picnic));
                    if (newWr > picnic) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    System.out.print(TEXT_RESET);
                    System.out.print(TEXT_BLACK);
                    continue;
                } else {
                    if (has[2] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[2] = 1;
                    }
                }

                if (rs.getString("map").equals("Pinball")) {
                    double newWr = Double.parseDouble(String.format("%.1f", pinball));
                    if (newWr > pinball) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    System.out.print(TEXT_RESET);
                    System.out.print(TEXT_BLACK);
                    continue;
                } else {
                    if (has[3] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[3] = 1;
                    }
                }

                if (rs.getString("map").equals("Prison")) {
                    double newWr = Double.parseDouble(String.format("%.1f", prison));
                    if (newWr > prison) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    System.out.print(TEXT_RESET);
                    System.out.print(TEXT_BLACK);
                    continue;
                } else {
                    if (has[4] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[4] = 1;
                    }
                }

                if (rs.getString("map").equals("Stadium")) {
                    double newWr = Double.parseDouble(String.format("%.1f", stadium));
                    if (newWr > stadium) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    continue;
                } else {
                    if (has[5] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[5] = 1;
                    }
                }

                if (rs.getString("map").equals("Station")) {
                    double newWr = Double.parseDouble(String.format("%.1f", station));
                    if (newWr > station) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    System.out.print(TEXT_RESET);
                    System.out.print(TEXT_BLACK);
                    continue;
                } else {
                    if (has[6] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[6] = 1;
                    }
                }

                if (rs.getString("map").equals("Venice")) {
                    double newWr = Double.parseDouble(String.format("%.1f", venice));
                    if (newWr > venice) {
                        newWr -= 0.05;
                    }
                    newWr = Double.parseDouble(String.format("%.3f", newWr));

                    double playerTime = Double.parseDouble(rs.getString("time"));
                    double last = Double.parseDouble(String.format("%.1f", playerTime));
                    if (last > playerTime) {
                        last -= 0.05;
                    }
                    last = Double.parseDouble(String.format("%.3f", last));

                    if (last == newWr) {
                        System.out.print(TEXT_BG_PURPLE);
                    } else if (last <= newWr * 1.01) {
                        System.out.print(TEXT_BRIGHT_BG_BLUE);
                    } else if (last <= newWr * 1.025) {
                        System.out.print(TEXT_BRIGHT_BG_GREEN);
                    } else if (last <= newWr * 1.05) {
                        System.out.print(TEXT_BRIGHT_BG_YELLOW);
                    } else if (last <= newWr * 1.1) {
                        System.out.print(TEXT_BRIGHT_BG_RED);
                    } else if (last <= newWr * 1.2) {
                        System.out.print(TEXT_BRIGHT_BG_BLACK);
                    } else {
                    }
                    System.out.printf(spacing, rs.getDouble("time"));
                    System.out.print(TEXT_RESET);
                    System.out.print(TEXT_BLACK);
                    continue;
                } else {
                    if (has[7] == 0) {
                        System.out.print(TEXT_RESET);
                        System.out.print(TEXT_BLACK);
                        System.out.printf(spacing, "N/A");
                        has[7] = 1;
                    }
                }
            }

            System.out.print(TEXT_RESET);
            System.out.print(TEXT_BLACK);
            if (has[0] == 0) {
                System.out.printf(spacing, "N/A");
                has[0] = 1;
            }

            if (has[1] == 0) {
                System.out.printf(spacing, "N/A");
                has[1] = 1;
            }

            if (has[2] == 0) {
                System.out.printf(spacing, "N/A");
                has[2] = 1;
            }

            if (has[3] == 0) {
                System.out.printf(spacing, "N/A");
                has[3] = 1;
            }

            if (has[4] == 0) {
                System.out.printf(spacing, "N/A");
                has[4] = 1;
            }

            if (has[5] == 0) {
                System.out.printf(spacing, "N/A");
                has[5] = 1;
            }

            if (has[6] == 0) {
                System.out.printf(spacing, "N/A");
                has[6] = 1;
            }

            if (has[7] == 0) {
                System.out.printf(spacing, "N/A");
                has[7] = 1;
            }
            System.out.println(TEXT_RESET);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int[] findMaps(String player) {
        String[] nameInput = player.split(":");
        String sql = "SELECT time, platform, map FROM sr WHERE name = '" + nameInput[0] + "' AND platform = '" + nameInput[1] + "' ORDER BY map;";
        int[] has = {0, 0, 0, 0, 0, 0, 0, 0};
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                if (rs.getString("map").equals("Music")) {
                    has[0] = 1;
                } else if (rs.getString("map").equals("Oriental")) {
                    has[1] = 1;
                } else if (rs.getString("map").equals("Picnic")) {
                    has[2] = 1;
                } else if (rs.getString("map").equals("Pinball")) {
                    has[3] = 1;
                } else if (rs.getString("map").equals("Prison")) {
                    has[4] = 1;
                } else if (rs.getString("map").equals("Stadium")) {
                    has[5] = 1;
                } else if (rs.getString("map").equals("Station")) {
                    has[6] = 1;
                } else if (rs.getString("map").equals("Venice")) {
                    has[7] = 1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return has;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, Integer> totalPoints = new HashMap<>();
        SELECT stadium = new SELECT();
        SELECT venice = new SELECT();
        SELECT prison = new SELECT();
        SELECT pinball = new SELECT();
        SELECT music = new SELECT();
        SELECT oriental = new SELECT();
        SELECT picnic = new SELECT();
        SELECT station = new SELECT();
        String input = "all";
        //String input = "Touch";
        //String input = "Controller";
        //String input = "KBM";
        //                stadium, venice, prison, pinball, music, oriental, picnic, station
        //overall
        double[] wrs = {46.646, 57.495, 34.098, 30.446, 42.916, 30.052, 17.506, 58.915};
        //Touch
        //double[] wrs = {49.994, 63.411, 38.855, 33.053, 46.821, 32.701, 19.095, 64.762};
        //Controller
        //double[] wrs = {47.240, 59.125, 37.050, 30.843, 44.490, 31.966, 17.708, 62.325};
        //KBM
        //double[] wrs = {46.646, 57.495, 34.274, 30.450, 43.201, 30.275, 17.506, 58.915};

        stadium.selectAll("Stadium", input);
        totalPoints = stadium.calcPoints(totalPoints, wrs[0]);
        mapTimes.clear();

        venice.selectAll("Venice", input);
        totalPoints = venice.calcPoints(totalPoints, wrs[1]);
        mapTimes.clear();

        prison.selectAll("Prison", input);
        totalPoints = prison.calcPoints(totalPoints, wrs[2]);
        mapTimes.clear();

        pinball.selectAll("Pinball", input);
        totalPoints = pinball.calcPoints(totalPoints, wrs[3]);
        mapTimes.clear();

        music.selectAll("Music", input);
        totalPoints = music.calcPoints(totalPoints, wrs[4]);
        mapTimes.clear();

        oriental.selectAll("Oriental", input);
        totalPoints = oriental.calcPoints(totalPoints, wrs[5]);
        mapTimes.clear();

        picnic.selectAll("Picnic", input);
        totalPoints = picnic.calcPoints(totalPoints, wrs[6]);
        mapTimes.clear();

        station.selectAll("Station", input);
        totalPoints = pinball.calcPoints(totalPoints, wrs[7]);
        mapTimes.clear();
        Set<Map.Entry<String, Integer>> set = totalPoints.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int count = 0;
        System.out.println("Pos:" + " " + "Name:" + "            " + "Input:" + "         " + "Points:" + "  Music:" + "    Oriental:" + " Picnic:" + "   Pinball:" + "  Prison:" + "   Stadium:" + "  Station:" + "  Venice:");

        for (Map.Entry<String, Integer> entry : list) {
            String[] nameInput = entry.getKey().split(":");
            count += 1;
            System.out.printf("%-4s %-16s %-14s %-9s", count + ":", nameInput[0], nameInput[1], entry.getValue());
            picnic.selectRuns(entry.getKey(), picnic.findMaps(entry.getKey()), wrs[0], wrs[1], wrs[2], wrs[3], wrs[4], wrs[5], wrs[6], wrs[7]);
        }
    }

    private HashMap<String, Integer> calcPoints(HashMap<String, Integer> totalPoints,
                                                double wr) {
        for (String entry : mapTimes) {
            String[] comp = entry.split(":");
            double newWr = Double.parseDouble(String.format("%.1f", wr));
            if (newWr > wr) {
                newWr -= 0.05;
            }
            newWr = Double.parseDouble(String.format("%.3f", newWr));

            double starter = Double.parseDouble(comp[2]);
            double last = Double.parseDouble(String.format("%.1f", starter));
            if (last > starter) {
                last -= 0.05;
            }
            last = Double.parseDouble(String.format("%.3f", last));

            int additionalScore = 0;
            if (last == newWr) {
                additionalScore = 6;
            } else if (last <= newWr * 1.01) {
                additionalScore = 5;
            } else if (last <= newWr * 1.025) {
                additionalScore = 4;
            } else if (last <= newWr * 1.05) {
                additionalScore = 3;
            } else if (last <= newWr * 1.1) {
                additionalScore = 2;
            } else if (last <= newWr * 1.2) {
                additionalScore = 1;
            }

            Iterator it = totalPoints.entrySet().iterator();
            boolean hasEntry = false;

            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();
                if (pair.getKey().equals(comp[0] + ":" + comp[1])) {
                    int newScore = 0;
                    newScore = Integer.parseInt(pair.getValue().toString()) + additionalScore;
                    //System.out.println(newScore);
                    totalPoints.put(comp[0] + ":" + comp[1], newScore);
                    hasEntry = true;
                }
                //it.remove(); // avoids a ConcurrentModificationException
            }
            if (hasEntry == false) {
                totalPoints.put(comp[0] + ":" + comp[1], additionalScore);
            }
        }
        return totalPoints;
    }
}