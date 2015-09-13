/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bestree.thrift.demo.multiplyservice;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-9-13")
public class MultiplyService {

  public interface Iface {

    public Result multiply(int a, int b) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void multiply(int a, int b, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public Result multiply(int a, int b) throws org.apache.thrift.TException
    {
      send_multiply(a, b);
      return recv_multiply();
    }

    public void send_multiply(int a, int b) throws org.apache.thrift.TException
    {
      multiply_args args = new multiply_args();
      args.setA(a);
      args.setB(b);
      sendBase("multiply", args);
    }

    public Result recv_multiply() throws org.apache.thrift.TException
    {
      multiply_result result = new multiply_result();
      receiveBase(result, "multiply");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "multiply failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void multiply(int a, int b, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
      checkReady();
      multiply_call method_call = new multiply_call(a, b, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class multiply_call extends org.apache.thrift.async.TAsyncMethodCall {
      private int a;
      private int b;
      public multiply_call(int a, int b, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.a = a;
        this.b = b;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("multiply", org.apache.thrift.protocol.TMessageType.CALL, 0));
        multiply_args args = new multiply_args();
        args.setA(a);
        args.setB(b);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public Result getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_multiply();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("multiply", new multiply());
      return processMap;
    }

    public static class multiply<I extends Iface> extends org.apache.thrift.ProcessFunction<I, multiply_args> {
      public multiply() {
        super("multiply");
      }

      public multiply_args getEmptyArgsInstance() {
        return new multiply_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public multiply_result getResult(I iface, multiply_args args) throws org.apache.thrift.TException {
        multiply_result result = new multiply_result();
        result.success = iface.multiply(args.a, args.b);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("multiply", new multiply());
      return processMap;
    }

    public static class multiply<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, multiply_args, Result> {
      public multiply() {
        super("multiply");
      }

      public multiply_args getEmptyArgsInstance() {
        return new multiply_args();
      }

      public AsyncMethodCallback<Result> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<Result>() { 
          public void onComplete(Result o) {
            multiply_result result = new multiply_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            multiply_result result = new multiply_result();
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, multiply_args args, org.apache.thrift.async.AsyncMethodCallback<Result> resultHandler) throws TException {
        iface.multiply(args.a, args.b,resultHandler);
      }
    }

  }

  public static class multiply_args implements org.apache.thrift.TBase<multiply_args, multiply_args._Fields>, java.io.Serializable, Cloneable, Comparable<multiply_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("multiply_args");

    private static final org.apache.thrift.protocol.TField A_FIELD_DESC = new org.apache.thrift.protocol.TField("a", org.apache.thrift.protocol.TType.I32, (short)1);
    private static final org.apache.thrift.protocol.TField B_FIELD_DESC = new org.apache.thrift.protocol.TField("b", org.apache.thrift.protocol.TType.I32, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new multiply_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new multiply_argsTupleSchemeFactory());
    }

    public int a; // required
    public int b; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      A((short)1, "a"),
      B((short)2, "b");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // A
            return A;
          case 2: // B
            return B;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __A_ISSET_ID = 0;
    private static final int __B_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.A, new org.apache.thrift.meta_data.FieldMetaData("a", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32          , "int")));
      tmpMap.put(_Fields.B, new org.apache.thrift.meta_data.FieldMetaData("b", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32          , "int")));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(multiply_args.class, metaDataMap);
    }

    public multiply_args() {
    }

    public multiply_args(
      int a,
      int b)
    {
      this();
      this.a = a;
      setAIsSet(true);
      this.b = b;
      setBIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public multiply_args(multiply_args other) {
      __isset_bitfield = other.__isset_bitfield;
      this.a = other.a;
      this.b = other.b;
    }

    public multiply_args deepCopy() {
      return new multiply_args(this);
    }

    @Override
    public void clear() {
      setAIsSet(false);
      this.a = 0;
      setBIsSet(false);
      this.b = 0;
    }

    public int getA() {
      return this.a;
    }

    public multiply_args setA(int a) {
      this.a = a;
      setAIsSet(true);
      return this;
    }

    public void unsetA() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __A_ISSET_ID);
    }

    /** Returns true if field a is set (has been assigned a value) and false otherwise */
    public boolean isSetA() {
      return EncodingUtils.testBit(__isset_bitfield, __A_ISSET_ID);
    }

