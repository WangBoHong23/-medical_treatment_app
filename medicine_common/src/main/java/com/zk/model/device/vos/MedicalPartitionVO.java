package com.zk.model.device.vos;


import lombok.Data;

import java.util.List;

@Data
public class MedicalPartitionVO {

    private Integer districtId;

    private List<MedicalPartitionName> names;
}
