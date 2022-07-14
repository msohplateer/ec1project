package com.plateer.ec1.common.model;

import com.plateer.ec1.common.validator.OnCreate;
import com.plateer.ec1.common.validator.OnUpdate;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class BaseModel {
    private Timestamp sysRegDtime;
    @NotNull(groups = OnCreate.class)
    private String sysRegrId;
    @NotNull(groups = {OnUpdate.class,OnUpdate.class})
    private Timestamp sysModDtime;
    private String sysModrId;
}
