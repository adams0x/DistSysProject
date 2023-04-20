// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LivestockActivityService.proto

package ds.livestockActivityService;

/**
 * Protobuf type {@code livestockActivityService.AnimalDetail}
 */
public  final class AnimalDetail extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:livestockActivityService.AnimalDetail)
    AnimalDetailOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AnimalDetail.newBuilder() to construct.
  private AnimalDetail(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AnimalDetail() {
    typeOfAnimal_ = 0;
    dateOfBirth_ = "";
    dateNextVaccine_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AnimalDetail(
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
          case 16: {
            int rawValue = input.readEnum();

            typeOfAnimal_ = rawValue;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            dateOfBirth_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            dateNextVaccine_ = s;
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
    return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalDetail_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalDetail_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.livestockActivityService.AnimalDetail.class, ds.livestockActivityService.AnimalDetail.Builder.class);
  }

  /**
   * Protobuf enum {@code livestockActivityService.AnimalDetail.TypeOfAnimal}
   */
  public enum TypeOfAnimal
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>COW = 0;</code>
     */
    COW(0),
    /**
     * <code>SHEEP = 1;</code>
     */
    SHEEP(1),
    /**
     * <code>HORSE = 2;</code>
     */
    HORSE(2),
    /**
     * <code>GOAT = 3;</code>
     */
    GOAT(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>COW = 0;</code>
     */
    public static final int COW_VALUE = 0;
    /**
     * <code>SHEEP = 1;</code>
     */
    public static final int SHEEP_VALUE = 1;
    /**
     * <code>HORSE = 2;</code>
     */
    public static final int HORSE_VALUE = 2;
    /**
     * <code>GOAT = 3;</code>
     */
    public static final int GOAT_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TypeOfAnimal valueOf(int value) {
      return forNumber(value);
    }

    public static TypeOfAnimal forNumber(int value) {
      switch (value) {
        case 0: return COW;
        case 1: return SHEEP;
        case 2: return HORSE;
        case 3: return GOAT;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TypeOfAnimal>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        TypeOfAnimal> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<TypeOfAnimal>() {
            public TypeOfAnimal findValueByNumber(int number) {
              return TypeOfAnimal.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return ds.livestockActivityService.AnimalDetail.getDescriptor().getEnumTypes().get(0);
    }

    private static final TypeOfAnimal[] VALUES = values();

    public static TypeOfAnimal valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private TypeOfAnimal(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:livestockActivityService.AnimalDetail.TypeOfAnimal)
  }

  public static final int ANIMALID_FIELD_NUMBER = 1;
  private ds.livestockActivityService.AnimalId animalID_;
  /**
   * <code>.livestockActivityService.AnimalId animalID = 1;</code>
   */
  public boolean hasAnimalID() {
    return animalID_ != null;
  }
  /**
   * <code>.livestockActivityService.AnimalId animalID = 1;</code>
   */
  public ds.livestockActivityService.AnimalId getAnimalID() {
    return animalID_ == null ? ds.livestockActivityService.AnimalId.getDefaultInstance() : animalID_;
  }
  /**
   * <code>.livestockActivityService.AnimalId animalID = 1;</code>
   */
  public ds.livestockActivityService.AnimalIdOrBuilder getAnimalIDOrBuilder() {
    return getAnimalID();
  }

  public static final int TYPEOFANIMAL_FIELD_NUMBER = 2;
  private int typeOfAnimal_;
  /**
   * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
   */
  public int getTypeOfAnimalValue() {
    return typeOfAnimal_;
  }
  /**
   * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
   */
  public ds.livestockActivityService.AnimalDetail.TypeOfAnimal getTypeOfAnimal() {
    @SuppressWarnings("deprecation")
    ds.livestockActivityService.AnimalDetail.TypeOfAnimal result = ds.livestockActivityService.AnimalDetail.TypeOfAnimal.valueOf(typeOfAnimal_);
    return result == null ? ds.livestockActivityService.AnimalDetail.TypeOfAnimal.UNRECOGNIZED : result;
  }

  public static final int DATEOFBIRTH_FIELD_NUMBER = 3;
  private volatile java.lang.Object dateOfBirth_;
  /**
   * <code>string dateOfBirth = 3;</code>
   */
  public java.lang.String getDateOfBirth() {
    java.lang.Object ref = dateOfBirth_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dateOfBirth_ = s;
      return s;
    }
  }
  /**
   * <code>string dateOfBirth = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDateOfBirthBytes() {
    java.lang.Object ref = dateOfBirth_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dateOfBirth_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATENEXTVACCINE_FIELD_NUMBER = 4;
  private volatile java.lang.Object dateNextVaccine_;
  /**
   * <code>string dateNextVaccine = 4;</code>
   */
  public java.lang.String getDateNextVaccine() {
    java.lang.Object ref = dateNextVaccine_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dateNextVaccine_ = s;
      return s;
    }
  }
  /**
   * <code>string dateNextVaccine = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDateNextVaccineBytes() {
    java.lang.Object ref = dateNextVaccine_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dateNextVaccine_ = b;
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
    if (animalID_ != null) {
      output.writeMessage(1, getAnimalID());
    }
    if (typeOfAnimal_ != ds.livestockActivityService.AnimalDetail.TypeOfAnimal.COW.getNumber()) {
      output.writeEnum(2, typeOfAnimal_);
    }
    if (!getDateOfBirthBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, dateOfBirth_);
    }
    if (!getDateNextVaccineBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, dateNextVaccine_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (animalID_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAnimalID());
    }
    if (typeOfAnimal_ != ds.livestockActivityService.AnimalDetail.TypeOfAnimal.COW.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, typeOfAnimal_);
    }
    if (!getDateOfBirthBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, dateOfBirth_);
    }
    if (!getDateNextVaccineBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, dateNextVaccine_);
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
    if (!(obj instanceof ds.livestockActivityService.AnimalDetail)) {
      return super.equals(obj);
    }
    ds.livestockActivityService.AnimalDetail other = (ds.livestockActivityService.AnimalDetail) obj;

    boolean result = true;
    result = result && (hasAnimalID() == other.hasAnimalID());
    if (hasAnimalID()) {
      result = result && getAnimalID()
          .equals(other.getAnimalID());
    }
    result = result && typeOfAnimal_ == other.typeOfAnimal_;
    result = result && getDateOfBirth()
        .equals(other.getDateOfBirth());
    result = result && getDateNextVaccine()
        .equals(other.getDateNextVaccine());
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
    if (hasAnimalID()) {
      hash = (37 * hash) + ANIMALID_FIELD_NUMBER;
      hash = (53 * hash) + getAnimalID().hashCode();
    }
    hash = (37 * hash) + TYPEOFANIMAL_FIELD_NUMBER;
    hash = (53 * hash) + typeOfAnimal_;
    hash = (37 * hash) + DATEOFBIRTH_FIELD_NUMBER;
    hash = (53 * hash) + getDateOfBirth().hashCode();
    hash = (37 * hash) + DATENEXTVACCINE_FIELD_NUMBER;
    hash = (53 * hash) + getDateNextVaccine().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.livestockActivityService.AnimalDetail parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalDetail parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.AnimalDetail parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.livestockActivityService.AnimalDetail parseFrom(
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
  public static Builder newBuilder(ds.livestockActivityService.AnimalDetail prototype) {
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
   * Protobuf type {@code livestockActivityService.AnimalDetail}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:livestockActivityService.AnimalDetail)
      ds.livestockActivityService.AnimalDetailOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalDetail_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalDetail_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.livestockActivityService.AnimalDetail.class, ds.livestockActivityService.AnimalDetail.Builder.class);
    }

    // Construct using ds.livestockActivityService.AnimalDetail.newBuilder()
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
      if (animalIDBuilder_ == null) {
        animalID_ = null;
      } else {
        animalID_ = null;
        animalIDBuilder_ = null;
      }
      typeOfAnimal_ = 0;

      dateOfBirth_ = "";

      dateNextVaccine_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.livestockActivityService.LivestockActivityServiceImpl.internal_static_livestockActivityService_AnimalDetail_descriptor;
    }

    @java.lang.Override
    public ds.livestockActivityService.AnimalDetail getDefaultInstanceForType() {
      return ds.livestockActivityService.AnimalDetail.getDefaultInstance();
    }

    @java.lang.Override
    public ds.livestockActivityService.AnimalDetail build() {
      ds.livestockActivityService.AnimalDetail result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.livestockActivityService.AnimalDetail buildPartial() {
      ds.livestockActivityService.AnimalDetail result = new ds.livestockActivityService.AnimalDetail(this);
      if (animalIDBuilder_ == null) {
        result.animalID_ = animalID_;
      } else {
        result.animalID_ = animalIDBuilder_.build();
      }
      result.typeOfAnimal_ = typeOfAnimal_;
      result.dateOfBirth_ = dateOfBirth_;
      result.dateNextVaccine_ = dateNextVaccine_;
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
      if (other instanceof ds.livestockActivityService.AnimalDetail) {
        return mergeFrom((ds.livestockActivityService.AnimalDetail)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.livestockActivityService.AnimalDetail other) {
      if (other == ds.livestockActivityService.AnimalDetail.getDefaultInstance()) return this;
      if (other.hasAnimalID()) {
        mergeAnimalID(other.getAnimalID());
      }
      if (other.typeOfAnimal_ != 0) {
        setTypeOfAnimalValue(other.getTypeOfAnimalValue());
      }
      if (!other.getDateOfBirth().isEmpty()) {
        dateOfBirth_ = other.dateOfBirth_;
        onChanged();
      }
      if (!other.getDateNextVaccine().isEmpty()) {
        dateNextVaccine_ = other.dateNextVaccine_;
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
      ds.livestockActivityService.AnimalDetail parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.livestockActivityService.AnimalDetail) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ds.livestockActivityService.AnimalId animalID_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.livestockActivityService.AnimalId, ds.livestockActivityService.AnimalId.Builder, ds.livestockActivityService.AnimalIdOrBuilder> animalIDBuilder_;
    /**
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
     */
    public boolean hasAnimalID() {
      return animalIDBuilder_ != null || animalID_ != null;
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
     */
    public ds.livestockActivityService.AnimalId getAnimalID() {
      if (animalIDBuilder_ == null) {
        return animalID_ == null ? ds.livestockActivityService.AnimalId.getDefaultInstance() : animalID_;
      } else {
        return animalIDBuilder_.getMessage();
      }
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
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
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
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
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
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
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
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
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
     */
    public ds.livestockActivityService.AnimalId.Builder getAnimalIDBuilder() {
      
      onChanged();
      return getAnimalIDFieldBuilder().getBuilder();
    }
    /**
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
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
     * <code>.livestockActivityService.AnimalId animalID = 1;</code>
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

    private int typeOfAnimal_ = 0;
    /**
     * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
     */
    public int getTypeOfAnimalValue() {
      return typeOfAnimal_;
    }
    /**
     * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
     */
    public Builder setTypeOfAnimalValue(int value) {
      typeOfAnimal_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
     */
    public ds.livestockActivityService.AnimalDetail.TypeOfAnimal getTypeOfAnimal() {
      @SuppressWarnings("deprecation")
      ds.livestockActivityService.AnimalDetail.TypeOfAnimal result = ds.livestockActivityService.AnimalDetail.TypeOfAnimal.valueOf(typeOfAnimal_);
      return result == null ? ds.livestockActivityService.AnimalDetail.TypeOfAnimal.UNRECOGNIZED : result;
    }
    /**
     * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
     */
    public Builder setTypeOfAnimal(ds.livestockActivityService.AnimalDetail.TypeOfAnimal value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      typeOfAnimal_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
     */
    public Builder clearTypeOfAnimal() {
      
      typeOfAnimal_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object dateOfBirth_ = "";
    /**
     * <code>string dateOfBirth = 3;</code>
     */
    public java.lang.String getDateOfBirth() {
      java.lang.Object ref = dateOfBirth_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dateOfBirth_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dateOfBirth = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDateOfBirthBytes() {
      java.lang.Object ref = dateOfBirth_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dateOfBirth_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dateOfBirth = 3;</code>
     */
    public Builder setDateOfBirth(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dateOfBirth_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dateOfBirth = 3;</code>
     */
    public Builder clearDateOfBirth() {
      
      dateOfBirth_ = getDefaultInstance().getDateOfBirth();
      onChanged();
      return this;
    }
    /**
     * <code>string dateOfBirth = 3;</code>
     */
    public Builder setDateOfBirthBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dateOfBirth_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dateNextVaccine_ = "";
    /**
     * <code>string dateNextVaccine = 4;</code>
     */
    public java.lang.String getDateNextVaccine() {
      java.lang.Object ref = dateNextVaccine_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dateNextVaccine_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dateNextVaccine = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDateNextVaccineBytes() {
      java.lang.Object ref = dateNextVaccine_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dateNextVaccine_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dateNextVaccine = 4;</code>
     */
    public Builder setDateNextVaccine(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dateNextVaccine_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dateNextVaccine = 4;</code>
     */
    public Builder clearDateNextVaccine() {
      
      dateNextVaccine_ = getDefaultInstance().getDateNextVaccine();
      onChanged();
      return this;
    }
    /**
     * <code>string dateNextVaccine = 4;</code>
     */
    public Builder setDateNextVaccineBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dateNextVaccine_ = value;
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


    // @@protoc_insertion_point(builder_scope:livestockActivityService.AnimalDetail)
  }

  // @@protoc_insertion_point(class_scope:livestockActivityService.AnimalDetail)
  private static final ds.livestockActivityService.AnimalDetail DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.livestockActivityService.AnimalDetail();
  }

  public static ds.livestockActivityService.AnimalDetail getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AnimalDetail>
      PARSER = new com.google.protobuf.AbstractParser<AnimalDetail>() {
    @java.lang.Override
    public AnimalDetail parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AnimalDetail(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AnimalDetail> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AnimalDetail> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.livestockActivityService.AnimalDetail getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
