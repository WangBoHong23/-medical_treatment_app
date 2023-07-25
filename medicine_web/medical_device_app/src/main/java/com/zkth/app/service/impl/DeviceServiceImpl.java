package com.zkth.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.common.dtos.PageResponseResult;
import com.zk.common.dtos.ResponseResult;
import com.zk.model.device.dtos.DeviceHomeDto;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.*;
import com.zkth.app.mapper.ApDeviceMapper;
import com.zkth.app.service.DeviceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    public ApDeviceMapper deviceMapper;

    /*
     *
     * 首页分页查询
     *
     *
     */
    @Override
    public ResponseResult list(DeviceHomeDto dto) {
        //分页查询
        Page<MedicalAppDevice> page = new Page<>(dto.getPage(), dto.getSize());
        //调用mapper
        deviceMapper.selectPage(page, null);
        //返回结果
        PageResponseResult responseResult = new PageResponseResult();
        responseResult.setData(page.getRecords());
        responseResult.setTotal(Integer.parseInt(page.getTotal() + ""));
        responseResult.setSize(dto.getSize());
        responseResult.setCurrentPage(dto.getPage());
        return responseResult;
    }


    @Override
    public List<MedicalPartitionVO> findRegionDataName(String districtId) {
        if ("null".equals(districtId) || districtId == null) {
            return deviceMapper.findRegionDataName(null);
        }
        List<MedicalPartitionVO> name = deviceMapper.findRegionDataName(Integer.valueOf(districtId));
        return name;
    }

    @Override
    public List<MedicalAppType> findAppTypeName(String typeId) {
        if ("null".equals(typeId) || typeId == null) {
            return deviceMapper.findAppTypeName(null);
        }
        List<MedicalAppType> appType = deviceMapper.findAppTypeName(Integer.valueOf(typeId));
        return appType;
    }


    @Override
    public List<MedicalAppType> findDevices(String typeId, String typeName) {
        if ("null".equals(typeId) || typeId == null) {
            return deviceMapper.findDevices(null, typeName);
        }
        if ("null".equals(typeName) || typeName == null) {
            return deviceMapper.findDevices(Integer.valueOf(typeId), null);
        }
        List<MedicalAppType> devices = deviceMapper.findDevices(Integer.valueOf(typeId), typeName);
        return devices;
    }

    @Override
    public Page<MedicalAppDevice> findAppDeviceNameWithPagination(Integer deviceTypes, String equipmentName, Integer regionId, Integer status, Integer equipmentNumber, String region, Integer currentPage, Integer pageSize) {
        IPage page = new Page(currentPage, pageSize);
        QueryWrapper<MedicalAppDevice> queryWrapper = new QueryWrapper<>();
        IPage<MedicalAppDevice> medicalAppDeviceIPage;
        if (deviceTypes !=null){
            queryWrapper.eq("device_types", deviceTypes);
        }
        if (regionId !=null){
            queryWrapper.eq("region_id", regionId);
        }
        if (status !=null){
            queryWrapper.eq("status", status);
        }
        if (equipmentNumber !=null){
            queryWrapper.eq("equipment_number", equipmentNumber);
        }
        if (StringUtils.isNotBlank(region)){
            queryWrapper.eq("region", region);
        }
        if (StringUtils.isNotBlank(equipmentName)){
            queryWrapper.eq("equipment_name", equipmentName);
        }

        medicalAppDeviceIPage = deviceMapper.selectPage(page, queryWrapper);
        List<MedicalAppDevice> records = medicalAppDeviceIPage.getRecords();
        Page<MedicalAppDevice> appDevicePage = new Page<>(currentPage, pageSize, medicalAppDeviceIPage.getTotal());
        appDevicePage.setRecords(records);
        return appDevicePage;
    }


    /**
     * 根据设备编号查询转运车信息
     *
     * @param equipmentNumber
     * @return
     */
    @Override
    public transfer_trolley_set_VO findTransferTrolleySetByEquipmentNumber(String equipmentNumber) {
        transfer_trolley_set_VO transferTrolleySetByEquipmentNumber = deviceMapper.findTransferTrolleySetByEquipmentNumber(equipmentNumber);
        return transferTrolleySetByEquipmentNumber;
    }

    /**
     * 修改设备状态
     *
     * @param status
     */
    @Override
    public void updateStatus(Integer status, String equipmentNumber) {
        deviceMapper.updateStatus(status, equipmentNumber);
    }

    /**
     * 根据设备编号查看网络检测信息
     *
     * @param
     * @return
     */
    @Override
    public network_information_VO ViewnetWorkInformationById(String equipmentNumber) {
        network_information_VO viewnetWorkInformationById = deviceMapper.ViewnetWorkInformationById(equipmentNumber);
        return viewnetWorkInformationById;
    }

    /**
     * 根据设备编号对硬件发送指令点亮指示灯
     *
     * @param equipmentNumber
     */
    @Override
    public void LocateTheDevice(String equipmentNumber) {
        //对硬件发送指令点亮指示灯
    }

    /**
     * 删除设备
     *
     * @param equipmentNumber
     */
    @Override
    public void DeletingDevice(String equipmentNumber) {
        deviceMapper.DeleteTheDeviceBasedOnTheNumber(equipmentNumber);
    }

    /**
     * 重启设备
     *
     * @param equipmentNumber
     */
    @Override
    public void DeviceRestart(String equipmentNumber) {
        //根据设备编号重启设备
    }

    /**
     * 根据设备的编号查询移位车设备的信息
     *
     * @param
     * @return
     */
    @Override
    public shift_car_VO findShiftCarSetByEquipmentNumber(String equipmentNumber) {
        shift_car_VO shiftCarSetByEquipmentNumber = deviceMapper.findShiftCarSetByEquipmentNumber(equipmentNumber);
        return shiftCarSetByEquipmentNumber;
    }

    /**
     * 升降调整
     *
     * @param equipmentNumber
     */
    @Override
    public void goUpDownAdjustment(String equipmentNumber) {

    }

    /**
     * 开合调整
     *
     * @param equipmentNumber
     */
    @Override
    public void OpeningClosingAdjustment(String equipmentNumber) {

    }

    /**
     * 移位车定位
     *
     * @param equipmentNumber
     */
    @Override
    public void transferTrolleyOrientation(String equipmentNumber) {

    }

    /**
     * 设备重启
     *
     * @param equipmentNumber
     */
    @Override
    public void transferTrolleyDeviceRestart(String equipmentNumber) {

    }

}
