package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Business class used to handle symptoms list, map.
 */
public class AnalyticsCounter {

	private final ISymptomReader symptomReader;
	private final ISymptomWriter symptomWriter;
	private List<String> listSymptoms;
	private LinkedHashMap<String, Long> symptomsMap;

	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter, LinkedHashMap<String, Long> symptomsMap) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
		this.symptomsMap = symptomsMap;
	}
	/**
	 * Generate a list of Symptoms from a file
	 */
	public void getListSymptoms() {
		this.listSymptoms = symptomReader.GetSymptoms();
	}

	/**
	 * Generate a file from a map
	 */
	public void setFileResult() {
		this.symptomWriter.setSymptoms(this.symptomsMap);
	}

	/**
	 * Generate a map of unique symptom as Key, and the occurrence as Value from a list
	 */
	public void setHashMapCounterSymptoms() {
		List<Map.Entry<String, Long>> toSort = new ArrayList<>();
		for (Map.Entry<String, Long> stringLongEntry : listSymptoms.stream()
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()))
				.entrySet()) {
			toSort.add(stringLongEntry);
		}
		toSort.sort(Map.Entry.comparingByKey());
		var listedSymptom =
				new LinkedHashMap<String, Long>();
		for (Map.Entry<String, Long> stringLongEntry : toSort) {
			listedSymptom.putIfAbsent(stringLongEntry.getKey(), stringLongEntry.getValue());
		}
		this.symptomsMap=listedSymptom;
	}
}
