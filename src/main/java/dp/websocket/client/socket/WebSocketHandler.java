package dp.websocket.client.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    protected Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connection has been established with websocket server. {}", session);
        TextMessage message = new TextMessage("Hi, from websocket!");
        session.sendMessage(message);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Message received : {} ", message.getPayload());
        session.sendMessage(new TextMessage("You have sent " + message.getPayload()));
    }

}
