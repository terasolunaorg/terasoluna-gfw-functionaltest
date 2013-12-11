package org.terasoluna.gfw.functionaltest.app.el;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Component;
import org.terasoluna.gfw.functionaltest.domain.repository.customer.CustomerSearchCriteria;

@Component
public class ELHelper {
    
    public void decodeName(CustomerSearchCriteria target) {
        try {
            target.setName(URLDecoder.decode(target.getName(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // no op
        }
    }

}
