package com.zk.model.device.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("medical_app_device")
public class MedicalAppDevice implements Serializable {

    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;

    @TableField(value = "equipment_number")
    private Long equipmentNumber;

    @TableField(value = "equipment_name")
    private String equipmentName;

    private String region;

    @TableField(value = "created_time")
    private Date createdTime;

    @TableField(value = "region_id")
    private Long regionId;

    @TableField(value = "notes")
    private String notes;

    @TableField(value = "device_types")
    private int deviceTypes;

    @TableField(value = "equipment_number_no")
    private int equipmentNumberNo;

    private int status;

}
