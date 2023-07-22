package com.zk.model.device.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("medical_app_type")
public class MedicalAppType {
    @TableField("type_id")
    private Long typeId;

    @TableField("type_name")
    private String typeName;
}
