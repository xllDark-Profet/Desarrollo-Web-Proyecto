package com.example.editorialmicroservice.dto;

import javax.validation.constraints.NotBlank;

public class EditorialDto {
    @NotBlank
    private String name;

    @NotBlank
    private String web_url;

    public EditorialDto(@NotBlank String name, @NotBlank String web_url) {
        this.name = name;
        this.web_url = web_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
