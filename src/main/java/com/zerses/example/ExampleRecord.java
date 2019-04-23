package com.zerses.example;

import com.zerses.util.GroupedRecord;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class ExampleRecord implements GroupedRecord<String> {


    @Override
    public String getGroupKey() {
        return fld01;
    }

    @DataField(pos = 1)
    public String fld01;

    @DataField(pos = 2)
    public String fld02;

    @DataField(pos = 3)
    public String fld03;

    @DataField(pos = 4)
    public String fld04;

    @DataField(pos = 5)
    public String fld05;
    @DataField(pos = 6)
    public String fld06;
    @DataField(pos = 7)
    public String fld07;
    @DataField(pos = 8)
    public String fld08;
    @DataField(pos = 9)
    public String fld09;
    @DataField(pos = 10)
    public String fld10;

    @DataField(pos = 11)
    public String fld11;
    @DataField(pos = 12)
    public String fld12;
    @DataField(pos = 13)
    public String fld13;
    @DataField(pos = 14)
    public String fld14;
    @DataField(pos = 15)
    public String fld15;
    @DataField(pos = 16)
    public String fld16;
    @DataField(pos = 17)
    public String fld17;
    @DataField(pos = 18)
    public String fld18;
    @DataField(pos = 19)
    public String fld19;
    @DataField(pos = 20)
    public String fld20;

    @DataField(pos = 21)
    public String fld21;
    @DataField(pos = 22)
    public String fld22;
    @DataField(pos = 23)
    public String fld23;
    @DataField(pos = 24)
    public String fld24;
    @DataField(pos = 25)
    public String fld25;
    @DataField(pos = 26)
    public String fld26;
    @DataField(pos = 27)
    public String fld27;
    @DataField(pos = 28)
    public String fld28;
    @DataField(pos = 29)
    public String fld29;
    @DataField(pos = 30)
    public String fld30;

    @DataField(pos = 31)
    public String fld31;
    @DataField(pos = 32)
    public String fld32;
    @DataField(pos = 33)
    public String fld33;
    @DataField(pos = 34)
    public String fld34;
    @DataField(pos = 35)
    public String fld35;
    @DataField(pos = 36)
    public String fld36;
    @DataField(pos = 37)
    public String fld37;
    @DataField(pos = 38)
    public String fld38;
    @DataField(pos = 39)
    public String fld39;
    @DataField(pos = 40)
    public String fld40;

    @DataField(pos = 41)
    public String fld41;
    @DataField(pos = 42)
    public String fld42;

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
