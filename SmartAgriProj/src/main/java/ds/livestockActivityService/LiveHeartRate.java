// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LivestockActivityService.proto

package ds.livestockActivityService;

/**
 * Protobuf type {@code livestockActivityService.LiveHeartRate}
 */
public  final class LiveHeartRate extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:livestockActivityService.LiveHeartRate)
    LiveHeartRateOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LiveHeartRate.newBuilder() to construct.
  private LiveHeartRate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LiveHeartRate() {
    bpm_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LiveHeartRate(
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
          case 8: {

            bpm_ = input.readInt32();
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
    return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_LiveHeartRate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_LiveHeartRate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.livestockActivityService.LiveHeartRate.class, ds.livestockActivityService.LiveHeartRate.Builder.class);
  }

  public static final int BPM_FIELD_NUMBER = 1;
  private int bpm_;
  /**
   * <code>int32 bpm = 1;</code>
   */
  public int getBpm() {
    return bpm_;
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
    if (bpm_ != 0) {
      output.writeInt32(1, bpm_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bpm_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, bpm_);
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
    if (!(obj instanceof ds.livestockActivityService.LiveHeartRate)) {
      return super.equals(obj);
    }
    ds.livestockActivityService.LiveHeartRate other = (ds.livestockActivityService.LiveHeartRate) obj;

    boolean result = true;
    result = result && (getBpm()
        == other.getBpm());
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
    hash = (37 * hash) + BPM_FIELD_NUMBER;
    hash = (53 * hash) + getBpm();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.livestockActivityService.LiveHeartRate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.LiveHeartRate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.LiveHeartRate parseFrom(
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
  public static Builder newBuilder(ds.livestockActivityService.LiveHeartRate prototype) {
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
   * Protobuf type {@code livestockActivityService.LiveHeartRate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:livestockActivityService.LiveHeartRate)
      ds.livestockActivityService.LiveHeartRateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_LiveHeartRate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_LiveHeartRate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.livestockActivityService.LiveHeartRate.class, ds.livestockActivityService.LiveHeartRate.Builder.class);
    }

    // Construct using ds.livestockActivityService.LiveHeartRate.newBuilder()
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
      bpm_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_LiveHeartRate_descriptor;
    }

    @java.lang.Override
    public ds.livestockActivityService.LiveHeartRate getDefaultInstanceForType() {
      return ds.livestockActivityService.LiveHeartRate.getDefaultInstance();
    }

    @java.lang.Override
    public ds.livestockActivityService.LiveHeartRate build() {
      ds.livestockActivityService.LiveHeartRate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.livestockActivityService.LiveHeartRate buildPartial() {
      ds.livestockActivityService.LiveHeartRate result = new ds.livestockActivityService.LiveHeartRate(this);
      result.bpm_ = bpm_;
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
      if (other instanceof ds.livestockActivityService.LiveHeartRate) {
        return mergeFrom((ds.livestockActivityService.LiveHeartRate)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.livestockActivityService.LiveHeartRate other) {
      if (other == ds.livestockActivityService.LiveHeartRate.getDefaultInstance()) return this;
      if (other.getBpm() != 0) {
        setBpm(other.getBpm());
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
      ds.livestockActivityService.LiveHeartRate parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.livestockActivityService.LiveHeartRate) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bpm_ ;
    /**
     * <code>int32 bpm = 1;</code>
     */
    public int getBpm() {
      return bpm_;
    }
    /**
     * <code>int32 bpm = 1;</code>
     */
    public Builder setBpm(int value) {
      
      bpm_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 bpm = 1;</code>
     */
    public Builder clearBpm() {
      
      bpm_ = 0;
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


    // @@protoc_insertion_point(builder_scope:livestockActivityService.LiveHeartRate)
  }

  // @@protoc_insertion_point(class_scope:livestockActivityService.LiveHeartRate)
  private static final ds.livestockActivityService.LiveHeartRate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.livestockActivityService.LiveHeartRate();
  }

  public static ds.livestockActivityService.LiveHeartRate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LiveHeartRate>
      PARSER = new com.google.protobuf.AbstractParser<LiveHeartRate>() {
    @java.lang.Override
    public LiveHeartRate parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LiveHeartRate(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LiveHeartRate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LiveHeartRate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.livestockActivityService.LiveHeartRate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

