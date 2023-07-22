package com.zk.model.device.vos;

import lombok.Data;

import java.util.List;

@Data
public class MedicalAppType {

    private Integer typeId;

    private List<MedicalAppTypeName> typeNames;;
}
