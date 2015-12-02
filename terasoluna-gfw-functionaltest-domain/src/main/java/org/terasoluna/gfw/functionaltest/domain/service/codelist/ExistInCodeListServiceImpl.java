package org.terasoluna.gfw.functionaltest.domain.service.codelist;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.codelist.CodeList;

@Service
public class ExistInCodeListServiceImpl implements ExistInCodeListService {
    @Inject
    @Named("CL_CODELIST08_08")
    CodeList existInParamCheckCodeList;

    @Override
    public String getLabel(String item1) {
        return existInParamCheckCodeList.asMap().get(item1);
    }
}
