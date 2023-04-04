// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MilkingParlourService.proto

package ds.milkingParlourService;

/**
 * Protobuf type {@code milkingParlourService.SetMachineDetailsReply}
 */
public  final class SetMachineDetailsReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:milkingParlourService.SetMachineDetailsReply)
    SetMachineDetailsReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetMachineDetailsReply.newBuilder() to construct.
  private SetMachineDetailsReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetMachineDetailsReply() {
    setMachineDetailsReply_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetMachineDetailsReply(
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
            java.lang.String s = input.readStringRequireUtf8();

            setMachineDetailsReply_ = s;
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
    return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_SetMachineDetailsReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_SetMachineDetailsReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.milkingParlourService.SetMachineDetailsReply.class, ds.milkingParlourService.SetMachineDetailsReply.Builder.class);
  }

  public static final int SETMACHINEDETAILSREPLY_FIELD_NUMBER = 1;
  private volatile java.lang.Object setMachineDetailsReply_;
  /**
   * <code>string setMachineDetailsReply = 1;</code>
   */
  public java.lang.String getSetMachineDetailsReply() {
    java.lang.Object ref = setMachineDetailsReply_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      setMachineDetailsReply_ = s;
      return s;
    }
  }
  /**
   * <code>string setMachineDetailsReply = 1;</code>
   */
  public com.google.protobuf.ByteString
      getSetMachineDetailsReplyBytes() {
    java.lang.Object ref = setMachineDetailsReply_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      setMachineDetailsReply_ = b;
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
    if (!getSetMachineDetailsReplyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, setMachineDetailsReply_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSetMachineDetailsReplyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, setMachineDetailsReply_);
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
    if (!(obj instanceof ds.milkingParlourService.SetMachineDetailsReply)) {
      return super.equals(obj);
    }
    ds.milkingParlourService.SetMachineDetailsReply other = (ds.milkingParlourService.SetMachineDetailsReply) obj;

    boolean result = true;
    result = result && getSetMachineDetailsReply()
        .equals(other.getSetMachineDetailsReply());
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
    hash = (37 * hash) + SETMACHINEDETAILSREPLY_FIELD_NUMBER;
    hash = (53 * hash) + getSetMachineDetailsReply().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.milkingParlourService.SetMachineDetailsReply parseFrom(
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
  public static Builder newBuilder(ds.milkingParlourService.SetMachineDetailsReply prototype) {
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
   * Protobuf type {@code milkingParlourService.SetMachineDetailsReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:milkingParlourService.SetMachineDetailsReply)
      ds.milkingParlourService.SetMachineDetailsReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_SetMachineDetailsReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_SetMachineDetailsReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.milkingParlourService.SetMachineDetailsReply.class, ds.milkingParlourService.SetMachineDetailsReply.Builder.class);
    }

    // Construct using ds.milkingParlourService.SetMachineDetailsReply.newBuilder()
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
      setMachineDetailsReply_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.milkingParlourService.MilkingParlourServiceImpl.internal_static_milkingParlourService_SetMachineDetailsReply_descriptor;
    }

    @java.lang.Override
    public ds.milkingParlourService.SetMachineDetailsReply getDefaultInstanceForType() {
      return ds.milkingParlourService.SetMachineDetailsReply.getDefaultInstance();
    }

    @java.lang.Override
    public ds.milkingParlourService.SetMachineDetailsReply build() {
      ds.milkingParlourService.SetMachineDetailsReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.milkingParlourService.SetMachineDetailsReply buildPartial() {
      ds.milkingParlourService.SetMachineDetailsReply result = new ds.milkingParlourService.SetMachineDetailsReply(this);
      result.setMachineDetailsReply_ = setMachineDetailsReply_;
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
      if (other instanceof ds.milkingParlourService.SetMachineDetailsReply) {
        return mergeFrom((ds.milkingParlourService.SetMachineDetailsReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.milkingParlourService.SetMachineDetailsReply other) {
      if (other == ds.milkingParlourService.SetMachineDetailsReply.getDefaultInstance()) return this;
      if (!other.getSetMachineDetailsReply().isEmpty()) {
        setMachineDetailsReply_ = other.setMachineDetailsReply_;
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
      ds.milkingParlourService.SetMachineDetailsReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.milkingParlourService.SetMachineDetailsReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object setMachineDetailsReply_ = "";
    /**
     * <code>string setMachineDetailsReply = 1;</code>
     */
    public java.lang.String getSetMachineDetailsReply() {
      java.lang.Object ref = setMachineDetailsReply_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        setMachineDetailsReply_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string setMachineDetailsReply = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSetMachineDetailsReplyBytes() {
      java.lang.Object ref = setMachineDetailsReply_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        setMachineDetailsReply_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string setMachineDetailsReply = 1;</code>
     */
    public Builder setSetMachineDetailsReply(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      setMachineDetailsReply_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string setMachineDetailsReply = 1;</code>
     */
    public Builder clearSetMachineDetailsReply() {
      
      setMachineDetailsReply_ = getDefaultInstance().getSetMachineDetailsReply();
      onChanged();
      return this;
    }
    /**
     * <code>string setMachineDetailsReply = 1;</code>
     */
    public Builder setSetMachineDetailsReplyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      setMachineDetailsReply_ = value;
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


    // @@protoc_insertion_point(builder_scope:milkingParlourService.SetMachineDetailsReply)
  }

  // @@protoc_insertion_point(class_scope:milkingParlourService.SetMachineDetailsReply)
  private static final ds.milkingParlourService.SetMachineDetailsReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.milkingParlourService.SetMachineDetailsReply();
  }

  public static ds.milkingParlourService.SetMachineDetailsReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetMachineDetailsReply>
      PARSER = new com.google.protobuf.AbstractParser<SetMachineDetailsReply>() {
    @java.lang.Override
    public SetMachineDetailsReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetMachineDetailsReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetMachineDetailsReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetMachineDetailsReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.milkingParlourService.SetMachineDetailsReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
