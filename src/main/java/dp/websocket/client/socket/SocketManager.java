package dp.websocket.client.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SocketManager implements InitializingBean {
    protected Logger logger = LoggerFactory.getLogger(SocketManager.class);

    @Lazy
    @Autowired
    private SocketConnector socketConnector;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("Loading the client....");
        socketConnector.establishSocket();
    }

}
