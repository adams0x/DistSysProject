// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LivestockActivityService.proto

package ds.livestockActivityService;

public interface AnimalDetailOrBuilder extends
    // @@protoc_insertion_point(interface_extends:livestockActivityService.AnimalDetail)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.livestockActivityService.AnimalId animalID = 1;</code>
   */
  boolean hasAnimalID();
  /**
   * <code>.livestockActivityService.AnimalId animalID = 1;</code>
   */
  ds.livestockActivityService.AnimalId getAnimalID();
  /**
   * <code>.livestockActivityService.AnimalId animalID = 1;</code>
   */
  ds.livestockActivityService.AnimalIdOrBuilder getAnimalIDOrBuilder();

  /**
   * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
   */
  int getTypeOfAnimalValue();
  /**
   * <code>.livestockActivityService.AnimalDetail.TypeOfAnimal typeOfAnimal = 2;</code>
   */
  ds.livestockActivityService.AnimalDetail.TypeOfAnimal getTypeOfAnimal();

  /**
   * <code>string dateOfBirth = 3;</code>
   */
  java.lang.String getDateOfBirth();
  /**
   * <code>string dateOfBirth = 3;</code>
   */
  com.google.protobuf.ByteString
      getDateOfBirthBytes();

  /**
   * <code>string dateNextVaccine = 4;</code>
   */
  java.lang.String getDateNextVaccine();
  /**
   * <code>string dateNextVaccine = 4;</code>
   */
  com.google.protobuf.ByteString
      getDateNextVaccineBytes();
}