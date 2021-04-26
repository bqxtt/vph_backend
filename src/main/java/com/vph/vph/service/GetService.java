package com.vph.vph.service;

import com.vph.vph.entity.Case;
import com.vph.vph.entity.Disease;
import com.vph.vph.entity.Info;
import com.vph.vph.entity.Office;
import com.vph.vph.mapper.GetMapper;
import com.vph.vph.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Service
public class GetService {

    @Autowired
    GetMapper getMapper;

    public Result getAllCases() {
        Result result;
        try {
            List<Case> cases = getMapper.getAllCases();
            Map<String, Object> data = new HashMap<>(1);
            Map<String, List<Case>> inner = new HashMap<>(cases.size());
            for (Case ca : cases) {
                if (!inner.containsKey(ca.getCategory())) {
                    inner.put(ca.getCategory(), new ArrayList<>());
                }
                List<Case> list = inner.get(ca.getCategory());
                list.add(ca);
            }
            data.put("data", inner);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getAllDiseases() {
        Result result;
        try {
            List<Disease> diseases = getMapper.getAllDiseases();
            Map<String, Object> data = new HashMap<>(1);
            Map<String, List<Disease>> inner = new HashMap<>(diseases.size());
            for (Disease disease : diseases) {
                if (!inner.containsKey(disease.getCategory())) {
                    inner.put(disease.getCategory(), new ArrayList<>());
                }
                inner.get(disease.getCategory()).add(disease);
            }
            data.put("data", inner);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getAllInfos() {
        Result result;
        try {
            List<Info> infos = getMapper.getAllInfos();
            Map<String, Object> data = new HashMap<>(1);
            data.put("data", infos);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result getAllOffices() {
        Result result;
        try {
            List<Office> offices = getMapper.getAllOffices();
            Map<String, Object> data = new HashMap<>(1);
            data.put("data", offices);
            result = Result.retOk(data);
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }
}
