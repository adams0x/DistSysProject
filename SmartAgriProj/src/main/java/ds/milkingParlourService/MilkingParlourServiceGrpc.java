package ds.milkingParlourService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: MilkingParlourService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MilkingParlourServiceGrpc {

  private MilkingParlourServiceGrpc() {}

  public static final String SERVICE_NAME = "milkingParlourService.MilkingParlourService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.milkingParlourService.MachineDetail,
      ds.milkingParlourService.SetMachineDetailsReply> getSetMachineDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMachineDetails",
      requestType = ds.milkingParlourService.MachineDetail.class,
      responseType = ds.milkingParlourService.SetMachineDetailsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.milkingParlourService.MachineDetail,
      ds.milkingParlourService.SetMachineDetailsReply> getSetMachineDetailsMethod() {
    io.grpc.MethodDescriptor<ds.milkingParlourService.MachineDetail, ds.milkingParlourService.SetMachineDetailsReply> getSetMachineDetailsMethod;
    if ((getSetMachineDetailsMethod = MilkingParlourServiceGrpc.getSetMachineDetailsMethod) == null) {
      synchronized (MilkingParlourServiceGrpc.class) {
        if ((getSetMachineDetailsMethod = MilkingParlourServiceGrpc.getSetMachineDetailsMethod) == null) {
          MilkingParlourServiceGrpc.getSetMachineDetailsMethod = getSetMachineDetailsMethod =
              io.grpc.MethodDescriptor.<ds.milkingParlourService.MachineDetail, ds.milkingParlourService.SetMachineDetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetMachineDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.MachineDetail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.SetMachineDetailsReply.getDefaultInstance()))
              .setSchemaDescriptor(new MilkingParlourServiceMethodDescriptorSupplier("SetMachineDetails"))
              .build();
        }
      }
    }
    return getSetMachineDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.milkingParlourService.Empty,
      ds.milkingParlourService.MachineId> getGetMachineIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMachineIds",
      requestType = ds.milkingParlourService.Empty.class,
      responseType = ds.milkingParlourService.MachineId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.milkingParlourService.Empty,
      ds.milkingParlourService.MachineId> getGetMachineIdsMethod() {
    io.grpc.MethodDescriptor<ds.milkingParlourService.Empty, ds.milkingParlourService.MachineId> getGetMachineIdsMethod;
    if ((getGetMachineIdsMethod = MilkingParlourServiceGrpc.getGetMachineIdsMethod) == null) {
      synchronized (MilkingParlourServiceGrpc.class) {
        if ((getGetMachineIdsMethod = MilkingParlourServiceGrpc.getGetMachineIdsMethod) == null) {
          MilkingParlourServiceGrpc.getGetMachineIdsMethod = getGetMachineIdsMethod =
              io.grpc.MethodDescriptor.<ds.milkingParlourService.Empty, ds.milkingParlourService.MachineId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMachineIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.MachineId.getDefaultInstance()))
              .setSchemaDescriptor(new MilkingParlourServiceMethodDescriptorSupplier("GetMachineIds"))
              .build();
        }
      }
    }
    return getGetMachineIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.milkingParlourService.MachineReportDate,
      ds.milkingParlourService.MilkReport> getGetMilkReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMilkReports",
      requestType = ds.milkingParlourService.MachineReportDate.class,
      responseType = ds.milkingParlourService.MilkReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.milkingParlourService.MachineReportDate,
      ds.milkingParlourService.MilkReport> getGetMilkReportsMethod() {
    io.grpc.MethodDescriptor<ds.milkingParlourService.MachineReportDate, ds.milkingParlourService.MilkReport> getGetMilkReportsMethod;
    if ((getGetMilkReportsMethod = MilkingParlourServiceGrpc.getGetMilkReportsMethod) == null) {
      synchronized (MilkingParlourServiceGrpc.class) {
        if ((getGetMilkReportsMethod = MilkingParlourServiceGrpc.getGetMilkReportsMethod) == null) {
          MilkingParlourServiceGrpc.getGetMilkReportsMethod = getGetMilkReportsMethod =
              io.grpc.MethodDescriptor.<ds.milkingParlourService.MachineReportDate, ds.milkingParlourService.MilkReport>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMilkReports"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.MachineReportDate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.MilkReport.getDefaultInstance()))
              .setSchemaDescriptor(new MilkingParlourServiceMethodDescriptorSupplier("GetMilkReports"))
              .build();
        }
      }
    }
    return getGetMilkReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.milkingParlourService.MachineTimeSpan,
      ds.milkingParlourService.MilkQuantity> getGetMilkVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMilkVolume",
      requestType = ds.milkingParlourService.MachineTimeSpan.class,
      responseType = ds.milkingParlourService.MilkQuantity.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.milkingParlourService.MachineTimeSpan,
      ds.milkingParlourService.MilkQuantity> getGetMilkVolumeMethod() {
    io.grpc.MethodDescriptor<ds.milkingParlourService.MachineTimeSpan, ds.milkingParlourService.MilkQuantity> getGetMilkVolumeMethod;
    if ((getGetMilkVolumeMethod = MilkingParlourServiceGrpc.getGetMilkVolumeMethod) == null) {
      synchronized (MilkingParlourServiceGrpc.class) {
        if ((getGetMilkVolumeMethod = MilkingParlourServiceGrpc.getGetMilkVolumeMethod) == null) {
          MilkingParlourServiceGrpc.getGetMilkVolumeMethod = getGetMilkVolumeMethod =
              io.grpc.MethodDescriptor.<ds.milkingParlourService.MachineTimeSpan, ds.milkingParlourService.MilkQuantity>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMilkVolume"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.MachineTimeSpan.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.milkingParlourService.MilkQuantity.getDefaultInstance()))
              .setSchemaDescriptor(new MilkingParlourServiceMethodDescriptorSupplier("GetMilkVolume"))
              .build();
        }
      }
    }
    return getGetMilkVolumeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MilkingParlourServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MilkingParlourServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MilkingParlourServiceStub>() {
        @java.lang.Override
        public MilkingParlourServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MilkingParlourServiceStub(channel, callOptions);
        }
      };
    return MilkingParlourServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MilkingParlourServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MilkingParlourServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MilkingParlourServiceBlockingStub>() {
        @java.lang.Override
        public MilkingParlourServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MilkingParlourServiceBlockingStub(channel, callOptions);
        }
      };
    return MilkingParlourServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MilkingParlourServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MilkingParlourServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MilkingParlourServiceFutureStub>() {
        @java.lang.Override
        public MilkingParlourServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MilkingParlourServiceFutureStub(channel, callOptions);
        }
      };
    return MilkingParlourServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineDetail> setMachineDetails(
        io.grpc.stub.StreamObserver<ds.milkingParlourService.SetMachineDetailsReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSetMachineDetailsMethod(), responseObserver);
    }

    /**
     */
    default void getMachineIds(ds.milkingParlourService.Empty request,
        io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMachineIdsMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineReportDate> getMilkReports(
        io.grpc.stub.StreamObserver<ds.milkingParlourService.MilkReport> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetMilkReportsMethod(), responseObserver);
    }

    /**
     */
    default void getMilkVolume(ds.milkingParlourService.MachineTimeSpan request,
        io.grpc.stub.StreamObserver<ds.milkingParlourService.MilkQuantity> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMilkVolumeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MilkingParlourService.
   */
  public static abstract class MilkingParlourServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MilkingParlourServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MilkingParlourService.
   */
  public static final class MilkingParlourServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MilkingParlourServiceStub> {
    private MilkingParlourServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MilkingParlourServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MilkingParlourServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineDetail> setMachineDetails(
        io.grpc.stub.StreamObserver<ds.milkingParlourService.SetMachineDetailsReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSetMachineDetailsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getMachineIds(ds.milkingParlourService.Empty request,
        io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMachineIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineReportDate> getMilkReports(
        io.grpc.stub.StreamObserver<ds.milkingParlourService.MilkReport> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetMilkReportsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getMilkVolume(ds.milkingParlourService.MachineTimeSpan request,
        io.grpc.stub.StreamObserver<ds.milkingParlourService.MilkQuantity> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMilkVolumeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MilkingParlourService.
   */
  public static final class MilkingParlourServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MilkingParlourServiceBlockingStub> {
    private MilkingParlourServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MilkingParlourServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MilkingParlourServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.milkingParlourService.MachineId> getMachineIds(
        ds.milkingParlourService.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMachineIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.milkingParlourService.MilkQuantity getMilkVolume(ds.milkingParlourService.MachineTimeSpan request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMilkVolumeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MilkingParlourService.
   */
  public static final class MilkingParlourServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MilkingParlourServiceFutureStub> {
    private MilkingParlourServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MilkingParlourServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MilkingParlourServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.milkingParlourService.MilkQuantity> getMilkVolume(
        ds.milkingParlourService.MachineTimeSpan request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMilkVolumeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MACHINE_IDS = 0;
  private static final int METHODID_GET_MILK_VOLUME = 1;
  private static final int METHODID_SET_MACHINE_DETAILS = 2;
  private static final int METHODID_GET_MILK_REPORTS = 3;

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
        case METHODID_GET_MACHINE_IDS:
          serviceImpl.getMachineIds((ds.milkingParlourService.Empty) request,
              (io.grpc.stub.StreamObserver<ds.milkingParlourService.MachineId>) responseObserver);
          break;
        case METHODID_GET_MILK_VOLUME:
          serviceImpl.getMilkVolume((ds.milkingParlourService.MachineTimeSpan) request,
              (io.grpc.stub.StreamObserver<ds.milkingParlourService.MilkQuantity>) responseObserver);
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
        case METHODID_SET_MACHINE_DETAILS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setMachineDetails(
              (io.grpc.stub.StreamObserver<ds.milkingParlourService.SetMachineDetailsReply>) responseObserver);
        case METHODID_GET_MILK_REPORTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getMilkReports(
              (io.grpc.stub.StreamObserver<ds.milkingParlourService.MilkReport>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSetMachineDetailsMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              ds.milkingParlourService.MachineDetail,
              ds.milkingParlourService.SetMachineDetailsReply>(
                service, METHODID_SET_MACHINE_DETAILS)))
        .addMethod(
          getGetMachineIdsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ds.milkingParlourService.Empty,
              ds.milkingParlourService.MachineId>(
                service, METHODID_GET_MACHINE_IDS)))
        .addMethod(
          getGetMilkReportsMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              ds.milkingParlourService.MachineReportDate,
              ds.milkingParlourService.MilkReport>(
                service, METHODID_GET_MILK_REPORTS)))
        .addMethod(
          getGetMilkVolumeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ds.milkingParlourService.MachineTimeSpan,
              ds.milkingParlourService.MilkQuantity>(
                service, METHODID_GET_MILK_VOLUME)))
        .build();
  }

  private static abstract class MilkingParlourServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MilkingParlourServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MilkingParlourService");
    }
  }

  private static final class MilkingParlourServiceFileDescriptorSupplier
      extends MilkingParlourServiceBaseDescriptorSupplier {
    MilkingParlourServiceFileDescriptorSupplier() {}
  }

  private static final class MilkingParlourServiceMethodDescriptorSupplier
      extends MilkingParlourServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MilkingParlourServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MilkingParlourServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MilkingParlourServiceFileDescriptorSupplier())
              .addMethod(getSetMachineDetailsMethod())
              .addMethod(getGetMachineIdsMethod())
              .addMethod(getGetMilkReportsMethod())
              .addMethod(getGetMilkVolumeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
