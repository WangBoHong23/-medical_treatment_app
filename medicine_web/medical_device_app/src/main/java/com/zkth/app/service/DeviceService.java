package com.zkth.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.common.dtos.ResponseResult;
import com.zk.model.device.dtos.DeviceHomeDto;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.*;

import java.util.List;

public interface DeviceService {

    ResponseResult list(DeviceHomeDto dto);


    List<MedicalPartitionVO> findRegionDataName(String districtId);

    List<MedicalAppType> findAppTypeName(String typeId);


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

    List<MedicalAppType> findDevices(String typeId,String typeName);

    Page<MedicalAppDevice> findAppDeviceNameWithPagination(Integer deviceTypes, String equipmentName, Integer regionId, Integer status, Integer equipmentNumber, String region, Integer currentPage, Integer pageSize);
}



