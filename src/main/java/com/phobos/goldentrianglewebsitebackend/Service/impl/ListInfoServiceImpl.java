package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.dto.ListInfo;
import com.phobos.goldentrianglewebsitebackend.Repository.ListDataRepo;
import com.phobos.goldentrianglewebsitebackend.Service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListInfoServiceImpl implements ListInfoService {
    private final ListDataRepo listDataRepo;
    @Autowired
    public ListInfoServiceImpl(ListDataRepo listDataRepo) {
        this.listDataRepo = listDataRepo;
    }

    //分页查询&条件分页查询
    @Override
    public List<ListInfo> findListInfoWithPages(int page, int size) {
        int start = (page-1)*size;
        return listDataRepo.findListInfoWithPage(start, size);
    }

    @Override
    public List<ListInfo> findListInfoByChNameContainsWithPage(String ch_name, int page, int size) {
        int start = (page-1)*size;
        return listDataRepo.findListInfoByCh_NameContainingWithPage(ch_name, start, size);
    }

    @Override
    public List<ListInfo> findListInfoByTaxonNameContainsWithPage(String taxon_name, int page, int size) {
        int start = (page-1)*size;
        return listDataRepo.findListInfoByTaxonNameContainingWithPage(taxon_name, start, size);
    }

    @Override
    public List<ListInfo> findListInfoByAreaWithPage(String area, int page, int size) {
        int skip = (page - 1) * size;
        return listDataRepo.findListInfoByAreaContainingWithPage(area, skip, size);
    }

    //统计
    @Override
    public int countListInfoByChNameContains(String ch_name) {
        return listDataRepo.countByChName(ch_name);
    }

    @Override
    public int countListInfoByTaxonNameContains(String taxon_name) {
        return listDataRepo.countByTaxonName(taxon_name);
    }

    @Override
    public int countListInfoByArea(String area) {
        return listDataRepo.countByArea(area);
    }

    @Override
    public int countAllListInfo() {
        return listDataRepo.countAllListInfo();
    }
}
