package ds.livestockActivityService;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: LivestockActivityService.proto")
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
              .setFullMethodName(generateFullMethodName(
                  "livestockActivityService.LivestockActivityService", "SetAnimalDetails"))
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
              .setFullMethodName(generateFullMethodName(
                  "livestockActivityService.LivestockActivityService", "GetAnimalIds"))
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
              .setFullMethodName(generateFullMethodName(
                  "livestockActivityService.LivestockActivityService", "GetLiveHeartRate"))
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
              .setFullMethodName(generateFullMethodName(
                  "livestockActivityService.LivestockActivityService", "GetHeartRateHistory"))
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
              .setFullMethodName(generateFullMethodName(
                  "livestockActivityService.LivestockActivityService", "GetCurrentActivity"))
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
              .setFullMethodName(generateFullMethodName(
                  "livestockActivityService.LivestockActivityService", "GetAnimalVitals"))
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
    return new LivestockActivityServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LivestockActivityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LivestockActivityServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LivestockActivityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LivestockActivityServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LivestockActivityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalDetail> setAnimalDetails(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.SetAnimalDetailsReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetAnimalDetailsMethod(), responseObserver);
    }

    /**
     */
    public void getAnimalIds(ds.livestockActivityService.Empty request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAnimalIdsMethod(), responseObserver);
    }

    /**
     */
    public void getLiveHeartRate(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.LiveHeartRate> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLiveHeartRateMethod(), responseObserver);
    }

    /**
     */
    public void getHeartRateHistory(ds.livestockActivityService.AnimalTimeSpan request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.HeartRateHistory> responseObserver) {
      asyncUnimplementedUnaryCall(getGetHeartRateHistoryMethod(), responseObserver);
    }

    /**
     */
    public void getCurrentActivity(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.CurrentActivity> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentActivityMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> getAnimalVitals(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalHealthInfo> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetAnimalVitalsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetAnimalDetailsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.livestockActivityService.AnimalDetail,
                ds.livestockActivityService.SetAnimalDetailsReply>(
                  this, METHODID_SET_ANIMAL_DETAILS)))
          .addMethod(
            getGetAnimalIdsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.livestockActivityService.Empty,
                ds.livestockActivityService.AnimalId>(
                  this, METHODID_GET_ANIMAL_IDS)))
          .addMethod(
            getGetLiveHeartRateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.livestockActivityService.AnimalId,
                ds.livestockActivityService.LiveHeartRate>(
                  this, METHODID_GET_LIVE_HEART_RATE)))
          .addMethod(
            getGetHeartRateHistoryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.livestockActivityService.AnimalTimeSpan,
                ds.livestockActivityService.HeartRateHistory>(
                  this, METHODID_GET_HEART_RATE_HISTORY)))
          .addMethod(
            getGetCurrentActivityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.livestockActivityService.AnimalId,
                ds.livestockActivityService.CurrentActivity>(
                  this, METHODID_GET_CURRENT_ACTIVITY)))
          .addMethod(
            getGetAnimalVitalsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.livestockActivityService.AnimalId,
                ds.livestockActivityService.AnimalHealthInfo>(
                  this, METHODID_GET_ANIMAL_VITALS)))
          .build();
    }
  }

  /**
   */
  public static final class LivestockActivityServiceStub extends io.grpc.stub.AbstractStub<LivestockActivityServiceStub> {
    private LivestockActivityServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LivestockActivityServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockActivityServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LivestockActivityServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalDetail> setAnimalDetails(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.SetAnimalDetailsReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSetAnimalDetailsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getAnimalIds(ds.livestockActivityService.Empty request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAnimalIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLiveHeartRate(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.LiveHeartRate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetLiveHeartRateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeartRateHistory(ds.livestockActivityService.AnimalTimeSpan request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.HeartRateHistory> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetHeartRateHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCurrentActivity(ds.livestockActivityService.AnimalId request,
        io.grpc.stub.StreamObserver<ds.livestockActivityService.CurrentActivity> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentActivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalId> getAnimalVitals(
        io.grpc.stub.StreamObserver<ds.livestockActivityService.AnimalHealthInfo> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetAnimalVitalsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LivestockActivityServiceBlockingStub extends io.grpc.stub.AbstractStub<LivestockActivityServiceBlockingStub> {
    private LivestockActivityServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LivestockActivityServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockActivityServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LivestockActivityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.livestockActivityService.AnimalId> getAnimalIds(
        ds.livestockActivityService.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAnimalIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.livestockActivityService.LiveHeartRate> getLiveHeartRate(
        ds.livestockActivityService.AnimalId request) {
      return blockingServerStreamingCall(
          getChannel(), getGetLiveHeartRateMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.livestockActivityService.HeartRateHistory> getHeartRateHistory(
        ds.livestockActivityService.AnimalTimeSpan request) {
      return blockingServerStreamingCall(
          getChannel(), getGetHeartRateHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.livestockActivityService.CurrentActivity getCurrentActivity(ds.livestockActivityService.AnimalId request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentActivityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LivestockActivityServiceFutureStub extends io.grpc.stub.AbstractStub<LivestockActivityServiceFutureStub> {
    private LivestockActivityServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LivestockActivityServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LivestockActivityServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LivestockActivityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.livestockActivityService.CurrentActivity> getCurrentActivity(
        ds.livestockActivityService.AnimalId request) {
      return futureUnaryCall(
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
    private final LivestockActivityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LivestockActivityServiceImplBase serviceImpl, int methodId) {
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
