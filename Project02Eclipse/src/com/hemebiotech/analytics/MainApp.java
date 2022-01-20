package com.hemebiotech.analytics;

import java.util.LinkedHashMap;

public class MainApp {
    public static void main(String[] args) {

        LinkedHashMap<String, Long> symptomsMap = new LinkedHashMap<>();
        AnalyticsCounter counterSymptoms = new AnalyticsCounter(
                new ReadSymptomDataFromFile("symptoms.txt"), new WriteSymptomDataIntoFile("result.out"), symptomsMap);

        counterSymptoms.getListSymptoms();
        counterSymptoms.setHashMapCounterSymptoms();
        counterSymptoms.setFileResult();
    }
}
