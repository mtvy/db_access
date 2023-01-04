package api;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: database.proto")
public final class DatabaseGrpc {

  private DatabaseGrpc() {}

  public static final String SERVICE_NAME = "api.Database";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<api.DatabaseOuterClass.GetDbRequest,
      api.DatabaseOuterClass.GetDbResponse> getGetDbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDb",
      requestType = api.DatabaseOuterClass.GetDbRequest.class,
      responseType = api.DatabaseOuterClass.GetDbResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<api.DatabaseOuterClass.GetDbRequest,
      api.DatabaseOuterClass.GetDbResponse> getGetDbMethod() {
    io.grpc.MethodDescriptor<api.DatabaseOuterClass.GetDbRequest, api.DatabaseOuterClass.GetDbResponse> getGetDbMethod;
    if ((getGetDbMethod = DatabaseGrpc.getGetDbMethod) == null) {
      synchronized (DatabaseGrpc.class) {
        if ((getGetDbMethod = DatabaseGrpc.getGetDbMethod) == null) {
          DatabaseGrpc.getGetDbMethod = getGetDbMethod =
              io.grpc.MethodDescriptor.<api.DatabaseOuterClass.GetDbRequest, api.DatabaseOuterClass.GetDbResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.DatabaseOuterClass.GetDbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.DatabaseOuterClass.GetDbResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseMethodDescriptorSupplier("GetDb"))
              .build();
        }
      }
    }
    return getGetDbMethod;
  }

  private static volatile io.grpc.MethodDescriptor<api.DatabaseOuterClass.InsertDbRequest,
      api.DatabaseOuterClass.InsertDbResponse> getInsertDbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InsertDb",
      requestType = api.DatabaseOuterClass.InsertDbRequest.class,
      responseType = api.DatabaseOuterClass.InsertDbResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<api.DatabaseOuterClass.InsertDbRequest,
      api.DatabaseOuterClass.InsertDbResponse> getInsertDbMethod() {
    io.grpc.MethodDescriptor<api.DatabaseOuterClass.InsertDbRequest, api.DatabaseOuterClass.InsertDbResponse> getInsertDbMethod;
    if ((getInsertDbMethod = DatabaseGrpc.getInsertDbMethod) == null) {
      synchronized (DatabaseGrpc.class) {
        if ((getInsertDbMethod = DatabaseGrpc.getInsertDbMethod) == null) {
          DatabaseGrpc.getInsertDbMethod = getInsertDbMethod =
              io.grpc.MethodDescriptor.<api.DatabaseOuterClass.InsertDbRequest, api.DatabaseOuterClass.InsertDbResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InsertDb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.DatabaseOuterClass.InsertDbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.DatabaseOuterClass.InsertDbResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseMethodDescriptorSupplier("InsertDb"))
              .build();
        }
      }
    }
    return getInsertDbMethod;
  }

  private static volatile io.grpc.MethodDescriptor<api.DatabaseOuterClass.DeleteDbRequest,
      api.DatabaseOuterClass.DeleteDbResponse> getDeleteDbMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDb",
      requestType = api.DatabaseOuterClass.DeleteDbRequest.class,
      responseType = api.DatabaseOuterClass.DeleteDbResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<api.DatabaseOuterClass.DeleteDbRequest,
      api.DatabaseOuterClass.DeleteDbResponse> getDeleteDbMethod() {
    io.grpc.MethodDescriptor<api.DatabaseOuterClass.DeleteDbRequest, api.DatabaseOuterClass.DeleteDbResponse> getDeleteDbMethod;
    if ((getDeleteDbMethod = DatabaseGrpc.getDeleteDbMethod) == null) {
      synchronized (DatabaseGrpc.class) {
        if ((getDeleteDbMethod = DatabaseGrpc.getDeleteDbMethod) == null) {
          DatabaseGrpc.getDeleteDbMethod = getDeleteDbMethod =
              io.grpc.MethodDescriptor.<api.DatabaseOuterClass.DeleteDbRequest, api.DatabaseOuterClass.DeleteDbResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDb"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.DatabaseOuterClass.DeleteDbRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  api.DatabaseOuterClass.DeleteDbResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatabaseMethodDescriptorSupplier("DeleteDb"))
              .build();
        }
      }
    }
    return getDeleteDbMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DatabaseStub newStub(io.grpc.Channel channel) {
    return new DatabaseStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatabaseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DatabaseBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DatabaseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DatabaseFutureStub(channel);
  }

  /**
   */
  public static abstract class DatabaseImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDb(api.DatabaseOuterClass.GetDbRequest request,
        io.grpc.stub.StreamObserver<api.DatabaseOuterClass.GetDbResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDbMethod(), responseObserver);
    }

    /**
     */
    public void insertDb(api.DatabaseOuterClass.InsertDbRequest request,
        io.grpc.stub.StreamObserver<api.DatabaseOuterClass.InsertDbResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertDbMethod(), responseObserver);
    }

    /**
     */
    public void deleteDb(api.DatabaseOuterClass.DeleteDbRequest request,
        io.grpc.stub.StreamObserver<api.DatabaseOuterClass.DeleteDbResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteDbMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDbMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                api.DatabaseOuterClass.GetDbRequest,
                api.DatabaseOuterClass.GetDbResponse>(
                  this, METHODID_GET_DB)))
          .addMethod(
            getInsertDbMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                api.DatabaseOuterClass.InsertDbRequest,
                api.DatabaseOuterClass.InsertDbResponse>(
                  this, METHODID_INSERT_DB)))
          .addMethod(
            getDeleteDbMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                api.DatabaseOuterClass.DeleteDbRequest,
                api.DatabaseOuterClass.DeleteDbResponse>(
                  this, METHODID_DELETE_DB)))
          .build();
    }
  }

  /**
   */
  public static final class DatabaseStub extends io.grpc.stub.AbstractStub<DatabaseStub> {
    private DatabaseStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DatabaseStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DatabaseStub(channel, callOptions);
    }

    /**
     */
    public void getDb(api.DatabaseOuterClass.GetDbRequest request,
        io.grpc.stub.StreamObserver<api.DatabaseOuterClass.GetDbResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDbMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insertDb(api.DatabaseOuterClass.InsertDbRequest request,
        io.grpc.stub.StreamObserver<api.DatabaseOuterClass.InsertDbResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertDbMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteDb(api.DatabaseOuterClass.DeleteDbRequest request,
        io.grpc.stub.StreamObserver<api.DatabaseOuterClass.DeleteDbResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteDbMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DatabaseBlockingStub extends io.grpc.stub.AbstractStub<DatabaseBlockingStub> {
    private DatabaseBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DatabaseBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DatabaseBlockingStub(channel, callOptions);
    }

    /**
     */
    public api.DatabaseOuterClass.GetDbResponse getDb(api.DatabaseOuterClass.GetDbRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDbMethod(), getCallOptions(), request);
    }

    /**
     */
    public api.DatabaseOuterClass.InsertDbResponse insertDb(api.DatabaseOuterClass.InsertDbRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertDbMethod(), getCallOptions(), request);
    }

    /**
     */
    public api.DatabaseOuterClass.DeleteDbResponse deleteDb(api.DatabaseOuterClass.DeleteDbRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteDbMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DatabaseFutureStub extends io.grpc.stub.AbstractStub<DatabaseFutureStub> {
    private DatabaseFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DatabaseFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatabaseFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DatabaseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<api.DatabaseOuterClass.GetDbResponse> getDb(
        api.DatabaseOuterClass.GetDbRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDbMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<api.DatabaseOuterClass.InsertDbResponse> insertDb(
        api.DatabaseOuterClass.InsertDbRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertDbMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<api.DatabaseOuterClass.DeleteDbResponse> deleteDb(
        api.DatabaseOuterClass.DeleteDbRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteDbMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DB = 0;
  private static final int METHODID_INSERT_DB = 1;
  private static final int METHODID_DELETE_DB = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatabaseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatabaseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DB:
          serviceImpl.getDb((api.DatabaseOuterClass.GetDbRequest) request,
              (io.grpc.stub.StreamObserver<api.DatabaseOuterClass.GetDbResponse>) responseObserver);
          break;
        case METHODID_INSERT_DB:
          serviceImpl.insertDb((api.DatabaseOuterClass.InsertDbRequest) request,
              (io.grpc.stub.StreamObserver<api.DatabaseOuterClass.InsertDbResponse>) responseObserver);
          break;
        case METHODID_DELETE_DB:
          serviceImpl.deleteDb((api.DatabaseOuterClass.DeleteDbRequest) request,
              (io.grpc.stub.StreamObserver<api.DatabaseOuterClass.DeleteDbResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DatabaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatabaseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return api.DatabaseOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Database");
    }
  }

  private static final class DatabaseFileDescriptorSupplier
      extends DatabaseBaseDescriptorSupplier {
    DatabaseFileDescriptorSupplier() {}
  }

  private static final class DatabaseMethodDescriptorSupplier
      extends DatabaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DatabaseMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DatabaseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DatabaseFileDescriptorSupplier())
              .addMethod(getGetDbMethod())
              .addMethod(getInsertDbMethod())
              .addMethod(getDeleteDbMethod())
              .build();
        }
      }
    }
    return result;
  }
}
