package com.naaisi.nursesite.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;
import java.util.List;

public class MyMessageDecoder2 extends ReplayingDecoder<Void> {
	
	private static  Logger log=LogManager.getLogger(MyMessageDecoder2.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode used");

        //需要将得到二进制字节码-> MessageProtocol 数据包(对象)
        int signs = in.readInt();
        if(signs==10086) {
        	//System.out.println("into signs 10086");
        	//log.info(this.getClass().getName()+"into signs 10086");
        	int type = in.readInt();
        	//System.out.println("type: "+type+"");
        	//log.info(this.getClass().getName()+"type: "+type);
            int content_len = in.readInt();
        	System.out.println("REtype: "+type+" REcontent_len: "+content_len);
        	//log.info(this.getClass().getName()+"content_len: "+content_len);
            
            byte[] content = new byte[content_len];
            in.readBytes(content);
            System.out.println("readBytes complete ");
        	//log.info(this.getClass().getName()+"readBytes complete ");
            
            String contentStr = new String(content, Charset.forName("utf-8"));
            //封装成 MessageProtocol 对象，放入 out， 传递下一个handler业务处理
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setSigns(signs);
            messageProtocol.setType(type);
            //messageProtocol.setContent_len(content_len);
            messageProtocol.setContentStr(contentStr);

            out.add(messageProtocol);
        	
        }else {
        	log.error(this.getClass().getName()+"error signs 10086");
        	System.out.println("signs wrong！close");
        	ctx.close();
        }
        

    }
}
