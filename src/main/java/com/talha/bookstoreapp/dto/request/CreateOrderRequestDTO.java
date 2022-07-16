package com.talha.bookstoreapp.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "CreateOrderRequestDTO", description = "CreateOrderRequestDTO")
public class CreateOrderRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "bookIds", example = "[1]", required = true, position = 0)
    private List<Long> bookIds;

    public List<Long> getBookIds()
    {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds)
    {
        this.bookIds = bookIds;
    }
}
