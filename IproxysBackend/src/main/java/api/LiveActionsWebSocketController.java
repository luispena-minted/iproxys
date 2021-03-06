package api;

import api.common.Authorize;
import api.common.RequestMethod;
import api.common.RequiresAuthorization;
import models.UserRoles;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by lupena on 3/9/2016.
 */

@WebSocket
@RequiresAuthorization(allowedRoles = {
        @Authorize(roles = {UserRoles.Admin, UserRoles.Distribuitor}, method = RequestMethod.GET, route = "/live-actions-socket"),
    },
    isWebSocket = true)
public class LiveActionsWebSocketController {


    public static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnWebSocketConnect
    public void connected(Session session) throws IOException {
        sessions.add(session);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void message(Session session, String message) throws IOException {
        System.out.println("Got: " + message);   // Print message
        session.getRemote().sendString(message); // and send it back
    }


}

