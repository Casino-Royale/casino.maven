package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
    private static final char DEFAULT_SEPARATOR = ',';  // (1)

    // (2)
    public static void writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;

        StringBuilder sb = new StringBuilder();

        // (3)
        for (String value : values) {
            if (!first) {
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");

        w.append(sb.toString());  // (4)
    }

    public static void csvFileSaver(CasinoAccount account) throws IOException {
        String csvFile = "accounts.csv";
        FileWriter writer = new FileWriter(csvFile);
        Integer nextId = 1;
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));
        Integer[] boards = account.getScoreboard().createCSVArray();
        List<String> list = new ArrayList<>();
        list.add(account.getAccountName());
        list.add(account.getPassword());
        list.add(String.valueOf(account.getAccountBalance()));
        //list.add(String.valueOf(account.getScoreboard()));

        for(int i = 0; i < boards.length; i++){
            list.add(String.valueOf(boards[i]));
        }
        CSVUtils.writeLine(writer, list);


        writer.flush();
        writer.close();
    }

    public static CasinoAccount loadData(){
        // (1)
        String csvFile = "accounts.csv";
        String line = "";
        String csvSplitBy = ",";
        Integer nextId = 1;
        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] account = line.split(csvSplitBy);

                String accountName = account[0];
                String password = account[1];
                String accountBalance = account[2];
                Scoreboard scoreboard = new Scoreboard();
                Integer count = 3;
                for(int i = 0; i < 5; i++){
                    scoreboard.getBoards()[i].addToLifetimeBets(Integer.parseInt(account[count]));
                    scoreboard.getBoards()[i].addToLifetimeWinnings(Integer.parseInt(account[count + 1]));
                    scoreboard.getBoards()[i].addToLifetimeLosses(Integer.parseInt(account[count + 2]));
                    count += 3;
                }
                // (5)
                //inventory.add(new Sneaker(id, name, brand, sport, size, qty, price));
                CasinoAccount loadedAccount = new CasinoAccount(accountName, password, scoreboard);
                loadedAccount.alterAccountBalance(Integer.parseInt(accountBalance));
                return loadedAccount;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
