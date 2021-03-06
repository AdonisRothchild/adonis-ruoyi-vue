package com.shamisen.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CorsFilter;

@RestController
public class BookController
{
    @Autowired
    private CorsFilter corsFilter;

    @GetMapping("")
    public AjaxResult getBooks()
    {

        return null;
    }
}
