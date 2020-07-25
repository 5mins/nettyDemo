package com.naaisi.nursesite.netty;

import java.nio.charset.Charset;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyHeartBeatHandler extends ChannelInboundHandlerAdapter {

	/**
	 *
	 * @param ctx 上下文
	 * @param evt 事件
	 * @throws Exception
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

		if (evt instanceof IdleStateEvent) {

			// 将 evt 向下转型 IdleStateEvent
			IdleStateEvent event = (IdleStateEvent) evt;
			String eventType = null;
			switch (event.state()) {
			case READER_IDLE:
				eventType = "读空闲";
				// readIdleTimes ++; // 读空闲的计数加1
				System.out.println(ctx.channel().remoteAddress() + " 读空闲，关闭连接");
				String mes = "you are out";
				//byte[] content = mes.getBytes(Charset.forName("utf-8"));
				////
				// 创建协议包对象
				
				//messageProtocol.setType(1);
				//messageProtocol.setContentStr(mes);
				//MessageProtocol messageProtocol = ;
				ctx.channel().writeAndFlush(new MessageProtocol(0,mes));//type 需要确定以后再更改
				ctx.channel().close();
				break;
			case WRITER_IDLE:
				eventType = "写空闲";
				break;
			case ALL_IDLE:
				eventType = "读写空闲";
				break;
			}
			// System.out.println(ctx.channel().remoteAddress() + "--超时时间--" + eventType);
			// System.out.println("服务器做相应处理..");
			// 如果发生空闲，关闭通道
//           if(readIdleTimes > 3){
//               //System.out.println(" [server]读空闲超过3次，关闭连接");
////               ctx.channel().writeAndFlush("you are out");
////               ctx.channel().close();
//           }

		}
	}
}
