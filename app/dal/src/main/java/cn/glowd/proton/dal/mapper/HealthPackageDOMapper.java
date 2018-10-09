package cn.glowd.proton.dal.mapper;

import cn.glowd.proton.dal.model.HealthPackageDO;
import java.util.List;

public interface HealthPackageDOMapper {
    /**
     * insert one record into table from <tt>health_package</tt>
     *
     * @param record
     */
    int insert(HealthPackageDO record);

    /**
     *
     * @param record
     */
    int insertSelective(HealthPackageDO record);

    /**
     * get one record by primary key from <tt>health_package</tt>
     *
     * @param id
     */
    HealthPackageDO selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthPackageDO record);

    /**
     * update one record by primary key from <tt>health_package</tt>
     *
     * @param record
     */
    int updateByPrimaryKey(HealthPackageDO record);

    /**
     * get all records from  <tt>health_package</tt>
     *
     */
    List<HealthPackageDO> selectAll();
}