package com.example.weatherapispring.mapper;

import com.example.weatherapispring.model.api.aqqu.currentcondition.CurrentConditionRs;
import com.example.weatherapispring.model.entity.CurrentCondition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrentConditionMapper {

    public List<CurrentCondition> toCurrentConditionList(
            List<CurrentConditionRs> currentConditionRs) {
        return currentConditionRs.stream()
                .map(this::toCurrentCondition)
                .collect(Collectors.toList());
    }

    public CurrentCondition toCurrentCondition(CurrentConditionRs currentConditionRs) {
        return CurrentCondition.builder()
                .value(currentConditionRs.temperature.metric.value)
                .unit(currentConditionRs.temperature.metric.unit)
                .build();

    }
}
