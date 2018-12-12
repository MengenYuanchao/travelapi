package com.travel.travelapi.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    @ApiModelProperty(value="当前页")
    private int pageNum=1;
    @ApiModelProperty(value="每页显示的条数")
    private int pageSize=10;
    @ApiModelProperty(value="开始行")
    private int startRow;
    @ApiModelProperty(value="结束行")
    private int endRow;
    @ApiModelProperty(value="总条数")
    private long total;
    @ApiModelProperty(value="总页数")
    private int pages;
    @ApiModelProperty(value="分页结果集")
    private List<T> items;

    /*@ApiModelProperty(value="分页结果集2")
    private boolean count;
    @ApiModelProperty(value="分页结果集3")
    private Boolean reasonable;
    @ApiModelProperty(value="分页结果集4")
    private Boolean pageSizeZero;
    @ApiModelProperty(value="分页结果集5")
    private String countColumn;
    @ApiModelProperty(value="分页结果集6")
    private String orderBy;
    @ApiModelProperty(value="分页结果集7")
    private boolean orderByOnly;*/

}
