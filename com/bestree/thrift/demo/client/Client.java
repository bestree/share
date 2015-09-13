package com.bestree.thrift.demo.client;

import com.bestree.thrift.demo.multiplyservice.MultiplyService;
import com.bestree.thrift.demo.userservice.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;

/**
 * Created by bestree007 on 2015/9/13.
 */
public class Client
{
    public static void main(String[] args)
    {
        try {
            TSocket transport = new TSocket("localhost", 9090);
            transport.open();
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, "UserService");
            UserService.Client userClient = new UserService.Client(mp);
            System.out.println(userClient.add(1011));

            TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol, "MultiplyService");
            MultiplyService.Client multiplyClient = new MultiplyService.Client(mp2);
            System.out.println(multiplyClient.multiply(1, 3));

        } catch (TException e) {
            e.printStackTrace();
        }


    }
}
