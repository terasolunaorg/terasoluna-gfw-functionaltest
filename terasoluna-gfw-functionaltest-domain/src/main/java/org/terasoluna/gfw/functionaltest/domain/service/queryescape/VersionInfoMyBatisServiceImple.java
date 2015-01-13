package org.terasoluna.gfw.functionaltest.domain.service.queryescape;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;
import org.terasoluna.gfw.functionaltest.domain.model.VersionInfo;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.VersionInfoMybatisRepository;

@Transactional(value = TransactionManagers.DATASOURCE, readOnly = true)
@Service("versionInfoMyBatisService")
public class VersionInfoMyBatisServiceImple implements VersionInfoService {

    @Inject
    VersionInfoMybatisRepository versionInfoMybatisRepository;

    @Override
    public List<VersionInfo> findAll() {
        return versionInfoMybatisRepository.findAll();
    }

}
