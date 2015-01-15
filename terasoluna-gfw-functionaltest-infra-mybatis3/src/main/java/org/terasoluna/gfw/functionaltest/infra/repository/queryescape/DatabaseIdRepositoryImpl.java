package org.terasoluna.gfw.functionaltest.infra.repository.queryescape;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.DatabaseIdRepository;

@Repository("databaseIdRepositor")
public class DatabaseIdRepositoryImpl implements DatabaseIdRepository{

    @Inject
    SqlSessionFactory sqlSessionFactory;

    @Override
    public String getDatabaseId() {
        return sqlSessionFactory.getConfiguration().getDatabaseId();
    }

}
