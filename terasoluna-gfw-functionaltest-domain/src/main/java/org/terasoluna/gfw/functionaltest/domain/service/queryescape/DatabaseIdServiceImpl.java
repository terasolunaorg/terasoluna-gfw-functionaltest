package org.terasoluna.gfw.functionaltest.domain.service.queryescape;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.DatabaseIdRepository;

@Service
public class DatabaseIdServiceImpl implements DatabaseIdService {

    @Inject
    @Named("databaseIdRepositor")
    DatabaseIdRepository databaseIdRepository;

    @Override
    public String getDatabaseId() {
        return databaseIdRepository.getDatabaseId();
    }

}
