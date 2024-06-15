package com.blerdU.rootworkapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SupportMatchingAlgorithm {

    public List<ProjectProfile> matchToolsetSupporters(List<ToolsetSupporterProfile> supporters, List<ProjectProfile> projects) {
        List<ProjectProfile> matchedProjects = new ArrayList<>();

        for (ToolsetSupporterProfile supporter : supporters) {
            for (ProjectProfile project : projects) {
                if (supporter.getPreferredCategories().contains(project.getCategory()) &&
                    supporter.getPreferredBusinessStatus().equals(project.getBusinessStatus()) &&
                    supporter.getSocialMediaLevels().contains(project.getCurrentSupportNeed())) {
                    
                    // Add project to matched list
                    matchedProjects.add(project);
                }
            }
        }
        return matchedProjects;
    }
}
