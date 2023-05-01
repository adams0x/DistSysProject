package ds.livestockActivityService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: LivestockActivityService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LivestockActivityServiceGrpc {

  private LivestockActivityServiceGrpc() {}

  public static final String SERVICE_NAME = "livestockActivityService.LivestockActivityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalDetail,
      ds.livestockActivityService.SetAnimalDetailsReply> getSetAnimalDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAnimalDetails",
      requestType = ds.livestockActivityService.AnimalDetail.class,
      responseType = ds.livestockActivityService.SetAnimalDetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalDetail,
      ds.livestockActivityService.SetAnimalDetailsReply> getSetAnimalDetailsMethod() {
    io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalDetail, ds.livestockActivityService.SetAnimalDetailsReply> getSetAnimalDetailsMethod;
    if ((getSetAnimalDetailsMethod = LivestockActivityServiceGrpc.getSetAnimalDetailsMethod) == null) {
      synchronized (LivestockActivityServiceGrpc.class) {
        if ((getSetAnimalDetailsMethod = LivestockActivityServiceGrpc.getSetAnimalDetailsMethod) == null) {
          LivestockActivityServiceGrpc.getSetAnimalDetailsMethod = getSetAnimalDetailsMethod =
              io.grpc.MethodDescriptor.<ds.livestockActivityService.AnimalDetail, ds.livestockActivityService.SetAnimalDetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetAnimalDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalDetail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.SetAnimalDetailsReply.getDefaultInstance()))
              .setSchemaDescriptor(new LivestockActivityServiceMethodDescriptorSupplier("SetAnimalDetails"))
              .build();
        }
      }
    }
    return getSetAnimalDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livestockActivityService.Empty,
      ds.livestockActivityService.AnimalId> getGetAnimalIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnimalIds",
      requestType = ds.livestockActivityService.Empty.class,
      responseType = ds.livestockActivityService.AnimalId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livestockActivityService.Empty,
      ds.livestockActivityService.AnimalId> getGetAnimalIdsMethod() {
    io.grpc.MethodDescriptor<ds.livestockActivityService.Empty, ds.livestockActivityService.AnimalId> getGetAnimalIdsMethod;
    if ((getGetAnimalIdsMethod = LivestockActivityServiceGrpc.getGetAnimalIdsMethod) == null) {
      synchronized (LivestockActivityServiceGrpc.class) {
        if ((getGetAnimalIdsMethod = LivestockActivityServiceGrpc.getGetAnimalIdsMethod) == null) {
          LivestockActivityServiceGrpc.getGetAnimalIdsMethod = getGetAnimalIdsMethod =
              io.grpc.MethodDescriptor.<ds.livestockActivityService.Empty, ds.livestockActivityService.AnimalId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnimalIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalId.getDefaultInstance()))
              .setSchemaDescriptor(new LivestockActivityServiceMethodDescriptorSupplier("GetAnimalIds"))
              .build();
        }
      }
    }
    return getGetAnimalIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId,
      ds.livestockActivityService.LiveHeartRate> getGetLiveHeartRateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLiveHeartRate",
      requestType = ds.livestockActivityService.AnimalId.class,
      responseType = ds.livestockActivityService.LiveHeartRate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId,
      ds.livestockActivityService.LiveHeartRate> getGetLiveHeartRateMethod() {
    io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId, ds.livestockActivityService.LiveHeartRate> getGetLiveHeartRateMethod;
    if ((getGetLiveHeartRateMethod = LivestockActivityServiceGrpc.getGetLiveHeartRateMethod) == null) {
      synchronized (LivestockActivityServiceGrpc.class) {
        if ((getGetLiveHeartRateMethod = LivestockActivityServiceGrpc.getGetLiveHeartRateMethod) == null) {
          LivestockActivityServiceGrpc.getGetLiveHeartRateMethod = getGetLiveHeartRateMethod =
              io.grpc.MethodDescriptor.<ds.livestockActivityService.AnimalId, ds.livestockActivityService.LiveHeartRate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLiveHeartRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.LiveHeartRate.getDefaultInstance()))
              .setSchemaDescriptor(new LivestockActivityServiceMethodDescriptorSupplier("GetLiveHeartRate"))
              .build();
        }
      }
    }
    return getGetLiveHeartRateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalTimeSpan,
      ds.livestockActivityService.HeartRateHistory> getGetHeartRateHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHeartRateHistory",
      requestType = ds.livestockActivityService.AnimalTimeSpan.class,
      responseType = ds.livestockActivityService.HeartRateHistory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalTimeSpan,
      ds.livestockActivityService.HeartRateHistory> getGetHeartRateHistoryMethod() {
    io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalTimeSpan, ds.livestockActivityService.HeartRateHistory> getGetHeartRateHistoryMethod;
    if ((getGetHeartRateHistoryMethod = LivestockActivityServiceGrpc.getGetHeartRateHistoryMethod) == null) {
      synchronized (LivestockActivityServiceGrpc.class) {
        if ((getGetHeartRateHistoryMethod = LivestockActivityServiceGrpc.getGetHeartRateHistoryMethod) == null) {
          LivestockActivityServiceGrpc.getGetHeartRateHistoryMethod = getGetHeartRateHistoryMethod =
              io.grpc.MethodDescriptor.<ds.livestockActivityService.AnimalTimeSpan, ds.livestockActivityService.HeartRateHistory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHeartRateHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalTimeSpan.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.HeartRateHistory.getDefaultInstance()))
              .setSchemaDescriptor(new LivestockActivityServiceMethodDescriptorSupplier("GetHeartRateHistory"))
              .build();
        }
      }
    }
    return getGetHeartRateHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId,
      ds.livestockActivityService.CurrentActivity> getGetCurrentActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentActivity",
      requestType = ds.livestockActivityService.AnimalId.class,
      responseType = ds.livestockActivityService.CurrentActivity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId,
      ds.livestockActivityService.CurrentActivity> getGetCurrentActivityMethod() {
    io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId, ds.livestockActivityService.CurrentActivity> getGetCurrentActivityMethod;
    if ((getGetCurrentActivityMethod = LivestockActivityServiceGrpc.getGetCurrentActivityMethod) == null) {
      synchronized (LivestockActivityServiceGrpc.class) {
        if ((getGetCurrentActivityMethod = LivestockActivityServiceGrpc.getGetCurrentActivityMethod) == null) {
          LivestockActivityServiceGrpc.getGetCurrentActivityMethod = getGetCurrentActivityMethod =
              io.grpc.MethodDescriptor.<ds.livestockActivityService.AnimalId, ds.livestockActivityService.CurrentActivity>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCurrentActivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.CurrentActivity.getDefaultInstance()))
              .setSchemaDescriptor(new LivestockActivityServiceMethodDescriptorSupplier("GetCurrentActivity"))
              .build();
        }
      }
    }
    return getGetCurrentActivityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId,
      ds.livestockActivityService.AnimalHealthInfo> getGetAnimalVitalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnimalVitals",
      requestType = ds.livestockActivityService.AnimalId.class,
      responseType = ds.livestockActivityService.AnimalHealthInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId,
      ds.livestockActivityService.AnimalHealthInfo> getGetAnimalVitalsMethod() {
    io.grpc.MethodDescriptor<ds.livestockActivityService.AnimalId, ds.livestockActivityService.AnimalHealthInfo> getGetAnimalVitalsMethod;
    if ((getGetAnimalVitalsMethod = LivestockActivityServiceGrpc.getGetAnimalVitalsMethod) == null) {
      synchronized (LivestockActivityServiceGrpc.class) {
        if ((getGetAnimalVitalsMethod = LivestockActivityServiceGrpc.getGetAnimalVitalsMethod) == null) {
          LivestockActivityServiceGrpc.getGetAnimalVitalsMethod = getGetAnimalVitalsMethod =
              io.grpc.MethodDescriptor.<ds.livestockActivityService.AnimalId, ds.livestockActivityService.AnimalHealthInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnimalVitals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.livestockActivityService.AnimalHealthInfo.getDefaultInstance()))
              .setSchemaDescriptor(new LivestockActivityServiceMethodDescriptorSupplier("GetAnimalVitals"))
              .build();
        }
      }
    }
    return getGetAnimalVitalsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LivestockActivityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivestockActivityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivestockActivityServiceStub>() {
        @java.lang.Override
        public LivestockActivityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivestockActivityServiceStub(channel, callOptions);
        }
      };
    return LivestockActivityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LivestockActivityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivestockActivityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivestockActivityServiceBlockingStub>() {
        @java.lang.Override
        public LivestockActivityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivestockActivityServiceBlockingStub(channel, callOptions);
        }
      };
    return LivestockActivityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LivestockActivityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LivestockActivityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LivestockActivityServiceFutureStub>() {
        @java.lang.Override
        public LivestockActivityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LivestockActivityServiceFutureStub(channel, callOptions);
        }
      };
    return LivestockActivityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalDetail> setAnimalDetails(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.SetAnimalDetailsReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSetAnimalDetailsMethod(), responseObserver);
    }

    /**
     */
    default void getAnimalIds(ds.livestockActivityService.Empty request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalIdsMethod(), responseObserver);
    }

    /**
     */
    default void getLiveHeartRate(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.LiveHeartRate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLiveHeartRateMethod(), responseObserver);
    }

    /**
     */
    default void getHeartRateHistory(ds.livestockActivityService.AnimalTimeSpan request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.HeartRateHistory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHeartRateHistoryMethod(), responseObserver);
    }

    /**
     */
    default void getCurrentActivity(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.CurrentActivity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentActivityMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> getAnimalVitals(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalHealthInfo> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetAnimalVitalsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LivestockActivityService.
   */
  public static abstract class LivestockActivityServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LivestockActivityServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LivestockActivityService.
   */
  public static final class LivestockActivityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LivestockActivityServiceStub> {
    private LivestockActivityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockActivityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivestockActivityServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalDetail> setAnimalDetails(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.SetAnimalDetailsReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSetAnimalDetailsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getAnimalIds(ds.livestockActivityService.Empty request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAnimalIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLiveHeartRate(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.LiveHeartRate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetLiveHeartRateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeartRateHistory(ds.livestockActivityService.AnimalTimeSpan request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.HeartRateHistory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetHeartRateHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCurrentActivity(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.CurrentActivity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentActivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> getAnimalVitals(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalHealthInfo> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetAnimalVitalsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LivestockActivityService.
   */
  public static final class LivestockActivityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LivestockActivityServiceBlockingStub> {
    private LivestockActivityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockActivityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivestockActivityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.livestockActivityService.AnimalId> getAnimalIds(
        ds.livestockActivityService.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAnimalIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.livestockActivityService.LiveHeartRate> getLiveHeartRate(
        ds.livestockActivityService.AnimalId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetLiveHeartRateMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.livestockActivityService.HeartRateHistory> getHeartRateHistory(
        ds.livestockActivityService.AnimalTimeSpan request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetHeartRateHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.livestockActivityService.CurrentActivity getCurrentActivity(ds.livestockActivityService.AnimalId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentActivityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LivestockActivityService.
   */
  public static final class LivestockActivityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LivestockActivityServiceFutureStub> {
    private LivestockActivityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockActivityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LivestockActivityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.livestockActivityService.CurrentActivity> getCurrentActivity(
        ds.livestockActivityService.AnimalId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentActivityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANIMAL_IDS = 0;
  private static final int METHODID_GET_LIVE_HEART_RATE = 1;
  private static final int METHODID_GET_HEART_RATE_HISTORY = 2;
  private static final int METHODID_GET_CURRENT_ACTIVITY = 3;
  private static final int METHODID_SET_ANIMAL_DETAILS = 4;
  private static final int METHODID_GET_ANIMAL_VITALS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMAL_IDS:
          serviceImpl.getAnimalIds((ds.livestockActivityService.Empty) request,
              (io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId>) responseObserver);
          break;
        case METHODID_GET_LIVE_HEART_RATE:
          serviceImpl.getLiveHeartRate((ds.livestockActivityService.AnimalId) request,
              (io.grpc.stub.StreamObserver<ds.livestockActivityService.LiveHeartRate>) responseObserver);
          break;
        case METHODID_GET_HEART_RATE_HISTORY:
          serviceImpl.getHeartRateHistory((ds.livestockActivityService.AnimalTimeSpan) request,
              (io.grpc.stub.StreamObserver<ds.livestockActivityService.HeartRateHistory>) responseObserver);
          break;
        case METHODID_GET_CURRENT_ACTIVITY:
          serviceImpl.getCurrentActivity((ds.livestockActivityService.AnimalId) request,
              (io.grpc.stub.StreamObserver<ds.livestockActivityService.CurrentActivity>) responseObserver);
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
        case METHODID_SET_ANIMAL_DETAILS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setAnimalDetails(
              (io.grpc.stub.StreamObserver<ds.livestockActivityService.SetAnimalDetailsReply>) responseObserver);
        case METHODID_GET_ANIMAL_VITALS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getAnimalVitals(
              (io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalHealthInfo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSetAnimalDetailsMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              ds.livestockActivityService.AnimalDetail,
              ds.livestockActivityService.SetAnimalDetailsReply>(
                service, METHODID_SET_ANIMAL_DETAILS)))
        .addMethod(
          getGetAnimalIdsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ds.livestockActivityService.Empty,
              ds.livestockActivityService.AnimalId>(
                service, METHODID_GET_ANIMAL_IDS)))
        .addMethod(
          getGetLiveHeartRateMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ds.livestockActivityService.AnimalId,
              ds.livestockActivityService.LiveHeartRate>(
                service, METHODID_GET_LIVE_HEART_RATE)))
        .addMethod(
          getGetHeartRateHistoryMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ds.livestockActivityService.AnimalTimeSpan,
              ds.livestockActivityService.HeartRateHistory>(
                service, METHODID_GET_HEART_RATE_HISTORY)))
        .addMethod(
          getGetCurrentActivityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ds.livestockActivityService.AnimalId,
              ds.livestockActivityService.CurrentActivity>(
                service, METHODID_GET_CURRENT_ACTIVITY)))
        .addMethod(
          getGetAnimalVitalsMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              ds.livestockActivityService.AnimalId,
              ds.livestockActivityService.AnimalHealthInfo>(
                service, METHODID_GET_ANIMAL_VITALS)))
        .build();
  }

  private static abstract class LivestockActivityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LivestockActivityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LivestockActivityService");
    }
  }

  private static final class LivestockActivityServiceFileDescriptorSupplier
      extends LivestockActivityServiceBaseDescriptorSupplier {
    LivestockActivityServiceFileDescriptorSupplier() {}
  }

  private static final class LivestockActivityServiceMethodDescriptorSupplier
      extends LivestockActivityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LivestockActivityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LivestockActivityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LivestockActivityServiceFileDescriptorSupplier())
              .addMethod(getSetAnimalDetailsMethod())
              .addMethod(getGetAnimalIdsMethod())
              .addMethod(getGetLiveHeartRateMethod())
              .addMethod(getGetHeartRateHistoryMethod())
              .addMethod(getGetCurrentActivityMethod())
              .addMethod(getGetAnimalVitalsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
