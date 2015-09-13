package com.bestree.thrift.demo.server;

import com.bestree.thrift.demo.multiplyservice.MultiplyService;
import com.bestree.thrift.demo.multiplyservice.MultiplyServiceImpl;
import com.bestree.thrift.demo.userservice.UserService;
import com.bestree.thrift.demo.userservice.UserServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by bestree007 on 2015/9/13.
 */
public class MultiplexedServer
{
    public static void main(String[] args)
    {

        try {
            int port = 9090;
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            TServerTransport t = new TServerSocket(port);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(t).processor(processor));
            processor.registerProcessor("MultiplyService", new MultiplyService.Processor<MultiplyService.Iface>(new MultiplyServiceImpl()));
            processor.registerProcessor("UserService", new UserService.Processor<UserService.Iface>(new UserServiceImpl()));

            System.out.println("starting server port:" + port);
            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
