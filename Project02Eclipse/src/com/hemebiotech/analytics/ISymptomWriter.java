package com.hemebiotech.analytics;

import java.util.LinkedHashMap;

/**
 * Anything that will write symptoms occurrences from a map into a file.
 */
public interface ISymptomWriter {
    /**
     *
     * This will not write if the map is null.
     * @param symptomsMap The map of symptom string paired with associated count
     */
    void setSymptoms(LinkedHashMap<String, Long> symptomsMap);
}
