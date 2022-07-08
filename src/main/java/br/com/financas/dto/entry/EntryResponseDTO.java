package br.com.financas.dto.entry;

import br.com.financas.dto.category.CategoryResponseDTO;
import br.com.financas.entity.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Lancamento Response DTO")
public class EntryResponseDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Type")
    private String type;

    @ApiModelProperty(value = "Amount")
    private Double amount;

    @ApiModelProperty(value = "Created At")
    private String createdAT;

    @ApiModelProperty(value = "Paid")
    private Boolean paid;

    @ApiModelProperty(value = "category Id")
    private CategoryResponseDTO category;

    public EntryResponseDTO() {}

    public EntryResponseDTO(Long id, String name, String description, String type, Double amount, String createdAT, Boolean paid, CategoryResponseDTO categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.createdAT = createdAT;
        this.paid = paid;
        this.category = categoryId;
    }

    public static EntryResponseDTO convertEntryDTO(Entry entry) {
        return new EntryResponseDTO(
                entry.getId(),
                entry.getName(),
                entry.getDescription(),
                entry.getType(),
                entry.getAmount(),
                entry.getCreatedAT(),
                entry.getPaid(),
                CategoryResponseDTO.convertToCategoryDTO(entry.getCategoryId())
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAT = createdAT;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public CategoryResponseDTO getCategoryId() {
        return category;
    }

    public void setCategoriaID(CategoryResponseDTO categoryId) {
        this.category = categoryId;
    }
}
