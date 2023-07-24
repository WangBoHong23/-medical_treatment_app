package com.zk.model.device.vos;

import lombok.Data;

@Data
public class network_information_VO {
    public String electricQuantity;
    public String ipAddr;
    public String MA;
    public String onlineTime;
    public String uplinkRate;
    public String downlinkRate;

}
