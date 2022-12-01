package com.example.loadbalancertest.service;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class HighLoadTester implements CommandLineRunner {

    PageTester pageTester;


    @Override
    public void run(String... args) throws Exception {

        int[] statisticsArray = new int[3];

        for (int i = 0; i < 50; i++) {
            pageTester.getUserByIdAsync().subscribe(page -> ++statisticsArray[pageTester.getInstanceNumber(page)]);
        }
        Thread.sleep(1000);
        log.info("1: {}\t\t2: {}\t\t3: {}", statisticsArray[0], statisticsArray[1], statisticsArray[2]);
    }
}
