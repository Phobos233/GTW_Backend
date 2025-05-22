package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.Species;

import java.util.List;

public interface SpeciesService {
    // 查询所有物种
    List<Species> findAllSpecies();

    // 根据物种名模糊查询
    List<Species> getSpeciesByTaxonNameContains(String name);

    // 根据分布地区模糊查询
    List<Species> getSpeciesByAreaContains(String area);

    // 根据科名模糊查询
    List<Species> getSpeciesByFamilyContains(String family);

    // 根据属名模糊查询
    List<Species> getSpeciesByGenusContains(String genus);

    // 根据中文名模糊查询
    List<Species> getSpeciesByCh_nameContains(String ch_name);

    // 根据节点ID查询
    List<Species> findSpeciesByNodeId(long id);

    // 根据植物ID查询
    List<Species> findSpeciesByPlantId(int plant_id);

    // 根据分布地区查询
    List<Species> findSpeciesByArea(String area);

    // 根据发表日期查询
    List<Species> findSpeciesByPubDate(String pub_date);
    // 根据属查询
    List<Species> findSpeciesByGenus(String genus);

    // 创建物种
    void createSpecies(int plant_id,String taxon_rank, String taxon_name, String Family, String area, String genus, String ch_name, int publish_date);

    // 删除物种
    void deleteSpecies(long node_id);

    // 更新物种
    void updateSpecies(long id, String taxon_rank,String taxon_name, String Family, String genus, String area, String ch_name,int publish_date);

    //计数
    int countSpeciesByGenus(String genus);
    int countSpeciesByArea(String area);
    int countSpeciesByFamily(String family);
    int countSpeciesByPub_date(int pub_date);
    int countAllSpecies();

}
