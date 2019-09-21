package com.huyouxiao.loquat;

import org.glassfish.grizzly.filterchain.BaseFilter;
import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;

import java.io.IOException;
import java.util.logging.Logger;

public class ClientFilter extends BaseFilter {

    private static final Logger logger = Logger.getLogger(ClientFilter.class.getName());

    @Override
    public NextAction handleRead(FilterChainContext ctx) throws IOException {
        // We get String message from the context, because we rely prev, Filter in chain is StringFilter.
        final String serverResponse = ctx.getMessage();
        logger.info("Server echo: " + serverResponse);

        return  ctx.getStopAction();
    }
}
