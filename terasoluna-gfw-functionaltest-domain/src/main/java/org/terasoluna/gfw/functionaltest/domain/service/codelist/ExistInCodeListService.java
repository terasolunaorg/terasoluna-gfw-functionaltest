package org.terasoluna.gfw.functionaltest.domain.service.codelist;

import org.springframework.validation.annotation.Validated;
import org.terasoluna.gfw.common.codelist.ExistInCodeList;

@Validated
public interface ExistInCodeListService {

    String getLabel(
            @ExistInCodeList(codeListId = "CL_CODELIST08_08") String item1);
}
