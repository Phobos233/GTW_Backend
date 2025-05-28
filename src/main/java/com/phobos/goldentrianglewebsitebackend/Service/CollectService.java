package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.CollectRelationship;

import java.util.List;

public interface CollectService {

    String getDatetime();

    // 查询收藏关系
    List<CollectRelationship> getCollectRelationshipsByCollectorId(long CollectorId);
    List<CollectRelationship> getCollectRelationshipsByCollectToId(long CollectToId);
    List<CollectRelationship> getCollectRelationshipsByCollectorIdAndCollectToId(long CollectorId, long CollectRelationshipToId);

    // 分页查询
    List<CollectRelationship> getCollectRelationshipsByCollectorIdWithPages(long CollectorId, int page, int size);

    // 关系管理
    List<CollectRelationship> createCollectRelationship(long CollectorId, long CollectRelationshipToId);
    void deleteCollectRelationship(long CollectRelationshipId);

    int getCollectRelationshipCountByCollectorId(long CollectorId);
}
