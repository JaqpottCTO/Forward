public class WebSocketService {
    private WebSocket webSocket;

    public WebSocketService(String serverUri) {
        try {
            webSocket = new WebSocketFactory().createSocket(serverUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() throws IOException {
        webSocket.connect();
    }

    public void sendMessage(String message) {
        webSocket.sendText(message);
    }

    public void onMessageReceived(WebSocketAdapter adapter) {
        webSocket.addListener(adapter);
    }
}
