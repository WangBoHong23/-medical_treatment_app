package com.zk.model.device.vos;

import lombok.Data;

@Data
public class transfer_trolley_set_VO {
    public String equipmentName;
    public String equipmentNumber;
    public String region;
    public Integer electricQuantity;
    public String status;
    public Integer deviceTypes;
    public double temperature;
    public Integer posture;

}
