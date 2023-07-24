package com.zk.model.device.vos;

import lombok.Data;

@Data
public class shift_car_VO {
    public String equipmentName;
    public String equipmentNumber;
    public String region;
    public Integer electricQuantity;
    public String status;
    public Integer deviceTypes;
    public Integer posture;
}
