package eosio.spectrum.websocket.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MessageListenerTransaction {

    private static final transient Logger logger = LoggerFactory.getLogger(MessageListenerTransaction.class);

    public void handleMessage(String message) {
        logger.info(message);
    }
}
