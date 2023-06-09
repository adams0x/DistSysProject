// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LivestockActivityService.proto

package ds.livestockActivityService;

/**
 * Protobuf type {@code livestockActivityService.AnimalTimeSpan}
 */
public  final class AnimalTimeSpan extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:livestockActivityService.AnimalTimeSpan)
    AnimalTimeSpanOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AnimalTimeSpan.newBuilder() to construct.
  private AnimalTimeSpan(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AnimalTimeSpan() {
    startDate_ = "";
    endDate_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AnimalTimeSpan(
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

            startDate_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            endDate_ = s;
            break;
          }
          case 26: {
            ds.livestockActivityService.AnimalId.Builder subBuilder = null;
            if (animalID_ != null) {
              subBuilder = animalID_.toBuilder();
            }
            animalID_ = input.readMessage(ds.livestockActivityService.AnimalId.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(animalID_);
              animalID_ = subBuilder.buildPartial();
            }

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
    return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalTimeSpan_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalTimeSpan_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.livestockActivityService.AnimalTimeSpan.class, ds.livestockActivityService.AnimalTimeSpan.Builder.class);
  }

  public static final int STARTDATE_FIELD_NUMBER = 1;
  private volatile java.lang.Object startDate_;
  /**
   * <code>string startDate = 1;</code>
   */
  public java.lang.String getStartDate() {
    java.lang.Object ref = startDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      startDate_ = s;
      return s;
    }
  }
  /**
   * <code>string startDate = 1;</code>
   */
  public com.google.protobuf.ByteString
      getStartDateBytes() {
    java.lang.Object ref = startDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      startDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ENDDATE_FIELD_NUMBER = 2;
  private volatile java.lang.Object endDate_;
  /**
   * <code>string endDate = 2;</code>
   */
  public java.lang.String getEndDate() {
    java.lang.Object ref = endDate_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      endDate_ = s;
      return s;
    }
  }
  /**
   * <code>string endDate = 2;</code>
   */
  public com.google.protobuf.ByteString
      getEndDateBytes() {
    java.lang.Object ref = endDate_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      endDate_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ANIMALID_FIELD_NUMBER = 3;
  private ds.livestockActivityService.AnimalId animalID_;
  /**
   * <code>.livestockActivityService.AnimalId animalID = 3;</code>
   */
  public boolean hasAnimalID() {
    return animalID_ != null;
  }
  /**
   * <code>.livestockActivityService.AnimalId animalID = 3;</code>
   */
  public ds.livestockActivityService.AnimalId getAnimalID() {
    return animalID_ == null ? ds.livestockActivityService.AnimalId.getDefaultInstance() : animalID_;
  }
  /**
   * <code>.livestockActivityService.AnimalId animalID = 3;</code>
   */
  public ds.livestockActivityService.AnimalIdOrBuilder getAnimalIDOrBuilder() {
    return getAnimalID();
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
    if (!getStartDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, startDate_);
    }
    if (!getEndDateBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, endDate_);
    }
    if (animalID_ != null) {
      output.writeMessage(3, getAnimalID());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getStartDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, startDate_);
    }
    if (!getEndDateBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, endDate_);
    }
    if (animalID_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getAnimalID());
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
    if (!(obj instanceof ds.livestockActivityService.AnimalTimeSpan)) {
      return super.equals(obj);
    }
    ds.livestockActivityService.AnimalTimeSpan other = (ds.livestockActivityService.AnimalTimeSpan) obj;

    boolean result = true;
    result = result && getStartDate()
        .equals(other.getStartDate());
    result = result && getEndDate()
        .equals(other.getEndDate());
    result = result && (hasAnimalID() == other.hasAnimalID());
    if (hasAnimalID()) {
      result = result && getAnimalID()
          .equals(other.getAnimalID());
    }
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
    hash = (37 * hash) + STARTDATE_FIELD_NUMBER;
    hash = (53 * hash) + getStartDate().hashCode();
    hash = (37 * hash) + ENDDATE_FIELD_NUMBER;
    hash = (53 * hash) + getEndDate().hashCode();
    if (hasAnimalID()) {
      hash = (37 * hash) + ANIMALID_FIELD_NUMBER;
      hash = (53 * hash) + getAnimalID().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.AnimalTimeSpan parseFrom(
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
  public static Builder newBuilder(ds.livestockActivityService.AnimalTimeSpan prototype) {
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
   * Protobuf type {@code livestockActivityService.AnimalTimeSpan}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:livestockActivityService.AnimalTimeSpan)
      ds.livestockActivityService.AnimalTimeSpanOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalTimeSpan_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalTimeSpan_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.livestockActivityService.AnimalTimeSpan.class, ds.livestockActivityService.AnimalTimeSpan.Builder.class);
    }

    // Construct using ds.livestockActivityService.AnimalTimeSpan.newBuilder()
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
      startDate_ = "";

      endDate_ = "";

      if (animalIDBuilder_ == null) {
        animalID_ = null;
      } else {
        animalID_ = null;
        animalIDBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalTimeSpan_descriptor;
    }

    @java.lang.Override
    public ds.livestockActivityService.AnimalTimeSpan getDefaultInstanceForType() {
      return ds.livestockActivityService.AnimalTimeSpan.getDefaultInstance();
    }

    @java.lang.Override
    public ds.livestockActivityService.AnimalTimeSpan build() {
      ds.livestockActivityService.AnimalTimeSpan result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.livestockActivityService.AnimalTimeSpan buildPartial() {
      ds.livestockActivityService.AnimalTimeSpan result = new ds.livestockActivityService.AnimalTimeSpan(this);
      result.startDate_ = startDate_;
      result.endDate_ = endDate_;
      if (animalIDBuilder_ == null) {
        result.animalID_ = animalID_;
      } else {
        result.animalID_ = animalIDBuilder_.build();
      }
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
      if (other instanceof ds.livestockActivityService.AnimalTimeSpan) {
        return mergeFrom((ds.livestockActivityService.AnimalTimeSpan)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.livestockActivityService.AnimalTimeSpan other) {
      if (other == ds.livestockActivityService.AnimalTimeSpan.getDefaultInstance()) return this;
      if (!other.getStartDate().isEmpty()) {
        startDate_ = other.startDate_;
        onChanged();
      }
      if (!other.getEndDate().isEmpty()) {
        endDate_ = other.endDate_;
        onChanged();
      }
      if (other.hasAnimalID()) {
        mergeAnimalID(other.getAnimalID());
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
      ds.livestockActivityService.AnimalTimeSpan parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.livestockActivityService.AnimalTimeSpan) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object startDate_ = "";
    /**
     * <code>string startDate = 1;</code>
     */
    public java.lang.String getStartDate() {
      java.lang.Object ref = startDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        startDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public com.google.protobuf.ByteString
        getStartDateBytes() {
      java.lang.Object ref = startDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        startDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public Builder setStartDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      startDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public Builder clearStartDate() {
      
      startDate_ = getDefaultInstance().getStartDate();
      onChanged();
      return this;
    }
    /**
     * <code>string startDate = 1;</code>
     */
    public Builder setStartDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      startDate_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object endDate_ = "";
    /**
     * <code>string endDate = 2;</code>
     */
    public java.lang.String getEndDate() {
      java.lang.Object ref = endDate_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        endDate_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string endDate = 2;</code>
     */
    public com.google.protobuf.ByteString
        getEndDateBytes() {
      java.lang.Object ref = endDate_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        endDate_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string endDate = 2;</code>
     */
    public Builder setEndDate(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      endDate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string endDate = 2;</code>
     */
    public Builder clearEndDate() {
      
      endDate_ = getDefaultInstance().getEndDate();
      onChanged();
      return this;
    }
    /**
     * <code>string endDate = 2;</code>
     */
    public Builder setEndDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      endDate_ = value;
      onChanged();
      return this;
    }

    private ds.livestockActivityService.AnimalId animalID_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.livestockActivityService.AnimalId, ds.livestockActivityService.AnimalId.Builder, ds.livestockActivityService.AnimalIdOrBuilder> animalIDBuilder_;
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public boolean hasAnimalID() {
      return animalIDBuilder_ != null || animalID_ != null;
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public ds.livestockActivityService.AnimalId getAnimalID() {
      if (animalIDBuilder_ == null) {
        return animalID_ == null ? ds.livestockActivityService.AnimalId.getDefaultInstance() : animalID_;
      } else {
        return animalIDBuilder_.getMessage();
      }
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public Builder setAnimalID(ds.livestockActivityService.AnimalId value) {
      if (animalIDBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        animalID_ = value;
        onChanged();
      } else {
        animalIDBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public Builder setAnimalID(
        ds.livestockActivityService.AnimalId.Builder builderForValue) {
      if (animalIDBuilder_ == null) {
        animalID_ = builderForValue.build();
        onChanged();
      } else {
        animalIDBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public Builder mergeAnimalID(ds.livestockActivityService.AnimalId value) {
      if (animalIDBuilder_ == null) {
        if (animalID_ != null) {
          animalID_ =
            ds.livestockActivityService.AnimalId.newBuilder(animalID_).mergeFrom(value).buildPartial();
        } else {
          animalID_ = value;
        }
        onChanged();
      } else {
        animalIDBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public Builder clearAnimalID() {
      if (animalIDBuilder_ == null) {
        animalID_ = null;
        onChanged();
      } else {
        animalID_ = null;
        animalIDBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public ds.livestockActivityService.AnimalId.Builder getAnimalIDBuilder() {
      
      onChanged();
      return getAnimalIDFieldBuilder().getBuilder();
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    public ds.livestockActivityService.AnimalIdOrBuilder getAnimalIDOrBuilder() {
      if (animalIDBuilder_ != null) {
        return animalIDBuilder_.getMessageOrBuilder();
      } else {
        return animalID_ == null ?
            ds.livestockActivityService.AnimalId.getDefaultInstance() : animalID_;
      }
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.livestockActivityService.AnimalId, ds.livestockActivityService.AnimalId.Builder, ds.livestockActivityService.AnimalIdOrBuilder> 
        getAnimalIDFieldBuilder() {
      if (animalIDBuilder_ == null) {
        animalIDBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ds.livestockActivityService.AnimalId, ds.livestockActivityService.AnimalId.Builder, ds.livestockActivityService.AnimalIdOrBuilder>(
                getAnimalID(),
                getParentForChildren(),
                isClean());
        animalID_ = null;
      }
      return animalIDBuilder_;
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


    // @@protoc_insertion_point(builder_scope:livestockActivityService.AnimalTimeSpan)
  }

  // @@protoc_insertion_point(class_scope:livestockActivityService.AnimalTimeSpan)
  private static final ds.livestockActivityService.AnimalTimeSpan DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.livestockActivityService.AnimalTimeSpan();
  }

  public static ds.livestockActivityService.AnimalTimeSpan getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AnimalTimeSpan>
      PARSER = new com.google.protobuf.AbstractParser<AnimalTimeSpan>() {
    @java.lang.Override
    public AnimalTimeSpan parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AnimalTimeSpan(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AnimalTimeSpan> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AnimalTimeSpan> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.livestockActivityService.AnimalTimeSpan getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

