package com.demowebshop.utils;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kaz", "o12702l@gmail.com", "13458Aa!"});
        list.add(new Object[]{"Orly", "Kan", "o12302k@gmail.com", "23458Aa!"});
        list.add(new Object[]{"Hen", "Omar", "h12102o@gmail.com", "33458Aa!"});
        return list.iterator();
    }



    @DataProvider
    public Iterator<Object[]>addNewUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/hwuser.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");

            list.add(new Object[]{new User()
                    .setName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3])});
            line=reader.readLine();
        }
        return list.iterator();
    }



}
