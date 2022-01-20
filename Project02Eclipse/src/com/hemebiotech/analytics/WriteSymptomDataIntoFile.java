package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This implementation is used to read data from specific file
 */
public class WriteSymptomDataIntoFile implements ISymptomWriter {

    private final String filePathOut;

    /**
     *
     * @param filePathOut a full or partial path to file with symptom map sorted
     */

    public WriteSymptomDataIntoFile(String filePathOut) {
        this.filePathOut = filePathOut;
    }

    @Override
    public void setSymptoms(LinkedHashMap<String, Long> symptomsMap) {

        if (filePathOut != null) {
            File Result = new File(filePathOut);
            BufferedWriter bufferWriter = null;

            try {
                bufferWriter = new BufferedWriter(new FileWriter(Result));

                for (Map.Entry<String, Long> entry : symptomsMap.entrySet()) {
                    bufferWriter.write(entry.getKey() + " : "
                            + entry.getValue());

                    bufferWriter.newLine();
                }

                bufferWriter.flush();


            }

            catch (IOException e) {
                e.printStackTrace();
            }

            finally {

                try {
                    assert bufferWriter != null;
                    bufferWriter.close();
                }

                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
