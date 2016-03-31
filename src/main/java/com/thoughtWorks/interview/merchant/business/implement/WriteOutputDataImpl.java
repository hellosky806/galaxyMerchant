package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IWriteOutputData;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteOutputDataImpl implements IWriteOutputData {

    public void writeOutputData(List<String> resultList) {
        File file = new File(Constant.OUTPUT_FILE_PATH);
        FileWriter fwriter = null;
        BufferedWriter writer = null;
        try {
            fwriter = new FileWriter(file);
            writer = new BufferedWriter(fwriter);
            for (String lineString : resultList) {
                writer.write(lineString);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert writer != null;
                writer.close();
                fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
