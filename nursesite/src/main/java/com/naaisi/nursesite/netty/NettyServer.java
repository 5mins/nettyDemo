package com.naaisi.nursesite.netty;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
/**
 * @author lizihao
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:applicationContext.xml")
//@Service
public class NettyServer implements Runnable{

    private int port; //监听端口
	private Channel channel;
	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	private Thread nserver;


    public NettyServer(int port) {
        this.port = port;
    }
    
    @Test
	public void init() {
		System.out.println("netty init");
		nserver = new Thread(this);
    	nserver.start();
	}

	public void destory() {
		System.out.println("destroy server resources");
		if (null == channel) {
			System.out.println("server channel is null");
		}
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		channel.closeFuture().syncUninterruptibly();
		bossGroup = null;
		workerGroup = null;
		channel = null;
	}

	public int getPort() {
		return port;
	}

//	public void setPort(int port) {
//		this.port = port;
//	}

    
    
    

    //编写run方法，处理客户端的请求
    @Override
    public void run() {

        //创建两个线程组
         bossGroup = new NioEventLoopGroup(1);
         workerGroup = new NioEventLoopGroup(); //8个NioEventLoop

        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128) //boss 线程 //对应tcp/ip listen函数的backlog 参数初始化服务器可连接队列大小
                    
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  //worker 线程//是否启用心跳保活机制。在双方TCP套接字建立连接后（即都进入ESTABLISHED状态）并且在两个小时左右上层没有任何数据传输的情况下，这套机制才会被激活。
                    .childOption(ChannelOption.TCP_NODELAY, true) //关闭Nagle ，实现低延迟
                    .childOption(ChannelOption.SO_SNDBUF, 1024)//ChannelOption.TCP_NODELAY, true 减少延迟
                    .childOption(ChannelOption.SO_RCVBUF, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            //获取到pipeline
                            ChannelPipeline pipeline = ch.pipeline();

                            //向pipeline加入解码器
                            //pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("mydecoder", new MyMessageDecoder2());
                            
                            //加入心跳检测包处理handler
                            pipeline.addLast(new IdleStateHandler(100,0,0, TimeUnit.SECONDS));// （读，写，读写空闲）
                            pipeline.addLast("MyHeartBeatHandler", new MyHeartBeatHandler());
                            
                            //向pipeline加入编码器
                            //pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("myencoder", new MyMessageEncoder2());
                            


                            //加入自己的业务处理handler
                            pipeline.addLast(new NettyServerHandler2());

                        }
                    });

            System.out.println("netty Start");
            ChannelFuture channelFuture = b.bind(port).sync();

            //监听关闭
            channelFuture.channel().closeFuture().sync();
            
            channel = channelFuture.channel();
            
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {

        new NettyServer(7000).run();
    }
}
