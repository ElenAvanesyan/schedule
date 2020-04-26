package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.CourseCluster;
import com.schedule.suggestion.persistence.entity.CourseSection;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseClusterDto {
    private Integer id;
    private Integer clusterId;
    private String clusterAlias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterAlias() {
        return clusterAlias;
    }

    public void setClusterAlias(String clusterAlias) {
        this.clusterAlias = clusterAlias;
    }


    public static CourseClusterDto mapEntityToDto(CourseCluster entity) {
        if (entity == null) {
            return null;
        }

        CourseClusterDto dto = new CourseClusterDto();
        dto.setId(entity.getId());
        dto.setClusterId(entity.getCluster().getId());
        dto.setClusterAlias(entity.getCluster().getClusterAlias());

        return dto;
    }

    public static List<CourseClusterDto> mapEntitiesToDtos(Collection<CourseCluster> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<CourseClusterDto> dtos = new ArrayList<>();
        for (CourseCluster entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
