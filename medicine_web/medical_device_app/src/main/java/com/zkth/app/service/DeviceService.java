package com.zkth.app.service;

import com.zk.common.dtos.ResponseResult;
import com.zk.model.device.dtos.DeviceHomeDto;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.*;

import java.util.List;

public interface DeviceService {

    ResponseResult list(DeviceHomeDto dto);

    //List<MedicalPartitionVO> findRegionData(Integer districtId);

    List<MedicalPartitionVO> findRegionDataName(Integer districtId);

    List<MedicalAppType> findAppTypeName(Integer typeId, String typeName);

    List<MedicalAppDevice> findAppDevice(Integer typeId, String typeName, Integer districtId, Integer status, Integer equipmentNumber);

    List<MedicalAppDevice> findAppDeviceName(Integer deviceTypes, String equipmentName, Integer regionId, Integer status, Integer equipmentNumber,String region);

    transfer_trolley_set_VO findTransferTrolleySetByEquipmentNumber(String equipmentNumber);

    void updateStatus(Integer status,String equipmentNumber);

    network_information_VO ViewnetWorkInformationById(String equipmentNumber);

    void LocateTheDevice(String equipmentNumber);

    void DeletingDevice(String equipmentNumber);

        void DeviceRestart(String equipmentNumber);

    shift_car_VO findShiftCarSetByEquipmentNumber(String equipmentNumber);
    

    void goUpDownAdjustment(String equipmentNumber);

    void OpeningClosingAdjustment(String equipmentNumber);

    void transferTrolleyOrientation(String equipmentNumber);

    void transferTrolleyDeviceRestart(String equipmentNumber);
}



