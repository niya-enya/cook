package top.durandal.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collection implements Serializable {

    @ApiModelProperty(hidden = true)
    private Integer worksId;
    @ApiModelProperty(hidden = true)
    private Works works;

//    @ApiModelProperty(hidden = true)
//    private List<Integer> userId;

    @ApiModelProperty(hidden = true)
    private User userMsg;

}
