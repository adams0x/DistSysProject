// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MilkingParlourService.proto

package ds.milkingParlourService;

/**
 * Protobuf type {@code milkingParlourService.MachineDetail}
 */
public  final class MachineDetail extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:milkingParlourService.MachineDetail)
    MachineDetailOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MachineDetail.newBuilder() to construct.
  private MachineDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MachineDetail() {
    dateInstalled_ = "";
    dateNextService_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MachineDetail(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            ds.milkingParlourService.MachineId.Builder subBuilder = null;
            if (machineID_ != null) {
              subBuilder = machineID_.toBuilder();
            }
            machineID_ = input.readMessage(ds.milkingParlourService.MachineId.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(machineID_);
              machineID_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            dateInstalled_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            dateNextService_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_MachineDetail_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_MachineDetail_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.milkingParlourService.MachineDetail.class, ds.milkingParlourService.MachineDetail.Builder.class);
  }

  public static final int MACHINEID_FIELD_NUMBER = 1;
  private ds.milkingParlourService.MachineId machineID_;
  /**
   * <code>.milkingParlourService.MachineId machineID = 1;</code>
   */
  public boolean hasMachineID() {
    return machineID_ != null;
  }
  /**
   * <code>.milkingParlourService.MachineId machineID = 1;</code>
   */
  public ds.milkingParlourService.MachineId getMachineID() {
    return machineID_ == null ? ds.milkingParlourService.MachineId.getDefaultInstance() : machineID_;
  }
  /**
   * <code>.milkingParlourService.MachineId machineID = 1;</code>
   */
  public ds.milkingParlourService.MachineIdOrBuilder getMachineIDOrBuilder() {
    return getMachineID();
  }

  public static final int DATEINSTALLED_FIELD_NUMBER = 2;
  private volatile java.lang.Object dateInstalled_;
  /**
   * <code>string dateInstalled = 2;</code>
   */
  public java.lang.String getDateInstalled() {
    java.lang.Object ref = dateInstalled_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dateInstalled_ = s;
      return s;
    }
  }
  /**
   * <code>string dateInstalled = 2;</code>
   */
  public com.google.protobuf.ByteString
      getDateInstalledBytes() {
    java.lang.Object ref = dateInstalled_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dateInstalled_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATENEXTSERVICE_FIELD_NUMBER = 3;
  private volatile java.lang.Object dateNextService_;
  /**
   * <code>string dateNextService = 3;</code>
   */
  public java.lang.String getDateNextService() {
    java.lang.Object ref = dateNextService_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dateNextService_ = s;
      return s;
    }
  }
  /**
   * <code>string dateNextService = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDateNextServiceBytes() {
    java.lang.Object ref = dateNextService_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dateNextService_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (machineID_ != null) {
      output.writeMessage(1, getMachineID());
    }
    if (!getDateInstalledBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, dateInstalled_);
    }
    if (!getDateNextServiceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dateNextService_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (machineID_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getMachineID());
    }
    if (!getDateInstalledBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, dateInstalled_);
    }
    if (!getDateNextServiceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dateNextService_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.milkingParlourService.MachineDetail)) {
      return super.equals(obj);
    }
    ds.milkingParlourService.MachineDetail other = (ds.milkingParlourService.MachineDetail) obj;

    boolean result = true;
    result = result && (hasMachineID() == other.hasMachineID());
    if (hasMachineID()) {
      result = result && getMachineID()
          .equals(other.getMachineID());
    }
    result = result && getDateInstalled()
        .equals(other.getDateInstalled());
    result = result && getDateNextService()
        .equals(other.getDateNextService());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasMachineID()) {
      hash = (37 * hash) + MACHINEID_FIELD_NUMBER;
      hash = (53 * hash) + getMachineID().hashCode();
    }
    hash = (37 * hash) + DATEINSTALLED_FIELD_NUMBER;
    hash = (53 * hash) + getDateInstalled().hashCode();
    hash = (37 * hash) + DATENEXTSERVICE_FIELD_NUMBER;
    hash = (53 * hash) + getDateNextService().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.milkingParlourService.MachineDetail parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.milkingParlourService.MachineDetail parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.milkingParlourService.MachineDetail parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.milkingParlourService.MachineDetail parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.milkingParlourService.MachineDetail prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code milkingParlourService.MachineDetail}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:milkingParlourService.MachineDetail)
      ds.milkingParlourService.MachineDetailOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_MachineDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_MachineDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.milkingParlourService.MachineDetail.class, ds.milkingParlourService.MachineDetail.Builder.class);
    }

    // Construct using ds.milkingParlourService.MachineDetail.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (machineIDBuilder_ == null) {
        machineID_ = null;
      } else {
        machineID_ = null;
        machineIDBuilder_ = null;
      }
      dateInstalled_ = "";

      dateNextService_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_MachineDetail_descriptor;
    }

    @java.lang.Override
    public ds.milkingParlourService.MachineDetail getDefaultInstanceForType() {
      return ds.milkingParlourService.MachineDetail.getDefaultInstance();
    }

    @java.lang.Override
    public ds.milkingParlourService.MachineDetail build() {
      ds.milkingParlourService.MachineDetail result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.milkingParlourService.MachineDetail buildPartial() {
      ds.milkingParlourService.MachineDetail result = new ds.milkingParlourService.MachineDetail(this);
      if (machineIDBuilder_ == null) {
        result.machineID_ = machineID_;
      } else {
        result.machineID_ = machineIDBuilder_.build();
      }
      result.dateInstalled_ = dateInstalled_;
      result.dateNextService_ = dateNextService_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.milkingParlourService.MachineDetail) {
        return mergeFrom((ds.milkingParlourService.MachineDetail)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.milkingParlourService.MachineDetail other) {
      if (other == ds.milkingParlourService.MachineDetail.getDefaultInstance()) return this;
      if (other.hasMachineID()) {
        mergeMachineID(other.getMachineID());
      }
      if (!other.getDateInstalled().isEmpty()) {
        dateInstalled_ = other.dateInstalled_;
        onChanged();
      }
      if (!other.getDateNextService().isEmpty()) {
        dateNextService_ = other.dateNextService_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.milkingParlourService.MachineDetail parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.milkingParlourService.MachineDetail) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ds.milkingParlourService.MachineId machineID_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.milkingParlourService.MachineId, ds.milkingParlourService.MachineId.Builder, ds.milkingParlourService.MachineIdOrBuilder> machineIDBuilder_;
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public boolean hasMachineID() {
      return machineIDBuilder_ != null || machineID_ != null;
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public ds.milkingParlourService.MachineId getMachineID() {
      if (machineIDBuilder_ == null) {
        return machineID_ == null ? ds.milkingParlourService.MachineId.getDefaultInstance() : machineID_;
      } else {
        return machineIDBuilder_.getMessage();
      }
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public Builder setMachineID(ds.milkingParlourService.MachineId value) {
      if (machineIDBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        machineID_ = value;
        onChanged();
      } else {
        machineIDBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public Builder setMachineID(
        ds.milkingParlourService.MachineId.Builder builderForValue) {
      if (machineIDBuilder_ == null) {
        machineID_ = builderForValue.build();
        onChanged();
      } else {
        machineIDBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public Builder mergeMachineID(ds.milkingParlourService.MachineId value) {
      if (machineIDBuilder_ == null) {
        if (machineID_ != null) {
          machineID_ =
            ds.milkingParlourService.MachineId.newBuilder(machineID_).mergeFrom(value).buildPartial();
        } else {
          machineID_ = value;
        }
        onChanged();
      } else {
        machineIDBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public Builder clearMachineID() {
      if (machineIDBuilder_ == null) {
        machineID_ = null;
        onChanged();
      } else {
        machineID_ = null;
        machineIDBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public ds.milkingParlourService.MachineId.Builder getMachineIDBuilder() {
      
      onChanged();
      return getMachineIDFieldBuilder().getBuilder();
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    public ds.milkingParlourService.MachineIdOrBuilder getMachineIDOrBuilder() {
      if (machineIDBuilder_ != null) {
        return machineIDBuilder_.getMessageOrBuilder();
      } else {
        return machineID_ == null ?
            ds.milkingParlourService.MachineId.getDefaultInstance() : machineID_;
      }
    }
    /**
     * <code>.milkingParlourService.MachineId machineID = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.milkingParlourService.MachineId, ds.milkingParlourService.MachineId.Builder, ds.milkingParlourService.MachineIdOrBuilder> 
        getMachineIDFieldBuilder() {
      if (machineIDBuilder_ == null) {
        machineIDBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ds.milkingParlourService.MachineId, ds.milkingParlourService.MachineId.Builder, ds.milkingParlourService.MachineIdOrBuilder>(
                getMachineID(),
                getParentForChildren(),
                isClean());
        machineID_ = null;
      }
      return machineIDBuilder_;
    }

    private java.lang.Object dateInstalled_ = "";
    /**
     * <code>string dateInstalled = 2;</code>
     */
    public java.lang.String getDateInstalled() {
      java.lang.Object ref = dateInstalled_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dateInstalled_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dateInstalled = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDateInstalledBytes() {
      java.lang.Object ref = dateInstalled_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dateInstalled_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dateInstalled = 2;</code>
     */
    public Builder setDateInstalled(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dateInstalled_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dateInstalled = 2;</code>
     */
    public Builder clearDateInstalled() {
      
      dateInstalled_ = getDefaultInstance().getDateInstalled();
      onChanged();
      return this;
    }
    /**
     * <code>string dateInstalled = 2;</code>
     */
    public Builder setDateInstalledBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dateInstalled_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dateNextService_ = "";
    /**
     * <code>string dateNextService = 3;</code>
     */
    public java.lang.String getDateNextService() {
      java.lang.Object ref = dateNextService_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dateNextService_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dateNextService = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDateNextServiceBytes() {
      java.lang.Object ref = dateNextService_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dateNextService_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dateNextService = 3;</code>
     */
    public Builder setDateNextService(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dateNextService_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dateNextService = 3;</code>
     */
    public Builder clearDateNextService() {
      
      dateNextService_ = getDefaultInstance().getDateNextService();
      onChanged();
      return this;
    }
    /**
     * <code>string dateNextService = 3;</code>
     */
    public Builder setDateNextServiceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dateNextService_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:milkingParlourService.MachineDetail)
  }

  // @@protoc_insertion_point(class_scope:milkingParlourService.MachineDetail)
  private static final ds.milkingParlourService.MachineDetail DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.milkingParlourService.MachineDetail();
  }

  public static ds.milkingParlourService.MachineDetail getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MachineDetail>
      PARSER = new com.google.protobuf.AbstractParser<MachineDetail>() {
    @java.lang.Override
    public MachineDetail parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MachineDetail(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MachineDetail> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MachineDetail> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.milkingParlourService.MachineDetail getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
