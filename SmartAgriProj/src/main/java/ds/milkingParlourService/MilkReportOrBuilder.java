// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MilkingParlourService.proto

package ds.milkingParlourService;

public interface MilkReportOrBuilder extends
    // @@protoc_insertion_point(interface_extends:milkingParlourService.MilkReport)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string reportDate = 1;</code>
   */
  java.lang.String getReportDate();
  /**
   * <code>string reportDate = 1;</code>
   */
  com.google.protobuf.ByteString
      getReportDateBytes();

  /**
   * <code>float volumeLitres = 2;</code>
   */
  float getVolumeLitres();

  /**
   * <code>float heatedTemperature = 3;</code>
   */
  float getHeatedTemperature();

  /**
   * <code>float heatedDuration = 4;</code>
   */
  float getHeatedDuration();

  /**
   * <code>float chilledTemperature = 5;</code>
   */
  float getChilledTemperature();

  /**
   * <code>string dateNextService = 6;</code>
   */
  java.lang.String getDateNextService();
  /**
   * <code>string dateNextService = 6;</code>
   */
  com.google.protobuf.ByteString
      getDateNextServiceBytes();

  /**
   * <code>int32 machId = 7;</code>
   */
  int getMachId();
}
