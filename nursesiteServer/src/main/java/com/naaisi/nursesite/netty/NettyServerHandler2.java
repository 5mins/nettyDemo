package com.naaisi.nursesite.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSON;
import com.naaisi.nursesite.socketrans.BusinessHandle;
import com.naaisi.nursesite.socketrans.jsonCodec;

//@Component
public class NettyServerHandler2 extends SimpleChannelInboundHandler<MessageProtocol> {

	// public static List<Channel> channels = new ArrayList<Channel>();

	// 使用一个hashmap 管理
	// public static Map<String, Channel> channels = new HashMap<String,Channel>();

	// 定义一个channle 组，管理所有的channel
	// GlobalEventExecutor.INSTANCE) 是全局的事件执行器，是一个单例
	private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// handlerAdded 表示连接建立，一旦连接，第一个被执行
	// 将当前channel 加入到 channelGroup
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		//
		/*
		 * 该方法会将 channelGroup 中所有的channel 遍历，并发送 消息， 我们不需要自己遍历
		 */
		// channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 加入" +
		// sdf.format(new java.util.Date()) + " \n");
		// System.out.println("[客户端]" + channel.remoteAddress() + " 加入" + sdf.format(new
		// java.util.Date()) + " \n");
		channelGroup.add(channel);

	}

	// 断开连接
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

		Channel channel = ctx.channel();
		// channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 离开了\n");
		System.out.println("channelGroup size" + channelGroup.size());

	}

	// 表示channel 处于活动状态
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		System.out.println(sdf.format(new java.util.Date()) + ctx.channel().remoteAddress() + "  connectd");
	}

	// 表示channel 处于不活动状态,
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {

		System.out.println(sdf.format(new java.util.Date()) + ctx.channel().remoteAddress() + "  removed");
	}

	// 读取数据
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol messageProtocol) throws Exception {

		// 获取到当前channel
		Channel channel = ctx.channel();

		// System.out.println("收到来自 "+channel.remoteAddress()+" 的消息: "+messageProtocol);

		int type = messageProtocol.getType();

		if (type == 1) {// 处理正常业务消息

			// byte[] content = messageProtocol.getContent();
			// String msg = new String(content, Charset.forName("utf-8"));

			String Mymsg = messageProtocol.getContentStr().trim();

			// 初步判断字符串是不是json格式
			boolean sign = jsonCodec.isJSONValid(Mymsg);

			if (sign) {

				// 开始处理普通费时任务
				ctx.channel().eventLoop().execute(new Runnable() {
					@Override
					public void run() {

						try {
							// Thread.sleep(2 * 1000);//模拟费时的任务
							BusinessHandle msh = new BusinessHandle();
							String result = (String) msh.exeNormal(Mymsg);// 只处理普通任务 ，供测试用
							// ctx.writeAndFlush(Unpooled.copiedBuffer(result, CharsetUtil.UTF_8));//????
							ctx.writeAndFlush(sentMyNormalMsg(result));// ????
							System.out.println("" + ctx.channel().hashCode() + "output: " + result);
						} catch (Exception ex) {
							System.out.println("error " + ex.getMessage());
						}
					}
				});

				// ch.writeAndFlush("查询结果：" + Mymsg + "\n");

			} else {

//        		message_handle msh = new message_handle();
//            	String result = (String) msh.exeNormal(Mymsg);//只处理普通任务 ，供测试用
//                ctx.writeAndFlush(Unpooled.copiedBuffer(result, CharsetUtil.UTF_8));

				String mmsg = "unkown: " + Mymsg;
				// ch.writeAndFlush(Unpooled.copiedBuffer(mmsg, CharsetUtil.UTF_8));

				ctx.writeAndFlush(sentMyNormalMsg(mmsg));
				System.out.println("" + ctx.channel().hashCode() + "  output: " + mmsg);

			}

		} else if (type == 2) {// 处理管理端推送消息
			// 遍历channelGroup, 根据不同的情况，回送不同的消息
//          channelGroup.forEach(ch -> {
//          if(channel != ch) { //不是当前的channel,转发消息
//              //ch.writeAndFlush("[客户]" + channel.remoteAddress() + " 发送了消息" + msg + "\n");
//          }else {//回显
//          	
//          }
//      });
		} else if (type == 0) {// 普通字符串消息

			String contentStr = messageProtocol.getContentStr();
			if (contentStr != null) {
				if (contentStr.equals("ping")) {// 客户端心跳协议回复
					ctx.writeAndFlush(sentMyStrMsg("pong"));

				} else {

					ctx.writeAndFlush(sentMyStrMsg("已经收到你的消息： " + contentStr));
				}

			}

		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// 关闭通道
		ctx.close();
	}

	private MessageProtocol sentMyNormalMsg(String mes) {// 正常业务消息

		// byte[] content = mes.getBytes(Charset.forName("utf-8"));
////
		// 创建协议包对象
		MessageProtocol messageProtocol = new MessageProtocol(1, mes);
		return messageProtocol;

	}

	private MessageProtocol sentMyStrMsg(String mes) {// 普通字符串消息

		// byte[] content = mes.getBytes(Charset.forName("utf-8"));
////
		// 创建协议包对象
		MessageProtocol messageProtocol = new MessageProtocol(0, mes);
		return messageProtocol;

	}

}
