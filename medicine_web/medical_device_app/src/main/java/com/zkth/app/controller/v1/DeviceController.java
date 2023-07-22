package com.zkth.app.controller.v1;

import com.zk.common.dtos.ResponseResult;
import com.zk.model.device.dtos.DeviceHomeDto;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.MedicalAppType;
import com.zk.model.device.vos.MedicalPartitionVO;
import com.zkth.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody DeviceHomeDto dto) {
        return deviceService.list(dto);
    }

    // 接口 findRegion()查询第一个下拉框
    @GetMapping("/findRegion")
    public ResponseResult<MedicalPartitionVO> findRegionData(@RequestParam Integer districtId
    ) {
        //依靠第一个条件查询的结果
        List<MedicalPartitionVO> region = deviceService.findRegionDataName(districtId);
        return ResponseResult.okResult(region);
    }

    //查询第二、三个下拉框
    @GetMapping("/findAppType")
    public ResponseResult<MedicalAppType> findAppType(@RequestParam Integer typeId,
                                                      @RequestParam String typeName) {
        {
            //依靠第一个条件查询的结果
            List<MedicalAppType> appType = deviceService.findAppTypeName(typeId, typeName);
            return ResponseResult.okResult(appType);
        }
    }

    //多参查询
    @GetMapping("/findAppDevice")
    public ResponseResult<MedicalAppDevice> findAppDevice(@RequestParam Integer typeId,
                                                          @RequestParam String typeName,
                                                          @RequestParam Integer districtId,
                                                          @RequestParam Integer status,
                                                          @RequestParam Integer equipmentNumber) {
        //依靠第一个条件查询的结果
        List<MedicalAppDevice> appDevice = deviceService.findAppDevice(typeId, typeName, districtId, status, equipmentNumber);
        return ResponseResult.okResult(appDevice);
    }

    //查询第三个下拉框 需要知道第二个下拉框的数据
    @GetMapping("/findAppDevices")
    public ResponseResult<MedicalAppDevice> findAppDeviceName(@RequestParam Integer deviceTypes,
                                                              @RequestParam String equipmentName,
                                                              @RequestParam Integer regionId,
                                                              @RequestParam String region,
                                                              @RequestParam Integer status,
                                                              @RequestParam Integer equipmentNumber) {
        //依靠第一个条件查询的结果
        List<MedicalAppDevice> appDevices = deviceService.findAppDeviceName(deviceTypes, equipmentName, regionId, status, equipmentNumber, region);
        return ResponseResult.okResult(appDevices);
    }
}

