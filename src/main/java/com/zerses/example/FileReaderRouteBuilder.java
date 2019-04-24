package com.zerses.example;

import com.zerses.util.GroupedRecordAggregator;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class FileReaderRouteBuilder extends RouteBuilder {

    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/in";

    DataFormat bindy = new BindyCsvDataFormat(ExampleRecord.class);

    @Override
    public void configure() throws Exception {

        // from("file://c:/temp/camel/in?noop=true")
        from("file:" + FILE_PATH + "?noop=true")
                .log("Detected file")
                .split().tokenize("\n")
                .streaming()
                .unmarshal(bindy)
                .aggregate(constant(true), new GroupedRecordAggregator())
                .completionTimeout(20)
                .eagerCheckCompletion()
                .to("direct:handleAggregatedRecords");

        from("direct:handleAggregatedRecords")
                .process(new ListLogger());
    }
}
