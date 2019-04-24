package com.zerses.example;

import com.zerses.util.GroupedRecord;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class ExampleRecord implements GroupedRecord<String> {


    @DataField(pos = 1)
    public String fld01;
    @DataField(pos = 2)
    public String fld02;
    @DataField(pos = 3)
    public String fld03;
    @DataField(pos = 4)
    public String fld04;

    @Override
    public String getGroupKey() {
        return fld01;
    }

    @Override
    public String toString() {
        return "ExampleRecord{" +
                "fld01='" + fld01 + '\'' +
                ", fld02='" + fld02 + '\'' +
                ", fld03='" + fld03 + '\'' +
                ", fld04='" + fld04 + '\'' +
                '}';
    }
}
