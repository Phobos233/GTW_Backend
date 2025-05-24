package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.CollectRelationship;
import com.phobos.goldentrianglewebsitebackend.Service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    private final CollectService collectService;

    @Autowired
    public RequestController(CollectService collectService) {
        this.collectService = collectService;
    }

    @RequestMapping("/getDatetime")
    public String getDatetime() {
        return collectService.getDatetime();
    }

}
