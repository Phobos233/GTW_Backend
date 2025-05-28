package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.CollectRelationship;
import com.phobos.goldentrianglewebsitebackend.Repository.CollectRepo;
import com.phobos.goldentrianglewebsitebackend.Service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    private final CollectRepo collectRepo;

    @Autowired
    public CollectServiceImpl(CollectRepo collectRepo) {
        this.collectRepo = collectRepo;
    }

    @Override
    public String getDatetime() {
        return collectRepo.getDatetime();
    }

    @Override
    public List<CollectRelationship> getCollectRelationshipsByCollectorId(long CollectorId) {
        return collectRepo.getCollectRelationshipByUserId(CollectorId);
    }

    @Override
    public List<CollectRelationship> getCollectRelationshipsByCollectToId(long CollectToId) {
        return List.of();
    }

    @Override
    public List<CollectRelationship> getCollectRelationshipsByCollectorIdAndCollectToId(long CollectorId, long CollectRelationshipToId) {
        return collectRepo.getCollectRelationshipByCollectorIdAndCollectorId(CollectorId, CollectRelationshipToId);
    }

    @Override
    public List<CollectRelationship> getCollectRelationshipsByCollectorIdWithPages(long CollectorId, int page, int size) {
        int start = (page - 1) * size;
        return collectRepo.getCollectRelationshipByUserIdWithPage(CollectorId, start, size);
    }

    @Override
    public List<CollectRelationship> createCollectRelationship(long CollectorId, long CollectRelationshipToId) {
        return collectRepo.createCollectRelationship(CollectorId, CollectRelationshipToId);
    }

    @Override
    public void deleteCollectRelationship(long CollectRelationshipId) {
        collectRepo.deleteCollectRelationship(CollectRelationshipId);
    }

    @Override
    public int getCollectRelationshipCountByCollectorId(long CollectorId) {
        return collectRepo.countCollectByCollectorId(CollectorId);
    }


}
