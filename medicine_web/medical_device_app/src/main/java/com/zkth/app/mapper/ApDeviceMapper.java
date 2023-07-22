package com.zkth.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.MedicalAppType;
import com.zk.model.device.vos.MedicalPartitionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@SuppressWarnings("MybatisXMapperMethodInspection")
@Mapper
public interface ApDeviceMapper extends BaseMapper<MedicalAppDevice> {
    //List<MedicalPartitionVO> findRegionData(Integer districtId);

    List<MedicalPartitionVO> findRegionDataName(Integer districtId);

    List<MedicalAppType> findAppTypeName(Integer typeId, String typeName);

    List<MedicalAppDevice> findAppDevice(Integer typeId, String typeName, Integer districtId, Integer status,Integer equipmentNumber);

    List<MedicalAppDevice> findAppDeviceName(Integer deviceTypes, String equipmentName, Integer regionId, Integer status, Integer equipmentNumber,String region);
}
