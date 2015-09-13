package com.bestree.thrift.demo.multiplyservice;

import org.apache.thrift.TException;

/**
 * Created by bestree007 on 2015/9/13.
 */
public class MultiplyServiceImpl implements MultiplyService.Iface
{
    @Override
    public Result multiply(int a, int b) throws TException
    {
        int result = a + b;
        return new Result(result);
    }
}
