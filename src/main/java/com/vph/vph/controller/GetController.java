package com.vph.vph.controller;

import com.vph.vph.model.Result;
import com.vph.vph.service.GetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Api(tags = "查询接口")
@RestController
@RequestMapping("/vph")
public class GetController {

    @Autowired
    GetService getService;

    @ApiOperation("获取病例")
    @GetMapping("/cases")
    public ResponseEntity<Result> getAllCases() {
        Result result = getService.getAllCases();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("获取疾病")
    @GetMapping("/diseases")
    public ResponseEntity<Result> getAllDiseases() {
        Result result = getService.getAllDiseases();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("获取医助info")
    @GetMapping("/infos")
    public ResponseEntity<Result> getAllInfos() {
        Result result = getService.getAllInfos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("获取科室")
    @GetMapping("/offices")
    public ResponseEntity<Result> getAllOffice() {
        Result result = getService.getAllOffices();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
