package com.zkth.app.service;

import com.zk.common.dtos.ResponseResult;
import com.zk.model.device.dtos.DeviceHomeDto;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.MedicalAppType;
import com.zk.model.device.vos.MedicalPartitionVO;

import java.util.List;

public interface DeviceService {

    ResponseResult list(DeviceHomeDto dto);

    //List<MedicalPartitionVO> findRegionData(Integer districtId);

    List<MedicalPartitionVO> findRegionDataName(Integer districtId);

    List<MedicalAppType> findAppTypeName(Integer typeId, String typeName);

    List<MedicalAppDevice> findAppDevice(Integer typeId, String typeName, Integer districtId, Integer status, Integer equipmentNumber);

    List<MedicalAppDevice> findAppDeviceName(Integer deviceTypes, String equipmentName, Integer regionId, Integer status, Integer equipmentNumber,String region);

}