    public void setAIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __A_ISSET_ID, value);
    }

    public int getB() {
      return this.b;
    }

    public multiply_args setB(int b) {
      this.b = b;
      setBIsSet(true);
      return this;
    }

    public void unsetB() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __B_ISSET_ID);
    }

    /** Returns true if field b is set (has been assigned a value) and false otherwise */
    public boolean isSetB() {
      return EncodingUtils.testBit(__isset_bitfield, __B_ISSET_ID);
    }

    public void setBIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __B_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case A:
        if (value == null) {
          unsetA();
        } else {
          setA((Integer)value);
        }
        break;

      case B:
        if (value == null) {
          unsetB();
        } else {
          setB((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case A:
        return Integer.valueOf(getA());

      case B:
        return Integer.valueOf(getB());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case A:
        return isSetA();
      case B:
        return isSetB();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof multiply_args)
        return this.equals((multiply_args)that);
      return false;
    }

    public boolean equals(multiply_args that) {
      if (that == null)
        return false;

      boolean this_present_a = true;
      boolean that_present_a = true;
      if (this_present_a || that_present_a) {
        if (!(this_present_a && that_present_a))
          return false;
        if (this.a != that.a)
          return false;
      }

      boolean this_present_b = true;
      boolean that_present_b = true;
      if (this_present_b || that_present_b) {
        if (!(this_present_b && that_present_b))
          return false;
        if (this.b != that.b)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_a = true;
      list.add(present_a);
      if (present_a)
        list.add(a);

      boolean present_b = true;
      list.add(present_b);
      if (present_b)
        list.add(b);

      return list.hashCode();
    }

    @Override
    public int compareTo(multiply_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetA()).compareTo(other.isSetA());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetA()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.a, other.a);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetB()).compareTo(other.isSetB());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetB()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.b, other.b);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("multiply_args(");
      boolean first = true;

      sb.append("a:");
      sb.append(this.a);
      first = false;
      if (!first) sb.append(", ");
      sb.append("b:");
      sb.append(this.b);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class multiply_argsStandardSchemeFactory implements SchemeFactory {
      public multiply_argsStandardScheme getScheme() {
        return new multiply_argsStandardScheme();
      }
    }

    private static class multiply_argsStandardScheme extends StandardScheme<multiply_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, multiply_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // A
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.a = iprot.readI32();
                struct.setAIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // B
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.b = iprot.readI32();
                struct.setBIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, multiply_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(A_FIELD_DESC);
        oprot.writeI32(struct.a);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(B_FIELD_DESC);
        oprot.writeI32(struct.b);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class multiply_argsTupleSchemeFactory implements SchemeFactory {
      public multiply_argsTupleScheme getScheme() {
        return new multiply_argsTupleScheme();
      }
    }

    private static class multiply_argsTupleScheme extends TupleScheme<multiply_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, multiply_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetA()) {
          optionals.set(0);
        }
        if (struct.isSetB()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetA()) {
          oprot.writeI32(struct.a);
        }
        if (struct.isSetB()) {
          oprot.writeI32(struct.b);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, multiply_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.a = iprot.readI32();
          struct.setAIsSet(true);
        }
        if (incoming.get(1)) {
          struct.b = iprot.readI32();
          struct.setBIsSet(true);
        }
      }
    }

  }

  public static class multiply_result implements org.apache.thrift.TBase<multiply_result, multiply_result._Fields>, java.io.Serializable, Cloneable, Comparable<multiply_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("multiply_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new multiply_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new multiply_resultTupleSchemeFactory());
    }

    public Result success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Result.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(multiply_result.class, metaDataMap);
    }

    public multiply_result() {
    }

    public multiply_result(
      Result success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public multiply_result(multiply_result other) {
      if (other.isSetSuccess()) {
        this.success = new Result(other.success);
      }
    }

    public multiply_result deepCopy() {
      return new multiply_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public Result getSuccess() {
      return this.success;
    }

    public multiply_result setSuccess(Result success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Result)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof multiply_result)
        return this.equals((multiply_result)that);
      return false;
    }

    public boolean equals(multiply_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_success = true && (isSetSuccess());
      list.add(present_success);
      if (present_success)
        list.add(success);

      return list.hashCode();
    }

    @Override
    public int compareTo(multiply_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("multiply_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
      if (success != null) {
        success.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class multiply_resultStandardSchemeFactory implements SchemeFactory {
      public multiply_resultStandardScheme getScheme() {
        return new multiply_resultStandardScheme();
      }
    }

    private static class multiply_resultStandardScheme extends StandardScheme<multiply_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, multiply_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.success = new Result();
                struct.success.read(iprot);
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, multiply_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class multiply_resultTupleSchemeFactory implements SchemeFactory {
      public multiply_resultTupleScheme getScheme() {
        return new multiply_resultTupleScheme();
      }
    }

    private static class multiply_resultTupleScheme extends TupleScheme<multiply_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, multiply_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          struct.success.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, multiply_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = new Result();
          struct.success.read(iprot);
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
