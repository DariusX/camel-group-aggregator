package com.zerses.util;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;
import org.apache.camel.processor.aggregate.PreCompletionAwareAggregationStrategy;

/**
 * Groups incoming exchanges together, based on the value of a key (the body should implement GroupedRecord)
 * Assumes that bodies with the same key come in together. For instance, if they are coming from a file, the file needs to
 * be pre-sorted on that key.
 * The implication of the above is that parallel processing cannot be used if such a file is being split
 * <p>
 * Uses the super-class AbstractListAggregationStrategy so that the Aggregated exchange contains a List of the individual exchanges
 * <p>
 * When a new key is detected, it immediately completes the previous aggregation and begins a new one
 * Important: The last record must be flushed out by also adding a completionTimeout in the route
 */
public class GroupedRecordAggregator extends AbstractListAggregationStrategy<GroupedRecord> implements PreCompletionAwareAggregationStrategy {

    @Override
    public GroupedRecord getValue(Exchange exchange) {
        GroupedRecord body = exchange.getIn().getBody(GroupedRecord.class);
        return body;
    }

//    @Override
//    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
//        Exchange aggrgatedExchange = super.aggregate(oldExchange, newExchange);
//
//        //Even though this detects the last record. Setting AGGREGATION_COMPLETE_CURRENT_GROUP does not
//        //flush out the last aggregation. So, maybe it does not play well with the preComplete
//        //A completion timeout has to be used, to flush the last group
//        boolean lastExchange = newExchange.getProperty("CamelSplitComplete", Boolean.class).booleanValue();
//        if (lastExchange) {
//            System.out.println("hello " + newExchange.getIn().getBody(GroupedRecord.class).toString());
//            aggrgatedExchange.setProperty(Exchange.AGGREGATION_COMPLETE_CURRENT_GROUP, true);
//        }
//
//        return aggrgatedExchange;
//    }

    @Override
    public boolean preComplete(Exchange oldExchange, Exchange newExchange) {

        Object newKey = newExchange.getIn().getBody(GroupedRecord.class).getGroupKey();

        if (oldExchange == null) {
            return false;
        }
        Object oldKey = oldExchange.getIn().getBody(GroupedRecord.class).getGroupKey();

        boolean preComplete = !newKey.equals(oldKey);
        return preComplete;
    }
}
