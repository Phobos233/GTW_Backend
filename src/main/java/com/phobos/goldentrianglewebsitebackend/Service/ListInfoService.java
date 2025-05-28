package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.dto.ListInfo;

import java.util.List;

public interface ListInfoService {

    // 查询
    List<ListInfo> findListInfoWithPages(int page, int size);
    List<ListInfo> findListInfoByChNameContainsWithPage(String ch_name, int page, int size);
    List<ListInfo> findListInfoByTaxonNameContainsWithPage(String taxon_name, int page, int size);
    List<ListInfo> findListInfoByAreaWithPage(String area, int page, int size);
    // 统计
    int countListInfoByChNameContains(String ch_name);
    int countListInfoByTaxonNameContains(String taxon_name);
    int countListInfoByArea(String area);
    int countAllListInfo();

}
