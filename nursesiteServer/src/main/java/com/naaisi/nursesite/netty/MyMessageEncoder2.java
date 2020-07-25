package com.naaisi.nursesite.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyMessageEncoder2 extends MessageToByteEncoder<MessageProtocol> {
	@Override
	protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
		System.out.println("MyMessageEncoder encode used");
		int sign = msg.getSigns();
		int type = msg.getType();
		int Str_len = msg.getContentStr().length();
		int content_len = 0;//发送byte的长度。
		byte[] content=null;
		if(Str_len!=0) {
			content = msg.getContentStr().getBytes(Charset.forName("utf-8"));
			content_len = content.length;
		}
		
		
		if(sign==0) {
			sign=10086; }
//		if(type==0) {
//			type=1; }
		System.out.println("SEtype: "+type+" SEcontent_len: "+content_len);
		
		// 构建
		out.writeInt(sign);
		out.writeInt(type);
		out.writeInt(content_len);
		out.writeBytes(content);
	}

}
