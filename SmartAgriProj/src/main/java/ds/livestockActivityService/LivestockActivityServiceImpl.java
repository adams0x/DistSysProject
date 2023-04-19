// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LivestockActivityService.proto

package ds.livestockActivityService;

public final class LivestockActivityServiceImpl {
  private LivestockActivityServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_AnimalId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_AnimalId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_AnimalDetail_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_AnimalDetail_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_SetAnimalDetailsReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_SetAnimalDetailsReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_AnimalTimeSpan_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_AnimalTimeSpan_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_LiveHeartRate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_LiveHeartRate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_HeartRateHistory_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_HeartRateHistory_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_CurrentActivity_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_CurrentActivity_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_AnimalHealthInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_AnimalHealthInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_livestockActivityService_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_livestockActivityService_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036LivestockActivityService.proto\022\030livest" +
      "ockActivityService\"\026\n\010AnimalId\022\n\n\002id\030\001 \001" +
      "(\005\"\366\001\n\014AnimalDetail\0224\n\010animalID\030\001 \001(\0132\"." +
      "livestockActivityService.AnimalId\022I\n\014typ" +
      "eOfAnimal\030\002 \001(\01623.livestockActivityServi" +
      "ce.AnimalDetail.TypeOfAnimal\022\023\n\013dateOfBi" +
      "rth\030\003 \001(\t\022\027\n\017dateNextVaccine\030\004 \001(\t\"7\n\014Ty" +
      "peOfAnimal\022\007\n\003COW\020\000\022\t\n\005SHEEP\020\001\022\t\n\005HORSE\020" +
      "\002\022\010\n\004GOAT\020\003\"6\n\025SetAnimalDetailsReply\022\035\n\025" +
      "setAnimalDetailsReply\030\001 \001(\t\"k\n\016AnimalTim" +
      "eSpan\022\021\n\tstartDate\030\001 \001(\t\022\017\n\007endDate\030\002 \001(" +
      "\t\0225\n\tmachineID\030\003 \001(\0132\".livestockActivity" +
      "Service.AnimalId\"\034\n\rLiveHeartRate\022\013\n\003bpm" +
      "\030\001 \001(\005\"2\n\020HeartRateHistory\022\013\n\003bpm\030\001 \001(\005\022" +
      "\021\n\ttimeStamp\030\002 \001(\t\"\331\001\n\017CurrentActivity\0224" +
      "\n\010animalID\030\001 \001(\0132\".livestockActivityServ" +
      "ice.AnimalId\022D\n\010activity\030\002 \001(\01622.livesto" +
      "ckActivityService.CurrentActivity.Activi" +
      "ty\"J\n\010Activity\022\014\n\010standing\020\000\022\013\n\007feeding\020" +
      "\001\022\014\n\010drinking\020\002\022\t\n\005lying\020\003\022\n\n\006moving\020\004\"\246" +
      "\002\n\020AnimalHealthInfo\022\022\n\nreportDate\030\001 \001(\t\022" +
      "\016\n\006minBPM\030\002 \001(\005\022\016\n\006maxBPM\030\003 \001(\005\022\016\n\006avgBP" +
      "M\030\004 \001(\005\022J\n\017healthIndicator\030\005 \001(\01621.lives" +
      "tockActivityService.AnimalHealthInfo.Hea" +
      "lth\0226\n\006animal\030\006 \001(\0132&.livestockActivityS" +
      "ervice.AnimalDetail\"J\n\006Health\022\013\n\007healthy" +
      "\020\000\022\016\n\nvaccineDue\020\001\022\021\n\rhighHeartRate\020\002\022\020\n" +
      "\014lowHeartRate\020\003\"\007\n\005Empty2\210\005\n\030LivestockAc" +
      "tivityService\022o\n\020SetAnimalDetails\022&.live" +
      "stockActivityService.AnimalDetail\032/.live" +
      "stockActivityService.SetAnimalDetailsRep" +
      "ly\"\000(\001\022W\n\014GetAnimalIds\022\037.livestockActivi" +
      "tyService.Empty\032\".livestockActivityServi" +
      "ce.AnimalId\"\0000\001\022c\n\020GetLiveHeartRate\022\".li" +
      "vestockActivityService.AnimalId\032\'.livest" +
      "ockActivityService.LiveHeartRate\"\0000\001\022m\n\023" +
      "GetHeartRateHistory\022(.livestockActivityS" +
      "ervice.AnimalTimeSpan\032*.livestockActivit" +
      "yService.HeartRateHistory\"\000\022e\n\022GetCurren" +
      "tActivity\022\".livestockActivityService.Ani" +
      "malId\032).livestockActivityService.Current" +
      "Activity\"\000\022g\n\017GetAnimalVitals\022\".livestoc" +
      "kActivityService.AnimalId\032*.livestockAct" +
      "ivityService.AnimalHealthInfo\"\000(\0010\001B=\n\033d" +
      "s.livestockActivityServiceB\034LivestockAct" +
      "ivityServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_livestockActivityService_AnimalId_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_livestockActivityService_AnimalId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_AnimalId_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_livestockActivityService_AnimalDetail_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_livestockActivityService_AnimalDetail_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_AnimalDetail_descriptor,
        new java.lang.String[] { "AnimalID", "TypeOfAnimal", "DateOfBirth", "DateNextVaccine", });
    internal_static_livestockActivityService_SetAnimalDetailsReply_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_livestockActivityService_SetAnimalDetailsReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_SetAnimalDetailsReply_descriptor,
        new java.lang.String[] { "SetAnimalDetailsReply", });
    internal_static_livestockActivityService_AnimalTimeSpan_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_livestockActivityService_AnimalTimeSpan_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_AnimalTimeSpan_descriptor,
        new java.lang.String[] { "StartDate", "EndDate", "MachineID", });
    internal_static_livestockActivityService_LiveHeartRate_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_livestockActivityService_LiveHeartRate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_LiveHeartRate_descriptor,
        new java.lang.String[] { "Bpm", });
    internal_static_livestockActivityService_HeartRateHistory_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_livestockActivityService_HeartRateHistory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_HeartRateHistory_descriptor,
        new java.lang.String[] { "Bpm", "TimeStamp", });
    internal_static_livestockActivityService_CurrentActivity_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_livestockActivityService_CurrentActivity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_CurrentActivity_descriptor,
        new java.lang.String[] { "AnimalID", "Activity", });
    internal_static_livestockActivityService_AnimalHealthInfo_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_livestockActivityService_AnimalHealthInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_AnimalHealthInfo_descriptor,
        new java.lang.String[] { "ReportDate", "MinBPM", "MaxBPM", "AvgBPM", "HealthIndicator", "Animal", });
    internal_static_livestockActivityService_Empty_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_livestockActivityService_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_livestockActivityService_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
