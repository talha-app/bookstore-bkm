package com.talha.bookstoreapp.mapper;


import com.talha.bookstoreapp.dto.AddressDTO;
import com.talha.bookstoreapp.entity.Address;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AddressMapperImpl", componentModel = "spring")
public interface IAddressMapper {
    Address toAddress(AddressDTO orderDTO);

    AddressDTO toAddressDTO(Address order);


}
