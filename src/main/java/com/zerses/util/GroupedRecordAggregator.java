package com.zerses.util;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;
import org.apache.camel.processor.aggregate.PreCompletionAwareAggregationStrategy;

public class GroupedRecordAggregator extends AbstractListAggregationStrategy<GroupedRecord> implements PreCompletionAwareAggregationStrategy
{

    @Override
    public GroupedRecord getValue(Exchange exchange) {
        GroupedRecord body = exchange.getIn().getBody(GroupedRecord.class);
        return body;
    }

    @Override
    public boolean preComplete(Exchange oldExchange, Exchange newExchange) {

        Object newKey = newExchange.getIn().getBody(GroupedRecord.class).getGroupKey();

        if (oldExchange == null) {
            System.out.println("oldKey=null-Exchange, newKey=" + newKey + ", preComplete=false");
            return false;
        }
        Object oldKey = oldExchange.getIn().getBody(GroupedRecord.class).getGroupKey();

        boolean preComplete = !newKey.equals(oldKey);

//        boolean lastExchange = newExchange.getProperty("CamelSplitComplete", Boolean.class).booleanValue() ;
//        System.out.println("LastExchange="+lastExchange);
//        if (newExchange.getProperty("CamelSplitComplete", Boolean.class).booleanValue()) {
//            newExchange.setProperty(Exchange.AGGREGATION_COMPLETE_CURRENT_GROUP, true);
//        }

        return preComplete;
    }
}
