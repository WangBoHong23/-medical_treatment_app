package com.zk.model.device.dtos;

import com.zk.common.dtos.PageRequestDto;
import lombok.Data;

@Data
public class DeviceHomeDto extends PageRequestDto {
    private Short isCollection;
}
