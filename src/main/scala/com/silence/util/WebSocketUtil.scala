package com.silence.util

import javax.websocket.Session
import java.util.concurrent.CopyOnWriteArraySet
import com.silence.websocket.WebSocket

object WebSocketUtil {
         
    //��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
    private var onlineCount: Int = 0
    
    //���ص�ǰ��������
    def getOnlineCount(): Int = synchronized(onlineCount)
    
    //�̰߳�ȫ����������
    def addOnlineCount() = synchronized(onlineCount += 1)
    
    //�̰߳�ȫ�������Լ�
    def subOnlineCount(): Unit = synchronized(onlineCount -= 1)
    
    //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket����
    var webSocketSet: CopyOnWriteArraySet[WebSocket] = new CopyOnWriteArraySet[WebSocket]()
    
    //�����ı���Ϣ
    def sendMessage(message: String, sess: Session): Unit =  sess.getBasicRemote().sendText(message)
    
}