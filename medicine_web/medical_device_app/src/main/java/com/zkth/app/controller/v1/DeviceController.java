package com.zkth.app.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.common.dtos.ResponseResult;
import com.zk.model.device.dtos.DeviceHomeDto;
import com.zk.model.device.pojos.MedicalAppDevice;
import com.zk.model.device.vos.*;
import com.zkth.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 根据设备的编号查询转运车设备的信息
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/equipment_number")
    public ResponseResult<transfer_trolley_set_VO> findTransferTrolleySetByEquipmentNumber(@RequestParam String equipmentNumber) {
        transfer_trolley_set_VO transferTrolleySetByEquipmentNumber = deviceService.findTransferTrolleySetByEquipmentNumber(equipmentNumber);
        return ResponseResult.okResult(transferTrolleySetByEquipmentNumber);
    }

    /**
     *前端传输设备状态，修改数据库状态
     * @param
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/status")
    public ResponseResult updateStatus(@RequestParam Integer status,
                                       @RequestParam String equipmentNumber) {
        deviceService.updateStatus(status,equipmentNumber);
        return ResponseResult.okResult("修改成功");
    }

    /**
     * 根据设备编号查看网络检测信息
     * @param
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/network")
    public ResponseResult<network_information_VO> findAppDeviceName(@RequestParam String equipmentNumber){
        network_information_VO networkInformationVO = deviceService.ViewnetWorkInformationById(equipmentNumber);
        return ResponseResult.okResult(networkInformationVO);
    }

    /**
     * 定位
     * @param
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/positionings")
    public void positioning(@RequestParam String equipmentNumber) {
        deviceService.LocateTheDevice(equipmentNumber);
    }


    @PostMapping("/list")
    public ResponseResult list(@RequestBody DeviceHomeDto dto) {
        return deviceService.list(dto);
    }

    /**
     * 删除设备
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/DeletingDevices")
    public ResponseResult DeletingDevice(@RequestParam String equipmentNumber) {
        deviceService.DeletingDevice(equipmentNumber);
        return ResponseResult.okResult("删除成功");
    }

    /**
     * 设备重启
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/DeviceRestarts")
    public ResponseResult DeviceRestart(@RequestParam String equipmentNumber) {
        deviceService.DeviceRestart(equipmentNumber);
        return ResponseResult.okResult("重启成功");
    }

    /**
     * 根据设备的编号查询移位车设备的信息
     * @param
     * @return
     */
    @GetMapping("/shift_car/remote_setting/set/equipment_number")
    public ResponseResult<shift_car_VO> findShiftCarSetByEquipmentNumber(@RequestParam String equipmentNumber) {
        shift_car_VO shiftCarSetByEquipmentNumber = deviceService.findShiftCarSetByEquipmentNumber(equipmentNumber);
        return ResponseResult.okResult(shiftCarSetByEquipmentNumber);
    }

    /**
     * 根据编号修改移位车的状态
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/shift_car/remote_setting/set/status")
    public ResponseResult updateShiftCarStatus(@RequestParam Integer status,
                                               @RequestParam String equipmentNumber) {
        deviceService.updateStatus(status,equipmentNumber);
        return ResponseResult.okResult("修改成功");
    }

    /**
     * 升降调整
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/shift_car/remote_setting/set/Adjustment")
    public ResponseResult goUpDownAdjustment(@RequestParam String equipmentNumber) {
        deviceService.goUpDownAdjustment(equipmentNumber);
        return ResponseResult.okResult("升降调整成功");
    }

    /**
     * 开合调整
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/shift_car/remote_setting/set/Opening_closingAdjustment")
    public ResponseResult OpeningClosingAdjustment(@RequestParam String equipmentNumber) {
        deviceService.OpeningClosingAdjustment(equipmentNumber);
        return ResponseResult.okResult("开合调整成功");
    }

    /**
     * 移位车的网络检测
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/shift_car/remote_setting/set/network")
    public ResponseResult<network_information_VO> findShiftCarNetWorkInformation(@RequestParam String equipmentNumber) {
        network_information_VO networkInformationVO = deviceService.ViewnetWorkInformationById(equipmentNumber);
        return ResponseResult.okResult(networkInformationVO);
    }

    /**
     * 根据设备编号指示灯定位
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/positioning")
    public void transferTrolleyOrientation(@RequestParam String equipmentNumber) {
        deviceService.transferTrolleyOrientation(equipmentNumber);
    }

    /**
     * 根据设备编号删除设备
     * @param
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/DeletingDevice")
    public ResponseResult transferTrolleyDeletingDevice(@RequestParam String equipmentNumber) {
        deviceService.DeletingDevice(equipmentNumber);
        return ResponseResult.okResult("删除成功");
    }

    /**
     * 设备重启
     * @param equipmentNumber
     * @return
     */
    @GetMapping("/transfer_trolley/remote_setting/set/DeviceRestart")
    public ResponseResult transferTrolleyDeviceRestart(@RequestParam String equipmentNumber) {
        deviceService.transferTrolleyDeviceRestart(equipmentNumber);
        return ResponseResult.okResult("重启成功");
    }



    // 接口 findRegion()查询第一个下拉框
    @GetMapping("/findRegion")
    public ResponseResult<MedicalPartitionVO> findRegionData(@RequestParam(required = false) String districtId
    ) {
        //依靠第一个条件查询的结果
        List<MedicalPartitionVO> region = deviceService.findRegionDataName(districtId);
        return ResponseResult.okResult(region);
    }


    //查询第二
    @GetMapping("/findAppType")
    public ResponseResult<MedicalAppType> findAppType(@RequestParam(required = false) String typeId) {
        {
            //依靠第一个条件查询的结果
            List<MedicalAppType> appType = deviceService.findAppTypeName(typeId);
            return ResponseResult.okResult(appType);
        }
    }
    //查询第三个下拉框 需要知道第二个下拉框的数据
    @GetMapping("findDevice")
    public ResponseResult<MedicalAppType> findDevices(@RequestParam(required = false) String typeId,
                                                      @RequestParam(required = false) String typeName){
        {
            List<MedicalAppType> devices = deviceService.findDevices(typeId, typeName);
            return ResponseResult.okResult(devices);
        }
    }


        //分页查询
        @GetMapping("/findAppDevicesPage")
        public ResponseResult<MedicalAppDevice> findAppDeviceNamePage(@RequestParam(required = false) Integer deviceTypes,
                                                              @RequestParam(required = false) String equipmentName,
                                                              @RequestParam(required = false) Integer regionId,
                                                              @RequestParam(required = false) String region,
                                                              @RequestParam(required = false) Integer status,
                                                              @RequestParam(required = false) Integer equipmentNumber,
                                                              @RequestParam(required = false) Integer currentPage,
                                                              @RequestParam(required = false) Integer pageSize) {
        //依靠第一个条件查询的结果hu
        Page<MedicalAppDevice> pageResult = deviceService.findAppDeviceNameWithPagination(deviceTypes, equipmentName, regionId, status, equipmentNumber, region, currentPage, pageSize);
        return ResponseResult.okResult(pageResult);
        }
    }

