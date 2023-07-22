package com.zk.model.device.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("medical_partition")
public class MedicalPartition {


    @TableField("id")
    private int id;


    @TableField("district_id")
    private int districtId;

    private String name;


}
