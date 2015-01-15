package org.terasoluna.gfw.functionaltest.infra.repository.queryescape;

import org.springframework.stereotype.Repository;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.DatabaseIdRepository;

@Repository("databaseIdRepositor")
public class DatabaseIdRepositoryImpl implements DatabaseIdRepository{

    @Override
    public String getDatabaseId() {
        return "";
    }

}
