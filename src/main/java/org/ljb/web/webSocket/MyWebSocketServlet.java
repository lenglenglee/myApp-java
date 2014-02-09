package org.ljb.web.webSocket;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint(value="/chat")
public class MyWebSocketServlet {

	
	@OnOpen
	public void onOpen(Session session){
		System.out.println("onOpen");
		
	}
	@OnMessage
	public void onMessage(String message, Session session){
		System.out.println(message);
		try {
			File file = new File("d:\\IMG_0417.JPG");
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[8 * 1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			ByteBuffer bb = ByteBuffer.wrap(out.toByteArray());
			Map<String,Object> data=new HashMap<String,Object>();
			data.put("img", "'../images/headimage.jpg'");
			data.put("time", "2014-02-02 22:25:19");
			data.put("content", "hello");
			data.put("name", "uu");
			
			session.getBasicRemote();
			
//			session.getBasicRemote().sendBinary(bb);
			session.getBasicRemote().sendText("hello!!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@OnMessage
	 public void onMessage(byte[] b, boolean last, Session session) {
	     // process partial data here, which check on last to see if these is more on the way
	 }
	@OnClose
	public void onClose(Session session, CloseReason closeReason){
		
	}
	@OnError
	public void onError(Throwable exception, Session session){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
