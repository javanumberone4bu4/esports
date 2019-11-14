package com.rimi.esports.controller;
import com.alibaba.fastjson.JSONObject;
import com.rimi.esports.common.Message;
import com.rimi.esports.common.Result0;
import org.springframework.web.bind.annotation.CrossOrigin;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 聊天室
 *
 * @author Wang Xiaoping
 * @date 2019/11/10 15:52
 */

@ServerEndpoint("/chatroom/{userTel}")
@CrossOrigin
public class ChatroomController {

    /**
     * concurrent 该包下的类皆为线程安全,用来存放每个客户端对应的自定义WebSocoket对象
     */
    private static Map<String, ChatroomController> clients = new ConcurrentHashMap<>();
    private static int onlineCount = 0;
    private Session session;
    private String userTel;

    @OnOpen
    public void onOpen(Session session, @PathParam("userTel") String userTel) {
        if (!clients.containsKey(userTel)) {
            this.session = session;
            this.userTel = userTel;
            clients.put(userTel, this);
            addOnlineCount();
            // 发送消息
            sendMessage(getResult("系统", this.userTel + "上线了"));
        }
    }

    @OnClose
    public void onClose(@PathParam("userTel") String userTel) {
        if (clients.containsKey(userTel)) {
            clients.remove(userTel);
            removeOnlineCount();
            sendMessage(getResult("系统", this.userTel + "下线了"));
        }
    }

    @OnError
    public void onError(Throwable error) {

    }

    /**
     * 接收客户端的消息
     *
     * @param message 客户端发送的消息
     */
    @OnMessage
    public void onMessage(String message) {
        //JSONObject jsonObject=new JSONObject();
        //jsonObject.put("userTel",this.userTel);
        //jsonObject.put("message",message);
        sendMessage(getResult(this.userTel,message));
    }

    /**
     * 绑定消息体内容
     * @param userTel 消息的来源
     * @param msg 消息的内容
     * @return
     */
    public String getResult(String userTel, String msg) {
        Message message = new Message();
        message.setName(userTel);
        message.setData(msg);
        //message.setTimes(System.currentTimeMillis());
        Result0 result = new Result0();
        result.setMessage(message);
        result.setOnline(clients.keySet());
        return JSONObject.toJSONString(result);
    }

    public void sendMessage(String message) {
        for (ChatroomController room : clients.values()) {
            room.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void removeOnlineCount() {
        onlineCount--;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

}
