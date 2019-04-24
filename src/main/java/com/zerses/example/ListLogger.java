package com.zerses.example;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class ListLogger implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<String> theList = exchange.getIn().getBody(List.class);
        System.out.println(" - - - - - - - - - - - - - - - - - - Aggregated List size=" + theList.size() + " - - - - - - - - - - - - - - -");
        for (Object s : theList) {
            System.out.println("   ... " + s);
        }
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
