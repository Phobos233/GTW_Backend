package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.Genus;

import java.util.List;

public interface GenusService {
    // 查询所有属
    List<Genus> findAllGenus();

    // 根据属名模糊查询
    List<Genus> getGenusByTaxonNameContains(String name);

    // 根据科名模糊查询
    List<Genus> getGenusByFamilyContains(String family);

    // 根据中文名模糊查询
    List<Genus> getGenusByCh_nameContains(String ch_name);

    // 根据节点ID查询
    List<Genus> findGenusByNodeId(long id);

    // 根据植物ID查询
    List<Genus> findGenusByPlantId(int plant_id);

    // 根据科名查询属
    List<Genus> findGenusByFamily(String family);

    // 根据属学名查询属
    List<Genus> findGenusByTaxonName(String taxon_name);

    // 根据属学名列表查询属
    List<Genus> findGenusByTaxonName(List<String> taxon_names);

    // 根据图表需要查询属
    List<Genus> findGenusInNeed();

    //分页查询
    List<Genus> findAllGenusWithPage(int page, int size);

    // 创建属
    void createGenus(int plant_id, String taxon_rank, String taxon_name, String Family, String ch_name);

    // 删除属
    void deleteGenus(long node_id);

    // 更新属
    void updateGenus(long node_id, String taxon_name, String Family, String taxon_rank, String ch_name);

    // 计数
    int countGenusByFamily(String family);
    int countAllGenus();
}
