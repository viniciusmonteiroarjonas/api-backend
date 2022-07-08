package br.com.financas.dto.category;

import br.com.financas.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@ApiModel("Categoria Request DTO")
public class CategoryResquestDTO {

    @ApiModelProperty(value = "Name")
    @NotBlank(message = "Name")
    @Length(min = 3, max = 50, message = "Name")
    private String name;

    @ApiModelProperty(value = "Description")
    @Length(min = 3, max = 250, message = "Description")
    private String description;

    public Category convertToEntity() {
        return new Category(name, description);
    }

    public Category convertToEntity(Long id) {
        return new Category(id, name, description);
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
}
