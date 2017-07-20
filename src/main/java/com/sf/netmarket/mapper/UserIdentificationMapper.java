package com.sf.netmarket.mapper;

import com.sf.netmarket.model.UserIdentification;
import com.sf.netmarket.model.UserIdentificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIdentificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    long countByExample(UserIdentificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    int deleteByExample(UserIdentificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    int insert(UserIdentification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    int insertSelective(UserIdentification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    List<UserIdentification> selectByExample(UserIdentificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    int updateByExampleSelective(@Param("record") UserIdentification record, @Param("example") UserIdentificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_identification
     *
     * @mbg.generated Mon Jun 26 23:15:29 CST 2017
     */
    int updateByExample(@Param("record") UserIdentification record, @Param("example") UserIdentificationExample example);
}