// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MilkingParlourService.proto

package ds.milkingParlourService;

public interface MachineDetailOrBuilder extends
    // @@protoc_insertion_point(interface_extends:milkingParlourService.MachineDetail)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.milkingParlourService.MachineId machineID = 1;</code>
   */
  boolean hasMachineID();
  /**
   * <code>.milkingParlourService.MachineId machineID = 1;</code>
   */
  ds.milkingParlourService.MachineId getMachineID();
  /**
   * <code>.milkingParlourService.MachineId machineID = 1;</code>
   */
  ds.milkingParlourService.MachineIdOrBuilder getMachineIDOrBuilder();

  /**
   * <code>string dateInstalled = 2;</code>
   */
  java.lang.String getDateInstalled();
  /**
   * <code>string dateInstalled = 2;</code>
   */
  com.google.protobuf.ByteString
      getDateInstalledBytes();

  /**
   * <code>string dateNextService = 3;</code>
   */
  java.lang.String getDateNextService();
  /**
   * <code>string dateNextService = 3;</code>
   */
  com.google.protobuf.ByteString
      getDateNextServiceBytes();
}
