package org.terasoluna.gfw.functionaltest.infra.repository.queryescape;

import javax.inject.Inject;

import jp.terasoluna.fw.dao.QueryDAO;

import org.springframework.stereotype.Repository;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.VersionInfoMybatisRepository;

@Repository
public class VersionInfoMybatisRepositoryImpl implements
        VersionInfoMybatisRepository {

    @Inject
    protected QueryDAO queryDAO;
    
    @Override
    public String findOne() {
        return queryDAO.executeForObject("versioninfo.findOne", null , null);
    }

}
