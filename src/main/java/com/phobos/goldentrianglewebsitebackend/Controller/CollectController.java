package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.CollectRelationship;
import com.phobos.goldentrianglewebsitebackend.Service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectController {

    //依赖注入
    private final CollectService collectService;
    @Autowired
    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    //查找
    @RequestMapping("/collect/find/collectorId")
    public List<CollectRelationship> getCollectRelationshipByCollectorId(long collectorId) {
        return collectService.getCollectRelationshipsByCollectorId(collectorId);
    }

    @RequestMapping("/collect/find/collectToId")
    public List<CollectRelationship> getCollectRelationshipByCollectToId(long collectToId) {
        return collectService.getCollectRelationshipsByCollectToId(collectToId);
    }
    @RequestMapping("/collect/find/collectorIdAndCollectToId")
    public List<CollectRelationship> getCollectRelationshipByCollectorIdAndCollectToId(long collectorId, long collectToId) {
        return collectService.getCollectRelationshipsByCollectorIdAndCollectToId(collectorId, collectToId);
    }

    // 分页查找
    @RequestMapping("/collect/find/collectorId/Page")
    public List<CollectRelationship> getCollectRelationshipByCollectorIdWithPage(long collectorId, int page, int size) {
        return collectService.getCollectRelationshipsByCollectorIdWithPages(collectorId, page, size);
    }

    //创建和删除
    @RequestMapping("/collect/create")
    public List<CollectRelationship> createCollectRelationship(long collectorId, long collectToId) {
        return collectService.createCollectRelationship(collectorId, collectToId);
    }
    @RequestMapping("/collect/delete")
    public void deleteCollectRelationship(long collectRelationshipId) {
        collectService.deleteCollectRelationship(collectRelationshipId);
    }

    //统计
    @RequestMapping("/collect/count/collectorId")
    public int getCollectRelationshipCountByCollectorId(long collectorId) {
        return collectService.getCollectRelationshipCountByCollectorId(collectorId);
    }

}
