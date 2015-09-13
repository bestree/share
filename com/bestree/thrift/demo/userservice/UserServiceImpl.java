package com.bestree.thrift.demo.userservice;

import org.apache.thrift.TException;

/**
 * Created by bestree007 on 2015/9/13.
 */
public class UserServiceImpl implements UserService.Iface
{
    @Override
    public User add(int id) throws TException
    {
        return new User(id, "bestree", 5);
    }
}
