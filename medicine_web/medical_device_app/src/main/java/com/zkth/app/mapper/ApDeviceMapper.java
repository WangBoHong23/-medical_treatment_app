package com.zkth.app.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("MybatisXMapperMethodInspection")
@Mapper
public interface ApDeviceMapper extends BaseMapper<MedicalAppDevice> {
    //List<MedicalPartitionVO> findRegionData(Integer districtId);

    List<MedicalPartitionVO> findRegionDataName(Integer districtId);

    List<MedicalAppType> findAppTypeName(Integer typeId);

    transfer_trolley_set_VO findTransferTrolleySetByEquipmentNumber(String equipmentNumber);

    void updateStatus(Integer status,String equipmentNumber);

    network_information_VO ViewnetWorkInformationById(String equipmentNumber);

    void DeleteTheDeviceBasedOnTheNumber(String equipmentNumber);

    shift_car_VO findShiftCarSetByEquipmentNumber(String equipmentNumber);


    List<MedicalAppType> findDevices(Integer typeId,String typeName);


    Page<MedicalAppDevice> findAppDeviceNameWithPagination(Integer deviceTypes, String equipmentName, Integer regionId, Integer status, Integer equipmentNumber, String region);
}
